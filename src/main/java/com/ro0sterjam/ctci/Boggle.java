package com.ro0sterjam.ctci;

import java.util.Random;

/**
 * Created by kenwang on 2016-04-17.
 */
public class Boggle {

    private static final Random RANDOM = new Random();
    private static final int DEFAULT_DIMENSIONS = 5;

    private final char[][] board;

    public Boggle() {
        board = generateBoard(DEFAULT_DIMENSIONS);
    }

    public char[][] getBoard() {
        return board;
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
