package edu.hw9.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FindDirectoriesTask extends RecursiveTask<List<File>> {
    private final File directory;
    private final int threshold;

    FindDirectoriesTask(File directory, int threshold) {
        this.directory = directory;
        this.threshold = threshold;
    }

    @Override
    protected List<File> compute() {
        List<File> result = new ArrayList<>();

        File[] files = directory.listFiles();
        if (files != null) {
            List<FindDirectoriesTask> subTasks = new ArrayList<>();

            for (File file : files) {
                if (file.isDirectory()) {
                    FindDirectoriesTask subTask = new FindDirectoriesTask(file, threshold);
                    subTask.fork();
                    subTasks.add(subTask);
                }
            }

            for (FindDirectoriesTask subTask : subTasks) {
                result.addAll(subTask.join());
            }

            if (files.length > threshold) {
                result.add(directory);
            }
        }

        return result;
    }
}
