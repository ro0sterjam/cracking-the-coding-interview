package test.java;

import main.java.MinTrackingStack;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by kenwang on 2016-04-02.
 */
public class MinTrackingStackTest {

    @Test
    public void testMin_emptyStack() {
        MinTrackingStack<Integer> stack = new MinTrackingStack<>();
        assertThat(stack.min(), is(nullValue()));
    }

    @Test
    public void testMin_singleElement() {
        MinTrackingStack<Integer> stack = MinTrackingStack.of(4);
        assertEquals((Integer) 4, stack.min());
    }

    @Test
    public void testMin_smallestAtBottom() {
        MinTrackingStack<Integer> stack = MinTrackingStack.of(4, 8, 7, 5);
        assertEquals((Integer) 4, stack.min());
    }

    @Test
    public void testMin_smallestAtTop() {
        MinTrackingStack<Integer> stack = MinTrackingStack.of(4, 8, 7, 3);
        assertEquals((Integer) 3, stack.min());
    }

    @Test
    public void testMin_smallestInMiddle() {
        MinTrackingStack<Integer> stack = MinTrackingStack.of(4, 8, 7, 3, 6, 9);
        assertEquals((Integer) 3, stack.min());
    }

    @Test
    public void testMin_smallestPopped() {
        MinTrackingStack<Integer> stack = MinTrackingStack.of(4, 8, 7, 3);
        stack.pop();
        assertEquals((Integer) 4, stack.min());
    }

    @Test
    public void testMin_smallestNotPopped() {
        MinTrackingStack<Integer> stack = MinTrackingStack.of(4, 8, 7, 5);
        stack.pop();
        assertEquals((Integer) 4, stack.min());
    }

    @Test
    public void testMin_duplicateSmallestPopped() {
        MinTrackingStack<Integer> stack = MinTrackingStack.of(3, 8, 7, 3);
        stack.pop();
        assertEquals((Integer) 3, stack.min());
    }
}