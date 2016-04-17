package com.ro0sterjam.ctci;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kenwang on 2016-04-17.
 */
public class TrieNode<T> {

    Map<T, TrieNode> children = new HashMap<>();

    void add(T[] array, int i) {
        if (i == array.length) {
            children.put(null, null);
            return;
        }
        T element = array[i];
        if (!children.containsKey(array[i])) {
            children.put(array[i], new TrieNode());
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
