package edu.hw5.Task7;

public class OneZeroAlphabet {
    public static final String PATTERN_1 = "[10]{2}0[10]*";
    public static final String PATTERN_2 = "([01]).*\\1$";
    public static final String PATTERN_3 = "^[01]{1,3}$";

    private OneZeroAlphabet() {
    }

    public static boolean validateAlphabet1(String password) {
        return password.matches(PATTERN_1);
    }

    public static boolean validateAlphabet2(String password) {
        return password.matches(PATTERN_2);
    }
    public static boolean validateAlphabet3(String password) {
        return password.matches(PATTERN_3);
    }
    public static void main(String[] args) {
        System.out.println(validateAlphabet1("101"));
        System.out.println(validateAlphabet2("10001"));
        System.out.println(validateAlphabet3("1"));
    }
}
