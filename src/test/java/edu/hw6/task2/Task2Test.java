package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import edu.hw6.Task2.FileCloner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {

    private static final String TEST_FILE_PATH = "src/test/java/edu/hw6/task2/files/Tinkoff Bank Biggest Secret.txt";

    @BeforeEach
    void set() {
        createTestFile();
    }

    @AfterEach
    void clear() {
        deleteTestFiles();
    }

    @Test
    @DisplayName("CloneFile")
    void test1() {
        Path filePath = Paths.get(TEST_FILE_PATH);
        FileCloner.cloneFile(filePath);

        Path copiedFilePath = Paths.get(TEST_FILE_PATH.replace(".txt", " — копия.txt"));
        assertTrue(Files.exists(copiedFilePath));

    }

    @Test
    @DisplayName("CloneTwoFiles")
    void test2() {
        Path filePath = Paths.get(TEST_FILE_PATH);
        FileCloner.cloneFile(filePath);

        FileCloner.cloneFile(filePath);

        Path firstCopyPath = Paths.get(TEST_FILE_PATH.replace(".txt", " — копия.txt"));
        Path secondCopyPath = Paths.get(TEST_FILE_PATH.replace(".txt", " — копия (2).txt"));
        assertTrue(Files.exists(firstCopyPath));
        assertTrue(Files.exists(secondCopyPath));

    }

    private void createTestFile() {
        try {
            Path filePath = Paths.get(TEST_FILE_PATH);
            Files.createFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteTestFiles() {
        Path directoryPath = Paths.get("src/test/java/edu/hw6/task2/files");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath)) {
            for (Path file : directoryStream) {
                if (!file.equals(Paths.get("src/test/java/edu/hw6/task2/testFiles/1.java"))) {
                    Files.delete(file);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
