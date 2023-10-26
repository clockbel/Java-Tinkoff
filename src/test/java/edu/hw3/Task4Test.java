package edu.hw3;

import edu.hw3.Task4.RomanOperation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task4Test {
    @Test
    @DisplayName("Test1")
    public void Test1() {
        int num = 2;
        String result = "II";
        assertThat(RomanOperation.converToRoman(num)).isEqualTo(result);
    }
    @Test
    @DisplayName("Test2")
    public void Test2() {
        int num = 12;
        String result = "XII";
        assertThat(RomanOperation.converToRoman(num)).isEqualTo(result);
    }
    @Test
    @DisplayName("Test3")
    public void Test3() {
        int num = 16;
        String result = "XVI";
        assertThat(RomanOperation.converToRoman(num)).isEqualTo(result);
    }
    @Test
    @DisplayName("Test4")
    public void Test4() {
        String result = "XVI";
        assertThat(RomanOperation.converToRoman(-10)).isNull();
    }
}
