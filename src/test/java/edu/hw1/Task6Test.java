package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("countKTest_1")
    void countKTest_1() {
        int a = Task6.countK(3524);
        assertThat(a).isEqualTo(3);
    }
    @Test
    @DisplayName("countKTest_2")
    void countKTest_2() {
        int a = Task6.countK(6621);
        assertThat(a).isEqualTo(5);
    }
    @Test
    @DisplayName("countKTest_3")
    void countKTest_3() {
        int a = Task6.countK(6554);
        assertThat(a).isEqualTo(4);
    }
    @Test
    @DisplayName("countKTest_4")
    void countKTest_4() {
        int a = Task6.countK(1234);
        assertThat(a).isEqualTo(3);
    }
}
