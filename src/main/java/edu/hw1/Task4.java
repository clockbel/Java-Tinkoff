package edu.hw1;

public class Task4 {
    public static String fixString(String str) {
        char[] old_str = str.toCharArray();
        char temp = '\0';
        for (int i = 0; i < old_str.length - 1; i += 2) {
            temp = old_str[i];
            old_str[i] = old_str[i + 1];
            old_str[i + 1] = temp;
        }
        return new String(old_str);
    }
}
