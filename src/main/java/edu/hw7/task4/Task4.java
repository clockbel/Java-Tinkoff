package edu.hw7.task4;

import java.util.Random;

public final class Task4 {
    private final static double RADIUS = 1;
    private final static double NUMBER_FOUR_FROM_FORMULA = 4.0;

    private Task4() {
    }

    public static double calculatePi(int totalSimulations) {
        if (totalSimulations <= 0) {
            throw new IllegalArgumentException();
        }
        int circleCount = 0;
        Random random = new Random();

        for (int i = 0; i < totalSimulations; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();

            double distance = Math.sqrt((x - RADIUS) * (x - RADIUS) + (y - RADIUS) * (y - RADIUS));

            if (distance <= RADIUS) {
                circleCount++;
            }
        }

        return NUMBER_FOUR_FROM_FORMULA * circleCount / totalSimulations;
    }

    public static double calculatePiMultiThreaded(int totalSimulations, int numThreads) {
        if (totalSimulations <= 0 || numThreads <= 0) {
            throw new IllegalArgumentException();
        }
        int simulationsPerThread = totalSimulations / numThreads;
        Thread[] threads = new Thread[numThreads];
        PiCalculation[] piCalculations = new PiCalculation[numThreads];

        for (int i = 0; i < numThreads; i++) {
            piCalculations[i] = new PiCalculation(simulationsPerThread);
            threads[i] = new Thread(piCalculations[i]);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int totalCircleCount = 0;
        for (PiCalculation piCalculation : piCalculations) {
            totalCircleCount += piCalculation.getCircleCount();
        }

        return NUMBER_FOUR_FROM_FORMULA * totalCircleCount / totalSimulations;
    }

    private static class PiCalculation implements Runnable {
        private final int simulations;
        private int circleCount;
        private final Random random;

        PiCalculation(int simulations) {
            this.simulations = simulations;
            this.circleCount = 0;
            this.random = new Random();
        }

        @Override
        public void run() {
            for (int i = 0; i < simulations; i++) {
                double x = random.nextDouble();
                double y = random.nextDouble();

                double distance = Math.sqrt((x - RADIUS) * (x - RADIUS) + (y - RADIUS) * (y - RADIUS));

                if (distance <= RADIUS) {
                    circleCount++;
                }
            }
        }

        public int getCircleCount() {
            return circleCount;
        }
    }
}
