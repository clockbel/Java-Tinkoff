package edu.project3.ParseCMD;

import edu.project3.ArgumentsCorrector.ArgumentDate;
import edu.project3.ArgumentsCorrector.ArgumentFormat;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public final class ArgumentsParser {

    private ArgumentsParser() {
    }

    public static ArgumentsContainer parse(String[] args) throws IOException {
        int argumentsCount = args.length;
        String path = null;
        LocalDate from = null;
        LocalDate to = null;
        OutputFormat format = null;
        int plusI = 0;
        for (int i = 0; i < argumentsCount; i++) {
            plusI = i;
            if (Objects.equals(args[i], "--path") && i != argumentsCount - 1) {
                path = args[++plusI];
            }
            if (Objects.equals(args[i], "--from") && i != argumentsCount - 1) {
                from = ArgumentDate.parseDate(args[++plusI]);
            }
            if (Objects.equals(args[i], "--to") && i != argumentsCount - 1) {
                to = ArgumentDate.parseDate(args[++plusI]);
            }
            if (Objects.equals(args[i], "--format") && i != argumentsCount - 1) {
                format = ArgumentFormat.parseFormat(args[++plusI]);
            }
        }
        return new
            ArgumentsContainer(
            ReadPath.getBufferedReader(path
            ),
            from,
            to,
            format,
            path
        );
    }
}
