package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public final class ParseDateDayMonthYear {
    private ParseDateDayMonthYear() {
    }

    public static Optional<LocalDate> parseDate(String date) {
        List<DateTimeFormatter> patterns = List.of(
            DateTimeFormatter.ofPattern("d/M/yyyy"),
            DateTimeFormatter.ofPattern("d/M/yy"),
            DateTimeFormatter.ofPattern("d/MM/yyyy"),
            DateTimeFormatter.ofPattern("d/MM/yy"),
            DateTimeFormatter.ofPattern("dd/M/yyyy"),
            DateTimeFormatter.ofPattern("dd/M/yy"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("dd/MM/yy")
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
