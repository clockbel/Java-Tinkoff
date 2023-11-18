package edu.project3.ParseCMD;

import edu.project3.ArgumentsCorrector.ArgumentDate;
import edu.project3.ArgumentsCorrector.ArgumentFormat;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class ArgumentsParser {



    private ArgumentsParser() {
    }

    public static ArgumentsContainer parse(String[] args) throws IOException {
        int argumentsCount = args.length;
        if (argumentsCount < 1) {
            throw new IllegalArgumentException("Not enough arguments");
        }
        String path = null;
        LocalDate from = null;
        LocalDate to = null;
        OutputFormat format = null;
        for (int i = 0; i < argumentsCount; i++) {
            if (Objects.equals(args[i], "--path")) {
                path = args[++i];
            }
            if (Objects.equals(args[i], "--from") || Objects.equals(args[i], "--to")) {
                if (Objects.equals(args[i], "--from")) {
                    from = ArgumentDate.parseDate(args[++i]);
                } else {
                    to = ArgumentDate.parseDate(args[++i]);
                }
            }
            if (Objects.equals(args[i], "--format")) {
                format = ArgumentFormat.parseFormat(args[++i]);
            }
        }
        return new ArgumentsContainer(
            ReadPath.getBufferedReader(path),
            from,
            to,
            format
        );
    }
}
