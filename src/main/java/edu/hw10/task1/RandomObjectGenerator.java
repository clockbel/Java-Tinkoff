package edu.hw10.task1;

import edu.hw10.task1.annotation.Max;
import edu.hw10.task1.annotation.Min;
import edu.hw10.task1.annotation.NotNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

class RandomObjectGenerator {
    private static final Random RANDOM = new SecureRandom();
    private static final int CHARS_VALUE = 65536;

    public <T> T nextObject(Class<T> clazz) throws Exception {
        return generateObjectUsingConstructor(clazz);
    }

    public <T> T nextObject(Class<T> clazz, String factoryMethodName) throws Exception {
        return generateObjectUsingFactoryMethod(clazz, factoryMethodName);
    }

    private <T> T generateObjectUsingConstructor(Class<T> clazz) throws Exception {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (constructors.length == 0) {
            throw new NoSuchMethodException("No constructors found for class: " + clazz.getName());
        }

        Constructor<?> constructor = constructors[0];
        constructor.setAccessible(true);

        Field[] fields = clazz.getDeclaredFields();
        Object[] args = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) {
            args[i] = generateValueForField(fields[i]);
        }

        return (T) constructor.newInstance(args);
    }

    private <T> T generateObjectUsingFactoryMethod(Class<T> clazz, String factoryMethod) throws Exception {
        Method method = getFabricMethod(clazz, factoryMethod);
        method.setAccessible(true);

        Field[] fields = clazz.getDeclaredFields();
        Object[] args = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) {
            args[i] = generateValueForField(fields[i]);
        }

        return (T) method.invoke(null, args);
    }

    private Method getFabricMethod(Class<?> generatingClass, String methodName) throws NoSuchMethodException {
        var methods = generatingClass.getMethods();
        for (var method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        throw new NoSuchMethodException();
    }

    private Object generateValueForField(Field field) {
        Class<?> type = field.getType();
        return generateValue(type, field);
    }

    private Object generateValue(Class<?> type, Field field) {
        if (type.isPrimitive()) {
            int minValue = getMinAnnotation(field);
            int maxValue = getMaxAnnotation(field);
            return generatePrimitive(type, minValue, maxValue);
        } else if (type.equals(String.class)) {
            if (field.isAnnotationPresent(NotNull.class)) {
                return generateString();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private Object generatePrimitive(Class<?> type, int min, int max) {

        return switch (type.getName()) {
            case "int" -> RANDOM.nextInt(min, max);
            case "double" -> RANDOM.nextDouble(min, max);
            case "long" -> RANDOM.nextLong(min, max);
            case "float" -> RANDOM.nextFloat(min, max);
            case "boolean" -> RANDOM.nextBoolean();
            case "byte" -> (byte) RANDOM.nextInt(min, max);
            case "short" -> (short) RANDOM.nextInt(min, max);
            case "char" -> (char) RANDOM.nextInt(CHARS_VALUE);
            default -> throw new IllegalArgumentException("Not primitive");
        };
    }

    private int getMinAnnotation(Field field) {
        if (field.isAnnotationPresent(Min.class)) {
            return field.getAnnotation(Min.class).value();
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private int getMaxAnnotation(Field field) {
        if (field.isAnnotationPresent(Max.class)) {
            return field.getAnnotation(Max.class).value();
        } else {
            return Integer.MAX_VALUE;
        }
    }

    private String generateString() {
        return UUID.randomUUID().toString();
    }
}
