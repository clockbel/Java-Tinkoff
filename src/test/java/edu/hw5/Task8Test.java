package edu.hw5;

import edu.hw5.Task8.OneZeroAlphabet2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Test1")
    public void Test1() {
        assertThat(OneZeroAlphabet2.validateAlphabet1("100")).isTrue();
    }
    @Test
    @DisplayName("Test2")
    public void Test2() {
        assertThat(OneZeroAlphabet2.validateAlphabet1("1011")).isFalse();
    }
    @Test
    @DisplayName("Test3")
    public void Test3() {
        assertThat(OneZeroAlphabet2.validateAlphabet2("010")).isTrue();
    }
    @Test
    @DisplayName("Test4")
    public void Test4() {
        assertThat(OneZeroAlphabet2.validateAlphabet2("1010")).isTrue();
    }
    @Test
    @DisplayName("Test5")
    public void Test5() {
        assertThat(OneZeroAlphabet2.validateAlphabet2("0011")).isFalse();
    }
    @Test
    @DisplayName("Test6")
    public void Test6() {
        assertThat(OneZeroAlphabet2.validateAlphabet2("110")).isFalse();
    }
    @Test
    @DisplayName("Test7")
    public void Test7() {
        assertThat(OneZeroAlphabet2.validateAlphabet3("10010")).isTrue();
    }
    @Test
    @DisplayName("Test8")
    public void Test8() {
        assertThat(OneZeroAlphabet2.validateAlphabet3("100")).isFalse();
    }
    @Test
    @DisplayName("Test9")
    public void Test9() {
        assertThat(OneZeroAlphabet2.validateAlphabet3("11111")).isFalse();
    }
    @Test
    @DisplayName("Test10")
    public void Test10() {
        assertThat(OneZeroAlphabet2.validateAlphabet4("110")).isTrue();
    }
    @Test
    @DisplayName("Test11")
    public void Test11() {
        assertThat(OneZeroAlphabet2.validateAlphabet4("1010")).isTrue();
    }
    @Test
    @DisplayName("Test12")
    public void Test12() {
        assertThat(OneZeroAlphabet2.validateAlphabet4("11")).isFalse();
    }
    @Test
    @DisplayName("Test13")
    public void Test13() {
        assertThat(OneZeroAlphabet2.validateAlphabet4("111")).isFalse();
    }
}
