package edu.hw3.Task2;

import java.util.ArrayList;
import java.util.List;

public final class ClasterBrackets {
    private ClasterBrackets() {

    }

    public static List<String> clusterize(String input) {
        boolean flag = checkInput(input);
        if (!flag) {
            return new ArrayList<>();
        }
        List<String> clusters = new ArrayList<>();
        int balance = 0;
        StringBuilder currentCluster = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            currentCluster.append(c);
            if (balance == 0) {
                clusters.add(currentCluster.toString());
                currentCluster.setLength(0);
            }
        }
        return clusters;
    }

    private static boolean checkInput(String input) {
        int countBrackets = 0;
        for (char symbol: input.toCharArray()) {
            if (symbol != '(' &&  symbol != ')') {
                return false;
            }
            if (symbol == '(') {
                countBrackets += 1;
            } else {
                countBrackets -= 1;
            }
        }
        return true;
    }
}
