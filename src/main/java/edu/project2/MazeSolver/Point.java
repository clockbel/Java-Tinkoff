package edu.project2.MazeSolver;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Point other) {
        return this.x == other.getX() && this.y == other.getY();
    }
}
