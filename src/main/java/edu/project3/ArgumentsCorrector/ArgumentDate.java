package edu.project3.ArgumentsCorrector;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ArgumentDate {
    private final static String DATE_FORMAT = "yyyy-MM-dd";
    private ArgumentDate() {

    }
    public static LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate parsedDate = null;
        try {
            parsedDate = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException dateTimeParseException) {
            System.out.println("Invalid date format, use ISO8601");
        }
        return parsedDate;
    }
}
