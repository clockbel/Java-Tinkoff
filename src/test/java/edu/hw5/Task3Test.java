package edu.hw5;

import edu.hw5.Task3.CheckDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task3Test {
    @Test
    @DisplayName("Task1Test")
    public void Test1() {
        assertThat(CheckDate.parseDate("2023-10-12")).isEqualTo(Optional.of(LocalDate.parse("2023-10-12")));
    }
    @Test
    @DisplayName("Task2Test")
    public void Test2() {
        assertThat(CheckDate.parseDate("2023-1012")).isEqualTo(Optional.empty());
    }
    @Test
    @DisplayName("Task3Test")
    public void Test3() {
        assertThat(CheckDate.parseDate("12/10/2023")).isEqualTo(Optional.of(LocalDate.parse("2023-10-12")));
    }
    @Test
    @DisplayName("Task4Test")
    public void Test4() {
        assertThat(CheckDate.parseDate("today")).isEqualTo(Optional.of(LocalDate.now()));
    }
    @Test
    @DisplayName("Task5Test")
    public void Test5() {
        assertThat(CheckDate.parseDate("1 day ago")).isEqualTo(Optional.of(LocalDate.now().minusDays(1)));
    }

}
