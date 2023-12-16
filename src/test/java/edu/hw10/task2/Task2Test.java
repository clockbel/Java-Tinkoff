package edu.hw10.task2;

import edu.hw10.task2.fib.Fib;
import edu.hw10.task2.fib.FibCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    void testCaching() {
        FibCalculator fibCalculator = new Fib();
        FibCalculator proxy = CacheProxy.create(fibCalculator, FibCalculator.class,
            "src/test/resources/");
        long result1 = proxy.fib(5);
        assertEquals(5, result1);
    }
}
