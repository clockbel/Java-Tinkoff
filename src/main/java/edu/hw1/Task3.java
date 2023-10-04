package edu.hw1;

public class Task3 {
    public static boolean isNestable(int[] array1, int[] array2) {
        boolean ans = false;
        if (array1.length > 1 && array2.length > 1) {
            int max_a1 = findMax(array1);
            int max_a2 = findMax(array2);
            int min_a1 = findMin(array1);
            int min_a2 = findMin(array2);
            if (min_a1 > min_a2 && max_a1 < max_a2) {
                ans = true;
            }
        }
        return ans;
    }

    private static int findMax(int[] array) {
        int max_a = array[0];
        for (int j : array) {
            if (max_a < j) {
                max_a = j;
            }
        }
        return max_a;
    }

    private static int findMin(int[] array) {
        int min_a = array[0];
        for (int j : array) {
            if (min_a > j) {
                min_a = j;
            }
        }
        return min_a;
    }
}
