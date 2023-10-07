package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task5Test {
    @Test
    @DisplayName("isPalindromeDescendantTest_1")
    void isPalindromeDescendantTest_1() {
        boolean a = Task5.isPalindromeDescendant(11211230);
        assertThat(a).isEqualTo(true);
    }
    @Test
    @DisplayName("isPalindromeDescendantTest_2")
    void isPalindromeDescendantTest_2() {
        boolean a = Task5.isPalindromeDescendant(13001120);
        assertThat(a).isEqualTo(true);
    }
    @Test
    @DisplayName("isPalindromeDescendantTest_3")
    void isPalindromeDescendantTest_3() {
        boolean a = Task5.isPalindromeDescendant(23336014);
        assertThat(a).isEqualTo(true);
    }
    @Test
    @DisplayName("isPalindromeDescendantTest_4")
    void isPalindromeDescendantTest_4() {
        boolean a = Task5.isPalindromeDescendant(11);
        assertThat(a).isEqualTo(true);
    }
    @Test
    @DisplayName("isPalindromeDescendantTest_5")
    void isPalindromeDescendantTest_5() {
        boolean a = Task5.isPalindromeDescendant(1234);
        assertThat(a).isEqualTo(false);
    }
    @Test
    @DisplayName("isPalindromeDescendantTest_6")
    void isPalindromeDescendantTest_6() {
        boolean a = Task5.isPalindromeDescendant(1);
        assertThat(a).isEqualTo(false);
    }
    @Test
    @DisplayName("isPalindromeDescendantTest_7")
    void isPalindromeDescendantTest_7() {
        boolean a = Task5.isPalindromeDescendant(-112211);
        assertThat(a).isEqualTo(false);
    }
}
