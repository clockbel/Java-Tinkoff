package edu.hw1;

import java.util.Arrays;

public final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        boolean ans = false;
        if (array1.length > 1 && array2.length > 1) {
            int maxArray1 = Arrays.stream(array1).max().getAsInt();
            int maxArray2 = Arrays.stream(array2).max().getAsInt();
            int minArray1 = Arrays.stream(array1).min().getAsInt();
            int minArray2 = Arrays.stream(array2).min().getAsInt();
            if (minArray1 > minArray2 && maxArray1 < maxArray2) {
                ans = true;
            }
        }
        return ans;
    }
}
