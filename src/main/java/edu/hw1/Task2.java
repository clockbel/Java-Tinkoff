package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    private static final int DIGIT_BASE = 10;

    public static int countDigits(int number) {
        int count = 0;
        int checkNumber = number;
        if (checkNumber == 0) {
            count = 1;
        }
        if (checkNumber < 0) {
            checkNumber *= -1;
        }
        while (checkNumber > 0) {
            checkNumber /= DIGIT_BASE;
            count += 1;
        }
        return count;
    }
}
