package edu.hw9.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public final class SolverDFS {
    private SolverDFS() {

    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int THREAD_POOL_SIZE = 4; // Adjust the number of threads as needed
    private final static Logger LOGGER = LogManager.getLogger();

    public static List<Coordinate> findPath(int[][] maze, Coordinate start, Coordinate end) {
        if (validInput(maze, start, end)) {
            return new ArrayList<>();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Coordinate> path = Collections.synchronizedList(new ArrayList<>());

        try {
            boolean[][] visited = new boolean[maze.length][maze[0].length];
            List<Future<Boolean>> futures = new ArrayList<>();
            futures.add(executorService.submit(() ->
                dfs(maze, start, end, visited, path)
            ));
            for (Future<Boolean> future : futures) {
                if (future.get()) {
                    break;
                }
            }
            Collections.reverse(path);
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.info(e.getMessage());
        } finally {
            executorService.shutdown();
        }

        return path;
    }

    private static boolean dfs(
        int[][] maze,
        Coordinate current,
        Coordinate end,
        boolean[][] visited,
        List<Coordinate> path
    ) {
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
        return coordinate.x >= 0 && coordinate.x < numRows && coordinate.y >= 0 && coordinate.y < numCols
            && maze[coordinate.x][coordinate.y] == 0;
    }

    private static boolean validInput(int[][] maze, Coordinate start, Coordinate exit) {
        boolean flag = false;
        if (maze == null) {
            flag = true;
        } else if (start.x <= 0 || start.y <= 0 || exit.x <= 0 || exit.y <= 0) {
            flag = true;
        } else if (start.x >= maze.length || start.y >= maze[0].length || exit.x >= maze.length
            || exit.y >= maze[0].length) {
            flag = true;
        }
        return flag;
    }
}
