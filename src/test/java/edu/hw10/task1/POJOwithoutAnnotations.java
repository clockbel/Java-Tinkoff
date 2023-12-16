package edu.hw10.task1;

import edu.hw10.task1.annotation.Max;
import edu.hw10.task1.annotation.Min;
import edu.hw10.task1.annotation.NotNull;

public class POJOwithoutAnnotations {
    private final int intValue;
    private final String stringValue;

    public POJOwithoutAnnotations(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public static POJOwithoutAnnotations create(int intValue, String stringValue) {
        return new POJOwithoutAnnotations(intValue, stringValue);
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
