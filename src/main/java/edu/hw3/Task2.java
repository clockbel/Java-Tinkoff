package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public final class Task2 {
    private Task2() {

    }

    public static List<String> clusterize(String input) {
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
}
