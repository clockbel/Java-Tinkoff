package edu.project2.MazeSolver;

import edu.project2.Print.PrintMaze;
import java.util.LinkedList;

public class MazeSolver {
    private int[][] maze;
    private int width;
    private int height;

    public MazeSolver(int[][] maze) {
        this.maze = maze;
        this.height = maze.length;
        this.width = maze[0].length;
    }

    public LinkedList<Point> solveMaze(Point start, Point end) {
        LinkedList<Point> path = new LinkedList<>();
        boolean[][] visited = new boolean[height][width];

        if (findPath(start.getX(), start.getY(), end, visited, path)) {
            return path;
        }

        return null;
    }

    private boolean findPath(int x, int y, Point end, boolean[][] visited, LinkedList<Point> path) {
        if (x < 0 || x >= width || y < 0 || y >= height || maze[y][x] == 1 || visited[y][x]) {
            return false;
        }

        Point current = new Point(x, y);

        visited[y][x] = true;
        path.add(current);

        if (current.equals(end)) {
            return true;
        }

        if (findPath(x + 1, y, end, visited, path) ||
            findPath(x - 1, y, end, visited, path) ||
            findPath(x, y + 1, end, visited, path) ||
            findPath(x, y - 1, end, visited, path)) {
            return true;
        }

        path.removeLast();
        return false;
    }

    public static void main(String[] args) {
        int[][] maze2 = {
            {1, 1, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
        };

        MazeSolver mazeSolver = new MazeSolver(maze2);
        LinkedList<Point> path = mazeSolver.solveMaze(new Point(1, 1), new Point(1, 4));

        if (path != null) {
            for (Point point : path) {
                System.out.println("X: " + point.getX() + ", Y: " + point.getY());
            }
            PrintMaze.printPath(maze2, path);
        } else {
            System.out.println("No path found.");
        }

    }
}

