package main.java;

/**
 * Created by kenwang on 2016-04-02.
 */
public class MinTrackingStack<T extends Comparable<T>> extends Stack<T> {

    private final Stack<T> minStack = new Stack<>();

    @Override
    public void push(T value) {
        super.push(value);
        if (minStack.peek() == null || value.compareTo(minStack.peek()) <= 0) {
            minStack.push(value);
        }
    }

    @Override
    public T pop() {
       T popped = super.pop();
        if (popped.compareTo(minStack.peek()) == 0) {
            minStack.pop();
        }
        return popped;
    }

    public T min() {
        return minStack.peek();
    }

    public static <T extends Comparable<T>> MinTrackingStack<T> of(T... elements) {
        MinTrackingStack<T> stack = new MinTrackingStack<>();
        for (T element : elements) {
            stack.push(element);
        }
        return stack;
    }

}
