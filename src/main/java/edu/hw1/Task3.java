package edu.hw1;

public final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        boolean ans = false;
        if (array1.length > 1 && array2.length > 1) {
            int maxArray1 = findMax(array1);
            int maxArray2 = findMax(array2);
            int minArray1 = findMin(array1);
            int minArray2 = findMin(array2);
            if (minArray1 > minArray2 && maxArray1 < maxArray2) {
                ans = true;
            }
        }
        return ans;
    }

    private static int findMax(int[] array) {
        int maxArray = array[0];
        for (int j : array) {
            if (maxArray < j) {
                maxArray = j;
            }
        }
        return maxArray;
    }

    private static int findMin(int[] array) {
        int minArray = array[0];
        for (int j : array) {
            if (minArray > j) {
                minArray = j;
            }
        }
        return minArray;
    }
}
