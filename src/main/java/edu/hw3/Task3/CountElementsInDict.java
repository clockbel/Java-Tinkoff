package edu.hw3.Task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CountElementsInDict {
    private CountElementsInDict() {

    }

    public static Map<Object, Integer> freqDict(List<Object> list) {
        if (list == null) {
            return null;
        }

        Map<Object, Integer> hashMap = new HashMap<>();

        for (Object elem : list) {
            hashMap.put(elem, hashMap.getOrDefault(elem, 0) + 1);
        }
        return hashMap;
    }
}
