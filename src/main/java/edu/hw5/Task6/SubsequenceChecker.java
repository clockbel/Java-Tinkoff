package edu.hw5.Task6;

import java.util.regex.Pattern;

public class SubsequenceChecker {
    public static boolean isSubsequence(String s, String t) {
        StringBuilder patternBuilder = new StringBuilder(".*");
        for (char c : s.toCharArray()) {
            patternBuilder.append(Pattern.quote(String.valueOf(c))).append(".*");
        }
        String pattern = patternBuilder.toString();
        return Pattern.matches(pattern, t);
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "achfdbaabgabcaabg";

        if (isSubsequence(s, t)) {
            System.out.println(s + " является подпоследовательностью " + t);
        } else {
            System.out.println(s + " не является подпоследовательностью " + t);
        }
    }
}

