package edu.hw5;

import edu.hw5.Task1.ComputerClubAnalytics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    @Test
    @DisplayName("Task1Test1")
    public void Test1() {
        List<String> strings = List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20");
        assertThat(ComputerClubAnalytics.session(strings)).isEqualTo("3ч 40м");
    }

    @Test
    @DisplayName("Task1Tes2")
    void Test2() {
        List<String> sessions = List.of("2022:03:13, 20:20");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ComputerClubAnalytics.session(sessions));
        String expectedMessage = "Date is incorrect";
        String actualMessage = exception.getMessage();
        assertThat(expectedMessage).isEqualTo(actualMessage);
    }
    @Test
    @DisplayName("Task1Test3")
    void wrongInputStringOneDate() {
        List<String> sessions = List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 0120");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ComputerClubAnalytics.session(sessions));
        String expectedMessage = "Date is incorrect";
        String actualMessage = exception.getMessage();
        assertThat(expectedMessage).isEqualTo(actualMessage);
    }
}
