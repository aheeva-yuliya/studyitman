package utils;

import collections.ArrayList;
import entities.Pair;

/**
 * GraphUtils.
 */
public class GraphUtils {

    /**
     * Returns an adjacency list for a given graph.
     *
     * @cpu (n + m) n = vertices and m = number of edges
     * @ram (n + m) n = vertices and m = number of edges
     *
     * @param vertices int argument
     * @param edges Pair[] represents an array of edges in a directed graph
     * @return an adjacency list for a given graph.
     */
    public static ArrayList[] toAdjacencyList(int vertices, Pair[] edges) {
        ArrayList[] adjacency = create(vertices);
        for (Pair edge : edges) {
            adjacency[edge.getLeft()].add(edge.getRight());
        }
        return adjacency;
    }

    private static ArrayList[] create(int vertices) {
        ArrayList[] adjacency = new ArrayList[vertices + 1];
        for (int i = 0; i < adjacency.length; i++) {
            adjacency[i] = new ArrayList();
        }
        return adjacency;
    }

    /**
     * Returns an adjacency list for a given graph.
     *
     * @cpu (n + m) n = vertices and m = edges. length
     * @ram (n + m) n = vertices and m = edges. length
     *
     * @param vertices int argument
     * @param edges Pair[] represents an array of edges in an undirected graph
     * @return an adjacency list for a given graph.
     */
    public static ArrayList[] toUndirectedAdjacencyList(int vertices, Pair[] edges) {
        ArrayList[] adjacency = create(vertices);
        for (Pair edge : edges) {
            adjacency[edge.getLeft()].add(edge.getRight());
            adjacency[edge.getRight()].add(edge.getLeft());
        }
        return adjacency;
    }
}
