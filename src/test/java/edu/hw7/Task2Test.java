package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw7.task2.ParallelFactorial.factorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
    @Test
    @DisplayName("Correct work")
    public void calculateFactorialTest() {
        assertEquals(1, factorial(0));
        assertEquals(1, factorial(1));
        assertEquals(2, factorial(2));
        assertEquals(6, factorial(3));
        assertEquals(24, factorial(4));
        assertEquals(120, factorial(5));
        assertEquals(3628800, factorial(10));
    }

    @Test
    @DisplayName("Incorrect work")
    public void calculateFactorialNegativeInputTest() {
        assertThrows(IllegalArgumentException.class, () -> factorial(-1));
        assertThrows(IllegalArgumentException.class, () -> factorial(-10));
        assertThrows(IllegalArgumentException.class, () -> factorial(-25));
    }
}
