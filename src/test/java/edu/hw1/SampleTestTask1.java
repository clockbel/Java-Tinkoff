package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTestTask1 {
    @Test
    @DisplayName("minutesToSecondsTest_1")
    void minutesToSecondsTest_1() {
        int a = Task1.minutesToSeconds("10:10");
        assertThat(a).isEqualTo(610);
    }
    @Test
    @DisplayName("minutesToSecondsTest_2")
    void minutesToSecondsTest_2() {
        int a = Task1.minutesToSeconds("1234:56");
        assertThat(a).isEqualTo(74096);
    }
    @Test
    @DisplayName("minutesToSecondsTest_3")
    void minutesToSecondsTest_3() {
        int a = Task1.minutesToSeconds("100:60");
        assertThat(a).isEqualTo(-1);
    }
    @Test
    @DisplayName("minutesToSecondsTest_4")
    void minutesToSecondsTest_4() {
        int a = Task1.minutesToSeconds("100:10:10");
        assertThat(a).isEqualTo(-1);
    }
    @Test
    @DisplayName("minutesToSecondsTest_5")
    void minutesToSecondsTest_5() {
        int a = Task1.minutesToSeconds("100:abc");
        assertThat(a).isEqualTo(-1);
    }
    @Test
    @DisplayName("minutesToSecondsTest_6")
    void minutesToSecondsTest_6() {
        int a = Task1.minutesToSeconds("100:-10");
        assertThat(a).isEqualTo(-1);
    }
    @Test
    @DisplayName("minutesToSecondsTest_7")
    void minutesToSecondsTest_7() {
        int a = Task1.minutesToSeconds("10010");
        assertThat(a).isEqualTo(-1);
    }
}
