package test.java;

import main.java.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kenwang on 2016-04-02.
 */
public class NodeTest {

    @Test
    public void testStartOfLoop_singleNodeNoLoop() {
        Node<Integer> node = new Node<>(4);
        assertEquals(null, node.startOfLoop());
    }

    @Test
    public void testStartOfLoop_singleNodeWithLoop() {
        Node<Integer> node = new Node<>(4);
        node.next = node;
        assertEquals(node, node.startOfLoop());
    }

    @Test
    public void testStartOfLoop_twoNodesNoLoop() {
        Node<Integer> node1 = new Node<>(4);
        Node<Integer> node2 = new Node<>(6);
        node1.next = node2;
        assertEquals(null, node1.startOfLoop());
    }

    @Test
    public void testStartOfLoop_twoNodesWithLoop() {
        Node<Integer> node1 = new Node<>(4);
        Node<Integer> node2 = new Node<>(7);
        node1.next = node2;
        node2.next = node1;
        assertEquals(node1, node1.startOfLoop());
    }

    @Test
    public void testStartOfLoop_twoNodesLoopStartingAtSecondNode() {
        Node<Integer> node1 = new Node<>(4);
        Node<Integer> node2 = new Node<>(2);
        node1.next = node2;
        node2.next = node2;
        assertEquals(node2, node1.startOfLoop());
    }

    @Test
    public void testStartOfLoop_multipleNodesNoLoop() {
        Node<Integer> node1 = new Node<>(4);
        Node<Integer> node2 = new Node<>(7);
        Node<Integer> node3 = new Node<>(2);
        Node<Integer> node4 = new Node<>(3);
        Node<Integer> node5 = new Node<>(9);
        Node<Integer> node6 = new Node<>(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        assertEquals(null, node1.startOfLoop());
    }

    @Test
    public void testStartOfLoop_multipleNodesWithLoop() {
        Node<Integer> node1 = new Node<>(4);
        Node<Integer> node2 = new Node<>(7);
        Node<Integer> node3 = new Node<>(2);
        Node<Integer> node4 = new Node<>(3);
        Node<Integer> node5 = new Node<>(9);
        Node<Integer> node6 = new Node<>(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node1;
        assertEquals(node1, node1.startOfLoop());
    }

    @Test
    public void testStartOfLoop_multipleNodesWithLoopStartingInMiddle() {
        Node<Integer> node1 = new Node<>(7);
        Node<Integer> node2 = new Node<>(3);
        Node<Integer> node3 = new Node<>(2);
        Node<Integer> node4 = new Node<>(1);
        Node<Integer> node5 = new Node<>(4);
        Node<Integer> node6 = new Node<>(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
        assertEquals(node3, node1.startOfLoop());
    }

}