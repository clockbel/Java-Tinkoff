package edu.hw3;

import edu.hw3.Task3.CountElementsInDict;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3Test {
    @Test
    @DisplayName("Test1")
    public void Test1() {
        List<Object> list = new ArrayList<>();
        list.add("a");
        list.add("bb");
        list.add("a");
        list.add("bb");
        Map<String , Integer> result = new HashMap<>();
        result.put("bb", 2);
        result.put("a", 2);
        assertThat(CountElementsInDict.freqDict(list)).isEqualTo(result);
    }
    @Test
    @DisplayName("Test2")
    public void Test2() {
        List<Object> list = new ArrayList<>();
        list.add("this");
        list.add("and");
        list.add("that");
        list.add("and");
        Map<String , Integer> result = new HashMap<>();
        result.put("that", 1);
        result.put("and", 2);
        result.put("this", 1);
        assertThat(CountElementsInDict.freqDict(list)).isEqualTo(result);
    }

    @Test
    @DisplayName("Test3")
    public void Test3() {
        List<Object> list = new ArrayList<>();
        list.add("код");
        list.add("код");
        list.add("код");
        list.add("bug");
        Map<String , Integer> result = new HashMap<>();
        result.put("код", 3);
        result.put("bug", 1);
        assertThat(CountElementsInDict.freqDict(list)).isEqualTo(result);
    }
    @Test
    @DisplayName("Test4")
    public void Test4() {
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        Map<Integer , Integer> result = new HashMap<>();
        result.put(1, 2);
        result.put(2, 2);
        assertThat(CountElementsInDict.freqDict(list)).isEqualTo(result);
    }

    @Test
    @DisplayName("Test5")
    public void Test5() {
        assertThat(CountElementsInDict.freqDict(null)).isNull();
    }
}
