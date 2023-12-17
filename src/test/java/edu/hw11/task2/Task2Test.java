package edu.hw11.task2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2Test {

    @Test
    void task2Test() {
        TypeDescription typeDescription = TypePool.Default.ofSystemLoader()
            .describe("edu.hw11.task2.SumArithmeticUtils")
            .resolve();
        new ByteBuddy()
            .redefine(typeDescription, ClassFileLocator.ForClassLoader.ofSystemLoader())
            .method(ElementMatchers.named("sum"))
            .intercept(MethodDelegation.to(new MultiArithmeticUtils()))
            .make()
            .load(ClassLoader.getSystemClassLoader(), ClassLoadingStrategy.Default.INJECTION);

        SumArithmeticUtils arithmeticUtils = new SumArithmeticUtils();
        Assertions.assertEquals(10, arithmeticUtils.sum(2, 5));
        Assertions.assertEquals(16, arithmeticUtils.sum(4, 4));
        Assertions.assertEquals(49, arithmeticUtils.sum(7, 7));
    }
}
