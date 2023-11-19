package edu.hw6.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import edu.hw6.Task4.OutputStreamCompositionExample;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {

    private static final Path TEST_FILE_PATH = Paths.get("src/test/java/edu/hw6/task4/files/test.txt");

    @BeforeEach
    void setUp() {
        createTestFile();
    }

    @AfterEach
    void clearDirectory() {
        deleteTestFiles();
    }

    @Test
    void testWriteTextToFile() throws IOException {
        OutputStreamCompositionExample.filter(TEST_FILE_PATH);
        try (BufferedReader reader = Files.newBufferedReader(TEST_FILE_PATH)) {
            String line = reader.readLine();
            assertEquals("Programming is learned by writing programs. ― Brian Kernighan", line);
        }
    }
    @Test
    void checkCheckSum() {
        OutputStreamCompositionExample.filter(TEST_FILE_PATH);
        assertEquals(OutputStreamCompositionExample.getCheckSum(), 266823);
    }

    private void createTestFile() {
        try {
            Path filePath = Paths.get(TEST_FILE_PATH.toUri());
            Files.createFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteTestFiles() {
        Path directoryPath = Paths.get("src/test/java/edu/hw6/task4/files");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath)) {
            for (Path file : directoryStream) {
                Files.delete(file);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error delete test files", e);
        }
    }
}
