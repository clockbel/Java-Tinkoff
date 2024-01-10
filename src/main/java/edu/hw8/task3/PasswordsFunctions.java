package edu.hw8.task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PasswordsFunctions {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static String SYMBOLS_FOR_PASSWORD = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private PasswordsFunctions() {
    }

    public static String md5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.info(e.getMessage());
            return null;
        }
    }

    public static String getUsernameByHash(String hash, Map<String, String> passwordDatabase) {
        for (Map.Entry<String, String> entry : passwordDatabase.entrySet()) {
            if (entry.getValue().equals(hash)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static String nextPassword(int length, char[] basePassword) {
        char[] characters = SYMBOLS_FOR_PASSWORD.toCharArray();
        StringBuilder password = new StringBuilder(length);
        return gen(password, length, basePassword, characters);
    }

    public static String gen(StringBuilder password, int length, char[] basePassword, char[] characters) {
        int index = length - 1;
        while (index >= 0 && basePassword[index] == characters[characters.length - 1]) {
            basePassword[index] = characters[0];
            index--;
        }

        if (index < 0) {
            return null;
        }
        if (basePassword[index] == ' ') {
            basePassword[index] = 'a';
        } else if (basePassword[index] == 'z') {
            basePassword[index] = 'A';
        } else if (basePassword[index] == 'Z') {
            basePassword[index] = '0';
        } else if (basePassword[index] == '9') {
            basePassword[index] = 'a';
        } else {
            basePassword[index]++;
        }
        password.setLength(0);
        password.append(basePassword);
        return password.toString();
    }

    static String calculateString(int length, String symbol) {
        return symbol + symbol.repeat(Math.max(0, length - 1));
    }
}
