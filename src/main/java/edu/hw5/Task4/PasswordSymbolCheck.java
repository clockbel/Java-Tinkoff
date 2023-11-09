package edu.hw5.Task4;

public class PasswordSymbolCheck {
    public static final String PATTERN = ".*[~!@#$%^&*|]+.*";

    private PasswordSymbolCheck() {
    }

    public static boolean validatePassword(String password) {
        return password.matches(PATTERN);
    }

    public static void main(String[] args) {
        String pass = "123$er1";
        System.out.println(validatePassword(pass));
    }
}
