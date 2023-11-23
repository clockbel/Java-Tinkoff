package edu.project2.Print;

import edu.project2.Coordinate.Coordinate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PrintMaze {
    private PrintMaze() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static String createMaze(int[][] maze) {
        try {
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
            return stringBuilder.toString();
        } catch (Exception ex) {
            LOGGER.info("Incorrect input for print maze");
        }
        return null;
    }

    public static String createPath(int[][] maze, List<Coordinate> path) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n");
            for (Coordinate coordinate : path) {
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
            return stringBuilder.toString();
        } catch (Exception ex) {
            LOGGER.info("Incorrect input for print maze with path");
        }
        return null;
    }

    public static void print(String string) {
        LOGGER.info(string);
    }
}
