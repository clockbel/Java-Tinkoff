package edu.hw10.task1;

import edu.hw10.task1.annotation.Max;
import edu.hw10.task1.annotation.Min;
import edu.hw10.task1.annotation.NotNull;

record RecordWithAnnotations(@Min(10) @Max(1000) int value, @NotNull String string) {
    public static RecordWithAnnotations start(int value, String string) {
        return new RecordWithAnnotations(value, string);
    }
}
