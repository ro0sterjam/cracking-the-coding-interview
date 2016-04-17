package com.ro0sterjam.ctci;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by kenwang on 2016-04-17.
 */
public class StringTrieTest {

    @Test
    public void testAdd_containsValue() {
        StringTrie trie = new StringTrie();
        trie.add("hello");
        assertTrue(trie.contains("hello"));
    }

    @Test
    public void testContains_notContaining() {
        StringTrie trie = new StringTrie();
        trie.add("hello");
        assertFalse(trie.contains("world"));
    }

    @Test
    public void testContains_containsSubstring() {
        StringTrie trie = new StringTrie();
        trie.add("hello");
        assertFalse(trie.contains("hellow"));
    }

    @Test
    public void testContains_substring() {
        StringTrie trie = new StringTrie();
        trie.add("hello");
        assertFalse(trie.contains("hell"));
    }
u
    @Test
    public void testAdd_substrings() {
        StringTrie trie = new StringTrie();
        trie.add("hello");
        trie.add("hell");
        assertTrue(trie.contains("hello"));
        assertTrue(trie.contains("hell"));
    }

    @Test
    public void testAdd_samePrefixes() {
        StringTrie trie = new StringTrie();
        trie.add("helium");
        trie.add("hello");
        assertTrue(trie.contains("helium"));
        assertTrue(trie.contains("hello"));
    }

    @Test
    public void testAdd_differentPrefixes() {
        StringTrie trie = new StringTrie();
        trie.add("hello");
        trie.add("world");
        assertTrue(trie.contains("hello"));
        assertTrue(trie.contains("world"));
    }

}