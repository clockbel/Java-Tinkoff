package edu.hw5;

import edu.hw5.Task5.CarNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Task5Test")
    public void Test1() {
        assertThat(CarNumber.validateCarNumber("А123СР777")).isTrue();
    }
    @Test
    @DisplayName("Task5Test")
    public void Test2() {
        assertThat(CarNumber.validateCarNumber("А123СРО777")).isFalse();
    }
    @Test
    @DisplayName("Task5Test")
    public void Test3() {
        assertThat(CarNumber.validateCarNumber(null)).isFalse();
    }
}
