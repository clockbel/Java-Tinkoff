package edu.project3.LogAnalys;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LogCheck {

    private LogCheck() {
    }

    public static Matcher checkLog(String log) {
        String logPattern = getLogPattern();
        Pattern pattern = Pattern.compile(logPattern);
        return pattern.matcher(log);
    }

    public static String getLogPattern() {
        return "^(\\S+) (\\S+) (\\S+) \\[([^]]+)\\] \"(\\S+) (\\S+) (\\S+)\" (\\d+) (\\d+) \"([^\"]+)\" \"([^\"]+)\"";
    }
}
