package edu.project2.Print;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintMaze {
    private PrintMaze() {

    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void printPath(int[][] maze) {
//        int x;
//        int y;
//        for (Point point : path) {
//            x = point.getX();
//            y = point.getY();
//            maze[x][y] = 2;
//        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (maze[i][j] == 0) {
                    stringBuilder.append("  ");
                } else if (maze[i][j] == 1) {
                    stringBuilder.append("╭╴");
//                } else {
//                    stringBuilder.append(". ");
                }
//                stringBuilder.append(maze[i][j]);
            }
            stringBuilder.append("\n");
        }
        LOGGER.info(stringBuilder);
    }
}
