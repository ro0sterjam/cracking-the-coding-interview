package test.java;

import main.java.StackWithMin;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by kenwang on 2016-04-02.
 */
public class StackWithMinTest {

    @Test
    public void testMin_emptyStack() {
        StackWithMin<Integer> stack = new StackWithMin<>();
        assertThat(stack.min(), is(nullValue()));
    }

    @Test
    public void testMin_singleElement() {
        StackWithMin<Integer> stack = StackWithMin.of(4);
        assertEquals((Integer) 4, stack.min());
    }

    @Test
    public void testMin_smallestAtBottom() {
        StackWithMin<Integer> stack = StackWithMin.of(4, 8, 7, 5);
        assertEquals((Integer) 4, stack.min());
    }

    @Test
    public void testMin_smallestAtTop() {
        StackWithMin<Integer> stack = StackWithMin.of(4, 8, 7, 3);
        assertEquals((Integer) 3, stack.min());
    }

    @Test
    public void testMin_smallestInMiddle() {
        StackWithMin<Integer> stack = StackWithMin.of(4, 8, 7, 3, 6, 9);
        assertEquals((Integer) 3, stack.min());
    }

    @Test
    public void testMin_smallestPopped() {
        StackWithMin<Integer> stack = StackWithMin.of(4, 8, 7, 3);
        stack.pop();
        assertEquals((Integer) 4, stack.min());
    }

    @Test
    public void testMin_smallestNotPopped() {
        StackWithMin<Integer> stack = StackWithMin.of(4, 8, 7, 5);
        stack.pop();
        assertEquals((Integer) 4, stack.min());
    }

    @Test
    public void testMin_duplicateSmallestPopped() {
        StackWithMin<Integer> stack = StackWithMin.of(3, 8, 7, 3);
        stack.pop();
        assertEquals((Integer) 3, stack.min());
    }
}