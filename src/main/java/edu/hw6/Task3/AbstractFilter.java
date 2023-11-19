package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    default AbstractFilter and(AbstractFilter other) {
        return path -> accept(path) && other.accept(path);
    }

    static AbstractFilter regularFile() {
        return Files::isRegularFile;
    }

    static AbstractFilter readable() {
        return Files::isReadable;
    }

    static AbstractFilter writeble() {
        return Files::isWritable;
    }

    static AbstractFilter smallerThan(long size) {
        return entry -> Files.size(entry) < size;
    }

    static AbstractFilter largerThan(long size) {
        return entry -> Files.size(entry) > size;
    }

    static AbstractFilter magicNumber(int... magicBytes) {
        return entry -> {
            try {
                byte[] header = Files.readAllBytes(entry);
                if (header.length < magicBytes.length) {
                    return false;
                }
                for (int i = 0; i < magicBytes.length; i++) {
                    if (header[i] != (byte) magicBytes[i]) {
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        };
    }

    static AbstractFilter globMatches(String glob) {
        return entry -> FileSystems.getDefault().getPathMatcher("glob:" + glob).matches(entry.getFileName());
    }

    static AbstractFilter regexMatches(String regex) {
        return entry -> RegexMatcher.getFileName(entry).toString().matches(regex);
    }
}
