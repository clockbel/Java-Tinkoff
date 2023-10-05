package edu.hw1;

public final class Task4 {
    private Task4() {
    }

    public static String fixString(String str) {
        char[] oldStr = str.toCharArray();
        char temp = '\0';
        for (int i = 0; i < oldStr.length - 1; i += 2) {
            temp = oldStr[i];
            oldStr[i] = oldStr[i + 1];
            oldStr[i + 1] = temp;
        }
        return new String(oldStr);
    }
}
