package edu.hw6.Task4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public class OutputStreamCompositionExample {
    public static void Filter(Path filePath) {
        // Шаг 1: Создаем файл и получаем OutputStream
        try (OutputStream fileOutputStream = Files.newOutputStream(filePath)) {

            // Шаг 2: Добавляем CheckedOutputStream для проверки записи при помощи контрольной суммы
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new CRC32());

            // Шаг 3: Добавляем BufferedOutputStream для буферизации данных
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);

            // Шаг 4: Добавляем OutputStreamWriter и включаем поддержку UTF-8
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");

            // Шаг 5: Добавляем финальный PrintWriter
            try (PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {
                // Шаг 6: Записываем текст в файл
                printWriter.println("Programming is learned by writing programs. ― Brian Kernighan");
            }

            // Шаг 7: Выводим контрольную сумму
            System.out.println("Checksum: " + checkedOutputStream.getChecksum().getValue());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
