package edu.project2.MazeGenerator;

import edu.project2.Coordinate.Coordinate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Miner {
    private final int rows;
    private final int columns;
    private final int[][] map;
    private final int totalSteps;
    private int steps;
    private final List<Coordinate> path = new ArrayList<>();
    private final List<Direction> minerDirection = new ArrayList<>();

    private final Random random = new Random();

    @SuppressWarnings("MagicNumber")
    public Miner(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.map = new int[rows][columns];
        this.totalSteps = (rows - 1) * (columns - 1) / 4;
    }

    private void initMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = 1;
            }
        }
        map[1][1] = 0;
        steps = 1;
        path.add(new Coordinate(1, 1));
    }

    private void step() {
        minerDirection.clear();
        Coordinate last = path.get(path.size() - 1);
        if (last.x + 2 < map[0].length && map[last.y][last.x + 2] == 1) {
            minerDirection.add(Direction.RIGHT);
        }
        if (last.x - 2 > 0 && map[last.y][last.x - 2] == 1) {
            minerDirection.add(Direction.LEFT);
        }
        if (last.y + 2 < map.length && map[last.y + 2][last.x] == 1) {
            minerDirection.add(Direction.DOWN);
        }
        if (last.y - 2 > 0 && map[last.y - 2][last.x] == 1) {
            minerDirection.add(Direction.TOP);
        }

        if (!minerDirection.isEmpty()) {
            steps++;
            int randomValue = random.nextInt(minerDirection.size());
            switch (minerDirection.get(randomValue)) {
                case RIGHT: //движение вправо
                    map[last.y][last.x + 1] = 0;
                    map[last.y][last.x + 2] = 0;
                    path.add(new Coordinate(last.x + 2, last.y));
                    break;
                case LEFT: //движение влево
                    map[last.y][last.x - 1] = 0;
                    map[last.y][last.x - 2] = 0;
                    path.add(new Coordinate(last.x - 2, last.y));
                    break;
                case DOWN: //движение вниз
                    map[last.y + 1][last.x] = 0;
                    map[last.y + 2][last.x] = 0;
                    path.add(new Coordinate(last.x, last.y + 2));
                    break;
                case TOP: //движение вверх
                    map[last.y - 1][last.x] = 0;
                    map[last.y - 2][last.x] = 0;
                    path.add(new Coordinate(last.x, last.y - 2));
                    break;
                default:
                    break;
            }
        } else {
            path.remove(path.size() - 1);
        }
    }

    private void build() {
        while (steps < totalSteps) {
            step();
        }
        minerDirection.clear();
    }

    public int[][] generateMaze() {
        if (validInput(map, rows, columns)) {
            return null;
        }
        initMaze();
        build();
        return map;
    }

    @SuppressWarnings("MagicNumber")
    private boolean validInput(int[][] maze, int rows, int columns) {
        if (maze == null || rows < 5 || columns < 5) {
            return true;
        }
        return false;
    }
}

