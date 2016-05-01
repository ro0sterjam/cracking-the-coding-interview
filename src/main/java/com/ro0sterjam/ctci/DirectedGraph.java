package com.ro0sterjam.ctci;

import java.util.*;

/**
 * Created by kenwang on 2016-05-01.
 */
public class DirectedGraph<V> {

    private Map<V, Set<V>> edges = new HashMap<>();

    public void addVertex(V vertex) {
        edges.put(vertex, new HashSet<>());
    }

    public void addEdge(V from, V to) {
        edges.get(from).add(to);
    }

    public Set<V> getConnected(V vertex) {
        return edges.getOrDefault(vertex, Collections.emptySet());
    }

    public boolean hasPath(V from, V to) {
        Set<V> visited = new HashSet<>();
        return hasPath(from, to, visited);
    }

    private boolean hasPath(V from, V to, Set<V> visited) {
        if (from == to) {
            return true;
        }
        visited.add(from);
        for (V connected : getConnected(from)) {
            if (!visited.contains(connected) && hasPath(connected, to)) {
               return true;
            }
        }
        return false;
    }

}
