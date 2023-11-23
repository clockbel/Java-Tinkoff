package edu.project3;

import edu.project3.ParseCMD.ArgumentsContainer;
import edu.project3.ParseCMD.ArgumentsParser;
import edu.project3.ParseCMD.OutputFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCMDParser {
    @Test
    @DisplayName("ParseArgs1")
    public void test1() throws IOException {
        String arg = "--path src/test/java/edu/project3/files/log.txt --from 2015-05-17 --to 2015-05-18 --format adoc";
        String[] args = arg.split(" ");
        ArgumentsContainer argumentsContainer = ArgumentsParser.parse(args);
        assertThat(argumentsContainer.path()).isEqualTo("src/test/java/edu/project3/files/log.txt");
        assertThat(argumentsContainer.from()).isEqualTo("2015-05-17");
        assertThat(argumentsContainer.to()).isEqualTo("2015-05-18");
        assertThat(argumentsContainer.outputFormat()).isEqualTo(OutputFormat.ADOC);
    }

    @Test
    @DisplayName("ParseArgs2")
    public void test2() throws IOException {
        String arg = "--path src/test/java/edu/project3/files/log.txt";
        String[] args = arg.split(" ");
        ArgumentsContainer argumentsContainer = ArgumentsParser.parse(args);
        assertThat(argumentsContainer.path()).isEqualTo("src/test/java/edu/project3/files/log.txt");
        assertThat(argumentsContainer.from()).isNull();
        assertThat(argumentsContainer.to()).isNull();
        assertThat(argumentsContainer.outputFormat()).isEqualTo(null);
    }

    @Test
    @DisplayName("ParseArgs3")
    public void test3() throws IOException {
        String arg =
            "--path https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs --from 2015-05-17 --format markdown";
        String[] args = arg.split(" ");
        ArgumentsContainer argumentsContainer = ArgumentsParser.parse(args);
        assertThat(argumentsContainer.path()).isEqualTo(
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs");
        assertThat(argumentsContainer.from()).isEqualTo("2015-05-17");
        assertThat(argumentsContainer.to()).isNull();
        assertThat(argumentsContainer.outputFormat()).isEqualTo(OutputFormat.MARKDOWN);
    }

    @Test
    @DisplayName("ParseArgs4")
    public void test4() throws IOException {
        String arg = "--path src/test/java/edu/project3/files/log.txt --from 20150517 --format markdown";
        String[] args = arg.split(" ");
        ArgumentsContainer argumentsContainer = ArgumentsParser.parse(args);
        assertThat(argumentsContainer.path()).isEqualTo("src/test/java/edu/project3/files/log.txt");
        assertThat(argumentsContainer.from()).isNull();
        assertThat(argumentsContainer.to()).isNull();
        assertThat(argumentsContainer.outputFormat()).isEqualTo(OutputFormat.MARKDOWN);
    }

    @Test
    @DisplayName("ParseArgs5")
    public void test5() throws IOException {
        String arg = "--path src/test/java/edu/project3/files/log123.txt --from 2015-05-17 --format markdown";
        String[] args = arg.split(" ");

        Exception exception = assertThrows(
            IOException.class, () -> ArgumentsParser.parse(args)
        );
        String extendMessage = "File is not founded";
        String actualMessage = exception.getMessage();
        assertThat(extendMessage).isEqualTo(actualMessage);
    }

}
