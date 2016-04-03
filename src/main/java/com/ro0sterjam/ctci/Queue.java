package com.ro0sterjam.ctci;

/**
 * Created by kenwang on 2016-04-03.
 */
public class Queue<T> {

    private SinglyLinkedNode<T> front;
    private SinglyLinkedNode<T> back;

    public void enqueue(T value) {
        SinglyLinkedNode<T> node = new SinglyLinkedNode<>(value);
        if (front == null) {
            front = back = node;
        } else {
            back.next = node;
            back = node;
        }
    }

    public T dequeue() {
        if (front == null) {
            return null;
        }
        T dequeued = front.value;
        if (front == back) {
            front = back = null;
        } else {
            front = front.next;
        }
        return dequeued;
    }

    public T poll() {
        return front == null? null : front.value;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
