package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw7.task1.ThreadsCounter.threadCounter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    @Test
    @DisplayName("Correct work")
    public void threadCounterTest() {
        assertEquals(10, threadCounter(1, 10));
        assertEquals(100, threadCounter(10, 10));
        assertEquals(10000, threadCounter(1000, 10));
    }
    @Test
    @DisplayName("Incorrect work")
    public void threadCounterInvalidTest() {
        assertThrows(IllegalArgumentException.class, () -> threadCounter(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> threadCounter(10, -5));
        assertThrows(IllegalArgumentException.class, () -> threadCounter(0, 5));
    }
}
