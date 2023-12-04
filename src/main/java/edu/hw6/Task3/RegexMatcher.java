package edu.hw6.Task3;

import java.nio.file.Path;

public final class RegexMatcher {
    private RegexMatcher() {

    }

    public static String getFileName(Path path) {
        String fileName = path.getFileName().toString();
        int indexPoint = fileName.lastIndexOf('.');
        return (indexPoint == -1) ? fileName : fileName.substring(0, indexPoint);
    }
}
