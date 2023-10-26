package edu.hw3.Task7;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator<>());
        tree.put(null, "test");
        // Проверка на наличие null в TreeMap
        System.out.println(tree.containsKey(null));
    }
}
