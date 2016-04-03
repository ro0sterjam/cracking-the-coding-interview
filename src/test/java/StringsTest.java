package test.java;

import org.junit.Test;

import static main.java.Strings.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by kenwang on 2016-03-13.
 */
public class StringsTest {

    @Test
    public void testEncodeSpaces_emptyString_returnsEmptyString() {
        assertThat(encodeSpaces(""), equalTo(""));
    }

    @Test
    public void testEncodeSpaces_noSpaces_returnsSameString() {
        assertThat(encodeSpaces("fsdf"), equalTo("fsdf"));
    }

    @Test
    public void testEncodeSpaces_onlySpaceCharacter_returnsSingleEncodedSpace() {
        assertThat(encodeSpaces(" "), equalTo("%20"));
    }

    @Test
    public void testEncodeSpaces_stringWithSingleSpace_returnsStringWithEncodedSpace() {
        assertThat(encodeSpaces("hello you"), equalTo("hello%20you"));
    }

    @Test
    public void testEncodeSpaces_stringMultipleSpaces_returnsStringWithEncodedSpaces() {
        assertThat(encodeSpaces("hello to you too"), equalTo("hello%20to%20you%20too"));
    }

    @Test
    public void testEncodeSpaces_onlyTwoSpaceCharacters_returnsTwoEncodedSpaces() {
        assertThat(encodeSpaces("  "), equalTo("%20%20"));
    }

    @Test
    public void testCompress_emptyString_returnsEmptyString() {
        assertThat(compress(""), equalTo(""));
    }

    @Test
    public void testCompress_singleCharacter_returnsSameString() {
        assertThat(compress("g"), equalTo("g"));
    }

    @Test
    public void testCompress_twoSameCharacters_returnsSameString() {
        assertThat(compress("gg"), equalTo("gg"));
    }

    @Test
    public void testCompress_compressedIsSameSize_returnsSameString() {
        assertThat(compress("ggff"), equalTo("ggff"));
    }

    @Test
    public void testCompress_compressedIsSmaller_returnsCompressedString() {
        assertThat(compress("gggffejjjj"), equalTo("g3f2e1j4"));
    }

    @Test
    public void testAreRotations_twoEmptyStrings_returnsTrue() {
        assertTrue(areRotations("", ""));
    }

    @Test
    public void testAreRotations_differingLengths_returnsFalse() {
        assertFalse(areRotations("abc", "bcah"));
    }

    @Test
    public void testAreRotations_isRotation_returnsTrue() {
        assertTrue(areRotations("waterbottle", "erbottlewat"));
    }

    @Test
    public void testAreRotations_isNotARotation_returnsFalse() {
        assertFalse(areRotations("hello", "llohf"));
    }

}