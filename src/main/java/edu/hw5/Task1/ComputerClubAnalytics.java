package edu.hw5.Task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class ComputerClubAnalytics {
    private static final String DATETIME_PATTERN = "yyyy-MM-dd, HH:mm";

    private ComputerClubAnalytics() {
    }

    public static String session(List<String> sessionDates) {
        Duration totalDuration = Duration.ZERO;
        if (sessionDates == null || sessionDates.isEmpty()) {
            return "0";
        }
        for (String checkSession : sessionDates) {
            String[] times = checkSession.split(" - ");
            Duration tmp;
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATETIME_PATTERN);
            try {
                if (times.length == 2) {
                    LocalDateTime beg = LocalDateTime.parse(times[0], dateTimeFormatter);
                    LocalDateTime end = LocalDateTime.parse(times[1], dateTimeFormatter);
                    tmp = Duration.between(beg, end);
                    totalDuration = totalDuration.plus(tmp);
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                throw new IllegalArgumentException("Date is incorrect");
            }
        }
        totalDuration = totalDuration.dividedBy(sessionDates.size());
        return totalDuration.toHoursPart() + "ч " + totalDuration.toMinutesPart() + "м";
    }
}

