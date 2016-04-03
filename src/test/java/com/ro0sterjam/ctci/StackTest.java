package com.ro0sterjam.ctci;

import org.junit.Test;

import static com.ro0sterjam.ctci.Stack.sort;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by kenwang on 2016-04-03.
 */
public class StackTest {

    @Test
    public void testSort_emptyStack() {
        Stack<Integer> stack = new Stack<>();
        sort(stack);
        assertArrayEquals(new Integer[0], stack.toArray());
    }

    @Test
    public void testSort_singleElement() {
        Stack<Integer> stack = Stack.of(7);
        sort(stack);
        assertArrayEquals(new Integer[]{ 7 }, stack.toArray());
    }

    @Test
    public void testSort_sorted() {
        Stack<Integer> stack = Stack.of(7, 8, 9, 10);
        sort(stack);
        assertArrayEquals(new Integer[]{ 7, 8, 9, 10 }, stack.toArray());
    }

    @Test
    public void testSort_sortedBackwards() {
        Stack<Integer> stack = Stack.of(10, 9, 8, 7);
        sort(stack);
        assertArrayEquals(new Integer[]{ 7, 8, 9, 10 }, stack.toArray());
    }

    @Test
    public void testSort_unsorted() {
        Stack<Integer> stack = Stack.of(5, 2, 6, 3, 4, 7, 1);
        sort(stack);
        assertArrayEquals(new Integer[]{ 1, 2, 3, 4, 5, 6, 7 }, stack.toArray());
    }

    @Test
    public void testSort_repeatedValues() {
        Stack<Integer> stack = Stack.of(5, 2, 6, 3, 4, 7, 1, 3);
        sort(stack);
        assertArrayEquals(new Integer[]{ 1, 2, 3, 3, 4, 5, 6, 7 }, stack.toArray());
    }

    @Test
    public void testSort_somePopsAndPushes() {
        Stack<Integer> stack = Stack.of(5, 2, 6, 3, 4, 7, 1, 3);
        stack.pop();
        stack.push(6);
        stack.push(9);
        stack.pop();
        sort(stack);
        assertArrayEquals(new Integer[]{ 1, 2, 3, 4, 5, 6, 6, 7 }, stack.toArray());
    }

}