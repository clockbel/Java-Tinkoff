package edu.hw6.task1;

import edu.hw6.Task1.DiskMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Test1")
    void Test1() {
        DiskMap diskMap = new DiskMap("./src/test/java/edu/hw6/task1/text.txt");
        assertThat(diskMap.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test2")
    void Test2() {
        DiskMap diskMap = new DiskMap("./src/test/java/edu/hw6/task1/text.txt");
        assertThat(diskMap.get("123")).isEqualTo("hi");
    }

    @Test
    @DisplayName("Test3")
    void Test3() {
        DiskMap diskMap = new DiskMap("./src/test/java/edu/hw6/task1/text.txt");
        diskMap.put("10", "rr");
        assertThat(diskMap.get("10")).isEqualTo("rr");
    }
}
