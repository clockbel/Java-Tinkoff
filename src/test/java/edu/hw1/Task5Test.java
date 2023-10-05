package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task5Test {
    @Test
    @DisplayName("isPalindromeDescendant_1")
    void isPalindromeDescendant_1() {
        boolean a = Task5.isPalindromeDescendant(11211230);
        assertThat(a).isEqualTo(true);
    }
    @Test
    @DisplayName("isPalindromeDescendant_2")
    void isPalindromeDescendant_2() {
        boolean a = Task5.isPalindromeDescendant(13001120);
        assertThat(a).isEqualTo(true);
    }
    @Test
    @DisplayName("isPalindromeDescendant_3")
    void isPalindromeDescendant_3() {
        boolean a = Task5.isPalindromeDescendant(23336014);
        assertThat(a).isEqualTo(true);
    }
    @Test
    @DisplayName("isPalindromeDescendant_4")
    void isPalindromeDescendant_4() {
        boolean a = Task5.isPalindromeDescendant(11);
        assertThat(a).isEqualTo(true);
    }
    @Test
    @DisplayName("isPalindromeDescendant_5")
    void isPalindromeDescendant_5() {
        boolean a = Task5.isPalindromeDescendant(1234);
        assertThat(a).isEqualTo(false);
    }
    @Test
    @DisplayName("isPalindromeDescendant_6")
    void isPalindromeDescendant_6() {
        boolean a = Task5.isPalindromeDescendant(1);
        assertThat(a).isEqualTo(false);
    }
    @Test
    @DisplayName("isPalindromeDescendant_7")
    void isPalindromeDescendant_7() {
        boolean a = Task5.isPalindromeDescendant(-112211);
        assertThat(a).isEqualTo(false);
    }
}
