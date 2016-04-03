package test.java;

import org.junit.Test;

import static main.java.Arrays.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by kenwang on 2016-03-13.
 */
public class ArraysTest {

    @Test
    public void testContainsDistinct_emptyCollection_returnsTrue() {
        assertTrue(containsDistinct(new Integer[0]));
    }

    @Test
    public void testContainsDistinctAscii_singleElement_returnsTrue() {
        assertTrue(containsDistinct(new Integer[]{4}));
    }

    @Test
    public void testContainsDistinct_twoDistinctElements_returnsTrue() {
        assertTrue(containsDistinct(new Integer[]{5, 7}));
    }

    @Test
    public void testContainsDistinct_twoSameElements_returnsFalse() {
        assertFalse(containsDistinct(new Integer[]{8, 8}));
    }

    @Test
    public void testContainsDistinct_twoDistinctAndTwoSameElements_returnsFalse() {
        assertFalse(containsDistinct(new Integer[]{7, 5, 4, 5}));
    }

    @Test
    public void testReverseInPlace_emptyCollection_doesNothing() {
        Integer[] array = new Integer[0];
        reverseInPlace(array);
        assertArrayEquals(new Integer[0], array);
    }

    @Test
    public void testReverseInPlace_singleElement_doesNothing() {
        Integer[] array = new Integer[]{3};
        reverseInPlace(array);
        assertArrayEquals(new Integer[]{3}, array);
    }

    @Test
    public void testReverseInPlace_oddLength_reversesArray() {
        Integer[] array = new Integer[]{4, 6, 8};
        reverseInPlace(array);
        assertArrayEquals(new Integer[]{8, 6, 4}, array);
    }

    @Test
    public void testReverseInPlace_evenLength_reverseArray() {
        Integer[] array = new Integer[]{4, 6, 8, 10};
        reverseInPlace(array);
        assertArrayEquals(new Integer[]{10, 8, 6, 4}, array);
    }

    @Test
    public void testArePermutations_emptyCollections_returnsTrue() {
        assertTrue(arePermutations(new Integer[0], new Integer[0]));
    }

    @Test
    public void testArePermuations_differingLengths_returnsFalse() {
        assertFalse(arePermutations(new Integer[0], new Integer[1]));
    }

    @Test
    public void testArePermutations_singleDifferingElement_returnsFalse() {
        assertFalse(arePermutations(new Integer[]{5}, new Integer[]{7}));
    }

    @Test
    public void testArePermutations_differingElements_returnsFalse() {
        assertFalse(arePermutations(new Integer[]{5, 6}, new Integer[]{7, 9}));
    }

    @Test
    public void testArePermutations_oneSameAndOneDifferentElements_returnsFalse() {
        assertFalse(arePermutations(new Integer[]{5, 6}, new Integer[]{5, 9}));
    }

    @Test
    public void testArePermutations_sameElement_returnsTrue() {
        assertTrue(arePermutations(new Integer[]{4}, new Integer[]{4}));
    }

    @Test
    public void testArePermutations_twoSameElementsSameOrder_returnsTrue() {
        assertTrue(arePermutations(new Integer[]{4, 6}, new Integer[]{4, 6}));
    }

    @Test
    public void testArePermutations_twoSameElementsDifferentOrder_returnsTrue() {
        assertTrue(arePermutations(new Integer[]{4, 6}, new Integer[]{6, 4}));
    }

    @Test
    public void testArePermutations_sameElementsSomeRepeated_returnsTrue() {
        assertTrue(arePermutations(new Integer[]{4, 6, 4, 7, 4, 6}, new Integer[]{6, 4, 6, 7, 4, 4}));
    }

    @Test
    public void testRotate_emptyMatrix() {
        Integer[][] matrix = new Integer[0][0];
        rotate(matrix);
        assertThat(matrix, equalTo(new Integer[0][0]));
    }

    @Test
    public void testRotate_1x1() {
        Integer[][] matrix = new Integer[][]{{2}};
        rotate(matrix);
        assertThat(matrix, equalTo(new Integer[][]{{2}}));
    }

    @Test
    public void testRotate_2x2() {
        Integer[][] matrix = new Integer[][]{{1,2},{3,4}};
        rotate(matrix);
        assertThat(matrix, equalTo(new Integer[][]{{2,4},{1,3}}));
    }

    @Test
    public void testRotate_3x3() {
        Integer[][] matrix = new Integer[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        assertThat(matrix, equalTo(new Integer[][]{{3,6,9},{2,5,8},{1,4,7}}));
    }

    @Test
    public void testRotate_4x4() {
        Integer[][] matrix = new Integer[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
        assertThat(matrix, equalTo(new Integer[][]{{4,8,12,16},{3,7,11,15},{2,6,10,14},{1,5,9,13}}));
    }

    @Test
    public void testCascadeZeroes_emptyMatrix() {
        int[][] matrix = new int[0][0];
        cascadeZeroes(matrix);
        assertThat(matrix, equalTo(new int[0][0]));
    }

    @Test
    public void testCascadeZeroes_singleZero() {
        int[][] matrix = new int[][]{{3,5,7},{4,5,0},{3,7,8}};
        cascadeZeroes(matrix);
        assertThat(matrix, equalTo(new int[][]{{3,5,0},{0,0,0},{3,7,0}}));
    }

    @Test
    public void testCascadeZeroes_twoZeroesSameRow() {
        int[][] matrix = new int[][]{{3,5,7},{4,5,0},{3,7,0}};
        cascadeZeroes(matrix);
        assertThat(matrix, equalTo(new int[][]{{3,5,0},{0,0,0},{0,0,0}}));
    }

    @Test
    public void testCascadeZeroes_twoZeroesSameColumn() {
        int[][] matrix = new int[][]{{3,5,7},{0,5,0},{3,7,8}};
        cascadeZeroes(matrix);
        assertThat(matrix, equalTo(new int[][]{{0,5,0},{0,0,0},{0,7,0}}));
    }

    @Test
    public void testCascadeZeroes_twoZeroesDifferentColumnAndRow() {
        int[][] matrix = new int[][]{{3,0,7},{4,5,0},{3,7,8}};
        cascadeZeroes(matrix);
        assertThat(matrix, equalTo(new int[][]{{0,0,0},{0,0,0},{3,0,0}}));
    }

}