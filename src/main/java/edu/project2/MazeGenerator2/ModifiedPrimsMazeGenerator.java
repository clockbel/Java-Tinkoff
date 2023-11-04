package edu.project2.MazeGenerator2;

import edu.project2.Print.PrintMaze;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModifiedPrimsMazeGenerator {
    private int width;
    private int height;
    private int[][] maze;
    private Random random = new Random();
    private List<Direction2> directions = new ArrayList<>();

    public ModifiedPrimsMazeGenerator(int width, int height) {
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

        directions.add(edu.project2.MazeGenerator2.Direction2.RIGHT);
        directions.add(edu.project2.MazeGenerator2.Direction2.LEFT);
        directions.add(edu.project2.MazeGenerator2.Direction2.DOWN);
        directions.add(edu.project2.MazeGenerator2.Direction2.TOP);
        int randomValue;
        for (int i = 0; i < 2; i++) {
            randomValue = random.nextInt(0, directions.size());
            directions.remove(randomValue);
        }
        for (int i = 0; i < 2; i++) {
            Direction2 wall = directions.get(i);
            switch (wall) {
                case LEFT:
                    randomValue = random.nextInt(1, maze.length - 1);
                    if (randomValue % 2 == 0) {
                        randomValue++;
                    }
                    maze[randomValue][0] = 0;
                    break;
                case RIGHT:
                    randomValue = random.nextInt(1, maze.length - 1);
                    if (randomValue % 2 == 0) {
                        randomValue++;
                    }
                    maze[randomValue][maze[0].length - 1] = 0;
                    break;
                case TOP:
                    randomValue = random.nextInt(1, maze[0].length - 1);
                    if (randomValue % 2 == 0) {
                        randomValue++;
                    }
                    maze[0][randomValue] = 0;
                    break;
                case DOWN:
                    randomValue = random.nextInt(1, maze[0].length - 1);
                    if (randomValue % 2 == 0) {
                        randomValue++;
                    }
                    maze[maze.length - 1][randomValue] = 0;
                    break;
                default:
                    break;
            }
        }
        return maze;
    }

    public static void main(String[] args) {
        ModifiedPrimsMazeGenerator mazeGenerator = new ModifiedPrimsMazeGenerator(11, 11);
        int[][] maze = mazeGenerator.generateMaze();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        PrintMaze.printPath(maze);
    }
}
