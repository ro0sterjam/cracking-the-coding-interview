package com.ro0sterjam.ctci;

/**
 * Created by kenwang on 2016-04-02.
 */
public class SinglyLinkedNode<T> {

    public T value;
    public SinglyLinkedNode<T> next;

    public SinglyLinkedNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(SinglyLinkedNode<T> next) {
        this.next = next;
    }

    public SinglyLinkedNode<T> startOfLoop() {
        if (next == null || next.next == null) {
            return null;
        }

        SinglyLinkedNode<T> cursor = this;
        SinglyLinkedNode<T> runner = this;
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
