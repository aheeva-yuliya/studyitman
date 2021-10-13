package tasks;

import collections.ArrayList;
import collections.Stack;
import entities.Pair;
import utils.GraphUtils;

/**
 * Task533
 */
public class Task533 {

    /**
     * Finds the number of components.
     *
     * @cpu O(n + m) n = number of vertices, m = number of edges
     * @ram O(n + m) n = number of vertices, m = number of edges
     *
     * @param n number of vertices
     * @param edges represents connection between vertices
     * @return the number of components.
     */
    public static int countComponents(int n, Pair[] edges) {
        int components = 0;
        final ArrayList[] adjacencyList = GraphUtils.toUndirectedAdjacencyList(n, edges);
        final boolean[] used = new boolean[adjacencyList.length];
        final Stack stack = new Stack();
        for (int startVertex = 1; startVertex <= n; startVertex++) {
            if (!used[startVertex]) {
                stack.push(startVertex);

                while (!stack.isEmpty()) {
                    final int vertex = stack.pop();
                    if (!used[vertex]) {
                        used[vertex] = true;
                        final ArrayList neighbors = adjacencyList[vertex];
                        for (int i = neighbors.size() - 1; i >= 0; i--) {
                            if (!used[neighbors.get(i)]) {
                                stack.push(neighbors.get(i));
                            }
                        }
                    }
                }
                components++;
            }
        }
        return components;
    }
}