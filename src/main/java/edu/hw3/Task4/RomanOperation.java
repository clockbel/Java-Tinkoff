package edu.hw3.Task4;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public final class RomanOperation {
    private RomanOperation() {

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

    public static String convertToRoman(int num) {
        if (num <= 0) {
            return null;
        }
        Map<Integer, String> roman = getIntegerStringHashMap();
        StringBuilder romanString = new StringBuilder();
        int number = num;
        for (Map.Entry<Integer, String> entry : roman.entrySet()) {
            int value = entry.getKey();
            String numeral = entry.getValue();
            while (number >= value) {
                romanString.append(numeral);
                number -= value;
            }
        }
        return romanString.toString();
    }

    @NotNull private static Map<Integer, String> getIntegerStringHashMap() {
        Map<Integer, String> roman = new LinkedHashMap<>();
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
        return roman;
    }
}
