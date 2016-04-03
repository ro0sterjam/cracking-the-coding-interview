package com.ro0sterjam.ctci;

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
        return (left == null || left.isBalanced()) && (right == null || right.isBalanced()) && Math.abs((left == null? -1 : left.height()) - (right == null? -1: right.height())) < 2;
    }

}
