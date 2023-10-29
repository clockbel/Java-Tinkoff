package edu.project2.Print;

import edu.project2.MazeSolver.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.LinkedList;

public class PrintMaze {
    private PrintMaze() {

    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void printPath(int[][] maze, LinkedList<Point> path) {
        int x;
        int y;
        for (Point point : path) {
            x = point.getX();
            y = point.getY();
            maze[x][y] = 2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
//                if (maze[i][j] == 0) {
//                    stringBuilder.append("  ");
//                } else if (maze[i][j] == 1) {
//                    stringBuilder.append("╭╴");
//                } else {
//                    stringBuilder.append(". ");
//                }
                stringBuilder.append(maze[i][j]);
            }
            stringBuilder.append("\n");
        }
        LOGGER.info(stringBuilder);
    }
}
