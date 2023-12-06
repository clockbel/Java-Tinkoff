package edu.hw9.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FindFilesTask extends RecursiveTask<List<File>> {
    private final File directory;
    private final long targetSize;
    private final String targetExtension;

    FindFilesTask(File directory, long targetSize, String targetExtension) {
        this.directory = directory;
        this.targetSize = targetSize;
        this.targetExtension = targetExtension;
    }

    @Override
    protected List<File> compute() {
        List<File> result = new ArrayList<>();

        File[] files = directory.listFiles();
        if (files != null) {
            List<FindFilesTask> subTasks = new ArrayList<>();

            for (File file : files) {
                if (file.isDirectory()) {
                    FindFilesTask subTask = new FindFilesTask(file, targetSize, targetExtension);
                    subTask.fork();
                    subTasks.add(subTask);
                } else {
                    // Проверяем условия для файла (размер, расширение)
                    if (file.length() == targetSize && file.getName().endsWith(targetExtension)) {
                        result.add(file);
                    }
                }
            }

            for (FindFilesTask subTask : subTasks) {
                result.addAll(subTask.join());
            }
        }

        return result;
    }
}
