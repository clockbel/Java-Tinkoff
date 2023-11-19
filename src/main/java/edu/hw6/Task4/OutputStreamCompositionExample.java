package edu.hw6.Task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class OutputStreamCompositionExample {
    private OutputStreamCompositionExample() {

    }

    private static long checkSum = 0;
    private final static Logger LOGGER = LogManager.getLogger();

    public static void filter(Path filePath) {
        try (OutputStream fileOutputStream = Files.newOutputStream(filePath)) {
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new CRC32());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
            try (PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {
                printWriter.println("Programming is learned by writing programs. ― Brian Kernighan");
            }
            checkSum = checkedOutputStream.getChecksum().getValue();
            LOGGER.info("Checksum: " + checkSum);
        } catch (IOException e) {
            LOGGER.info("Incorrect work");
        }
    }

    public static long getCheckSum() {
        return checkSum;
    }
}
