package com.ro0sterjam.ctci;

import org.junit.Test;

import static com.ro0sterjam.ctci.Binary.replace;
import static com.ro0sterjam.ctci.Binary.toBinaryArray;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by kenwang on 2016-05-06.
 */
public class BinaryTest {

    @Test
    public void testToBinaryArray_zero() {
        assertArrayEquals(new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, toBinaryArray(0));
    }

    @Test
    public void testToBinaryArray_one() {
        assertArrayEquals(new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, toBinaryArray(1));
    }

    @Test
    public void testToBinaryArray_two() {
        assertArrayEquals(new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, toBinaryArray(2));
    }

    @Test
    public void testToBinaryArray_three() {
        assertArrayEquals(new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 }, toBinaryArray(3));
    }

    @Test
    public void testToBinaryArray_876() {
        assertArrayEquals(new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 }, toBinaryArray(876));
    }

    @Test
    public void testToBinaryArray_maxInt() {
        assertArrayEquals(new int[]{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, toBinaryArray(Integer.MAX_VALUE));
    }

    @Test
    public void testReplace_subsetSimple() {
        assertEquals(1100, replace(1024, 19, 6, 2));
    }

    @Test
    public void testReplace_leftEdge() {
        assertEquals(1807, replace(1871, 3, 6, 2));
    }

    @Test
    public void testReplace_rightEdge() {
        assertEquals(3347, replace(3423, 4, 6, 2));
    }


}