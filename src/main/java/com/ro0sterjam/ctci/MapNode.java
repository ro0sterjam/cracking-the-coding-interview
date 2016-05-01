package com.ro0sterjam.ctci;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kenwang on 2016-04-17.
 */
public class MapNode<T> {

    private Map<T, MapNode> children = new HashMap<>();

    public Map<T, MapNode> getChildren() {
        return children;
    }

    void add(T[] array, int i) {
        if (i == array.length) {
            children.put(null, null);
            return;
        }
        T element = array[i];
        if (!children.containsKey(array[i])) {
            children.put(array[i], new MapNode());
        }
        children.get(array[i]).add(array, i + 1);
    }

    boolean contains(T[] array, int i) {
        if (i == array.length) {
            return children.containsKey(null);
        }
        return children.containsKey(array[i]) && children.get(array[i]).contains(array, i + 1);
    }

}
