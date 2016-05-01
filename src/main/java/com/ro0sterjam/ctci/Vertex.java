package com.ro0sterjam.ctci;

/**
 * Created by kenwang on 2016-05-01.
 */
public class Vertex<T> {

    private T value;

    public Vertex(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
