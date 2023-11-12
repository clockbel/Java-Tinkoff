package edu.hw5.Task7;

public final class OneZeroAlphabet {
    private static final String PATTERN_1 = "[10]{2}0[10]*";
    private static final String PATTERN_2 = "([01]).*\\1$";
    private static final String PATTERN_3 = "^[01]{1,3}$";

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
}
