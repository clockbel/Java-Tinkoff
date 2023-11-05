package edu.project2.MazeGenerator;

import edu.project2.Print.PrintMaze;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Prim {
    private int width;
    private int height;
    private int[][] maze;
    private Random random = new Random();

    public Prim(int width, int height) {
        this.width = width;
        this.height = height;
        maze = new int[width][height];
    }

    public int[][] generateMaze() {
        // Initialize the maze with walls
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                maze[x][y] = 1;
            }
        }

        // Create a border wall around the maze
        for (int x = 1; x < width - 1; x++) {
            maze[x][1] = 1;
            maze[x][height - 2] = 1;
        }

        for (int y = 1; y < height - 1; y++) {
            maze[1][y] = 1;
            maze[width - 2][y] = 1;
        }

        // Create the initial cell
        int startX = 3; // Adjust for border wall
        int startY = 3; // Adjust for border wall
        maze[startX][startY] = 0;

        // Create a list of frontier cells
        List<int[]> frontierCells = new ArrayList<>();
        frontierCells.add(new int[]{startX, startY});

        while (!frontierCells.isEmpty()) {
            int[] currentCell = frontierCells.remove(random.nextInt(frontierCells.size()));
            int x = currentCell[0];
            int y = currentCell[1];

            List<int[]> neighbors = new ArrayList<>();
            if (x >= 3) neighbors.add(new int[]{x - 2, y});
            if (x < width - 3) neighbors.add(new int[]{x + 2, y});
            if (y >= 3) neighbors.add(new int[]{x, y - 2});
            if (y < height - 3) neighbors.add(new int[]{x, y + 2});

            for (int[] neighbor : neighbors) {
                int nx = neighbor[0];
                int ny = neighbor[1];

                if (maze[nx][ny] == 1) {
                    maze[nx][ny] = 0;
                    maze[x + (nx - x) / 2][y + (ny - y) / 2] = 0;
                    frontierCells.add(new int[]{nx, ny});
                }
            }
        }
        return maze;
    }

    public static void main(String[] args) {
        Prim mazeGenerator = new Prim(11, 11);
        int[][] maze = mazeGenerator.generateMaze();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        PrintMaze.printMaze(maze);
    }
}
