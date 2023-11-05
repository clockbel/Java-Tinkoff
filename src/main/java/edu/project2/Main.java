package edu.project2;

import edu.project2.Coordinate.Coordinate;
import edu.project2.MazeGenerator.Miner;
import edu.project2.MazeSolver.SolverBFS;
import edu.project2.Print.PrintMaze;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Miner maze = new Miner(11, 11);
        maze.initMaze();
        maze.build();
        PrintMaze.printMaze(maze.getMaze());
        List<Coordinate> path = SolverBFS.findPath(maze.getMaze(), new Coordinate(1, 1), new Coordinate(9, 9));
        PrintMaze.printPath(maze.getMaze(), path);
        for (Coordinate coordinate : path) {
            System.out.println("(" + coordinate.x + ", " + coordinate.y + ")");
        }
    }
}
