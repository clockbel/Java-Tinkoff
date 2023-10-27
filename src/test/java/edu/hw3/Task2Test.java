package edu.hw3;

import edu.hw3.Task2.ClasterBrackets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Test1")
    public void Test1() {
        String string = "()()()";
        ArrayList<String> result = new ArrayList<>();
        result.add("()");
        result.add("()");
        result.add("()");
        assertThat(ClasterBrackets.clusterize(string)).isEqualTo(result);
    }

    @Test
    @DisplayName("Test2")
    public void Test2() {
        String string = "((()))";
        ArrayList<String> result = new ArrayList<>();
        result.add("((()))");
        assertThat(ClasterBrackets.clusterize(string)).isEqualTo(result);
    }

    @Test
    @DisplayName("Test3")
    public void Test3() {
        String string = "((())";
        ArrayList<String> result = new ArrayList<>();
        assertThat(ClasterBrackets.clusterize(string)).isEqualTo(result);
    }

    @Test
    @DisplayName("Test4")
    public void Test4() {
        String string = "((()))(())()()(()())";
        ArrayList<String> result = new ArrayList<>();
        result.add("((()))");
        result.add("(())");
        result.add("()");
        result.add("()");
        result.add("(()())");
        assertThat(ClasterBrackets.clusterize(string)).isEqualTo(result);
    }

    @Test
    @DisplayName("Test5")
    public void Test5() {
        String string = "((())())(()(()()))";
        ArrayList<String> result = new ArrayList<>();
        result.add("((())())");
        result.add("(()(()()))");
        assertThat(ClasterBrackets.clusterize(string)).isEqualTo(result);
    }
}
