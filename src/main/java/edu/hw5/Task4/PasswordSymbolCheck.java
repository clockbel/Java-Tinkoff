package edu.hw5.Task4;

public final class PasswordSymbolCheck {
    public static final String PATTERN = ".*[~!@#$%^&*|]+.*";

    private PasswordSymbolCheck() {
    }

    public static boolean validatePassword(String password) {
        return password.matches(PATTERN);
    }
}
