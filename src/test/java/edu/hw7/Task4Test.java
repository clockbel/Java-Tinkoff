package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw7.task4.Task4.calculatePi;
import static edu.hw7.task4.Task4.calculatePiMultiThreaded;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {

    @Test
    @DisplayName("Correct work")
    public void calculatePiTest() {
        int totalSimulations = 1000000;
        double piApproximation = calculatePi(totalSimulations);

        assertTrue(piApproximation >= 3.0 && piApproximation <= 3.5);
    }

    @Test
    @DisplayName("Correct work")
    public void calculatePiMultiThreadedTest() {
        int totalSimulations = 1000000;
        int numThreads = 4;

        double piApproximationMultiThreaded = calculatePiMultiThreaded(totalSimulations, numThreads);

        assertTrue(piApproximationMultiThreaded >= 3.0 && piApproximationMultiThreaded <= 3.5);
    }

    @Test
    @DisplayName("Incorrect work")
    public void invalidArgumentsSingleThreadedTest() {
        assertThrows(IllegalArgumentException.class, () -> calculatePi(0));
        assertThrows(IllegalArgumentException.class, () -> calculatePi(-5));
    }

    @Test
    @DisplayName("Incorrect work")
    public void invalidArgumentsMultiThreadedTest() {
        assertThrows(IllegalArgumentException.class, () -> calculatePiMultiThreaded(100, 0));
        assertThrows(IllegalArgumentException.class, () -> calculatePiMultiThreaded(0, 24));
        assertThrows(IllegalArgumentException.class, () -> calculatePiMultiThreaded(-100, 3));
        assertThrows(IllegalArgumentException.class, () -> calculatePiMultiThreaded(100, -8));
    }
}
