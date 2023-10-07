package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("rotateLeftTest_1")
    void rotateLeftTest_1() {
        int a = Task7.rotateLeft(8, 1);
        assertThat(a).isEqualTo(1);
    }
    @Test
    @DisplayName("rotateLeftTest_2")
    void rotateLeftTest_2() {
        int a = Task7.rotateLeft(16, 2);
        assertThat(a).isEqualTo(2);
    }
    @Test
    @DisplayName("rotateLeftTest_3")
    void rotateLeftTest_3() {
        int a = Task7.rotateLeft(17, 2);
        assertThat(a).isEqualTo(6);
    }
    @Test
    @DisplayName("rotateLeftTest_4")
    void rotateLeftTest_4() {
        int a = Task7.rotateLeft(-16, 1);
        assertThat(a).isEqualTo(1);
    }
    @Test
    @DisplayName("rotateLeftTest_5")
    void rotateLeftTest_5() {
        int a = Task7.rotateLeft(16, 21);
        assertThat(a).isEqualTo(1);
    }
    @Test
    @DisplayName("rotateRightTest_1")
    void rotateRightTest_1() {
        int a = Task7.rotateRight(8, 1);
        assertThat(a).isEqualTo(4);
    }
    @Test
    @DisplayName("rotateRightTest_2")
    void rotateRightTest_2() {
        int a = Task7.rotateRight(16, 1);
        assertThat(a).isEqualTo(8);
    }
    @Test
    @DisplayName("rotateRightTest_3")
    void rotateRightTest_3() {
        int a = Task7.rotateRight(17, 2);
        assertThat(a).isEqualTo(12);
    }
    @Test
    @DisplayName("rotateRightTest_4")
    void rotateRightTest_4() {
        int a = Task7.rotateRight(-17, 2);
        assertThat(a).isEqualTo(12);
    }
    @Test
    @DisplayName("rotateRightTest_5")
    void rotateRightTest_5() {
        int a = Task7.rotateRight(17, 22);
        assertThat(a).isEqualTo(12);
    }
}
