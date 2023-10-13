package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("countDigitsTest_1")
    void countDigitsTest_1() {
        int a = Task2.countDigits(4666);
        assertThat(a).isEqualTo(4);
    }
    @Test
    @DisplayName("countDigitsTest_2")
    void countDigitsTest_2() {
        int a = Task2.countDigits(544);
        assertThat(a).isEqualTo(3);
    }
    @Test
    @DisplayName("countDigitsTest_3")
    void countDigitsTest_3() {
        int a = Task2.countDigits(0);
        assertThat(a).isEqualTo(1);
    }
    @Test
    @DisplayName("countDigitsTest_4")
    void countDigitsTest_4() {
        int a = Task2.countDigits(-10);
        assertThat(a).isEqualTo(2);
    }
}
