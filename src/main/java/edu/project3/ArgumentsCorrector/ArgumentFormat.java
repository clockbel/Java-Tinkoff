package edu.project3.ArgumentsCorrector;

import edu.project3.ParseCMD.OutputFormat;

import java.util.Objects;

public class ArgumentFormat {

    private final static String MARKDOWN = "markdown";
    private final static String ADOC = "adoc";

    private ArgumentFormat() {

    }

    public static OutputFormat parseFormat(String format) {
        if (Objects.equals(format, MARKDOWN)) {
            return OutputFormat.MARKDOWN;
        } else if (Objects.equals(format, ADOC)) {
            return OutputFormat.ADOC;
        } else {
            return null;
        }
    }
}
