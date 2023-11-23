package edu.hw5;

import edu.hw5.Task2.FridayThirteen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Test1Task")
    public void Test1() {
        List<LocalDate> dates = List.of(LocalDate.parse("2022-05-13"));
        assertThat(FridayThirteen.getFridayThirteen(2022)).isEqualTo(dates);
    }

    @Test
    @DisplayName("Test2Task")
    public void Test2() {
        List<LocalDate> dates = new ArrayList<>();
        assertThat(FridayThirteen.getFridayThirteen(-2022)).isEqualTo(dates);
    }

    @Test
    @DisplayName("Test3Task")
    public void Test3() {
        assertThat(FridayThirteen.nextFridayThirteen(LocalDate.parse("2022-11-13"))).isEqualTo(LocalDate.parse(
            "2023-01-13"));
    }
}
