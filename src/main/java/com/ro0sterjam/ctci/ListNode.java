package com.ro0sterjam.ctci;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kenwang on 2016-04-19.
 */
public class ListNode<T> {

    private T value;
    private List<ListNode<T>> children = new ArrayList<>();

    public ListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public List<ListNode<T>> getChildren() {
        return children;
    }

    public void addChild(ListNode<T> child) {
        children.add(child);
    }

    public ListNode<T> dfs(T value) {
        Set<ListNode<T>> visited = new HashSet<>();
        return dfs(this, value, visited);
    }

    public ListNode<T> bfs(T value) {
        Queue<ListNode<T>> queue = new Queue<>();
        Set<ListNode<T>> visited = new HashSet<>();
        queue.enqueue(this);
        while (!queue.isEmpty()) {
            ListNode<T> node = queue.dequeue();
            if (node.value.equals(value)) {
                return node;
            } else {
                node.getChildren().forEach(child -> {
                    if (!visited.contains(child)) {
                        queue.enqueue(child);
                    }
                });
            }
        }
        return null;
    }

    private static <T> ListNode<T> dfs(ListNode<T> node, T value, Set<ListNode<T>> visited) {
        if (node.value.equals(value)) {
            return node;
        }
        visited.add(node);
        for (ListNode<T> child: node.getChildren()) {
            if (!visited.contains(child)) {
                ListNode<T> found = dfs(child, value, visited);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

}
