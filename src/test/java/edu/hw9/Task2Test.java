package edu.hw9;

import edu.hw9.task2.DirectorySearch;
import edu.hw9.task2.FileSearch;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class Task2Test {
    static @TempDir Path tmpDir;

    @BeforeAll
    public static void init() throws IOException {
        Path testDir1 = tmpDir.resolve("test1");
        Path testDir2 = tmpDir.resolve("test2");
        Files.createDirectory(testDir1);
        Files.createDirectory(testDir2);
        Files.createFile(tmpDir.resolve("test_0.txt"));
        Files.createFile(testDir1.resolve("test_1.txt"));
        Files.createFile(testDir2.resolve("test_2.txt"));
        createFileWithSize(tmpDir.resolve("test_3.png"), 20);
        createFileWithSize(testDir1.resolve("test_4.png"), 10);
    }

    @Test
    void DirectorySearchTest() throws FileNotFoundException {
        DirectorySearch searchTask = DirectorySearch.search(tmpDir, 2);
        List<Path> expResult = List.of(tmpDir, tmpDir.resolve("test1"));

        List<Path> result = ForkJoinPool.commonPool().invoke(searchTask);

        assertThat(result)
            .containsExactlyInAnyOrderElementsOf(expResult);
    }

    @Test
    void FileSearchTest() throws FileNotFoundException {
        Predicate<Path> predicate = file -> {
            try {
                return file.getFileName().toString().matches(".*\\.png") && Files.size(file) > 9;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        FileSearch searchTask = FileSearch.search(tmpDir, predicate);
        List<Path> expResult = List.of(
            tmpDir.resolve("test_3.png"),
            tmpDir.resolve("test1").resolve("test_4.png")
        );

        List<Path> result = ForkJoinPool.commonPool().invoke(searchTask);

        assertThat(result)
            .containsExactlyInAnyOrderElementsOf(expResult);
    }

    @Test
    void FileNotFoundTest() {
        assertThatExceptionOfType(FileNotFoundException.class)
            .isThrownBy(() -> FileSearch.search(Path.of("ser"), file -> true));

        assertThatExceptionOfType(FileNotFoundException.class)
            .isThrownBy(() -> DirectorySearch.search(Path.of("ssseerrr"), 10));
    }

    private static void createFileWithSize(Path file, long size) throws IOException {
        Files.createFile(file);
        byte[] data = new byte[(int) size];
        Files.write(file, data);
    }
}
