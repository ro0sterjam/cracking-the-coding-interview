package test.java;

import main.java.StackBasedQueue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by kenwang on 2016-04-02.
 */
public class StackBasedQueueTest {

    @Test
    public void testDequeue_emptyQueue() {
        StackBasedQueue<Integer> queue = new StackBasedQueue<>();
        assertEquals(null, queue.dequeue());
    }

    @Test
    public void testEnqueueAndDequeue_singleElement() {
        StackBasedQueue<Integer> queue = new StackBasedQueue<>();
        queue.enqueue(4);
        assertEquals((Integer) 4, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueAndDequeue_multipleElements() {
        StackBasedQueue<Integer> queue = new StackBasedQueue<>();
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(9);
        assertEquals((Integer) 6, queue.dequeue());
        assertEquals((Integer) 7, queue.dequeue());
        assertEquals((Integer) 2, queue.dequeue());
        assertEquals((Integer) 4, queue.dequeue());
        assertEquals((Integer) 9, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueAndDequeue_randomOrder() {
        StackBasedQueue<Integer> queue = new StackBasedQueue<>();
        queue.enqueue(6);
        queue.enqueue(7);
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(9);
        assertEquals((Integer) 4, queue.dequeue());
        assertEquals((Integer) 9, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

}