package edu.hw5;

import edu.hw5.Task7.OneZeroAlphabet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Test1")
    public void Test1() {
        assertThat(OneZeroAlphabet.validateAlphabet1("100")).isTrue();
    }
    @Test
    @DisplayName("Test2")
    public void Test2() {
        assertThat(OneZeroAlphabet.validateAlphabet1("1011")).isFalse();
    }
    @Test
    @DisplayName("Test3")
    public void Test3() {
        assertThat(OneZeroAlphabet.validateAlphabet1("10")).isFalse();
    }
    @Test
    @DisplayName("Test4")
    public void Test4() {
        assertThat(OneZeroAlphabet.validateAlphabet2("101")).isTrue();
    }
    @Test
    @DisplayName("Test5")
    public void Test5() {
        assertThat(OneZeroAlphabet.validateAlphabet2("0011")).isFalse();
    }
    @Test
    @DisplayName("Test6")
    public void Test6() {
        assertThat(OneZeroAlphabet.validateAlphabet2("10")).isFalse();
    }
    @Test
    @DisplayName("Test7")
    public void Test7() {
        assertThat(OneZeroAlphabet.validateAlphabet3("10")).isTrue();
    }
    @Test
    @DisplayName("Test8")
    public void Test8() {
        assertThat(OneZeroAlphabet.validateAlphabet3("")).isFalse();
    }
    @Test
    @DisplayName("Test9")
    public void Test9() {
        assertThat(OneZeroAlphabet.validateAlphabet3("10110")).isFalse();
    }
}
