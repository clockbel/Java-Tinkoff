package edu.project3;

import edu.project3.LogAnalysis.Log;
import edu.project3.LogAnalysis.LogParse;
import edu.project3.ParseCMD.ArgumentsContainer;
import edu.project3.ParseCMD.ArgumentsParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestLogParser {

    private final static Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("ParseLog1")
    public void test1() throws IOException {
        String arg = "--path src/test/java/edu/project3/files/log.txt --from 2015-05-17 --to 2015-05-18 --format adoc";
        String[] args = arg.split(" ");
        ArgumentsContainer argumentsContainer = ArgumentsParser.parse(args);
        String line;
        List<Log> logs = new ArrayList<>();
        while ((line = argumentsContainer.file().readLine()) != null) {
            LogParse logParse = new LogParse(line, argumentsContainer.from(), argumentsContainer.to());
            if (logParse.parseLog() != null) {
                logs.add(logParse.parseLog());
            }
        }
        List<Log> result = new ArrayList<>();
        result.add(new Log(
            "217.168.17.5",
            "/downloads/product_1",
            200,
            490,
            "Debian APT-HTTP/1.3 (0.8.10.3)"
        ));
        result.add(new Log(
            "2001:4801:7824:102:8bee:6e66:ff10:6aa2",
            "/downloads/product_1",
            200,
            85619205,
            "Chef Client/12.0.3 (ruby-2.1.4-p265; ohai-8.0.1; x86_64-linux; +http://opscode.com)"
        ));
        assertThat(logs).isEqualTo(result);
    }

    @Test
    @DisplayName("ParseLog2")
    public void test2() throws IOException {
        String arg = "--path src/test/java/edu/project3/files/empty.txt";
        String[] args = arg.split(" ");
        ArgumentsContainer argumentsContainer = ArgumentsParser.parse(args);
        String line;
        List<Log> logs = new ArrayList<>();
        while ((line = argumentsContainer.file().readLine()) != null) {
            LogParse logParse = new LogParse(line, argumentsContainer.from(), argumentsContainer.to());
            if (logParse.parseLog() != null) {
                logs.add(logParse.parseLog());
            }
        }
        List<Log> result = new ArrayList<>();
        assertThat(logs).isEqualTo(result);
    }

    @Test
    @DisplayName("ParseLog3")
    public void test3() throws IOException {
        String arg = "--path src/test/java/edu/project3/files/incorrectLog.txt";
        String[] args = arg.split(" ");
        ArgumentsContainer argumentsContainer = ArgumentsParser.parse(args);
        LogParse logParse = new LogParse(argumentsContainer.file().readLine(), argumentsContainer.from(), argumentsContainer.to());
        Exception runTimeException = assertThrows(
            RuntimeException.class,
            logParse::parseLog
        );
        String extendMessage = "Incorrect log";
        String actualMessage = runTimeException.getMessage();
        assertThat(extendMessage).isEqualTo(actualMessage);
    }
}
