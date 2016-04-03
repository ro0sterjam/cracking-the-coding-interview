package com.ro0sterjam.ctci;

/**
 * Created by kenwang on 2016-04-02.
 */
public class Node<T> {

    public T value;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> startOfLoop() {
        if (next == null || next.next == null) {
            return null;
        }

        Node<T> cursor = this;
        Node<T> runner = this;
        while ((cursor = cursor.next) != (runner = runner.next.next)) {
            if (runner.next.next == null) {
                return null;
            }
        }
        runner = this;
        while (cursor != runner) {
            cursor = cursor.next;
            runner = runner.next;
        }
        return cursor;
    }
}
