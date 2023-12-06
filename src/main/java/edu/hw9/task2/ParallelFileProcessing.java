package edu.hw9.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelFileProcessing {

    public static void main(String[] args) {
        // Укажите корневую директорию для обработки
        String rootPath = "src/main/java/edu/hw9";
        File rootDirectory = new File(rootPath);

        // Создаем ForkJoinPool с количеством доступных процессоров
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // Поиск директорий, в которых больше 1000 файлов
        int threshold = 1000;
        FindDirectoriesTask findDirectoriesTask = new FindDirectoriesTask(rootDirectory, threshold);
        List<File> directoriesWithManyFiles = forkJoinPool.invoke(findDirectoriesTask);

        System.out.println("Directories with more than 1000 files:");
        directoriesWithManyFiles.forEach(System.out::println);

        // Поиск файлов по предикату: размер, расширение
        String targetExtension = ".java";
        long targetSize = 1024; // Размер в байтах
        FindFilesTask findFilesTask = new FindFilesTask(rootDirectory, targetSize, targetExtension);
        List<File> matchingFiles = forkJoinPool.invoke(findFilesTask);

        System.out.println("\nFiles matching the criteria:");
        matchingFiles.forEach(System.out::println);
    }
}

