package com.ro0sterjam.ctci;

/**
 * Created by kenwang on 2016-04-03.
 */
public class BinaryTree<T> {

    private BinaryNode<T> root;

    public boolean isBalanced() {
        return root == null || root.isBalanced();
    }

}
