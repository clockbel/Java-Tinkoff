package edu.hw2.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[] {
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect.setHeight(10);
        rect.setWidth(20);
        assertThat(rect.area()).isEqualTo(200.0);
    }

    @Test
    @DisplayName("SquareOne")
    void squareOne() {
        Square square = new Square();
        square.setWidth(10);
        assertThat(square.area()).isEqualTo(100);
    }
}
