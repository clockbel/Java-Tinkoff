package edu.hw1;

public class Task2 {
    public static int countDigits(int num) {
        int count = 0;
        if (num == 0) {
            count = 1;
        }
        if (num < 0) {
            num *= -1;
        }
        while (num > 0) {
            num /= 10;
            count += 1;
        }
        return count;
    }
}
