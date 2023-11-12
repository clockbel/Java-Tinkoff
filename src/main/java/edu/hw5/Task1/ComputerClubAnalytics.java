package edu.hw5.Task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ComputerClubAnalytics {
    private static final String DATETIME_PATTERN = "yyyy-MM-dd, HH:mm";

    private ComputerClubAnalytics() {
    }

    public static String session(String[] sessionDates) {
        Duration totalDuration = Duration.ZERO;
        if (sessionDates == null || sessionDates.length == 0) {
            return "0";
        }
        for (String checkSession : sessionDates) {
            String[] times = checkSession.split(" - ");
            Duration tmp;
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATETIME_PATTERN);
            LocalDateTime beg = LocalDateTime.parse(times[0], dateTimeFormatter);
            LocalDateTime end = LocalDateTime.parse(times[1], dateTimeFormatter);
            tmp = Duration.between(beg, end);
            totalDuration = totalDuration.plus(tmp);
        }
        totalDuration = totalDuration.dividedBy(sessionDates.length);
        return totalDuration.toHoursPart() + "ч " + totalDuration.toMinutesPart() + "м";
    }
}

