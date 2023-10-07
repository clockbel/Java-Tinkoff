package edu.hw1;

public final class Task8 {
    private Task8() {

    }

    public static boolean knightBoardCapture(int[][] knightMatrix) {
        final int M = 8;
        boolean flag = true;
        for (int i = 0; i < M && flag; i++) {
            for (int j = 0; j < M && flag; j++) {
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
        final int M = 8;
        final int minusMoveOne = 1;
        final int minusMoveTwo = 2;
        final int plusMoveOne = M - 2;
        final int plusMoveTwo = M - 3;
        if (i >= minusMoveOne && j >= minusMoveTwo && knightMatrix[i - 1][j - 2] == 1) {
            flag = false;
        }
        if (flag && i >= minusMoveTwo && j <= plusMoveOne && knightMatrix[i - 2][j + 1] == 1) {
            flag = false;
        }
        if (flag && i >= minusMoveOne && j <= plusMoveTwo && knightMatrix[i - 1][j + 2] == 1) {
            flag = false;
        }
        if (flag && i >= minusMoveTwo && j >= minusMoveOne && knightMatrix[i - 2][j - 1] == 1) {
            flag = false;
        }
        return flag;
    }

    private static boolean attackKnightDown(int[][] knightMatrix, int i, int j) {
        boolean flag = true;
        final int M = 8;
        final int minusMoveOne = 1;
        final int minusMoveTwo = 2;
        final int plusMoveOne = M - 2;
        final int plusMoveTwo = M - 3;
        if (i <= plusMoveTwo && j >= minusMoveOne && knightMatrix[i + 2][j - 1] == 1) {
            flag = false;
        }
        if (i <= plusMoveOne && j >= minusMoveTwo && knightMatrix[i + 1][j - 2] == 1) {
            flag = false;
        }
        if (i <= plusMoveTwo && j <= plusMoveOne && knightMatrix[i + 2][j + 1] == 1) {
            flag = false;
        }
        if (i <= plusMoveOne && j <= plusMoveTwo && knightMatrix[i + 1][j + 2] == 1) {
            flag = false;
        }
        return flag;
    }
}
