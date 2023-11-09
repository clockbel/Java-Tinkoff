package edu.hw5.Task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ComputerClubAnalytics {
    private static final String DATETIME_PATTERN = "yyyy-MM-dd, HH:mm";

    public static String Session(String[] sessionDates) {
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
        return totalDuration.toHoursPart() + "ч " + totalDuration.toMinutesPart()+ "м";
    }

    public static void main(String[] args) {
        String[] times =
            new String[] {"2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20"};
        System.out.println(Session(times));
    }
}

