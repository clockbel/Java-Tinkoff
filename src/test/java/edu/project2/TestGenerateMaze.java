package edu.project2;

import edu.project2.Coordinate.Coordinate;
import edu.project2.MazeGenerator.Miner;
import edu.project2.MazeGenerator.Prim;
import edu.project2.MazeSolver.SolverBFS;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestGenerateMaze {
    @Test
    @DisplayName("TestGenerate1")
    public void Test1() {
        Miner miner = new Miner(11,11);
        int[][] maze = miner.generateMaze();
        assertThat(maze.length).isEqualTo(11);
        assertThat(maze[0].length).isEqualTo(11);
        Coordinate start = new Coordinate(1,1);
        Coordinate end = new Coordinate(9,9);
        List<Coordinate> coordinateList = SolverBFS.findPath(maze, start, end);
        assertThat(coordinateList.size()).isNotEqualTo(0);

    }
    @Test
    @DisplayName("TestGenerate2")
    public void Test2() {
        Miner miner = new Miner(0,0);
        int[][] maze = miner.generateMaze();
        assertThat(maze).isNull();
    }
    @Test
    @DisplayName("TestGenerate3")
    public void Test3() {
        Prim miner = new Prim(11,11);
        int[][] maze = miner.generateMaze();
        assertThat(maze.length).isEqualTo(11);
        assertThat(maze[0].length).isEqualTo(11);
        Coordinate start = new Coordinate(1,1);
        Coordinate end = new Coordinate(9,9);
        List<Coordinate> coordinateList = SolverBFS.findPath(maze, start, end);
        assertThat(coordinateList.size()).isNotEqualTo(0);

    }
    @Test
    @DisplayName("TestGenerate4")
    public void Test4() {
        Prim miner = new Prim(0,0);
        int[][] maze = miner.generateMaze();
        assertThat(maze).isNull();
    }
}
