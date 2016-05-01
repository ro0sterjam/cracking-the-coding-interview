package com.ro0sterjam.ctci;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by kenwang on 2016-05-01.
 */
public class DirectedGraphTest {

    @Test
    public void testHasPath_noEdges() {
        DirectedGraph<Vertex<Integer>> graph = new DirectedGraph<>();
        Vertex<Integer> v1 = new Vertex<>(4);
        Vertex<Integer> v2 = new Vertex<>(5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        assertFalse(graph.hasPath(v1, v2));
    }

    @Test
    public void testHasPath_hill() {
        DirectedGraph<Vertex<Integer>> graph = new DirectedGraph<>();
        Vertex<Integer> v1 = new Vertex<>(4);
        Vertex<Integer> v2 = new Vertex<>(5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addEdge(v1, v2);
        assertFalse(graph.hasPath(v2, v1));
    }

    @Test
    public void testHasPath_sink() {
        DirectedGraph<Vertex<Integer>> graph = new DirectedGraph<>();
        Vertex<Integer> v1 = new Vertex<>(4);
        Vertex<Integer> v2 = new Vertex<>(5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addEdge(v1, v2);
        assertTrue(graph.hasPath(v1, v2));
    }

    @Test
    public void testHasPath_disjointed() {
        DirectedGraph<Vertex<Integer>> graph = new DirectedGraph<>();
        Vertex<Integer> v1 = new Vertex<>(4);
        Vertex<Integer> v2 = new Vertex<>(5);
        Vertex<Integer> v3 = new Vertex<>(8);
        Vertex<Integer> v4 = new Vertex<>(9);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addEdge(v1, v2);
        graph.addEdge(v3, v4);
        assertFalse(graph.hasPath(v1, v4));
    }

    @Test
    public void testHasPath_circular() {
        DirectedGraph<Vertex<Integer>> graph = new DirectedGraph<>();
        Vertex<Integer> v1 = new Vertex<>(4);
        Vertex<Integer> v2 = new Vertex<>(5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addEdge(v1, v2);
        graph.addEdge(v2, v1);
        assertTrue(graph.hasPath(v1, v2));
        assertTrue(graph.hasPath(v2, v1));
    }

    @Test
    public void testHasPath_hallway() {
        DirectedGraph<Vertex<Integer>> graph = new DirectedGraph<>();
        Vertex<Integer> v1 = new Vertex<>(4);
        Vertex<Integer> v2 = new Vertex<>(5);
        Vertex<Integer> v3 = new Vertex<>(8);
        Vertex<Integer> v4 = new Vertex<>(9);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addEdge(v1, v2);
        graph.addEdge(v2, v3);
        graph.addEdge(v3, v4);
        assertTrue(graph.hasPath(v1, v4));
    }

    @Test
    public void testHasPath_multiplePaths() {
        DirectedGraph<Vertex<Integer>> graph = new DirectedGraph<>();
        Vertex<Integer> v1 = new Vertex<>(4);
        Vertex<Integer> v2 = new Vertex<>(5);
        Vertex<Integer> v3 = new Vertex<>(8);
        Vertex<Integer> v4 = new Vertex<>(9);
        Vertex<Integer> v5 = new Vertex<>(2);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addEdge(v1, v2);
        graph.addEdge(v2, v3);
        graph.addEdge(v3, v4);
        graph.addEdge(v1, v5);
        graph.addEdge(v5, v4);
        assertTrue(graph.hasPath(v1, v4));
    }

    @Test
    public void testHasPath_multipleCircularPaths() {
        DirectedGraph<Vertex<Integer>> graph = new DirectedGraph<>();
        Vertex<Integer> v1 = new Vertex<>(4);
        Vertex<Integer> v2 = new Vertex<>(5);
        Vertex<Integer> v3 = new Vertex<>(8);
        Vertex<Integer> v4 = new Vertex<>(9);
        Vertex<Integer> v5 = new Vertex<>(2);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addEdge(v1, v2);
        graph.addEdge(v3, v2);
        graph.addEdge(v2, v3);
        graph.addEdge(v3, v4);
        graph.addEdge(v3, v1);
        graph.addEdge(v1, v5);
        graph.addEdge(v5, v4);
        assertTrue(graph.hasPath(v1, v4));
    }

    @Test
    public void testHasPath_multipleCircularPathsHill() {
        DirectedGraph<Vertex<Integer>> graph = new DirectedGraph<>();
        Vertex<Integer> v1 = new Vertex<>(4);
        Vertex<Integer> v2 = new Vertex<>(5);
        Vertex<Integer> v3 = new Vertex<>(8);
        Vertex<Integer> v4 = new Vertex<>(9);
        Vertex<Integer> v5 = new Vertex<>(2);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addEdge(v1, v2);
        graph.addEdge(v3, v2);
        graph.addEdge(v2, v3);
        graph.addEdge(v3, v4);
        graph.addEdge(v3, v1);
        graph.addEdge(v1, v5);
        graph.addEdge(v5, v4);
        assertFalse(graph.hasPath(v4, v1));
    }

}