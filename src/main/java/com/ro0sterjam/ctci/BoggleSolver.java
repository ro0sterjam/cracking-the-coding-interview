package com.ro0sterjam.ctci;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by kenwang on 2016-04-17.
 */
public class BoggleSolver {

    private static final String DEFAULT_DICTIONARY_PATH = "/usr/share/dict/words";
    private final StringTrie dictionary;

    public BoggleSolver() throws IOException {
        dictionary = createDictionary(DEFAULT_DICTIONARY_PATH);
    }

    public Set<String> solve(Boggle boggle) {
        Set<String> found = new HashSet<>();
        for (int i = 0; i < boggle.getBoard().length; i++) {
            for (int j = 0; j < boggle.getBoard()[i].length; j++) {
                solve(boggle, dictionary.root, new Coordinates(i, j), new HashSet<>(), found, "");
            }
        }
        return found;
    }

    private void solve(Boggle boggle, TrieNode<Character> node, Coordinates coordinates, Set<Coordinates> searched, Set<String> found, String prefix) {
        searched.add(coordinates);
        if (node.children.containsKey(null) && prefix.length() > 2) {
            found.add(prefix);
        }
        for (Coordinates adjacent : adjacent(boggle, coordinates)) {
            Character c = boggle.getBoard()[adjacent.x][adjacent.y];
            if (searched.contains(adjacent) || !node.children.containsKey(c)) {
                continue;
            }
            solve(boggle, node.children.get(c), adjacent, new HashSet<>(searched), found, prefix + c);
        }
    }

    private Set<Coordinates> adjacent(Boggle boggle, Coordinates coordinates) {
        Set<Coordinates> adjacent = new HashSet<>();
        if (coordinates.x > 0) {
            adjacent.add(new Coordinates(coordinates.x - 1, coordinates.y));
            if (coordinates.y > 0) {
                adjacent.add(new Coordinates(coordinates.x - 1, coordinates.y - 1));
            }
            if (coordinates.y < boggle.getBoard()[coordinates.x].length - 1) {
                adjacent.add(new Coordinates(coordinates.x - 1, coordinates.y + 1));
            }
        }
        if (coordinates.x < boggle.getBoard().length - 1) {
            adjacent.add(new Coordinates(coordinates.x + 1, coordinates.y));
            if (coordinates.y > 0) {
                adjacent.add(new Coordinates(coordinates.x + 1, coordinates.y - 1));
            }
            if (coordinates.y < boggle.getBoard()[coordinates.x].length - 1) {
                adjacent.add(new Coordinates(coordinates.x + 1, coordinates.y + 1));
            }
        }
        if (coordinates.y > 0) {
            adjacent.add(new Coordinates(coordinates.x, coordinates.y - 1));
        }
        if (coordinates.y < boggle.getBoard()[coordinates.x].length - 1) {
            adjacent.add(new Coordinates(coordinates.x, coordinates.y + 1));
        }
        return adjacent;
    }

    private static StringTrie createDictionary(String dictionaryPath) throws IOException {
        StringTrie dictionary = new StringTrie();
        try (BufferedReader br = new BufferedReader(new FileReader(dictionaryPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                dictionary.add(line);
            }
        }
        return dictionary;
    }

    public static void main(String[] args) throws IOException {
        Boggle boggle = new Boggle();
        boggle.printBoard();
        System.out.println("------------------");
        BoggleSolver boggleSolver = new BoggleSolver();
        boggleSolver.solve(boggle).forEach(System.out::println);
    }

    private class Coordinates {
        private int x, y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinates that = (Coordinates) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
