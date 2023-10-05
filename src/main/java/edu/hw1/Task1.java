package edu.hw1;

public final class Task1 {
    private Task1() {
    }

    public static int minutesToSeconds(String timeMinutes) {
        int timeSeconds = -1;
        int indexDoublePoint = timeMinutes.indexOf(':');
        if (indexDoublePoint != -1 && indexDoublePoint != 0 && indexDoublePoint != timeMinutes.length() - 1) {
            String[] pairs = timeMinutes.split(":");
            if (pairs.length == 2) {
                try {
                    final int secondsSixty = 60;
                    int minutes = Integer.parseInt(pairs[0]) * secondsSixty;
                    int seconds = Integer.parseInt(pairs[1]);
                    if (minutes >= 0 && seconds >= 0 && seconds < secondsSixty) {
                        timeSeconds = minutes + seconds;
                    }
                } catch (NumberFormatException ignored) {
                }
            }
        }
        return timeSeconds;
    }
}
