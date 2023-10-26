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
            if (hashMap.containsKey(elem)) {
                hashMap.put(elem, hashMap.get(elem) + 1);
            } else {
                hashMap.put(elem, 1);
            }
        }
        return hashMap;
    }
}
