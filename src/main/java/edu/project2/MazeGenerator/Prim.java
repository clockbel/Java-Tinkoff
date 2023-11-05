package edu.project2.MazeGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Prim {
    private final int rows;
    private final int columns;
    private final int[][] maze;
    private final Random random = new Random();

    public Prim(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        maze = new int[rows][columns];
    }

    @SuppressWarnings("MagicNumber")
    public int[][] generateMaze() {
        if (validInput(maze, rows, columns)) {
            return null;
        }
        // Initialize the maze with walls
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                maze[x][y] = 1;
            }
        }

        // Create a border wall around the maze
        for (int x = 1; x < rows - 1; x++) {
            maze[x][1] = 1;
            maze[x][columns - 2] = 1;
        }

        for (int y = 1; y < columns - 1; y++) {
            maze[1][y] = 1;
            maze[rows - 2][y] = 1;
        }

        // Create the initial cell
        int startX = 3; // Adjust for border wall
        int startY = 3; // Adjust for border wall
        maze[startX][startY] = 0;

        // Create a list of frontier cells
        List<int[]> frontierCells = new ArrayList<>();
        frontierCells.add(new int[] {startX, startY});

        while (!frontierCells.isEmpty()) {
            int[] currentCell = frontierCells.remove(random.nextInt(frontierCells.size()));
            int x = currentCell[0];
            int y = currentCell[1];

            List<int[]> neighbors = new ArrayList<>();
            if (x >= 3) {
                neighbors.add(new int[] {x - 2, y});
            }
            if (x < rows - 3) {
                neighbors.add(new int[] {x + 2, y});
            }
            if (y >= 3) {
                neighbors.add(new int[] {x, y - 2});
            }
            if (y < columns - 3) {
                neighbors.add(new int[] {x, y + 2});
            }

            for (int[] neighbor : neighbors) {
                int nx = neighbor[0];
                int ny = neighbor[1];

                if (maze[nx][ny] == 1) {
                    maze[nx][ny] = 0;
                    maze[x + (nx - x) / 2][y + (ny - y) / 2] = 0;
                    frontierCells.add(new int[] {nx, ny});
                }
            }
        }
        return maze;
    }

    @SuppressWarnings("MagicNumber")
    private boolean validInput(int[][] maze, int rows, int columns) {
        if (maze == null || rows < 5 || columns < 5) {
            return true;
        }
        return false;
    }
}
