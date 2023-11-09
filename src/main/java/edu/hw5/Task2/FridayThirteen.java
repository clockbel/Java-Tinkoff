package edu.hw5.Task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class FridayThirteen {
    public static List<LocalDate> getFridayThirteen(int year) {
        if (year <= 0) {
            return new ArrayList<>();
        }
        List<LocalDate> result = new ArrayList<>();
        LocalDate date = LocalDate.of(year, 1, 13);
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
        while (!(result.getDayOfMonth() == 13 && result.getDayOfWeek() == DayOfWeek.FRIDAY)) {
            result = result.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return result;
    }

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.of(2023, 1, 1); // Замените на нужную дату
        LocalDate nextFridayThe13th = nextFridayThirteen(currentDate);
        System.out.println("Следующая пятница 13-го: " + nextFridayThe13th);
        List<LocalDate> list = getFridayThirteen(2023);
        System.out.println(list);
    }
}
