package edu.hw1;

public final class Task8 {
    private Task8() {

    }

    private static final int SIZE_BOARD = 8;
    private static final int MOVE_MINUS_ONE = 1;
    private static final int MOVE_MINUS_TWO = 2;
    private static final int MOVE_PLUS_ONE = SIZE_BOARD - 2;
    private static final int MOVE_PLUS_TWO = SIZE_BOARD - 3;

    public static boolean knightBoardCapture(int[][] knightMatrix) {
        boolean flag = true;
        for (int i = 0; i < SIZE_BOARD && flag; i++) {
            for (int j = 0; j < SIZE_BOARD && flag; j++) {
                if (knightMatrix[i][j] == 1) {
                    flag = attackKnight(knightMatrix, i, j);
                }
            }
        }
        return flag;
    }

    private static boolean attackKnight(int[][] knightMatrix, int i, int j) {
        boolean flag;
        flag = attackKnightUp(knightMatrix, i, j);
        if (flag) {
            flag = attackKnightDown(knightMatrix, i, j);
        }
        return flag;
    }

    private static boolean attackKnightUp(int[][] knightMatrix, int i, int j) {
        boolean flag = true;
        if (i >= MOVE_MINUS_ONE && j >= MOVE_MINUS_TWO && knightMatrix[i - 1][j - 2] == 1) {
            flag = false;
        }
        if (flag && i >= MOVE_MINUS_TWO && j <= MOVE_PLUS_ONE && knightMatrix[i - 2][j + 1] == 1) {
            flag = false;
        }
        if (flag && i >= MOVE_MINUS_ONE && j <= MOVE_PLUS_TWO && knightMatrix[i - 1][j + 2] == 1) {
            flag = false;
        }
        if (flag && i >= MOVE_MINUS_TWO && j >= MOVE_MINUS_ONE && knightMatrix[i - 2][j - 1] == 1) {
            flag = false;
        }
        return flag;
    }

    private static boolean attackKnightDown(int[][] knightMatrix, int i, int j) {
        boolean flag = true;
        if (i <= MOVE_PLUS_TWO && j >= MOVE_MINUS_ONE && knightMatrix[i + 2][j - 1] == 1) {
            flag = false;
        }
        if (i <= MOVE_PLUS_ONE && j >= MOVE_MINUS_TWO && knightMatrix[i + 1][j - 2] == 1) {
            flag = false;
        }
        if (i <= MOVE_PLUS_TWO && j <= MOVE_PLUS_ONE && knightMatrix[i + 2][j + 1] == 1) {
            flag = false;
        }
        if (i <= MOVE_PLUS_ONE && j <= MOVE_PLUS_TWO && knightMatrix[i + 1][j + 2] == 1) {
            flag = false;
        }
        return flag;
    }
}
