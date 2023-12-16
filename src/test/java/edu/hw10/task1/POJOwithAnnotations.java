package edu.hw10.task1;

import edu.hw10.task1.annotation.Max;
import edu.hw10.task1.annotation.Min;
import edu.hw10.task1.annotation.NotNull;

public class POJOwithAnnotations {
    @Min(10)
    @Max(100)
    private final int intValue;
    @NotNull
    private final String stringValue;

    public POJOwithAnnotations(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public static POJOwithAnnotations create(int intValue, String stringValue) {
        return new POJOwithAnnotations(intValue, stringValue);
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
