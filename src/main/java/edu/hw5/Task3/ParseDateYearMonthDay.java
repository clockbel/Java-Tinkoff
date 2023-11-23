package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public final class ParseDateYearMonthDay {
    private ParseDateYearMonthDay() {
    }

    public static Optional<LocalDate> parseDate(String date) {
        List<DateTimeFormatter> patterns = List.of(
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy-MM-d"),
            DateTimeFormatter.ofPattern("yyyy-M-dd"),
            DateTimeFormatter.ofPattern("yyyy-M-d")
        );
        for (DateTimeFormatter formatter : patterns) {
            Optional<LocalDate> parsedDate = parseFormat(date, formatter);
            if (parsedDate.isPresent()) {
                return parsedDate;
            }
        }
        return Optional.empty();
    }

    private static Optional<LocalDate> parseFormat(String date, DateTimeFormatter formatter) {
        try {
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            return Optional.of(parsedDate);
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
