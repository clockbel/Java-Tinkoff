package edu.hw6.task1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import edu.hw6.Task1.DiskMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {

    private static final String TEST_FILE_PATH = "src/test/java/edu/hw6/task1/files/test.txt";
    private DiskMap diskMap;

    @BeforeEach
    void setUp() {
        diskMap = new DiskMap(TEST_FILE_PATH);
    }

    @AfterEach
    void clearFile() {
        diskMap.clear();
    }

    @Test
    @DisplayName("Size")
    void test1() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        assertEquals(2, diskMap.size());
    }

    @Test
    @DisplayName("IsEmpty")
    void test2() {
        assertTrue(diskMap.isEmpty());

        diskMap.put("k", "v");

        assertFalse(diskMap.isEmpty());
    }

    @Test
    @DisplayName("ContainsKey")
    void test3() {
        diskMap.put("key1", "value1");

        assertTrue(diskMap.containsKey("key1"));
        assertFalse(diskMap.containsKey("key"));
    }

    @Test
    @DisplayName("ContainsValue")
    void test4() {
        diskMap.put("key1", "value1");

        assertTrue(diskMap.containsValue("value1"));
        assertFalse(diskMap.containsValue("val"));
    }

    @Test
    @DisplayName("Get")
    void test5() {
        diskMap.put("key1", "value1");

        assertEquals("value1", diskMap.get("key1"));
        assertNull(diskMap.get("nonexistentKey"));
    }

    @Test
    @DisplayName("Put")
    void test6() {
        diskMap.put("key1", "value1");
        assertEquals("value1", diskMap.get("key1"));
    }

    @Test
    @DisplayName("Remove")
    void test7() {
        diskMap.put("key1", "value1");

        assertEquals("value1", diskMap.remove("key1"));
        assertNull(diskMap.remove("nonexistentKey"));
    }

    @Test
    @DisplayName("PutAll")
    void test8() {
        Map<String, String> testData = new HashMap<>();
        testData.put("key1", "value1");
        testData.put("key2", "value2");

        diskMap.putAll(testData);

        assertEquals(2, diskMap.size());
        assertEquals("value1", diskMap.get("key1"));
        assertEquals("value2", diskMap.get("key2"));
    }

    @Test
    @DisplayName("Clear")
    void test9() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        diskMap.clear();

        assertEquals(0, diskMap.size());
        assertTrue(diskMap.isEmpty());
    }

    @Test
    @DisplayName("KeySet")
    void test10() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        Set<String> keySet = diskMap.keySet();

        assertEquals(2, keySet.size());
        assertTrue(keySet.contains("key1"));
        assertTrue(keySet.contains("key2"));
    }

    @Test
    @DisplayName("Values")
    void test11() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        Collection<String> values = diskMap.values();

        assertEquals(2, values.size());
        assertTrue(values.contains("value1"));
        assertTrue(values.contains("value2"));
    }

    @Test
    @DisplayName("EntrySet")
    void test12() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        Set<Map.Entry<String, String>> entrySet = diskMap.entrySet();

        assertEquals(2, entrySet.size());
        assertTrue(entrySet.contains(Map.entry("key1", "value1")));
        assertTrue(entrySet.contains(Map.entry("key2", "value2")));
    }

}
