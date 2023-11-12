package edu.hw5.Task6;

import java.util.regex.Pattern;

public final class SubsequenceChecker {
    private SubsequenceChecker() {
    }

    public static boolean isSubsequence(String s, String t) {
        StringBuilder patternBuilder = new StringBuilder(".*");
        for (char c : s.toCharArray()) {
            patternBuilder.append(Pattern.quote(String.valueOf(c))).append(".*");
        }
        String pattern = patternBuilder.toString();
        return Pattern.matches(pattern, t);
    }
}

