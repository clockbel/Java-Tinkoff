package edu.hw3.Task7;

import java.util.Comparator;

public class NullComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        int res = 1;
        if (o1 == null && o2 == null) {
            res = 0;
        } else if (o1 == null) {
            res = -1;
        }
        return res;
    }
}
