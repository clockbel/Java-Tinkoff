package edu.project3;

import edu.project3.LogAnalysis.Log;
import edu.project3.LogAnalysis.LogAnalysis;
import edu.project3.LogAnalysis.LogParse;
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
//        String arg = "--path https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs --from 2015-05-17 --to 2015-05-18 --format markdown";
//        args = arg.split(" ");
        List<Log> logs = new ArrayList<>();
        ArgumentsContainer argumentsContainer = ArgumentsParser.parse(args);
        BufferedReader reader = argumentsContainer.file();
        String line;
        while ((line = reader.readLine()) != null) {
            LogParse logParse = new LogParse(line, argumentsContainer.from(), argumentsContainer.to());
            if (logParse.parseLog() != null) {
                logs.add(logParse.parseLog());
            }
        }
        LogAnalysis logAnalysis = new LogAnalysis(logs);
        if (argumentsContainer.outputFormat() == OutputFormat.MARKDOWN) {
            MarkdownOutput.printResult(
                argumentsContainer.path(),
                argumentsContainer.from(),
                argumentsContainer.to(),
                logAnalysis
            );
        } else {
            AdocOutput.printResult(
                argumentsContainer.path(),
                argumentsContainer.from(),
                argumentsContainer.to(),
                logAnalysis
            );
        }
    }
}
