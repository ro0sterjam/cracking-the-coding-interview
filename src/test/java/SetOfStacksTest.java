package test.java;

import main.java.SetOfStacks;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kenwang on 2016-04-02.
 */
public class SetOfStacksTest {

    @Test
    public void testPop_emptyStack() {
        SetOfStacks<Integer> stack = new SetOfStacks<>();
        assertEquals(null, stack.pop());
    }

    @Test
    public void testPushAndPop_singleElement() {
        SetOfStacks<Integer> stack = new SetOfStacks<>(3);
        stack.push(5);
        assertEquals((Integer) 5, stack.pop());
    }

    @Test
    public void testPushAndPop_MultipleElements() {
        SetOfStacks<Integer> stack = new SetOfStacks<>(3);
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
        SetOfStacks<Integer> stack = new SetOfStacks<>(3);
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
        SetOfStacks<Integer> stack = new SetOfStacks<>(3);
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
        SetOfStacks<Integer> stack = new SetOfStacks<>(3);
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