package edu.project2.MazeSolver;

import edu.project2.Coordinate.Coordinate;
import java.util.*;


public class SolverDFS {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static List<Coordinate> findPath(int[][] maze, Coordinate start, Coordinate end) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        List<Coordinate> path = new ArrayList<>();
        dfs(maze, start, end, visited, path);
        Collections.reverse(path);
        return path;
    }

    private static boolean dfs(int[][] maze, Coordinate current, Coordinate end, boolean[][] visited, List<Coordinate> path) {
        if (current.x == end.x && current.y == end.y) {
            path.add(current);
            return true;
        }

        visited[current.x][current.y] = true;
        for (int[] direction : DIRECTIONS) {
            int newX = current.x + direction[0];
            int newY = current.y + direction[1];
            Coordinate next = new Coordinate(newX, newY);

            if (isValidMove(maze, next) && !visited[newX][newY]) {
                if (dfs(maze, next, end, visited, path)) {
                    path.add(current);
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isValidMove(int[][] maze, Coordinate coordinate) {
        int numRows = maze.length;
        int numCols = maze[0].length;
        return coordinate.x >= 0 && coordinate.x < numRows && coordinate.y >= 0 && coordinate.y < numCols && maze[coordinate.x][coordinate.y] == 0;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
        };

        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(7, 7);

        List<Coordinate> path = findPath(maze, start, end);

        if (path.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.println("Path found:");
            for (Coordinate coordinate : path) {
                System.out.println("(" + coordinate.x + ", " + coordinate.y + ")");
            }
        }
    }
}

