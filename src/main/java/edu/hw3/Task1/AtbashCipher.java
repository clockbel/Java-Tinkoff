package edu.hw3.Task1;

public final class AtbashCipher {
    private AtbashCipher() {

    }

    public static String atbash(String message) {
        if (message == null) {
            return null;
        }
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    char encryptedChar = (char) ('Z' - (c - 'A'));
                    cipher.append(encryptedChar);
                } else {
                    char encryptedChar = (char) ('z' - (c - 'a'));
                    cipher.append(encryptedChar);
                }
            } else {
                cipher.append(c);
            }
        }
        return cipher.toString();
    }
}
