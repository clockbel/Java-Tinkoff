package edu.hw5;

import edu.hw5.Task4.PasswordSymbolCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Test1")
    public void Test1() {
        assertThat(PasswordSymbolCheck.validatePassword("1234")).isFalse();
    }

    @Test
    @DisplayName("Test2")
    public void Test2() {
        assertThat(PasswordSymbolCheck.validatePassword("!1234#")).isTrue();
    }
}
