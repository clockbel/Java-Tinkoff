package edu.project3.LogCorrector;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.logging.Logger;

public class DateCorrector {
    private final static String DATE_FORMAT = "dd/MMM/yyyy:HH:mm:ss Z";
    private DateCorrector() {

    }
    public static LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.ENGLISH);
        LocalDate parsedDate = null;
        try {
            parsedDate = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException dateTimeParseException) {
            System.out.println("Invalid date format, use ISO8601");
        }
        return parsedDate;
    }
}
