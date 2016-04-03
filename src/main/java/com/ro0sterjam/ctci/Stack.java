package com.ro0sterjam.ctci;

import java.lang.reflect.Array;

/**
 * Created by kenwang on 2016-04-02.
 */
public class Stack<T> {

    private SinglyLinkedNode<T> top;
    private int size = 0;

    public void push(T value) {
        SinglyLinkedNode<T> node = new SinglyLinkedNode<>(value);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        SinglyLinkedNode<T> node = top;
        top = node.next;
        size--;
        return node.value;
    }

    public T peek() {
        if (top == null) {
            return null;
        }
        return top.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T[] toArray() {
        if (top == null) {
            return (T[]) new Object[0];
        }
        T[] array = (T[]) Array.newInstance(top.value.getClass(), size());
        SinglyLinkedNode<T> node = top;
        int i = size() - 1;
        while (node != null) {
            array[i--] = node.value;
            node = node.next;
        }
        return array;
    }

    public static <T> Stack<T> of(T... elements) {
        Stack<T> stack = new Stack<>();
        for (T element : elements) {
            stack.push(element);
        }
        return stack;
    }

    public static <T extends Comparable<T>> void sort(Stack<T> stack) {
        Stack<T> sorted = new Stack<>();
        while (!stack.isEmpty()) {
            T tmp = stack.pop();
            while (!sorted.isEmpty() && sorted.peek().compareTo(tmp) > 0) {
                stack.push(sorted.pop());
            }
            sorted.push(tmp);
        }
        stack.top = sorted.top;
        stack.size = sorted.size;
    }
}
