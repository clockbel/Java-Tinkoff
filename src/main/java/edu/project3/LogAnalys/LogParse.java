package edu.project3.LogAnalys;

import edu.project3.LogCorrector.DateCorrector;
import java.time.LocalDate;
import java.util.regex.Matcher;

public class LogParse {
    private final String line;
    private final LocalDate from;
    private final LocalDate to;

    public LogParse(String line, LocalDate from, LocalDate to) {
        this.line = line;
        this.from = from;
        this.to = to;
    }

    @SuppressWarnings("MagicNumber")
    public Log parseLog() {
        Log log = null;
        Matcher matcher = LogCheck.checkLog(line);
        if (matcher.matches()) {
            LocalDate logDate = DateCorrector.parseDate(matcher.group(4));
            if ((to == null || logDate.isBefore(to) || logDate.isEqual(to))
                && (from == null || logDate.isAfter(from) || logDate.isEqual(from))) {
                return process(matcher);
            }
        } else {
            throw new RuntimeException("Incorrect log");
        }
        return log;
    }

    @SuppressWarnings("MagicNumber")
    private Log process(Matcher matcher) {
        String ip = matcher.group(1);
        String resource = extractResource(matcher.group(6));
        int responseCode = Integer.parseInt(matcher.group(8));
        int responseSize = Integer.parseInt(matcher.group(9));
        String userAgent = matcher.group(11);
        Log log = new Log(ip, resource, responseCode, responseSize, userAgent);
        return log;
    }

    private static String extractResource(String request) {
        String[] parts = request.split("\\s+");
        return parts.length > 1 ? parts[1] : request;
    }
}
