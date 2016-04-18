package com.ro0sterjam.ctci;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by kenwang on 2016-04-18.
 */
public class BoggleSolverTest {

    private BoggleSolver solver;

    @Before
    public void setup() throws IOException {
        solver = new BoggleSolver();
    }

    @Test
    public void testSolve_emptyBoard() {
        Boggle game = new Boggle(0);
        Set<String> words = solver.solve(game);
        assertEquals(new HashSet<>(), words);
    }

    @Test
    public void testSolve_singleCharacter() {
        Boggle game = new Boggle(new char[][] {{ 'e' }});
        Set<String> words = solver.solve(game);
        assertEquals(new HashSet<>(), words);
    }


    @Test
    public void testSolve_singleWord() {
        Boggle game = new Boggle(new char[][] {{ 'e', 'g' }, { 'f', 'g' }});
        Set<String> words = solver.solve(game);
        assertEquals(Sets.newHashSet("egg"), words);
    }

    @Test
    public void testSolve_twoWords() {
        Boggle game = new Boggle(new char[][] {{ 'e', 'g' }, { 's', 'g' }});
        Set<String> words = solver.solve(game);
        assertEquals(Sets.newHashSet("egg", "seg"), words);
    }

    @Test
    public void testSolve_multipleWords() {
        Boggle game = new Boggle(new char[][] {{ 'e', 'g', 'g' }, { 'a', 'z', 's' }, { 't', 'h', 'y' }});
        Set<String> words = solver.solve(game);
        assertEquals(Sets.newHashSet("zag", "gaz", "geat", "egg", "thy", "shy", "hazy", "gazy", "zat", "tha", "sha", "shag", "hag", "haze", "gaze", "eat", "tae", "hat", "gat", "tag", "shat", "gez", "age"), words);
    }

}