package edu.project3;

import edu.project3.LogAnalys.Log;
import edu.project3.LogAnalys.LogAnalys;
import edu.project3.LogAnalys.LogParse;
import edu.project3.Output.AdocOutput;
import edu.project3.Output.MarkdownOutput;
import edu.project3.ParseCMD.ArgumentsContainer;
import edu.project3.ParseCMD.ArgumentsParser;
import edu.project3.ParseCMD.OutputFormat;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {
    private Main() {

    }

    private final static Logger LOGGER = LogManager.getLogger();
    private final static int MIN_ARGS = 2;

    @SuppressWarnings("checkstyle:UncommentedMain")

    public static void main(String[] args) throws IOException {
        if (args.length < MIN_ARGS) {
            System.exit(1);
        }
        List<Log> logs = new ArrayList<>();
        ArgumentsContainer argumentsContainer = ArgumentsParser.parse(args);
        BufferedReader reader = argumentsContainer.file();
        String line;
        while ((line = reader.readLine()) != null) {
            LogParse logAnalyse = new LogParse(line, argumentsContainer.from(), argumentsContainer.to());
            if (logAnalyse.parseLog() != null) {
                logs.add(logAnalyse.parseLog());
            }
        }
        LogAnalys logAnalys = new LogAnalys(logs);
        if (argumentsContainer.outputFormat() == OutputFormat.MARKDOWN) {
            MarkdownOutput.printResult(
                argumentsContainer.path(),
                argumentsContainer.from(),
                argumentsContainer.to(),
                logAnalys
            );
        } else {
            AdocOutput.printResult(
                argumentsContainer.path(),
                argumentsContainer.from(),
                argumentsContainer.to(),
                logAnalys
            );
        }
    }
}
