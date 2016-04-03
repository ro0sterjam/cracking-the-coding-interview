package test.java;

import main.java.RolloverStack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kenwang on 2016-04-02.
 */
public class RolloverStackTest {

    @Test
    public void testPop_emptyStack() {
        RolloverStack<Integer> stack = new RolloverStack<>();
        assertEquals(null, stack.pop());
    }

    @Test
    public void testPushAndPop_singleElement() {
        RolloverStack<Integer> stack = new RolloverStack<>(3);
        stack.push(5);
        assertEquals((Integer) 5, stack.pop());
    }

    @Test
    public void testPushAndPop_MultipleElements() {
        RolloverStack<Integer> stack = new RolloverStack<>(3);
        stack.push(5);
        stack.push(7);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(22);
        stack.push(43);
        assertEquals((Integer) 43, stack.pop());
        assertEquals((Integer) 22, stack.pop());
        assertEquals((Integer) 7, stack.pop());
        assertEquals((Integer) 5, stack.pop());
        assertEquals((Integer) 3, stack.pop());
        assertEquals((Integer) 7, stack.pop());
        assertEquals((Integer) 5, stack.pop());
    }

    @Test
    public void testPushPopAndPush_nearCapacity() {
        RolloverStack<Integer> stack = new RolloverStack<>(3);
        stack.push(5);
        stack.push(7);
        stack.push(3);
        stack.push(5);
        stack.pop();
        stack.push(9);
        assertEquals((Integer) 9, stack.pop());
        assertEquals((Integer) 3, stack.pop());
        assertEquals((Integer) 7, stack.pop());
        assertEquals((Integer) 5, stack.pop());
    }

    @Test
    public void testPopAt_middleStack() {
        RolloverStack<Integer> stack = new RolloverStack<>(3);
        stack.push(5);
        stack.push(7);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(22);
        stack.push(43);
        stack.popAt(1);
        assertEquals((Integer) 43, stack.pop());
        assertEquals((Integer) 7, stack.pop());
        assertEquals((Integer) 5, stack.pop());
        assertEquals((Integer) 3, stack.pop());
        assertEquals((Integer) 7, stack.pop());
        assertEquals((Integer) 5, stack.pop());
    }

    @Test
    public void testPopAt_middleStackAll() {
        RolloverStack<Integer> stack = new RolloverStack<>(3);
        stack.push(5);
        stack.push(7);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(22);
        stack.push(43);
        stack.popAt(1);
        stack.popAt(1);
        stack.popAt(1);
        assertEquals((Integer) 43, stack.pop());
        assertEquals((Integer) 3, stack.pop());
        assertEquals((Integer) 7, stack.pop());
        assertEquals((Integer) 5, stack.pop());
    }

}