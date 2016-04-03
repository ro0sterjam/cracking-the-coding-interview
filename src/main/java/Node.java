package main.java;

/**
 * Created by kenwang on 2016-04-02.
 */
class Node<T> {

    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public Node<T> findStartOfLoop() {
        if (next == null || next.next == null) {
            return null;
        }

        Node<T> cursor = this;
        Node<T> runner = this;
        while ((cursor = cursor.next) != (runner = runner.next.next)) {
            if (runner.next.next == null) {
                return null;
            }
        }
        runner = this;
        while (cursor != runner) {
            cursor = cursor.next;
            runner = runner.next;
        }
        return cursor;
    }
}
