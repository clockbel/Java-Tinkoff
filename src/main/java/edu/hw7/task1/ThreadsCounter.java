package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicInteger;

public final class ThreadsCounter {
    private ThreadsCounter() {
    }

    public static int threadCounter(int givenNumber, int numberOfThreads) {
        if (givenNumber <= 0 || numberOfThreads <= 0) {
            throw new IllegalArgumentException();
        }
        AtomicInteger counter = new AtomicInteger(0);
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < givenNumber; j++) {
                    counter.incrementAndGet();
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return counter.get();
    }
}
