package com.ro0sterjam.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenwang on 2016-04-03.
 */
public class BinaryNode<T> {

    private T value;

    private BinaryNode<T> parent;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> node) {
        left = node;
        if (node != null) {
            node.parent = this;
        }
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> node) {
        right = node;
        if (node != null) {
            node.parent = this;
        }
    }

    public int height() {
        if (left == null && right == null) {
            return 0;
        } else {
            return Math.max(left == null? 0 : left.height(), right == null? 0: right.height()) + 1;
        }
    }

    public int depth() {
        int depth = 0;
        BinaryNode<T> node = this;
        while (node.parent != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }

    public boolean isBalanced() {
        return balancedHeight() != -1;
    }

    public BinaryNode<T> first() {
        BinaryNode<T> first = this;
        while (first.left != null) {
            first = first.left;
        }
        return first;
    }

    public BinaryNode<T> next() {
        if (right != null) {
            return right.first();
        } else {
            BinaryNode<T> next = this;
            while (next.parent != null && next.parent.right == next) {
                next = next.parent;
            }
            if (next.parent != null) {
                return next.parent;
            } else {
                return null;
            }
        }
    }

    public List<LinkedList<T>> toLists() {
        List<LinkedList<T>> lists = new ArrayList<>();
        populateLists(this, lists, 0);
        return lists;
    }

    public boolean contains(BinaryNode<T> node) {
        return equals(node) || left != null && left.contains(node) || right != null && right.contains(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryNode<?> that = (BinaryNode<?>) o;
        if (!value.equals(that.getValue()) || left == null && that.left != null || right == null && that.right != null) {
            return false;
        }
        return (left == null || left.equals(that.left)) && (right == null || right.equals(that.right));
    }

    public static <T> BinaryNode<T> firstCommonAncestor(BinaryNode<T> node1, BinaryNode<T> node2) {
        int depth1 = node1.depth();
        int depth2 = node2.depth();
        int depthDiff = depth1 - depth2;
        if (depthDiff > 0) {
            while (depthDiff-- > 0) {
                node1 = node1.parent;
            }
        } else if (depthDiff < 0) {
            while (depthDiff++ < 0) {
                node2 = node2.parent;
            }
        }
        if (node1 == node2) {
            return node1;
        }
        while (node1.parent != null && node2.parent != null) {
            if (node1.parent == node2.parent) {
                return node1.parent;
            }
            node1 = node1.parent;
            node2 = node2.parent;
        }
        return null;
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

    public static <T> BinaryNode<T> fromArrayInOrder(T[] array) {
        return fromArrayInOrder(array, 0, array.length);
    }

    public static <T> BinaryNode<T> fromArrayLevelOrder(T[] array) {
        return fromArrayLevelOrder(array, 0);
    }

    private static <T> BinaryNode<T> fromArrayLevelOrder(T[] array, int i) {
        if (i >= array.length || array[i] == null) {
            return null;
        }
        BinaryNode<T> node = new BinaryNode<>(array[i]);
        node.setLeft(fromArrayLevelOrder(array, i * 2 + 1));
        node.setRight(fromArrayLevelOrder(array, i * 2 + 2));
        return node;
    }

    private static <T> BinaryNode<T> fromArrayInOrder(T[] array, int i, int j) {
        if (i == j) {
            return null;
        } else {
            int mid = (i + j) / 2;
            if (array[mid] == null) {
                return null;
            }
            BinaryNode<T> node = new BinaryNode<>(array[mid]);
            node.setLeft(fromArrayInOrder(array, i, mid));
            node.setRight(fromArrayInOrder(array, mid + 1, j));
            return node;
        }
    }

}
