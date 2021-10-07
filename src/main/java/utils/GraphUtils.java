package utils;

import collections.ArrayList;
import entities.Pair;

/**
 * GraphUtils
 */
public class GraphUtils {

    /**
     * Returns an adjacency list for a given graph.
     *
     * @cpu (n + m) n = vertices and m = edges.length
     * @ram (n + m) n = vertices and m = edges.length
     *
     * @param vertices int argument
     * @param edges Pair[] represents an array of edges in a directed graph
     * @return an adjacency list for a given graph.
     */
    public static ArrayList[] toAdjacencyList(int vertices, Pair[] edges){
        ArrayList[] adjacency = new ArrayList[vertices + 1];
        for (int i = 0; i < adjacency.length; i++) {
            adjacency[i] = new ArrayList();
        }
        for (Pair edge : edges) {
            adjacency[edge.getLeft()].add(edge.getRight());
        }
        return adjacency;
    }
}
