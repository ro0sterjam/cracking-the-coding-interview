package test.java;

import main.java.LinkedList;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static main.java.LinkedList.partition;
import static main.java.LinkedList.reverseSum;
import static main.java.LinkedList.sum;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by kenwang on 2016-03-13.
 */
public class LinkedListTest {

    @Test
    public void testRemoveDuplicates_emptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.removeDuplicates();
        assertArrayEquals(new Integer[0], list.toArray());
    }

    @Test
    public void testRemoveDuplicates_singleElement() {
        LinkedList<Integer> list = LinkedList.of(4);
        list.removeDuplicates();
        assertArrayEquals(new Integer[]{4}, list.toArray());
    }

    @Test
    public void testRemoveDuplicates_twoUniqueElements() {
        LinkedList<Integer> list = LinkedList.of(4, 7);
        list.removeDuplicates();
        assertArrayEquals(new Integer[]{4, 7}, list.toArray());
    }

    @Test
    public void testRemoveDuplicates_twoSameElements() {
        LinkedList<Integer> list = LinkedList.of(4, 4);
        list.removeDuplicates();
        assertArrayEquals(new Integer[]{4}, list.toArray());
    }

    @Test
    public void testRemoveDuplicates_twoSameElementsPlusOtherUniqueElements() {
        LinkedList<Integer> list = LinkedList.of(4, 3, 8, 4, 9);
        list.removeDuplicates();
        assertArrayEquals(new Integer[]{4, 3, 8, 9}, list.toArray());
    }

    @Test
    public void testRemoveDuplicates_multipleOfSameElementPlusOtherUniqueElements() {
        LinkedList<Integer> list = LinkedList.of(4, 3, 8, 4, 9, 4, 7, 4);
        list.removeDuplicates();
        assertArrayEquals(new Integer[]{4, 3, 8, 9, 7}, list.toArray());
    }

    @Test
    public void testRemoveDuplicates_multipleDuplicates() {
        LinkedList<Integer> list = LinkedList.of(4, 3, 8, 4, 3, 4, 7, 4);
        list.removeDuplicates();
        assertArrayEquals(new Integer[]{4, 3, 8, 7}, list.toArray());
    }

    @Test
    public void testRemoveDuplicates_multipleDuplicatesSideBySide() {
        LinkedList<Integer> list = LinkedList.of(4, 4, 8, 3, 3, 3, 7, 9);
        list.removeDuplicates();
        assertArrayEquals(new Integer[]{4, 8, 3, 7, 9}, list.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testReverseGet_emptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.reverseGet(0);
    }

    @Test
    public void testReverseGet_singleElement() {
        LinkedList<Integer> list = LinkedList.of(5);
        assertThat(list.reverseGet(0), is(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testReverseGet_negativeIndex() {
        LinkedList<Integer> list = LinkedList.of(5);
        list.reverseGet(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testReverseGet_indexOutOfBounds() {
        LinkedList<Integer> list = LinkedList.of(5);
        list.reverseGet(1);
    }

    @Test
    public void testReverseGet_lastElement() {
        LinkedList<Integer> list = LinkedList.of(5, 4, 3, 2, 1);
        assertThat(list.reverseGet(0), is(1));
    }

    @Test
    public void testReverseGet_secondLastElement() {
        LinkedList<Integer> list = LinkedList.of(5, 4, 3, 2, 1);
        assertThat(list.reverseGet(1), is(2));
    }

    @Test
    public void testReverseGet_thirdLastElement() {
        LinkedList<Integer> list = LinkedList.of(5, 4, 3, 2, 1);
        assertThat(list.reverseGet(2), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_emptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.get(0);
    }

    @Test
    public void testGet_singleElement() {
        LinkedList<Integer> list = LinkedList.of(5);
        assertThat(list.get(0), is(5));
    }

    @Test
    public void testGet_negativeIndex() {
        LinkedList<Integer> list = LinkedList.of(5);
        assertThat(list.get(-1), is(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_indexOutOfBounds() {
        LinkedList<Integer> list = LinkedList.of(5);
        list.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_negativeIndexOutOfBounds() {
        LinkedList<Integer> list = LinkedList.of(5);
        list.get(-2);
    }

    @Test
    public void testGet_firstElement() {
        LinkedList<Integer> list = LinkedList.of(5, 4, 3, 2, 1);
        assertThat(list.get(0), is(5));
    }

    @Test
    public void testGet_secondElement() {
        LinkedList<Integer> list = LinkedList.of(5, 4, 3, 2, 1);
        assertThat(list.get(1), is(4));
    }

    @Test
    public void testGet_thirdElement() {
        LinkedList<Integer> list = LinkedList.of(5, 4, 3, 2, 1);
        assertThat(list.get(2), is(3));
    }

    @Test
    public void testGet_lastElement() {
        LinkedList<Integer> list = LinkedList.of(5, 4, 3, 2, 1);
        assertThat(list.get(-1), is(1));
    }

    @Test
    public void testGet_secondLastElement() {
        LinkedList<Integer> list = LinkedList.of(5, 4, 3, 2, 1);
        assertThat(list.get(-2), is(2));
    }

    @Test
    public void testGet_thirdLastElement() {
        LinkedList<Integer> list = LinkedList.of(5, 4, 3, 2, 1);
        assertThat(list.get(-3), is(3));
    }

    @Test
    public void testPartition_emptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        partition(list, 7);
        assertArrayEquals(new Integer[0], list.toArray());
    }

    @Test
    public void testPartition_singleElement() {
        LinkedList<Integer> list = LinkedList.of(2);
        partition(list, 7);
        assertArrayEquals(new Integer[]{2}, list.toArray());
    }

    @Test
    public void testPartition_allElementsSmaller() {
        LinkedList<Integer> list = LinkedList.of(7, 3, 4, 2, 9, 23, 11);
        Set<Integer> lt = new HashSet<>(Arrays.asList(7, 3, 4, 2, 9, 23, 11));
        Set<Integer> ge = new HashSet<>(Arrays.asList());
        partition(list, 55);
        assertPartitions(list, lt, ge);
    }

    @Test
    public void testPartition_allElementsLarger() {
        LinkedList<Integer> list = LinkedList.of(7, 3, 4, 2, 9, 23, 11);
        Set<Integer> lt = new HashSet<>(Arrays.asList());
        Set<Integer> ge = new HashSet<>(Arrays.asList(7, 3, 4, 2, 9, 23, 11));
        partition(list, 1);
        assertPartitions(list, lt, ge);
    }

    @Test
    public void testPartition_middlePartition() {
        LinkedList<Integer> list = LinkedList.of(7, 3, 4, 2, 9, 23, 11);
        Set<Integer> lt = new HashSet<>(Arrays.asList(3, 4, 2));
        Set<Integer> ge = new HashSet<>(Arrays.asList(7, 9, 23, 11));
        partition(list, 7);
        assertPartitions(list, lt, ge);
    }


    @Test
    public void testPartition_middlePartitionAndElementNotInList() {
        LinkedList<Integer> list = LinkedList.of(7, 3, 4, 2, 9, 23, 11);
        Set<Integer> lt = new HashSet<>(Arrays.asList(7, 3, 4, 2, 9));
        Set<Integer> ge = new HashSet<>(Arrays.asList(23, 11));
        partition(list, 10);
        assertPartitions(list, lt, ge);
    }

    @Test
    public void testReverseSum_emptyLists() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        assertArrayEquals(new Integer[0], reverseSum(list1, list2).toArray());
    }

    @Test
    public void testReverseSum_equalLengthsNoCarries() {
        LinkedList<Integer> list1 = LinkedList.of(1, 2, 3, 4);
        LinkedList<Integer> list2 = LinkedList.of(4, 3, 2, 1);
        assertArrayEquals(new Integer[]{ 5, 5, 5, 5 }, reverseSum(list1, list2).toArray());
    }

    @Test
    public void testReverseSum_equalLengthsWithCarries() {
        LinkedList<Integer> list1 = LinkedList.of(7, 9, 3, 6);
        LinkedList<Integer> list2 = LinkedList.of(4, 3, 8, 8);
        assertArrayEquals(new Integer[]{ 1, 3, 2, 5, 1 }, reverseSum(list1, list2).toArray());
    }

    @Test
    public void testReverseSum_differentLengths() {
        LinkedList<Integer> list1 = LinkedList.of(7, 9, 3, 6, 4, 5, 3);
        LinkedList<Integer> list2 = LinkedList.of(4, 3, 8, 8);
        assertArrayEquals(new Integer[]{ 1, 3, 2, 5, 5, 5, 3 }, reverseSum(list1, list2).toArray());
    }

    @Test
    public void testReverseSum_cascadedCarry() {
        LinkedList<Integer> list1 = LinkedList.of(7, 6, 3, 6);
        LinkedList<Integer> list2 = LinkedList.of(4, 3, 8, 8);
        assertArrayEquals(new Integer[]{ 1, 0, 2, 5, 1 }, reverseSum(list1, list2).toArray());
    }

    @Test
    public void testSum_emptyLists() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        assertArrayEquals(new Integer[0], sum(list1, list2).toArray());
    }


    @Test
    public void testSum_ofZero() {
        LinkedList<Integer> list1 = LinkedList.of(0);
        LinkedList<Integer> list2 = LinkedList.of(0);
        assertArrayEquals(new Integer[]{ 0 }, sum(list1, list2).toArray());
    }

    @Test
    public void testSum_oneEmpty() {
        LinkedList<Integer> list1 = LinkedList.of(1, 2, 3, 4);
        LinkedList<Integer> list2 = new LinkedList<>();
        assertArrayEquals(new Integer[]{ 1, 2, 3, 4 }, sum(list1, list2).toArray());
    }

    @Test
    public void testSum_equalLengthsNoCarries() {
        LinkedList<Integer> list1 = LinkedList.of(1, 2, 3, 4);
        LinkedList<Integer> list2 = LinkedList.of(4, 3, 2, 1);
        assertArrayEquals(new Integer[]{ 5, 5, 5, 5 }, sum(list1, list2).toArray());
    }

    @Test
    public void testSum_equalLengthsWithCarries() {
        LinkedList<Integer> list1 = LinkedList.of(7, 9, 3, 6);
        LinkedList<Integer> list2 = LinkedList.of(4, 3, 8, 8);
        assertArrayEquals(new Integer[]{ 1, 2, 3, 2, 4 }, sum(list1, list2).toArray());
    }

    @Test
    public void testSum_differentLengths() {
        LinkedList<Integer> list1 = LinkedList.of(7, 9, 3, 6, 4, 5, 3);
        LinkedList<Integer> list2 = LinkedList.of(4, 3, 8, 8);
        assertArrayEquals(new Integer[]{ 7, 9, 4, 0, 8, 4, 1 }, sum(list1, list2).toArray());
    }

    @Test
    public void testSum_cascadedCarry() {
        LinkedList<Integer> list1 = LinkedList.of(7, 6, 3, 6);
        LinkedList<Integer> list2 = LinkedList.of(4, 3, 8, 8);
        assertArrayEquals(new Integer[]{ 1, 2, 0, 2, 4 }, sum(list1, list2).toArray());
    }

    @Test
    public void testIsPalindrome_emptyList() {
        LinkedList<Character> list = new LinkedList<>();
        assertTrue(list.isPalindrome());
    }

    @Test
    public void testIsPalindrome_singleElement() {
        LinkedList<Character> list = LinkedList.of('f');
        assertTrue(list.isPalindrome());
    }

    @Test
    public void testIsPalindrome_twoSameElements() {
        LinkedList<Character> list = LinkedList.of('f', 'f');
        assertTrue(list.isPalindrome());
    }

    @Test
    public void testIsPalindrome_twoDifferentElements() {
        LinkedList<Character> list = LinkedList.of('f', 'e');
        assertFalse(list.isPalindrome());
    }

    @Test
    public void testIsPalindrome_true() {
        LinkedList<Character> list = LinkedList.of('r', 'a', 'c', 'e', 'c', 'a', 'r');
        assertTrue(list.isPalindrome());
    }

    @Test
    public void testIsPalindrome_false() {
        LinkedList<Character> list = LinkedList.of('f', 'l', 'a', 'n', 'n', 'e', 'l');
        assertFalse(list.isPalindrome());
    }

    private void assertPartitions(LinkedList<Integer> list, Set<Integer> lt, Set<Integer> ge) {
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            if (!lt.isEmpty()) {
                assertTrue(lt.contains(element));
                lt.remove(element);
            } else {
                assertTrue(ge.contains(element));
                ge.remove(element);
            }
        }
        assertTrue(lt.isEmpty() && ge.isEmpty());
    }
}