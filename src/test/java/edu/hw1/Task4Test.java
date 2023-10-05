package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Task4Test_1")
    void Task4Test_1() {
        String a = Task4.fixString("123456");
        assertThat(a).isEqualTo("214365");
    }
    @Test
    @DisplayName("Task4Test_2")
    void Task4Test_2() {
        String a = Task4.fixString("hTsii  s aimex dpus rtni.g");
        assertThat(a).isEqualTo("This is a mixed up string.");
    }
    @Test
    @DisplayName("Task4Test_3")
    void Task4Test_3() {
        String a = Task4.fixString("badce");
        assertThat(a).isEqualTo("abcde");
    }
    @Test
    @DisplayName("Task4Test_4")
    void Task4Test_4() {
        String a = Task4.fixString("1");
        assertThat(a).isEqualTo("1");
    }
    @Test
    @DisplayName("Task4Test_5")
    void Task4Test_5() {
        String a = Task4.fixString("");
        assertThat(a).isEqualTo("");
    }

}
