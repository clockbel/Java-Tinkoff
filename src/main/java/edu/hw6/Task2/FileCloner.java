package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCloner {

    public static void cloneFile(Path path) {
        String fileName = path.getFileName().toString();
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        String extension = fileName.substring(fileName.lastIndexOf('.'));

        Path destinationPath = path.getParent();
        int copyNumber = 1;

        while (Files.exists(destinationPath.resolve(fileName))) {
            String copyName = baseName + " — копия";
            if (copyNumber > 1) {
                copyName += " (" + copyNumber + ")";
            }
            copyName += extension;

            fileName = copyName;
            copyNumber++;
        }

        Path destinationFile = destinationPath.resolve(fileName);

        try {
            Files.copy(path, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File cloned successfully. New file: " + destinationFile);
        } catch (IOException e) {
            System.err.println("Error cloning file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Пример использования
        Path sourcePath = Paths.get("./src/main/java/hw6/Task2/file.txt");
        cloneFile(sourcePath);
    }
}
