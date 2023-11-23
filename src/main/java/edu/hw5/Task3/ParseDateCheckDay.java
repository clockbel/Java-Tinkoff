package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public final class ParseDateCheckDay {
    private ParseDateCheckDay() {
    }

    public static Optional<LocalDate> parseDate(String date) {
        String today = "today";
        String tomorrow = "tomorrow";
        String yesterday = "yesterday";
        if (date.equals(today)) {
            return Optional.of(LocalDate.now());
        } else if (date.equals(tomorrow)) {
            return Optional.of(LocalDate.now().plusDays(1));
        } else if (date.equals(yesterday)) {
            return Optional.of(LocalDate.now().minusDays(1));
        }
        return Optional.empty();
    }
}
