package com.ro0sterjam.ctci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kenwang on 2016-05-01.
 */
public class ArrayBasedStacksTest {

    @Test(expected = RuntimeException.class)
    public void testPop_emptyFirstStack() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>();
        stacks.pop(0);
    }

    @Test(expected = RuntimeException.class)
    public void testPop_emptySecondStack() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>();
        stacks.pop(1);
    }

    @Test(expected = RuntimeException.class)
    public void testPop_emptyThirdStack() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>();
        stacks.pop(2);
    }

    @Test
    public void testPush_atFirstLimit() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>(9);
        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(0, 3);
        assertEquals((Integer) 3, stacks.peek(0));
    }

    @Test(expected = RuntimeException.class)
    public void testPush_pastFirstLimit() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>(9);
        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(0, 3);
        stacks.push(0, 4);
    }

    @Test
    public void testPush_atSecondLimit() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>(9);
        stacks.push(1, 1);
        stacks.push(1, 2);
        stacks.push(1, 3);
        assertEquals((Integer) 3, stacks.peek(1));
    }

    @Test(expected = RuntimeException.class)
    public void testPush_pastSecondLimit() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>(9);
        stacks.push(1, 1);
        stacks.push(1, 2);
        stacks.push(1, 3);
        stacks.push(1, 4);
    }

    @Test
    public void testPush_atThirdLimit() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>(9);
        stacks.push(2, 1);
        stacks.push(2, 2);
        stacks.push(2, 3);
        assertEquals((Integer) 3, stacks.peek(2));
    }

    @Test(expected = RuntimeException.class)
    public void testPush_pastThirdLimit() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>(9);
        stacks.push(2, 1);
        stacks.push(2, 2);
        stacks.push(2, 3);
        stacks.push(2, 4);
    }

    @Test
    public void testPushAndPop_first() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>();
        stacks.push(0, 1);
        stacks.push(0, 2);
        assertEquals((Integer) 2, stacks.pop(0));
        assertEquals((Integer) 1, stacks.pop(0));
    }

    @Test
    public void testPushAndPop_second() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>();
        stacks.push(1, 1);
        stacks.push(1, 2);
        assertEquals((Integer) 2, stacks.pop(1));
        assertEquals((Integer) 1, stacks.pop(1));
    }

    @Test
    public void testPushAndPop_third() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>();
        stacks.push(2, 1);
        stacks.push(2, 2);
        assertEquals((Integer) 2, stacks.pop(2));
        assertEquals((Integer) 1, stacks.pop(2));
    }

    @Test
    public void testPushAndPop_allStacks() {
        ArrayBasedStacks<Integer> stacks = new ArrayBasedStacks<>();
        stacks.push(0, 4);
        stacks.push(1, 2);
        stacks.push(2, 5);
        stacks.push(2, 8);
        stacks.push(0, 3);
        stacks.push(1, 1);
        assertEquals((Integer) 3, stacks.pop(0));
        assertEquals((Integer) 4, stacks.pop(0));
        assertEquals((Integer) 1, stacks.pop(1));
        assertEquals((Integer) 2, stacks.pop(1));
        assertEquals((Integer) 8, stacks.pop(2));
        assertEquals((Integer) 5, stacks.pop(2));
    }

}