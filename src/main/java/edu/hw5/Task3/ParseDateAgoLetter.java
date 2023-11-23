package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public final class ParseDateAgoLetter {
    private ParseDateAgoLetter() {
    }

    public static Optional<LocalDate> parseDate(String date) {
        if (date.matches("\\d+ day(s)? (ago|letter)")) {
            String[] strings = date.split(" ");
            Optional<LocalDate> result;
            if (Objects.equals(strings[2], "ago")) {
                return Optional.of(LocalDate.now().minusDays(Long.parseLong(strings[0])));
            } else {
                return Optional.of(LocalDate.now().plusDays(Long.parseLong(strings[0])));
            }
        } else {
            return Optional.empty();
        }
    }
}
