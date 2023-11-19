package edu.project3;

import edu.project3.LogAnalysis.Log;
import edu.project3.LogAnalysis.LogAnalysis;
import edu.project3.LogAnalysis.LogParse;
import edu.project3.ParseCMD.ArgumentsContainer;
import edu.project3.ParseCMD.ArgumentsParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestLogAnalysis {

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
        LogAnalysis logAnalysis = new LogAnalysis(logs);
        int totalRequest = 2;
        long averageResponzeSize = 42809847;
        Map<String, Integer> resourceCountMap = new HashMap<>();
        resourceCountMap.put("/downloads/product_1", 2);
        Map<String, Integer> responseCountCodeMap = new HashMap<>();
        responseCountCodeMap.put("200", 2);
        Map<String, Integer> ipAdressMap = new HashMap<>();
        ipAdressMap.put("217.168.17.5", 1);
        ipAdressMap.put("2001:4801:7824:102:8bee:6e66:ff10:6aa2", 1);
        Map<String, Integer> userAgentMap = new HashMap<>();
        userAgentMap.put("Debian APT-HTTP/1.3 (0.8.10.3)", 1);
        userAgentMap.put("Chef Client/12.0.3 (ruby-2.1.4-p265; ohai-8.0.1; x86_64-linux; +http://opscode.com)", 1);
        assertThat(totalRequest).isEqualTo(logAnalysis.getTotalRequests());
        assertThat(averageResponzeSize).isEqualTo(logAnalysis.getAverageResponseSize());
        assertThat(resourceCountMap).isEqualTo(logAnalysis.getResourceCountMap());
        assertThat(responseCountCodeMap).isEqualTo(logAnalysis.getResponseCodeCountMap());
        assertThat(ipAdressMap).isEqualTo(logAnalysis.getIpAddressMap());
        assertThat(userAgentMap).isEqualTo(logAnalysis.getUserAgentMap());
    }

    @Test
    @DisplayName("ParseLog2")
    public void test2() {
        List<Log> logs = new ArrayList<>();
        Exception runTimeException = assertThrows(
            RuntimeException.class,() ->
            new LogAnalysis(logs)
        );
        String extendMessage = "List log is empty";
        String actualMessage = runTimeException.getMessage();
        assertThat(extendMessage).isEqualTo(actualMessage);
    }
}
