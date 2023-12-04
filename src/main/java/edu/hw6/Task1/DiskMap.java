package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class DiskMap implements Map<String, String> {

    private final String filePath;
    private final Map<String, String> inMemoryMap;

    private final static Logger LOGGER = LogManager.getLogger();

    public DiskMap(String filePath) {
        this.filePath = filePath;
        this.inMemoryMap = new HashMap<>();
        loadFromDisk();
    }

    private void loadFromDisk() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    inMemoryMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    private void saveToDisk() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : inMemoryMap.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    @Override
    public int size() {
        return inMemoryMap.size();
    }

    @Override
    public boolean isEmpty() {
        return inMemoryMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return inMemoryMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return inMemoryMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return inMemoryMap.get(key);
    }

    @Override
    public String put(String key, String value) {
        String oldValue = inMemoryMap.put(key, value);
        saveToDisk();
        return oldValue;
    }

    @Override
    public String remove(Object key) {
        String removedValue = inMemoryMap.remove(key);
        saveToDisk();
        return removedValue;
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        inMemoryMap.putAll(m);
        saveToDisk();
    }

    @Override
    public void clear() {
        inMemoryMap.clear();
        saveToDisk();
    }

    @Override
    public @NotNull Set<String> keySet() {
        return inMemoryMap.keySet();
    }

    @Override
    public @NotNull Collection<String> values() {
        return inMemoryMap.values();
    }

    @Override
    public @NotNull Set<Entry<String, String>> entrySet() {
        return inMemoryMap.entrySet();
    }
}
