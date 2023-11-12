package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public final class CheckDate {
    private CheckDate() {

    }

    public static Optional<LocalDate> parseDate(String date) {
        return ParseDateYearMonthDay.parseDate(date).isPresent()
            ? ParseDateYearMonthDay.parseDate(date)
            : ParseDateDayMonthYear.parseDate(date).isPresent()
            ? ParseDateDayMonthYear.parseDate(date)
            : ParseDateAgoLetter.parseDate(date).isPresent()
            ? ParseDateAgoLetter.parseDate(date)
            : ParseDateCheckDay.parseDate(date).isPresent()
            ? ParseDateCheckDay.parseDate(date)
            : Optional.empty();
    }
}
