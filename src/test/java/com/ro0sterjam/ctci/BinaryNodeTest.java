package com.ro0sterjam.ctci;

import org.junit.Test;

import java.util.List;

import static com.ro0sterjam.ctci.BinaryNode.isOrdered;
import static org.junit.Assert.*;

/**
 * Created by kenwang on 2016-04-03.
 */
public class BinaryNodeTest {

    @Test
    public void testIsBalanced_singleNode() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        assertTrue(root.isBalanced());
    }

    @Test
    public void testIsBalanced_singleLeftNode() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.left = new BinaryNode<>(4);
        assertTrue(root.isBalanced());
    }

    @Test
    public void testIsBalanced_twoLeftNodes() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.left = new BinaryNode<>(4);
        root.left.left = new BinaryNode<>(5);
        assertFalse(root.isBalanced());
    }

    @Test
    public void testIsBalanced_leftRightNodes() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.left = new BinaryNode<>(4);
        root.left.right = new BinaryNode<>(5);
        assertFalse(root.isBalanced());
    }

    @Test
    public void testIsBalanced_singleRightNode() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.right = new BinaryNode<>(4);
        assertTrue(root.isBalanced());
    }

    @Test
    public void testIsBalanced_twoRightNodes() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.right = new BinaryNode<>(4);
        root.right.right = new BinaryNode<>(5);
        assertFalse(root.isBalanced());
    }

    @Test
    public void testIsBalanced_rightLeftNodes() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.right = new BinaryNode<>(4);
        root.right.left = new BinaryNode<>(5);
        assertFalse(root.isBalanced());
    }

    @Test
    public void testIsBalanced_singleLeftAndRight() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.left = new BinaryNode<>(4);
        root.right = new BinaryNode<>(9);
        assertTrue(root.isBalanced());
    }

    @Test
    public void testIsBalanced_singleLeftAndTwoRight() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.left = new BinaryNode<>(4);
        root.right = new BinaryNode<>(9);
        root.right.right = new BinaryNode<>(11);
        assertTrue(root.isBalanced());
    }

    @Test
    public void testIsBalanced_unbalancedSubtree() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.left = new BinaryNode<>(4);
        root.left.left = new BinaryNode<>(9);
        root.left.left.left = new BinaryNode<>(4);
        root.right = new BinaryNode<>(12);
        root.right.right = new BinaryNode<>(11);
        assertFalse(root.isBalanced());
    }

    @Test
    public void testFromArray_emptyArray() {
        Integer[] array = new Integer[0];
        BinaryNode<Integer> root = BinaryNode.fromArray(array);
        assertEquals(null, root);
    }

    @Test
    public void testFromArray_singleElement() {
        Integer[] array = new Integer[]{ 5 };
        BinaryNode<Integer> root = BinaryNode.fromArray(array);
        assertEquals(0, root.height());
    }

    @Test
    public void testFromArray_twoElements() {
        Integer[] array = new Integer[]{ 5, 7 };
        BinaryNode<Integer> root = BinaryNode.fromArray(array);
        assertEquals(1, root.height());
        assertTrue(isOrdered(root));
    }

    @Test
    public void testFromArray_threeElements() {
        Integer[] array = new Integer[]{ 5, 7, 9 };
        BinaryNode<Integer> root = BinaryNode.fromArray(array);
        assertEquals(1, root.height());
        assertTrue(isOrdered(root));
    }

    @Test
    public void testFromArray_fourElements() {
        Integer[] array = new Integer[]{ 5, 7, 9, 10 };
        BinaryNode<Integer> root = BinaryNode.fromArray(array);
        assertEquals(2, root.height());
        assertTrue(isOrdered(root));
    }

    @Test
    public void testFromArray_sevenElements() {
        Integer[] array = new Integer[]{ 5, 7, 9, 10, 17, 19, 22 };
        BinaryNode<Integer> root = BinaryNode.fromArray(array);
        assertEquals(2, root.height());
        assertTrue(isOrdered(root));
    }

    @Test
    public void testFromArray_eightElements() {
        Integer[] array = new Integer[]{ 5, 7, 9, 10, 17, 19, 22, 24 };
        BinaryNode<Integer> root = BinaryNode.fromArray(array);
        assertEquals(3, root.height());
        assertTrue(isOrdered(root));
    }

    @Test
    public void testToList_singleElement() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        List<LinkedList<Integer>> lists = root.toLists();
        assertEquals(1, lists.size());
        assertEquals(1, lists.get(0).size());
        assertEquals((Integer) 6, lists.get(0).get(0));
    }

    @Test
    public void testToList_threeElementsTwoLevels() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.left = new BinaryNode<>(7);
        root.right = new BinaryNode<>(8);
        List<LinkedList<Integer>> lists = root.toLists();
        assertEquals(2, lists.size());
        assertEquals(1, lists.get(0).size());
        assertEquals(2, lists.get(1).size());
        assertEquals((Integer) 6, lists.get(0).get(0));
        assertEquals((Integer) 7, lists.get(1).get(0));
        assertEquals((Integer) 8, lists.get(1).get(1));
    }

    @Test
    public void testToList_multipleUnevenLevels() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.left = new BinaryNode<>(7);
        root.left.left = new BinaryNode<>(11);
        root.right = new BinaryNode<>(8);
        root.right.right = new BinaryNode<>(99);
        List<LinkedList<Integer>> lists = root.toLists();
        assertEquals(3, lists.size());
        assertEquals(1, lists.get(0).size());
        assertEquals(2, lists.get(1).size());
        assertEquals(2, lists.get(2).size());
        assertEquals((Integer) 6, lists.get(0).get(0));
        assertEquals((Integer) 7, lists.get(1).get(0));
        assertEquals((Integer) 8, lists.get(1).get(1));
        assertEquals((Integer) 11, lists.get(2).get(0));
        assertEquals((Integer) 99, lists.get(2).get(1));
    }
}