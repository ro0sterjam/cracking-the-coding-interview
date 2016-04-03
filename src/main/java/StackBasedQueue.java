package main.java;

/**
 * Created by kenwang on 2016-04-02.
 */
public class StackBasedQueue<T> {

    private Stack<T> left = new Stack<>();
    private Stack<T> right = new Stack<>();

    public void enqueue(T value) {
        while (!right.isEmpty()) {
            left.push(right.pop());
        }
        left.push(value);
    }

    public T dequeue() {
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        return right.pop();
    }

    public boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }
}
