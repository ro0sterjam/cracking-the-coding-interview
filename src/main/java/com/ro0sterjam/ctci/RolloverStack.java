package com.ro0sterjam.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenwang on 2016-04-02.
 */
public class RolloverStack<T> {

    private static final int DEFAULT_CAPACITY = 5;

    private List<Stack<T>> stacks = new ArrayList<>();
    private final int capacity;

    public RolloverStack(int capacity) {
        this.capacity = capacity;
    }

    public RolloverStack() {
        this(DEFAULT_CAPACITY);
    }

    public void push(T value) {
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == capacity) {
            stacks.add(new Stack<>());
        }
        stacks.get(stacks.size() - 1).push(value);
    }

    public T pop() {
        if (stacks.isEmpty() ) {
            return null;
        }
        return popAt(stacks.size() - 1);
    }

    public T popAt(int index) {
        Stack<T> stack = stacks.get(index);
        T popped = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(index);
        }
        return popped;
    }

}
