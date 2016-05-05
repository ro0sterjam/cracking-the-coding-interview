package com.ro0sterjam.ctci;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.ro0sterjam.ctci.BinaryNode.*;
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
        root.setLeft(new BinaryNode<>(4));
        assertTrue(root.isBalanced());
    }

    @Test
    public void testIsBalanced_twoLeftNodes() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.setLeft(new BinaryNode<>(4));
        root.getLeft().setLeft(new BinaryNode<>(5));
        assertFalse(root.isBalanced());
    }

    @Test
    public void testIsBalanced_leftRightNodes() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.setLeft(new BinaryNode<>(4));
        root.getLeft().setRight(new BinaryNode<>(5));
        assertFalse(root.isBalanced());
    }

    @Test
    public void testIsBalanced_singleRightNode() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.setRight(new BinaryNode<>(4));
        assertTrue(root.isBalanced());
    }

    @Test
    public void testIsBalanced_twoRightNodes() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.setRight(new BinaryNode<>(4));
        root.getRight().setRight(new BinaryNode<>(5));
        assertFalse(root.isBalanced());
    }

    @Test
    public void testIsBalanced_rightLeftNodes() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.setRight(new BinaryNode<>(4));
        root.getRight().setLeft(new BinaryNode<>(5));
        assertFalse(root.isBalanced());
    }

    @Test
    public void testIsBalanced_singleLeftAndRight() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.setLeft(new BinaryNode<>(4));
        root.setRight(new BinaryNode<>(9));
        assertTrue(root.isBalanced());
    }

    @Test
    public void testIsBalanced_singleLeftAndTwoRight() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.setLeft(new BinaryNode<>(4));
        root.setRight(new BinaryNode<>(9));
        root.getRight().setRight(new BinaryNode<>(11));
        assertTrue(root.isBalanced());
    }

    @Test
    public void testIsBalanced_unbalancedSubtree() {
        BinaryNode<Integer> root = new BinaryNode<>(6);
        root.setLeft(new BinaryNode<>(4));
        root.getLeft().setLeft(new BinaryNode<>(9));
        root.getLeft().getLeft().setLeft(new BinaryNode<>(4));
        root.setRight(new BinaryNode<>(12));
        root.getRight().setRight(new BinaryNode<>(11));
        assertFalse(root.isBalanced());
    }

    @Test
    public void testFromArrayInOrder_emptyArray() {
        Integer[] array = new Integer[0];
        BinaryNode<Integer> root = BinaryNode.fromArrayInOrder(array);
        assertEquals(null, root);
    }

    @Test
    public void testFromArrayInOrder_singleElement() {
        Integer[] array = new Integer[]{ 5 };
        BinaryNode<Integer> root = BinaryNode.fromArrayInOrder(array);
        assertEquals(0, root.height());
    }

    @Test
    public void testFromArrayInOrder_twoElements() {
        Integer[] array = new Integer[]{ 5, 7 };
        BinaryNode<Integer> root = BinaryNode.fromArrayInOrder(array);
        assertEquals(1, root.height());
        assertTrue(isOrdered(root));
    }

    @Test
    public void testFromArrayInOrder_threeElements() {
        Integer[] array = new Integer[]{ 5, 7, 9 };
        BinaryNode<Integer> root = BinaryNode.fromArrayInOrder(array);
        assertEquals(1, root.height());
        assertTrue(isOrdered(root));
    }

    @Test
    public void testFromArrayInOrder_fourElements() {
        Integer[] array = new Integer[]{ 5, 7, 9, 10 };
        BinaryNode<Integer> root = BinaryNode.fromArrayInOrder(array);
        assertEquals(2, root.height());
        assertTrue(isOrdered(root));
    }

    @Test
    public void testFromArrayInOrder_sevenElements() {
        Integer[] array = new Integer[]{ 5, 7, 9, 10, 17, 19, 22 };
        BinaryNode<Integer> root = BinaryNode.fromArrayInOrder(array);
        assertEquals(2, root.height());
        assertTrue(isOrdered(root));
    }

    @Test
    public void testFromArrayInOrder_eightElements() {
        Integer[] array = new Integer[]{ 5, 7, 9, 10, 17, 19, 22, 24 };
        BinaryNode<Integer> root = BinaryNode.fromArrayInOrder(array);
        assertEquals(3, root.height());
        assertTrue(isOrdered(root));
    }

    @Test
    public void testFromArrayLevelOrder_emptyArray() {
        Integer[] array = new Integer[0];
        assertEquals(null, fromArrayLevelOrder(array));
    }

    @Test
    public void testFromArrayLevelOrder_singleElement() {
        BinaryNode<Integer> node = fromArrayLevelOrder(new Integer[]{ 4 });
        assertEquals((Integer) 4, node.getValue());
        assertEquals(null, node.getLeft());
        assertEquals(null, node.getRight());
    }

    @Test
    public void testFromArrayLevelOrder_twoElements() {
        BinaryNode<Integer> node = fromArrayLevelOrder(new Integer[]{ 4, 7 });
        assertEquals((Integer) 4, node.getValue());
        assertEquals((Integer) 7, node.getLeft().getValue());
        assertEquals(null, node.getRight());
    }

    @Test
    public void testFromArrayLevelOrder_threeElements() {
        BinaryNode<Integer> node = fromArrayLevelOrder(new Integer[]{ 4, 7, 8 });
        assertEquals((Integer) 4, node.getValue());
        assertEquals((Integer) 7, node.getLeft().getValue());
        assertEquals((Integer) 8, node.getRight().getValue());
    }

    @Test
    public void testFromArrayLevelOrder_sixElements() {
        BinaryNode<Integer> node = fromArrayLevelOrder(new Integer[]{ 4, 7, 8, 10, 3, 7 });
        assertEquals((Integer) 4, node.getValue());
        assertEquals((Integer) 7, node.getLeft().getValue());
        assertEquals((Integer) 8, node.getRight().getValue());
        assertEquals((Integer) 10, node.getLeft().getLeft().getValue());
        assertEquals((Integer) 3, node.getLeft().getRight().getValue());
        assertEquals((Integer) 7, node.getRight().getLeft().getValue());
    }

    @Test
    public void testFromArrayLevelOrder_nullElements() {
        BinaryNode<Integer> node = fromArrayLevelOrder(new Integer[]{ 4, null, 8, null, null, 10, 3, null, null, null, null, null, 7 });
        assertEquals((Integer) 4, node.getValue());
        assertEquals(null, node.getLeft());
        assertEquals((Integer) 8, node.getRight().getValue());
        assertEquals((Integer) 10, node.getRight().getLeft().getValue());
        assertEquals((Integer) 3, node.getRight().getRight().getValue());
        assertEquals(null, node.getRight().getLeft().getLeft());
        assertEquals((Integer) 7, node.getRight().getLeft().getRight().getValue());
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
        root.setLeft(new BinaryNode<>(7));
        root.setRight(new BinaryNode<>(8));
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
        root.setLeft(new BinaryNode<>(7));
        root.getLeft().setLeft(new BinaryNode<>(11));
        root.setRight(new BinaryNode<>(8));
        root.getRight().setRight(new BinaryNode<>(99));
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

    @Test
    public void testNext_singleNode() {
        BinaryNode<Integer> root = new BinaryNode<>(5);
        assertEquals(null, root.next());
    }

    @Test
    public void testNext_leftChild() {
        BinaryNode<Integer> root = new BinaryNode<>(5);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        root.setLeft(left);
        assertEquals(null, root.next());
    }

    @Test
    public void testNext_rightChild() {
        BinaryNode<Integer> root = new BinaryNode<>(5);
        BinaryNode<Integer> right = new BinaryNode<>(7);
        root.setRight(right);
        assertEquals(right, root.next());
    }

    @Test
    public void testNext_leftChildAndRightChild() {
        BinaryNode<Integer> root = new BinaryNode<>(5);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> right = new BinaryNode<>(7);
        root.setLeft(left);
        root.setRight(right);
        assertEquals(right, root.next());
    }

    @Test
    public void testNext_rightChildAndRightParent() {
        BinaryNode<Integer> root = new BinaryNode<>(5);
        BinaryNode<Integer> right = new BinaryNode<>(7);
        BinaryNode<Integer> rightParent = new BinaryNode<>(8);
        root.setRight(right);
        rightParent.setLeft(root);
        assertEquals(right, root.next());
    }

    @Test
    public void testNext_rightParent() {
        BinaryNode<Integer> root = new BinaryNode<>(5);
        BinaryNode<Integer> rightParent = new BinaryNode<>(8);
        rightParent.setLeft(root);
        assertEquals(rightParent, root.next());
    }

    @Test
    public void testNext_rightParentAndRightGrandparent() {
        BinaryNode<Integer> root = new BinaryNode<>(5);
        BinaryNode<Integer> rightParent = new BinaryNode<>(8);
        BinaryNode<Integer> rightGrandParent = new BinaryNode<>(10);
        rightParent.setLeft(root);
        rightGrandParent.setLeft(rightParent);
        assertEquals(rightParent, root.next());
    }

    @Test
    public void testNext_rightParentAndLeftGrandparent() {
        BinaryNode<Integer> root = new BinaryNode<>(5);
        BinaryNode<Integer> rightParent = new BinaryNode<>(8);
        BinaryNode<Integer> leftGrandParent = new BinaryNode<>(7);
        rightParent.setLeft(root);
        leftGrandParent.setRight(rightParent);
        assertEquals(rightParent, root.next());
    }

    @Test
    public void testNext_leftParentAndLeftGrandparent() {
        BinaryNode<Integer> root = new BinaryNode<>(5);
        BinaryNode<Integer> leftParent = new BinaryNode<>(3);
        BinaryNode<Integer> leftGrandParent = new BinaryNode<>(1);
        leftParent.setRight(root);
        leftGrandParent.setRight(leftParent);
        assertEquals(null, root.next());
    }

    @Test
    public void testNext_leftParentAndRightGrandparent() {
        BinaryNode<Integer> root = new BinaryNode<>(5);
        BinaryNode<Integer> leftParent = new BinaryNode<>(3);
        BinaryNode<Integer> rightGrandParent = new BinaryNode<>(7);
        leftParent.setRight(root);
        rightGrandParent.setLeft(leftParent);
        assertEquals(rightGrandParent, root.next());
    }

    @Test
    public void testFirstCommonAncestor_disjointedNodes() {
        BinaryNode<Integer> node1 = new BinaryNode<>(2);
        BinaryNode<Integer> node2 = new BinaryNode<>(5);
        assertEquals(null, firstCommonAncestor(node1, node2));
    }

    @Test
    public void testFirstCommonAncestor_disjointedTrees() {
        BinaryNode<Integer> node1 = new BinaryNode<>(2);
        BinaryNode<Integer> node1Parent = new BinaryNode<>(3);
        node1Parent.setLeft(node1);
        BinaryNode<Integer> node1Grandparent = new BinaryNode<>(3);
        node1Grandparent.setLeft(node1Parent);
        BinaryNode<Integer> node2 = new BinaryNode<>(5);
        BinaryNode<Integer> node2Parent = new BinaryNode<>(6);
        node2Parent.setLeft(node2);
        assertEquals(null, firstCommonAncestor(node1, node2));
    }

    @Test
    public void testFirstCommonAncestor_parent() {
        BinaryNode<Integer> node1 = new BinaryNode<>(2);
        BinaryNode<Integer> node2 = new BinaryNode<>(5);
        BinaryNode<Integer> parent = new BinaryNode<>(8);
        parent.setLeft(node1);
        parent.setRight(node2);
        assertEquals(parent, firstCommonAncestor(node1, node2));
    }

    @Test
    public void testFirstCommonAncestor_grandparent() {
        BinaryNode<Integer> node1 = new BinaryNode<>(2);
        BinaryNode<Integer> node1Parent = new BinaryNode<>(3);
        node1Parent.setLeft(node1);
        BinaryNode<Integer> node2 = new BinaryNode<>(5);
        BinaryNode<Integer> node2Parent = new BinaryNode<>(6);
        node2Parent.setLeft(node2);
        BinaryNode<Integer> grandparent = new BinaryNode<>(8);
        grandparent.setLeft(node1Parent);
        grandparent.setRight(node2Parent);
        assertEquals(grandparent, firstCommonAncestor(node1, node2));
    }

    @Test
    public void testFirstCommonAncestor_leftTaller() {
        BinaryNode<Integer> node1 = new BinaryNode<>(2);
        BinaryNode<Integer> node1Parent = new BinaryNode<>(3);
        node1Parent.setLeft(node1);
        BinaryNode<Integer> node2 = new BinaryNode<>(5);
        BinaryNode<Integer> grandparent = new BinaryNode<>(8);
        grandparent.setLeft(node1Parent);
        grandparent.setRight(node2);
        assertEquals(grandparent, firstCommonAncestor(node1, node2));
    }

    @Test
    public void testFirstCommonAncestor_rightTaller() {
        BinaryNode<Integer> node1 = new BinaryNode<>(2);
        BinaryNode<Integer> node2 = new BinaryNode<>(5);
        BinaryNode<Integer> node2Parent = new BinaryNode<>(3);
        node2Parent.setLeft(node2);
        BinaryNode<Integer> grandparent = new BinaryNode<>(8);
        grandparent.setLeft(node2Parent);
        grandparent.setRight(node1);
        assertEquals(grandparent, firstCommonAncestor(node1, node2));
    }

    @Test
    public void testFirstCommonAncestor_root() {
        BinaryNode<Integer> node1 = new BinaryNode<>(2);
        BinaryNode<Integer> node2 = new BinaryNode<>(5);
        node1.setLeft(node2);
        assertEquals(node1, firstCommonAncestor(node1, node2));
    }

    @Test
    public void testContains_singleRootNotContains() {
        BinaryNode<Integer> node = new BinaryNode<>(5);
        assertFalse(node.contains(new BinaryNode<>(7)));
    }

    @Test
    public void testContains_singleRootEquals() {
        BinaryNode<Integer> node = new BinaryNode<>(5);
        assertTrue(node.contains(node));
    }

    @Test
    public void testContains_leftChild() {
        BinaryNode<Integer> node = new BinaryNode<>(5);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        node.setLeft(left);
        assertTrue(node.contains(left));
    }

    @Test
    public void testContains_rightChild() {
        BinaryNode<Integer> node = new BinaryNode<>(5);
        BinaryNode<Integer> right = new BinaryNode<>(2);
        node.setRight(right);
        assertTrue(node.contains(right));
    }

    @Test
    public void testContains_leftGrandchild() {
        BinaryNode<Integer> node = new BinaryNode<>(5);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> grandLeft = new BinaryNode<>(2);
        node.setLeft(left);
        left.setLeft(grandLeft);
        assertTrue(node.contains(grandLeft));
    }

    @Test
    public void testContains_rightGrandchild() {
        BinaryNode<Integer> node = new BinaryNode<>(5);
        BinaryNode<Integer> right = new BinaryNode<>(2);
        BinaryNode<Integer> grandRight = new BinaryNode<>(2);
        node.setRight(right);
        right.setRight(grandRight);
        assertTrue(node.contains(grandRight));
    }

    @Test
    public void testContains_rootMultipleNodes() {
        BinaryNode<Integer> node = new BinaryNode<>(5);
        BinaryNode<Integer> right = new BinaryNode<>(2);
        BinaryNode<Integer> grandRight = new BinaryNode<>(2);
        node.setRight(right);
        right.setRight(grandRight);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> grandLeft = new BinaryNode<>(2);
        node.setLeft(left);
        left.setLeft(grandLeft);
        assertTrue(node.contains(node));
    }

    @Test
    public void testContains_containsMultipleNodes() {
        BinaryNode<Integer> node = new BinaryNode<>(5);
        BinaryNode<Integer> right = new BinaryNode<>(2);
        BinaryNode<Integer> grandRightRight = new BinaryNode<>(2);
        BinaryNode<Integer> grandRightLeft = new BinaryNode<>(2);
        node.setRight(right);
        right.setRight(grandRightRight);
        right.setLeft(grandRightLeft);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> grandLeftRight = new BinaryNode<>(2);
        node.setLeft(left);
        left.setRight(grandLeftRight);
        assertTrue(node.contains(right));
    }

    @Test
    public void testContains_notContainsMultipleNodes() {
        BinaryNode<Integer> node = new BinaryNode<>(5);
        BinaryNode<Integer> right = new BinaryNode<>(2);
        BinaryNode<Integer> grandRightRight = new BinaryNode<>(2);
        BinaryNode<Integer> grandRightLeft = new BinaryNode<>(2);
        node.setRight(right);
        right.setRight(grandRightRight);
        right.setLeft(grandRightLeft);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> grandLeftRight = new BinaryNode<>(2);
        node.setLeft(left);
        left.setRight(grandLeftRight);
        BinaryNode<Integer> otherNode = new BinaryNode<>(4);
        assertFalse(node.contains(otherNode));
    }

    @Test
    public void testContains_subtreeSingleNode() {
        BinaryNode<Integer> tree = fromArrayLevelOrder(new Integer[]{ 4, 6, 3 });
        assertTrue(tree.contains(fromArrayLevelOrder(new Integer[]{ 3 })));
    }

    @Test
    public void testContains_subtreeFull() {
        BinaryNode<Integer> tree = fromArrayLevelOrder(new Integer[]{ 4, 6, 3, 4, 8 });
        assertTrue(tree.contains(fromArrayLevelOrder(new Integer[]{ 6, 4, 8 })));
    }

    @Test
    public void testContains_subtreeLarger() {
        BinaryNode<Integer> tree = fromArrayLevelOrder(new Integer[]{ 4, 6, 3 });
        assertFalse(tree.contains(fromArrayLevelOrder(new Integer[]{ 3, 7 })));
    }

    @Test
    public void testContains_subtreeSmaller() {
        BinaryNode<Integer> tree = fromArrayLevelOrder(new Integer[]{ 4, 6, 3, null, null, 7 });
        assertFalse(tree.contains(fromArrayLevelOrder(new Integer[]{ 3 })));
    }

    @Test
    public void testContains_subtreeContained() {
        BinaryNode<Integer> tree = fromArrayLevelOrder(new Integer[]{ 4, 6, 3, null, null, 7 });
        assertTrue(tree.contains(fromArrayLevelOrder(new Integer[]{ 3, 7 })));
    }

    @Test
    public void testContains_manySameRoots() {
        BinaryNode<Integer> tree = fromArrayLevelOrder(new Integer[]{ 4, 3, 3, null, null, 7, 3, null, null, null, null, 3, 8, 7, null, null, null, null, null, null, null, null, null, 7, 3, null, 3, null, 9 });
        assertTrue(tree.contains(fromArrayLevelOrder(new Integer[]{ 3, 7, null, null, 9 })));
    }

    @Test
    public void testEquals_singleNodeAndNull() {
        BinaryNode<Integer> node = new BinaryNode<>(7);
        assertFalse(node.equals(null));
    }

    @Test
    public void testEquals_singleNodeSameInstance() {
        BinaryNode<Integer> node = new BinaryNode<>(8);
        assertTrue(node.equals(node));
    }

    @Test
    public void testEquals_singleNodeSameValue() {
        BinaryNode<Integer> node1 = new BinaryNode<>(8);
        BinaryNode<Integer> node2 = new BinaryNode<>(8);
        assertTrue(node1.equals(node2));
    }

    @Test
    public void testEquals_leftChildEquals() {
        BinaryNode<Integer> node1 = new BinaryNode<>(6);
        node1.setLeft(new BinaryNode<>(9));
        BinaryNode<Integer> node2 = new BinaryNode<>(6);
        node2.setLeft(new BinaryNode<>(9));
        assertTrue(node1.equals(node2));
    }

    @Test
    public void testEquals_leftChildNotEquals() {
        BinaryNode<Integer> node1 = new BinaryNode<>(6);
        node1.setLeft(new BinaryNode<>(9));
        BinaryNode<Integer> node2 = new BinaryNode<>(6);
        node2.setLeft(new BinaryNode<>(10));
        assertFalse(node1.equals(node2));
    }

    @Test
    public void testEquals_rightChildEquals() {
        BinaryNode<Integer> node1 = new BinaryNode<>(6);
        node1.setRight(new BinaryNode<>(9));
        BinaryNode<Integer> node2 = new BinaryNode<>(6);
        node2.setRight(new BinaryNode<>(9));
        assertTrue(node1.equals(node2));
    }

    @Test
    public void testEquals_rightChildNotEquals() {
        BinaryNode<Integer> node1 = new BinaryNode<>(6);
        node1.setRight(new BinaryNode<>(9));
        BinaryNode<Integer> node2 = new BinaryNode<>(6);
        node2.setRight(new BinaryNode<>(10));
        assertFalse(node1.equals(node2));
    }

    @Test
    public void testEquals_extraRightChild() {
        BinaryNode<Integer> node1 = new BinaryNode<>(6);
        node1.setLeft(new BinaryNode<>(9));
        BinaryNode<Integer> node2 = new BinaryNode<>(6);
        node2.setLeft(new BinaryNode<>(9));
        node2.setRight(new BinaryNode<>(10));
        assertFalse(node1.equals(node2));
    }

    @Test
    public void testEquals_otherExtraRightChild() {
        BinaryNode<Integer> node1 = new BinaryNode<>(6);
        node1.setLeft(new BinaryNode<>(9));
        node1.setRight(new BinaryNode<>(10));
        BinaryNode<Integer> node2 = new BinaryNode<>(6);
        node2.setLeft(new BinaryNode<>(9));
        assertFalse(node1.equals(node2));
    }

    @Test
    public void testEquals_extraLeftChild() {
        BinaryNode<Integer> node1 = new BinaryNode<>(6);
        node1.setRight(new BinaryNode<>(9));
        BinaryNode<Integer> node2 = new BinaryNode<>(6);
        node2.setRight(new BinaryNode<>(9));
        node2.setLeft(new BinaryNode<>(10));
        assertFalse(node1.equals(node2));
    }

    @Test
    public void testEquals_otherExtraLeftChild() {
        BinaryNode<Integer> node1 = new BinaryNode<>(6);
        node1.setRight(new BinaryNode<>(9));
        node1.setLeft(new BinaryNode<>(10));
        BinaryNode<Integer> node2 = new BinaryNode<>(6);
        node2.setRight(new BinaryNode<>(9));
        assertFalse(node1.equals(node2));
    }

    @Test
    public void testEquals_bothLeftAndRightEquals() {
        BinaryNode<Integer> node1 = new BinaryNode<>(6);
        node1.setRight(new BinaryNode<>(9));
        node1.setLeft(new BinaryNode<>(10));
        BinaryNode<Integer> node2 = new BinaryNode<>(6);
        node2.setRight(new BinaryNode<>(9));
        node2.setLeft(new BinaryNode<>(10));
        assertTrue(node1.equals(node2));
    }

    @Test
    public void testEquals_twoLevelsEqual() {
        BinaryNode<Integer> node1 = new BinaryNode<>(6);
        BinaryNode<Integer> node1Left = new BinaryNode<>(10);
        node1Left.setRight(new BinaryNode<>(3));
        node1.setRight(new BinaryNode<>(9));
        node1.setLeft(node1Left);
        BinaryNode<Integer> node2 = new BinaryNode<>(6);
        BinaryNode<Integer> node2Left = new BinaryNode<>(10);
        node2Left.setRight(new BinaryNode<>(3));
        node2.setRight(new BinaryNode<>(9));
        node2.setLeft(node2Left);
        assertTrue(node1.equals(node2));
    }

    @Test
    public void testEquals_twoLevelsNotEqual() {
        BinaryNode<Integer> node1 = new BinaryNode<>(6);
        BinaryNode<Integer> node1Left = new BinaryNode<>(10);
        node1Left.setRight(new BinaryNode<>(6));
        node1.setRight(new BinaryNode<>(9));
        node1.setLeft(node1Left);
        BinaryNode<Integer> node2 = new BinaryNode<>(6);
        BinaryNode<Integer> node2Left = new BinaryNode<>(10);
        node2Left.setRight(new BinaryNode<>(3));
        node2.setRight(new BinaryNode<>(9));
        node2.setLeft(node2Left);
        assertFalse(node1.equals(node2));
    }

    @Test
    public void testEquals_earlyFail() {
        BinaryNode<Integer> node1 = new BinaryNode<>(3);
        node1.setRight(new BinaryNode<>(9));
        node1.setLeft(new BinaryNode<>(10));
        BinaryNode<Integer> node2 = new BinaryNode<>(6);
        node2.setRight(new BinaryNode<>(9));
        node2.setLeft(new BinaryNode<>(10));
        assertFalse(node1.equals(node2));
    }

    @Test
    public void testGetPathsWithSum_singleNodeNotEquals() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9);
        assertTrue(getPathsWithSum(node, 8).isEmpty());
    }

    @Test
    public void testGetPathsWithSum_singleNodeEquals() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9);
        Set<String> expectedPaths = new HashSet<>();
        expectedPaths.add("9,");
        assertEquals(expectedPaths, getPathsWithSum(node, 9));
    }

    @Test
    public void testGetPathsWithSum_leftSumFullPath() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9, 6, 7, -2);
        Set<String> expectedPaths = new HashSet<>();
        expectedPaths.add("9,6,-2,");
        assertEquals(expectedPaths, getPathsWithSum(node, 13));
    }

    @Test
    public void testGetPathsWithSum_rightSumFullPath() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9, 6, 7, null, null, -2);
        Set<String> expectedPaths = new HashSet<>();
        expectedPaths.add("9,7,-2,");
        assertEquals(expectedPaths, getPathsWithSum(node, 14));
    }

    @Test
    public void testGetPathsWithSum_leftSumNoLeaf() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9, 6, 7, -2);
        Set<String> expectedPaths = new HashSet<>();
        expectedPaths.add("9,6,");
        assertEquals(expectedPaths, getPathsWithSum(node, 15));
    }

    @Test
    public void testGetPathsWithSum_rightSumNoLeaf() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9, 6, 7, null, null, -2);
        Set<String> expectedPaths = new HashSet<>();
        expectedPaths.add("9,6,");
        assertEquals(expectedPaths, getPathsWithSum(node, 15));
    }

    @Test
    public void testGetPathsWithSum_leftSumNoRoot() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9, 6, 7, -2);
        Set<String> expectedPaths = new HashSet<>();
        expectedPaths.add("6,-2,");
        assertEquals(expectedPaths, getPathsWithSum(node, 4));
    }

    @Test
    public void testGetPathsWithSum_rightSumNoRoot() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9, 6, 7, null, null, -2);
        Set<String> expectedPaths = new HashSet<>();
        expectedPaths.add("7,-2,");
        assertEquals(expectedPaths, getPathsWithSum(node, 5));
    }

    @Test
    public void testGetPathsWithSum_leftSumPartialPath() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9, 6, 7, -2, null, null, null, null, 7);
        Set<String> expectedPaths = new HashSet<>();
        expectedPaths.add("6,-2,");
        assertEquals(expectedPaths, getPathsWithSum(node, 4));
    }

    @Test
    public void testGetPathsWithSum_rightSumPartialPath() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9, 6, 7, null, null, -2, null, null, null, null, null, 4);
        Set<String> expectedPaths = new HashSet<>();
        expectedPaths.add("7,-2,");
        assertEquals(expectedPaths, getPathsWithSum(node, 5));
    }

    @Test
    public void testGetPathsWithSum_multiplePaths() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9, 8, 7, -3, null, -2, null, null, null, null, null, 4);
        Set<String> expectedPaths = new HashSet<>();
        expectedPaths.add("7,-2,");
        expectedPaths.add("8,-3,");
        assertEquals(expectedPaths, getPathsWithSum(node, 5));
    }

    @Test
    public void testGetPathsWithSum_subpath() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9, 6, 7, null, null, -2, null, null, null, null, null, 0);
        Set<String> expectedPaths = new HashSet<>();
        expectedPaths.add("7,-2,");
        expectedPaths.add("7,-2,0,");
        assertEquals(expectedPaths, getPathsWithSum(node, 5));
    }

    @Test
    public void testGetPathsWithSum_overlap() {
        BinaryNode<Integer> node = fromArrayLevelOrder(9, 6, 7, null, null, -2, null, null, null, null, null, 7);
        Set<String> expectedPaths = new HashSet<>();
        expectedPaths.add("7,-2,");
        expectedPaths.add("-2,7,");
        assertEquals(expectedPaths, getPathsWithSum(node, 5));
    }
}