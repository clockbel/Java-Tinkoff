package edu.hw2.task3;

public class DefaultConnectionManager implements ConnectionManager {
    private static final int FIRSTS_DIGIT_AFTER_POINT = 10;

    @Override
    public Connection getConnection() {
        int random = (int) (Math.random() * FIRSTS_DIGIT_AFTER_POINT);
        if (random % 2 != 0) {
            return new StableConnection();
        } else {
            return new FaultyConnection();
        }
    }
}
