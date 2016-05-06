package com.ro0sterjam.ctci;

import org.junit.Test;

import static com.ro0sterjam.ctci.Binary.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by kenwang on 2016-05-06.
 */
public class BinaryTest {

    @Test
    public void testToBinary_zero() {
        assertEquals("0", toBinary(0));
    }

    @Test
    public void testToBinary_one() {
        assertEquals("1", toBinary(1));
    }

    @Test
    public void testToBinary_two() {
        assertEquals("10", toBinary(2));
    }

    @Test
    public void testToBinary_three() {
        assertEquals("11", toBinary(3));
    }

    @Test
    public void testToBinary_876() {
        assertEquals("1101101100", toBinary(876));
    }

    @Test
    public void testToBinary_maxInt() {
        assertEquals("1111111111111111111111111111111", toBinary(Integer.MAX_VALUE));
    }

    @Test
    public void testFromBinary_zero() {
        assertEquals(0, fromBinary("0"));
    }

    @Test
    public void testFromBinary_one() {
        assertEquals(1, fromBinary("1"));
    }

    @Test
    public void testFromBinary_two() {
        assertEquals(2, fromBinary("10"));
    }

    @Test
    public void testFromBinary_three() {
        assertEquals(3, fromBinary("11"));
    }

    @Test
    public void testFromBinary_876() {
        assertEquals(876, fromBinary("1101101100"));
    }

    @Test
    public void testFromBinary_maxInt() {
        assertEquals(Integer.MAX_VALUE, fromBinary("1111111111111111111111111111111"));
    }

    @Test
    public void testReplace_subsetSimple() {
        assertEquals(fromBinary("0000010001001100"), replace(fromBinary("0000010000000000"), fromBinary("10011"), 6, 2));
    }

    @Test
    public void testReplace_leftEdge() {
        assertEquals(fromBinary("0000011100001111"), replace(fromBinary("0000011101001111"), fromBinary("00011"), 6, 2));
    }

    @Test
    public void testReplace_rightEdge() {
        assertEquals(fromBinary("0000110100010011"), replace(fromBinary("0000110101011111"), fromBinary("00100"), 6, 2));
    }

    @Test
    public void testToBinary_zeroDouble() {
        assertEquals("0.0", toBinary(0.0));
    }

    @Test
    public void testToBinary_justShyOf1() {
        assertEquals("0.111111111111111111111111111111111", toBinary(0.9999999999999999999));
    }

    @Test
    public void testToBinary_simple() {
        assertEquals("0.111", toBinary(0.875));
    }

    @Test
    public void testToBinary_complex() {
        assertEquals("0.101110000101000111101011100001010", toBinary(0.72));
    }

    @Test
    public void testNextWithSameParity_zero() {
        assertEquals(-1, nextWithSameParity(0));
    }

    @Test
    public void testNextWithSameParity_maxInteger() {
        assertEquals(-1, nextWithSameParity(Integer.MAX_VALUE));
    }

    @Test
    public void testNextWithSameParity_singleOneInFront() {
        assertEquals(-1, nextWithSameParity(fromBinary("1000000000000000000000000000000")));
    }

    @Test
    public void testNextWithSameParity_allOnesThenAllZeros() {
        assertEquals(-1, nextWithSameParity(fromBinary("1111111111111110000000000000000")));
    }

    @Test
    public void testNextWithSameParity_singleOne() {
        assertEquals(fromBinary("11011001111000"), nextWithSameParity(fromBinary("11011001110100")));
    }

    @Test
    public void testNextWithSameParity_multipleOnes() {
        assertEquals(fromBinary("11011010001111"), nextWithSameParity(fromBinary("11011001111100")));
    }

    @Test
    public void testPreviousWithSameParity_zero() {
        assertEquals(-1, prevWithSameParity(0));
    }

    @Test
    public void testPreviousWithSameParity_maxInteger() {
        assertEquals(-1, prevWithSameParity(Integer.MAX_VALUE));
    }

    @Test
    public void testPreviousWithSameParity_allZerosThenAllOnes() {
        assertEquals(-1, prevWithSameParity(fromBinary("0000000000000000111111111111111")));
    }

    @Test
    public void testPreviousWithSameParity_singleZeroBetweenOnes() {
        assertEquals(fromBinary("11011001101111"), prevWithSameParity(fromBinary("11011001110111")));
    }

    @Test
    public void testPreviousWithSameParity_multipleZerosBetweenOnes() {
        assertEquals(fromBinary("10011101110000"), prevWithSameParity(fromBinary("10011110000011")));
    }

    @Test
    public void testIsPowerOf2_zero() {
        assertTrue(isPowerOf2(0));
    }

    @Test
    public void testIsPowerOf2_one() {
        assertTrue(isPowerOf2(1));
    }

    @Test
    public void testIsPowerOf2_two() {
        assertTrue(isPowerOf2(2));
    }

    @Test
    public void testIsPowerOf2_three() {
        assertFalse(isPowerOf2(3));
    }

    @Test
    public void testIsPowerOf2_four() {
        assertTrue(isPowerOf2(4));
    }

    @Test
    public void testIsPowerOf2_five() {
        assertFalse(isPowerOf2(5));
    }

    @Test
    public void testIsPowerOf2_six() {
        assertFalse(isPowerOf2(6));
    }

    @Test
    public void testIsPowerOf2_eight() {
        assertTrue(isPowerOf2(4));
    }

    @Test
    public void testIsPowerOf2_sixteen() {
        assertTrue(isPowerOf2(4));
    }

    @Test
    public void testIsPowerOf2_thirtyTwo() {
        assertTrue(isPowerOf2(32));
    }

    @Test
    public void testIsPowerOf2_leftMost() {
        assertTrue(isPowerOf2(fromBinary("1000000000000000000000000000000")));
    }

    @Test
    public void testIsPowerOf2_leftMostAndAnother() {
        assertFalse(isPowerOf2(fromBinary("1000000000000010000000000000000")));
    }

    @Test
    public void testBitDiff_same() {
        assertEquals(0, bitDiff(2434, 2434));
    }

    @Test
    public void testBitDiff_singleDifference() {
        assertEquals(1, bitDiff(fromBinary("10001000111010"), fromBinary("10001001111010")));
    }

    @Test
    public void testBitDiff_twoDifferences() {
        assertEquals(2, bitDiff(fromBinary("10101000111010"), fromBinary("10001001111010")));
    }

    @Test
    public void testSwapEvenAndOddBits() {
        assertEquals(fromBinary("0101100001110110011011010001001"), swapEvenAndOddBits(fromBinary("0011100001101110011100101000110")));
    }
}