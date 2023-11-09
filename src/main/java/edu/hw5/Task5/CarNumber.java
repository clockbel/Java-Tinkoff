package edu.hw5.Task5;

public class CarNumber {
    private static final String PATTERN = "^[АВЕКМНОРСТУХ]{1}\\d{3}[АВЕКМНОРСТУХ]{2}\\d{3}$";
    private CarNumber() {
    }

    public static boolean validateCarNumber(String password) {
        return password.matches(PATTERN);
    }

    public static void main(String[] args) {
        String pass = "В123ОР777";
        System.out.println(validateCarNumber(pass));
    }
}
