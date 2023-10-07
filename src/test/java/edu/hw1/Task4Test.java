package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("fixStringTest_1")
    void fixStringTest_1() {
        String a = Task4.fixString("123456");
        assertThat(a).isEqualTo("214365");
    }
    @Test
    @DisplayName("fixStringTest_2")
    void fixStringTest_2() {
        String a = Task4.fixString("hTsii  s aimex dpus rtni.g");
        assertThat(a).isEqualTo("This is a mixed up string.");
    }
    @Test
    @DisplayName("fixStringTest_3")
    void fixStringTest_3() {
        String a = Task4.fixString("badce");
        assertThat(a).isEqualTo("abcde");
    }
    @Test
    @DisplayName("fixStringTest_4")
    void fixStringTest_4() {
        String a = Task4.fixString("1");
        assertThat(a).isEqualTo("1");
    }
    @Test
    @DisplayName("fixStringTest_5")
    void fixStringTest_5() {
        String a = Task4.fixString("");
        assertThat(a).isEqualTo("");
    }

}
