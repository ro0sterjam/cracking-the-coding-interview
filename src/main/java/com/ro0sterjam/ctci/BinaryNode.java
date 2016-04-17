package com.ro0sterjam.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenwang on 2016-04-03.
 */
public class BinaryNode<T> {

    public T value;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T value) {
        this.value = value;
    }

    public int height() {
        if (left == null && right == null) {
            return 0;
        } else {
            return Math.max(left == null? 0 : left.height(), right == null? 0: right.height()) + 1;
        }
    }

    public boolean isBalanced() {
        return balancedHeight() != -1;
    }

    public List<LinkedList<T>> toLists() {
        List<LinkedList<T>> lists = new ArrayList<>();
        populateLists(this, lists, 0);
        return lists;
    }

    private static <T> void populateLists(BinaryNode<T> node, List<LinkedList<T>> lists, int depth) {
        if (node == null) {
            return;
        }
        if (lists.size() - 1 < depth) {
            lists.add(depth, new LinkedList<>());
        }
        lists.get(depth).add(node.value);
        populateLists(node.left, lists, depth + 1);
        populateLists(node.right, lists, depth + 1);
    }

    private int balancedHeight() {
        int leftHeight = left == null? -1 : left.balancedHeight();
        int rightHeight = right == null? -1 : right.balancedHeight();
        if (left != null && leftHeight == -1 || right != null && rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static <T extends Comparable<T>> boolean isOrdered(BinaryNode<T> root) {
        return (root.left == null || root.left.value.compareTo(root.value) <= 0 && isOrdered(root.left)) && (root.right == null || root.right.value.compareTo(root.value) >= 0 && isOrdered(root.right));
    }

    public static <T> BinaryNode<T> fromArray(T[] array) {
        return fromArray(array, 0, array.length);
    }

    public static <T> BinaryNode<T> fromArray(T[] array, int i, int j) {
        if (i == j) {
            return null;
        } else {
            int mid = (i + j) / 2;
            BinaryNode<T> node = new BinaryNode<>(array[mid]);
            node.left = fromArray(array, i, mid);
            node.right = fromArray(array, mid + 1, j);
            return node;
        }
    }

}
