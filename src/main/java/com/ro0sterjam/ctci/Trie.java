package com.ro0sterjam.ctci;

/**
 * Created by kenwang on 2016-04-17.
 */
public class Trie<T> {

    private MapNode<T> root = new MapNode<>();

    public void add(T[] array) {
        root.add(array, 0);
    }

    public boolean contains(T[] array) {
        return root.contains(array, 0);
    }

}
