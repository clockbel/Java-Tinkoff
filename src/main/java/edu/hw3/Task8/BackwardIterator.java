package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private final List<T> collection;
    private int currentIndex;

    public BackwardIterator(List<T> collection) {
        this.collection = collection;
        this.currentIndex = collection.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public T next() {
        if (currentIndex >= 0) {
            return collection.get(currentIndex--);
        } else {
            throw new IndexOutOfBoundsException("No more elements to iterate.");
        }
    }
}

