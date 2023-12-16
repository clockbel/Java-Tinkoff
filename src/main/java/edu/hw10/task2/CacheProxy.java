package edu.hw10.task2;

import edu.hw10.task2.annotation.Cache;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CacheProxy implements InvocationHandler {

    private final Object target;
    private final Map<String, Object> cache = new ConcurrentHashMap<>();
    private static final Logger LOGGER = LogManager.getLogger();
    private final String cacheDirectory;

    private CacheProxy(Object target, String cacheDirectory) {
        this.target = target;
        this.cacheDirectory = cacheDirectory;
    }

    public static <T> T create(Object target, Class<T> interfaceClass, String cacheDirectory) {
        CacheProxy handler = new CacheProxy(target, cacheDirectory);
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[] {interfaceClass}, handler

        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cache cacheAnnotation = method.getAnnotation(Cache.class);
        if (cacheAnnotation != null) {
            String key = method.getName() + args.hashCode();
            if (cache.containsKey(key)) {
                return cache.get(key);
            } else {
                Object result = method.invoke(target, args);
                cache.put(key, result);
                if (cacheAnnotation.persist()) {
                    saveToDisk(key, result);
                }
                return result;
            }
        } else {
            return method.invoke(target, args);
        }
    }

    private void saveToDisk(String key, Object result) {
        try (FileOutputStream fileOut = new FileOutputStream(
            cacheDirectory + File.separator + "cache_" + key + ".cache");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(result);
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
