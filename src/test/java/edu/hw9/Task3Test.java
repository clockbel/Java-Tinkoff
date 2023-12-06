package edu.hw9;

import edu.hw9.task3.Coordinate;
import edu.hw9.task3.SolverDFS;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.ArrayList;
import java.util.List;

public class Task3Test {
    @Test
    @DisplayName("TestSolver2")
    public void Test2() {
        int[][] maze = {
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
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(9, 9);
        List<Coordinate> coordinateList = SolverDFS.findPath(maze, start, end);
        List<Coordinate> result = List.of(
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

        boolean flag = true;
        if (coordinateList.isEmpty()) {
            flag = false;
        } else {
            for (int i = 0; i < coordinateList.size(); i++) {
                if (coordinateList.get(i).x != result.get(i).x || coordinateList.get(i).y != result.get(i).y) {
                    flag = false;
                    break;
                }
            }
        }
        assertThat(flag).isTrue();
    }
    @Test
    @DisplayName("TestSolver4")
    public void Test4() {
        int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(9, 9);
        List<Coordinate> coordinateList = SolverDFS.findPath(maze, start, end);
        List<Coordinate> result = new ArrayList<>();
        assertThat(coordinateList).isEqualTo(result);
    }
}
