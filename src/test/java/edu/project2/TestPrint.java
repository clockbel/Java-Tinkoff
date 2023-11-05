package edu.project2;

import edu.project2.Coordinate.Coordinate;
import edu.project2.Print.PrintMaze;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestPrint {
    @Test
    @DisplayName("Test1")
    public void Test1() {
        int[][] mazeMap = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        String maze = PrintMaze.createMaze(mazeMap);
        String result = "\n" +
            "╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴\n" +
            "╭╴                  ╭╴\n" +
            "╭╴╭╴╭╴  ╭╴╭╴╭╴╭╴╭╴  ╭╴\n" +
            "╭╴          ╭╴  ╭╴  ╭╴\n" +
            "╭╴╭╴╭╴  ╭╴╭╴╭╴  ╭╴╭╴╭╴\n" +
            "╭╴          ╭╴      ╭╴\n" +
            "╭╴╭╴╭╴  ╭╴╭╴╭╴  ╭╴╭╴╭╴\n" +
            "╭╴                  ╭╴\n" +
            "╭╴  ╭╴  ╭╴  ╭╴  ╭╴╭╴╭╴\n" +
            "╭╴  ╭╴  ╭╴  ╭╴      ╭╴\n" +
            "╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴" + "\n";
        assertThat(maze).isEqualTo(result);
    }

    @Test
    @DisplayName("Test2")
    public void Test2() {
        int[][] mazeMap = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 2, 2, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 2, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 2, 0, 0, 1, 0, 1, 0, 1},
            {1, 1, 1, 2, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 0, 2, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 2, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 0, 2, 2, 2, 2, 2, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 2, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 2, 2, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        List<Coordinate> path = List.of(
            new Coordinate(1, 1),
            new Coordinate(1, 2),
            new Coordinate(1, 3),
            new Coordinate(2, 3),
            new Coordinate(3, 3),
            new Coordinate(4, 3),
            new Coordinate(5, 3),
            new Coordinate(6, 3),
            new Coordinate(7, 3),
            new Coordinate(7, 4),
            new Coordinate(7, 5),
            new Coordinate(7, 6),
            new Coordinate(7, 7),
            new Coordinate(8, 7),
            new Coordinate(9, 7),
            new Coordinate(9, 8),
            new Coordinate(9, 9)
        );
        String maze = PrintMaze.createPath(mazeMap, path);
        String result = "\n" +
            "╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴\n" +
            "╭╴. . .             ╭╴\n" +
            "╭╴╭╴╭╴. ╭╴╭╴╭╴╭╴╭╴  ╭╴\n" +
            "╭╴    .     ╭╴  ╭╴  ╭╴\n" +
            "╭╴╭╴╭╴. ╭╴╭╴╭╴  ╭╴╭╴╭╴\n" +
            "╭╴    .     ╭╴      ╭╴\n" +
            "╭╴╭╴╭╴. ╭╴╭╴╭╴  ╭╴╭╴╭╴\n" +
            "╭╴    . . . . .     ╭╴\n" +
            "╭╴  ╭╴  ╭╴  ╭╴. ╭╴╭╴╭╴\n" +
            "╭╴  ╭╴  ╭╴  ╭╴. . . ╭╴\n" +
            "╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴╭╴" + "\n";
        assertThat(maze).isEqualTo(result);
    }
}

