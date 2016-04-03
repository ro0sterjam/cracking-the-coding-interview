package com.ro0sterjam.ctci;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

}