package edu.project2.Print;

import edu.project2.Coordinate.Coordinate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class PrintMaze {
    private PrintMaze() {

    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void printMaze(int[][] maze) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int[] ints : maze) {
            for (int j = 0; j < maze[0].length; j++) {
                if (ints[j] == 0) {
                    stringBuilder.append("  ");
                } else if (ints[j] == 1) {
                    stringBuilder.append("╭╴");
                }
            }
            stringBuilder.append("\n");
        }
        LOGGER.info(stringBuilder);
    }

    public static void printPath(int[][] maze, List<Coordinate> path) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (Coordinate coordinate: path) {
            maze[coordinate.x][coordinate.y] = 2;
        }
        for (int[] ints : maze) {
            for (int j = 0; j < maze[0].length; j++) {
                if (ints[j] == 0) {
                    stringBuilder.append("  ");
                } else if (ints[j] == 1) {
                    stringBuilder.append("╭╴");
                } else if (ints[j] == 2) {
                    stringBuilder.append(". ");
                }
            }
            stringBuilder.append("\n");
        }
        LOGGER.info(stringBuilder);

    }
}
