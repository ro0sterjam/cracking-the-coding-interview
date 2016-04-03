package main.java;

/**
 * Created by kenwang on 2016-04-02.
 */
public class Stack<T> {

    private Node<T> top;
    private int size = 0;

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        Node<T> node = top;
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

    public static <T extends Comparable<T>> Stack<T> of(T... elements) {
        Stack<T> stack = new Stack<>();
        for (T element : elements) {
            stack.push(element);
        }
        return stack;
    }
}
