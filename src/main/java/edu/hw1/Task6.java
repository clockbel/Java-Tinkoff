package edu.hw1;

import java.util.Arrays;

public final class Task6 {
    private Task6() {
    }

    public static int countK(int number) {
        final int finalNumber = 6174;
        int count = 1;
        if (number == finalNumber) {
            count = 0;
        } else {
            int[] intArray = intergerToArray(number);
            Arrays.sort(intArray);
            int ascending = 0;
            int descending = 0;
            final int rank = 10;
            for (int i = 0; i < intArray.length; i++) {
                ascending = ascending * rank + intArray[i];
            }
            for (int i = intArray.length - 1; i > -1; i--) {
                descending = descending * rank + intArray[i];
            }
            int difference = descending - ascending;
            count += countK(difference);
        }
        return count;
    }

    private static int[] intergerToArray(int number) {
        String numberString = Integer.toString(number);
        char[] charArray = numberString.toCharArray();
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);
        }
        return intArray;
    }
}
