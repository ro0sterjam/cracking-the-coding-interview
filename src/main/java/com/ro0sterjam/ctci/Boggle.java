package com.ro0sterjam.ctci;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by kenwang on 2016-04-17.
 */
public class Boggle {

    private static final Random RANDOM = new Random();
    private static final int DEFAULT_DIMENSIONS = 5;

    private final char[][] board;

    public Boggle(char[][] board) {
        this.board = board;
    }

    public Boggle(int dimensions) {
        this(generateBoard(dimensions));
    }

    public Boggle() {
        this(DEFAULT_DIMENSIONS);
    }

    public char getLetter(int x, int y) {
        return board[x][y];
    }

    public char getLetter(Coordinates coordinates) {
        return getLetter(coordinates.getX(), coordinates.getY());
    }

    public int getDimensions() {
        return board.length;
    }

    public Set<Coordinates> getAdjacent(Coordinates coordinates) {
        Set<Coordinates> adjacent = new HashSet<>();
        if (coordinates.getX() > 0) {
            adjacent.add(new Coordinates(coordinates.getX() - 1, coordinates.getY()));
            if (coordinates.getY() > 0) {
                adjacent.add(new Coordinates(coordinates.getX() - 1, coordinates.getY() - 1));
            }
            if (coordinates.getY() < getDimensions() - 1) {
                adjacent.add(new Coordinates(coordinates.getX() - 1, coordinates.getY() + 1));
            }
        }
        if (coordinates.getX() < getDimensions() - 1) {
            adjacent.add(new Coordinates(coordinates.getX() + 1, coordinates.getY()));
            if (coordinates.getY() > 0) {
                adjacent.add(new Coordinates(coordinates.getX() + 1, coordinates.getY() - 1));
            }
            if (coordinates.getY() < getDimensions() - 1) {
                adjacent.add(new Coordinates(coordinates.getX() + 1, coordinates.getY() + 1));
            }
        }
        if (coordinates.getY() > 0) {
            adjacent.add(new Coordinates(coordinates.getX(), coordinates.getY() - 1));
        }
        if (coordinates.getY() < getDimensions() - 1) {
            adjacent.add(new Coordinates(coordinates.getX(), coordinates.getY() + 1));
        }
        return adjacent;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static char randomCharacter() {
        return (char) (RANDOM.nextInt(26) + 'a');
    }

    private static char[][] generateBoard(int dimensions) {
        char[][] board = new char[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                board[i][j] = randomCharacter();
            }
        }
        return board;
    }

    public static void main(String[] args) {
        Boggle boggle = new Boggle();
        boggle.printBoard();
    }
}
