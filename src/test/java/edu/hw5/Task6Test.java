package edu.hw5;

import edu.hw5.Task6.SubsequenceChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Task6Test")
    public void Test1() {
        assertThat(SubsequenceChecker.isSubsequence("abc", "adfgaf")).isFalse();
    }
    @Test
    @DisplayName("Task6Test")
    public void Test2() {
        assertThat(SubsequenceChecker.isSubsequence("abc", "adfabcgaf")).isTrue();
    }
    @Test
    @DisplayName("Task6Test")
    public void Test3() {
        assertThat(SubsequenceChecker.isSubsequence(null, "adfabcgaf")).isFalse();
    }
}
