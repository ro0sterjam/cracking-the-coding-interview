package com.ro0sterjam.ctci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kenwang on 2016-04-02.
 */
public class SinglyLinkedNodeTest {

    @Test
    public void testStartOfLoop_singleNodeNoLoop() {
        SinglyLinkedNode<Integer> node = new SinglyLinkedNode<>(4);
        assertEquals(null, node.startOfLoop());
    }

    @Test
    public void testStartOfLoop_singleNodeWithLoop() {
        SinglyLinkedNode<Integer> node = new SinglyLinkedNode<>(4);
        node.next = node;
        assertEquals(node, node.startOfLoop());
    }

    @Test
    public void testStartOfLoop_twoNodesNoLoop() {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<>(4);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<>(6);
        node1.next = node2;
        assertEquals(null, node1.startOfLoop());
    }

    @Test
    public void testStartOfLoop_twoNodesWithLoop() {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<>(4);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<>(7);
        node1.next = node2;
        node2.next = node1;
        assertEquals(node1, node1.startOfLoop());
    }

    @Test
    public void testStartOfLoop_twoNodesLoopStartingAtSecondNode() {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<>(4);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<>(2);
        node1.next = node2;
        node2.next = node2;
        assertEquals(node2, node1.startOfLoop());
    }

    @Test
    public void testStartOfLoop_multipleNodesNoLoop() {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<>(4);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<>(7);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<>(2);
        SinglyLinkedNode<Integer> node4 = new SinglyLinkedNode<>(3);
        SinglyLinkedNode<Integer> node5 = new SinglyLinkedNode<>(9);
        SinglyLinkedNode<Integer> node6 = new SinglyLinkedNode<>(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        assertEquals(null, node1.startOfLoop());
    }

    @Test
    public void testStartOfLoop_multipleNodesWithLoop() {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<>(4);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<>(7);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<>(2);
        SinglyLinkedNode<Integer> node4 = new SinglyLinkedNode<>(3);
        SinglyLinkedNode<Integer> node5 = new SinglyLinkedNode<>(9);
        SinglyLinkedNode<Integer> node6 = new SinglyLinkedNode<>(3);
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
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<>(7);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<>(3);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<>(2);
        SinglyLinkedNode<Integer> node4 = new SinglyLinkedNode<>(1);
        SinglyLinkedNode<Integer> node5 = new SinglyLinkedNode<>(4);
        SinglyLinkedNode<Integer> node6 = new SinglyLinkedNode<>(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
        assertEquals(node3, node1.startOfLoop());
    }

}