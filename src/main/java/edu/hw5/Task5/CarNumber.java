package edu.hw5.Task5;

public final class CarNumber {
    private static final String PATTERN = "^[АВЕКМНОРСТУХ]{1}\\d{3}[АВЕКМНОРСТУХ]{2}\\d{3}$";

    private CarNumber() {
    }

    public static boolean validateCarNumber(String password) {
        return password != null ? password.matches(PATTERN) : false;
    }
}
