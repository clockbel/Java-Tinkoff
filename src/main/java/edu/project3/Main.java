package edu.project3;

import edu.project3.LogAnalys.Log;
import edu.project3.LogAnalys.LogAnalys;
import edu.project3.LogAnalys.LogParse;
import edu.project3.ParseCMD.ArgumentsContainer;
import edu.project3.ParseCMD.ArgumentsParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws IOException {
        String s =
            "--path https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs --from 2015-05-17 --to 2015-05-19 --format adoc";
        //String s = "--path ./src/main/resources/logs/log.txt --from 2015-05-18 --to 2015-05-19 --format adoc";
        String[] arguments = s.split(" ");
        List<Log> logs = new ArrayList<>();
        ArgumentsContainer argumentsContainer = ArgumentsParser.parse(arguments);
        LOGGER.info(argumentsContainer);
        BufferedReader reader = argumentsContainer.file();
        String line;
        while ((line = reader.readLine()) != null) {
            LogParse logAnalys = new LogParse(line, argumentsContainer.from(), argumentsContainer.to());
            if (logAnalys.parseLog() != null) {
                logs.add(logAnalys.parseLog());
            }
        }
//        for (Log log : logs) {
//            LOGGER.info(log);
//        }
        LogAnalys logAnalys = new LogAnalys(logs);
        LOGGER.info(logAnalys.getTotalRequests());
        LOGGER.info(logAnalys.getAverageResponseSize());
        LOGGER.info(logAnalys.getResourceCountMap());
        LOGGER.info(logAnalys.getResponseCodeCountMap());
        LOGGER.info(logAnalys.getIpAddressMap());
        LOGGER.info(logAnalys.getUserAgentMap());
    }
}
