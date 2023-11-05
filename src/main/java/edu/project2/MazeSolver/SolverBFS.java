package edu.project2.MazeSolver;

import edu.project2.Coordinate.Coordinate;
import java.util.*;


public class SolverBFS {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static List<Coordinate> findPath(int[][] maze, Coordinate start, Coordinate end) {
        int numRows = maze.length;
        int numCols = maze[0].length;
        boolean[][] visited = new boolean[numRows][numCols];

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        Map<Coordinate, Coordinate> parentMap = new HashMap<>();

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.x == end.x && current.y == end.y) {
                return constructPath(parentMap, start, current);
            }

            for (int[] direction : DIRECTIONS) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                if (isValidMove(maze, visited, newX, newY)) {
                    Coordinate next = new Coordinate(newX, newY);
                    queue.add(next);
                    visited[newX][newY] = true;
                    parentMap.put(next, current);
                }
            }
        }

        return new ArrayList<>();
    }

    private static boolean isValidMove(int[][] maze, boolean[][] visited, int x, int y) {
        int numRows = maze.length;
        int numCols = maze[0].length;
        return x >= 0 && x < numRows && y >= 0 && y < numCols && maze[x][y] == 0 && !visited[x][y];
    }

    private static List<Coordinate> constructPath(Map<Coordinate, Coordinate> parentMap, Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        Coordinate current = end;

        while (!current.equals(start)) {
            path.add(current);
            current = parentMap.get(current);
        }

        path.add(start);
        Collections.reverse(path);
        return path;
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
        Coordinate end = new Coordinate(5, 1);

        List<Coordinate> path = findPath(maze, start, end);

        if (path.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.println("Path found:");
            for (Coordinate coordinate : path) {
                System.out.println("(" + coordinate.y + ", " + coordinate.x + ")");
            }
        }
    }
}
