package com.ro0sterjam.ctci;

/**
 * Created by kenwang on 2016-04-17.
 */
public class StringTrie {

    MapNode<Character> root = new MapNode<>();

    public void add(String string) {
        root.add(Strings.toObjectArray(string.toCharArray()), 0);
    }

    public boolean contains(String string) {
        return root.contains(Strings.toObjectArray(string.toCharArray()), 0);
    }

}
