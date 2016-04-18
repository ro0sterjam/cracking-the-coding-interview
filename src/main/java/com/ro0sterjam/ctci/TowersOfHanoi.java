package com.ro0sterjam.ctci;

/**
 * Created by kenwang on 2016-04-02.
 */
public class TowersOfHanoi {

    private static final int DEFAULT_HEIGHT = 5;

    private Stack<Integer> left = new Stack<>();
    private Stack<Integer> mid = new Stack<>();
    private Stack<Integer> right = new Stack<>();

    public TowersOfHanoi(int height) {
       while (height-- > 0) {
           left.push(height);
       }
    }

    public TowersOfHanoi() {
        this(DEFAULT_HEIGHT);
    }

    public void move(int from, int to) {
        move(getTower(from), getTower(to));
    }

    public int getNumDisks(int tower) {
        return getTower(tower).size();
    }

    public boolean isSolved() {
        return left.isEmpty() && mid.isEmpty();
    }

    private void move(Stack<Integer> from, Stack<Integer> to) {
        if (from.isEmpty() || !to.isEmpty() && to.peek() < from.peek()) {
            throw new InvalidMoveException();
        }
        to.push(from.pop());
    }

    private Stack<Integer> getTower(int index) {
        switch(index) {
            case 0:
                return left;
            case 1:
                return mid;
            case 2:
                return right;
        }
        throw new IndexOutOfBoundsException();
    }

    public static class InvalidMoveException extends RuntimeException {

    }

}
