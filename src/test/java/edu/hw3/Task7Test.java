package edu.hw3;

import edu.hw3.Task7.NullComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Test1")
    public void Test1() {
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator<>());
        tree.put(null, null);
        assertThat(tree.containsKey(null)).isTrue();
    }
    @Test
    @DisplayName("Test2")
    public void Test2() {
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator<>());
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }
}
