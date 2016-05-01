package com.ro0sterjam.ctci;

/**
 * Created by kenwang on 2016-04-19.
 */
public class ArrayBasedStacks<T> {

    private static final int DEFAULT_ARRAY_SIZE = 999;

    private Object[] array;
    private int[] pointers = new int[]{ -1, -1, -1 };

    public ArrayBasedStacks() {
        array = new Object[DEFAULT_ARRAY_SIZE];
    }

    public ArrayBasedStacks(int size) {
        if (size % 3 != 0) {
            throw new IllegalArgumentException("Size must be divisible by 3");
        }
        array = new Object[size];
    }

    public void push(int stack, T value) {
        if (stack < 0 || stack > pointers.length - 1) {
            throw new IllegalArgumentException("Stack must be between 0 and " + (pointers.length - 1));
        } else if (pointers[stack] + 1 == array.length / pointers.length) {
            throw new RuntimeException("No more space in stack");
        } else {
            array[stack * array.length / pointers.length + ++pointers[stack]] = value;
        }
    }

    public T pop(int stack) {
        if (stack < 0 || stack > pointers.length - 1) {
            throw new IllegalArgumentException("Stack must be between 0 and " + (pointers.length - 1));
        } else if (pointers[stack] == -1) {
            throw new RuntimeException("Nothing to pop");
        } else {
            return (T) array[stack * array.length / pointers.length + pointers[stack]--];
        }
    }

    public T peek(int stack) {
        if (stack < 0 || stack > pointers.length - 1) {
            throw new IllegalArgumentException("Stack must be between 0 and " + (pointers.length - 1));
        } else if (pointers[stack] == -1) {
            throw new RuntimeException("Nothing to peek");
        } else {
            return (T) array[stack * array.length / pointers.length + pointers[stack]];
        }
    }

}
