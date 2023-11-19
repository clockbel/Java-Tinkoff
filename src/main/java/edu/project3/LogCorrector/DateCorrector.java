package edu.project3.LogCorrector;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class DateCorrector {
    private final static String DATE_FORMAT = "dd/MMM/yyyy:HH:mm:ss Z";
    private final static Logger LOGGER = LogManager.getLogger();

    private DateCorrector() {

    }

    public static LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.ENGLISH);
        LocalDate parsedDate = null;
        try {
            parsedDate = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException dateTimeParseException) {
            LOGGER.info("Invalid date format, use ISO8601");
        }
        return parsedDate;
    }
}
