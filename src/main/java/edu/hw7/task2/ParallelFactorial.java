package edu.hw7.task2;

import java.util.stream.LongStream;

public final class ParallelFactorial {
    private ParallelFactorial() {
    }

    public static Long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Incorrect value");
        }
        return LongStream.rangeClosed(1, n)
            .parallel()
            .reduce(1, (a, b) -> a * b);
    }
}
