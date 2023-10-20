package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public final class Task4 {
    private Task4() {

    }

    private final static int ROMAN_VALUE_M = 1000;
    private final static int ROMAN_VALUE_CM = 900;
    private final static int ROMAN_VALUE_D = 500;
    private final static int ROMAN_VALUE_CD = 400;
    private final static int ROMAN_VALUE_C = 100;
    private final static int ROMAN_VALUE_XC = 90;
    private final static int ROMAN_VALUE_L = 50;
    private final static int ROMAN_VALUE_XL = 40;
    private final static int ROMAN_VALUE_X = 10;
    private final static int ROMAN_VALUE_IX = 9;
    private final static int ROMAN_VALUE_V = 5;
    private final static int ROMAN_VALUE_IV = 4;
    private final static int ROMAN_VALUE_I = 1;

    public static String converToRoman(int num) {
        HashMap<Integer, String> roman = new HashMap<>();
        roman.put(ROMAN_VALUE_M, "M");
        roman.put(ROMAN_VALUE_CM, "CM");
        roman.put(ROMAN_VALUE_D, "D");
        roman.put(ROMAN_VALUE_CD, "CD");
        roman.put(ROMAN_VALUE_C, "C");
        roman.put(ROMAN_VALUE_XC, "XC");
        roman.put(ROMAN_VALUE_L, "L");
        roman.put(ROMAN_VALUE_XL, "XL");
        roman.put(ROMAN_VALUE_X, "X");
        roman.put(ROMAN_VALUE_IX, "IX");
        roman.put(ROMAN_VALUE_V, "V");
        roman.put(ROMAN_VALUE_IV, "IV");
        roman.put(ROMAN_VALUE_I, "I");

        StringBuilder romanString = new StringBuilder();
        Set<Integer> romanKeys = roman.keySet();
        List<Integer> list = new ArrayList<>(romanKeys);
        Collections.reverse(list);
        int numToRoman = num;
        while (numToRoman > 0) {
            for (int keys : list) {
                while (numToRoman >= keys) {
                    romanString.append(roman.get(keys));
                    numToRoman -= keys;
                }
            }
        }
        return romanString.toString();
    }
}
