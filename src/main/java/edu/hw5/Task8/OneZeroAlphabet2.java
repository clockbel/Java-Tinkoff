package edu.hw5.Task8;

public final class OneZeroAlphabet2 {
    private static final String PATTERN_1 = "([01]{2})*[01]";
    private static final String PATTERN_2 = "0([01]{2})*|1([01]{2})*[01]";
    private static final String PATTERN_3 = "((1*01*){3})*";
    private static final String PATTERN_4 = "(1[01])*[01]{0,1}";

    private OneZeroAlphabet2() {

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

    public static boolean validateAlphabet4(String password) {
        return password.matches(PATTERN_4);
    }
}
