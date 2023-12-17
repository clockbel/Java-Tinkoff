package edu.hw11.task3;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.Opcodes;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    void test1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        var unloaded = new ByteBuddy()
            .subclass(Object.class)
            .name("edu.hw11.FibCalculator")
            .defineMethod("fib", int.class, Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC)
            .withParameter(int.class, "n")
            .intercept(new Implementation.Simple(new ByteCodeFib()))
            .make();
        Class<?> fibClass = unloaded.load(null, ClassLoadingStrategy.Default.WRAPPER)
            .getLoaded();
        Method fib = fibClass.getMethod("fib", int.class);

        assertEquals(1, (int) fib.invoke(null, 1));
        assertEquals(55, (int) fib.invoke(null, 10));
    }
}

