package edu.project2.MazeGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze {
    private final int rows;
    private final int columns;
    private final int[][] map;
    private final int totalSteps;
    private int steps;
    private final List<Slot> path = new ArrayList<>();
    private final List<Direction> minerDirection = new ArrayList<>();

    private final Random random = new Random();
    private final static Logger LOGGER = LogManager.getLogger();

    public Maze(int rows, int columns) {
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
        path.add(new Slot(1, 1));
    }

    public void step() {
        minerDirection.clear();
        ;
        Slot last = path.get(path.size() - 1);
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
                    path.add(new Slot(last.y, last.x + 2));
                    break;
                case LEFT: //движение влево
                    map[last.y][last.x - 1] = 0;
                    map[last.y][last.x - 2] = 0;
                    path.add(new Slot(last.y, last.x - 2));
                    break;
                case DOWN: //движение вниз
                    map[last.y + 1][last.x] = 0;
                    map[last.y + 2][last.x] = 0;
                    path.add(new Slot(last.y + 2, last.x));
                    break;
                case TOP: //движение вверх
                    map[last.y - 1][last.x] = 0;
                    map[last.y - 2][last.x] = 0;
                    path.add(new Slot(last.y - 2, last.x));
                    break;
                default:
                    break;
            }
        } else {
            path.remove(path.size() - 1);
        }
    }

    public void build() {
        while (steps < totalSteps) {
            step();
        }
        minerDirection.clear();
        minerDirection.add(Direction.RIGHT);
        minerDirection.add(Direction.LEFT);
        minerDirection.add(Direction.DOWN);
        minerDirection.add(Direction.TOP);
        int randomValue;
        for (int i = 0; i < 2; i++) {
            randomValue = random.nextInt(0, minerDirection.size());
            minerDirection.remove(randomValue);
        }
        for (int i = 0; i < 2; i++) {
            Direction wall = minerDirection.get(i);
            switch (wall) {
                case LEFT:
                    randomValue = random.nextInt(1, map.length - 1);
                    if (randomValue % 2 == 0) {
                        randomValue++;
                    }
                    map[randomValue][0] = 0;
                    break;
                case RIGHT:
                    randomValue = random.nextInt(1, map.length - 1);
                    if (randomValue % 2 == 0) {
                        randomValue++;
                    }
                    map[randomValue][map[0].length - 1] = 0;
                    break;
                case TOP:
                    randomValue = random.nextInt(1, map[0].length - 1);
                    if (randomValue % 2 == 0) {
                        randomValue++;
                    }
                    map[0][randomValue] = 0;
                    break;
                case DOWN:
                    randomValue = random.nextInt(1, map[0].length - 1);
                    if (randomValue % 2 == 0) {
                        randomValue++;
                    }
                    map[map.length - 1][randomValue] = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public void printMaze() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (map[i][j] == 0) {
                    stringBuilder.append("  ");
                } else {
                    stringBuilder.append("╭╴");
                }
            }
            stringBuilder.append("\n");
        }
        LOGGER.info(stringBuilder);
    }

    public int[][] getMaze() {
        return map;
    }

    public static void main(String[] args) {
        int[][] mapMaze = new int[11][11];
        Maze maze = new Maze(7, 7);
        maze.initMaze();
        maze.build();
        mapMaze = maze.getMaze();
        maze.printMaze();
    }
}

