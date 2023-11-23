package edu.hw5.Task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public final class FridayThirteen {
    private final static int FRIDAY_13 = 13;

    private FridayThirteen() {
    }

    public static List<LocalDate> getFridayThirteen(int year) {
        if (year <= 0) {
            return new ArrayList<>();
        }
        List<LocalDate> result = new ArrayList<>();
        LocalDate date = LocalDate.of(year, 1, FRIDAY_13);
        while (date.getYear() == year) {
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                result.add(date);
            }
            date = date.plusMonths(1);
        }
        return result;
    }

    public static LocalDate nextFridayThirteen(LocalDate date) {
        if (date == null) {
            return null;
        }
        LocalDate result = date.plusDays(1);
        while (!(result.getDayOfMonth() == FRIDAY_13 && result.getDayOfWeek() == DayOfWeek.FRIDAY)) {
            result = result.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return result;
    }
}
