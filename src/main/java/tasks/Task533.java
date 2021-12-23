package tasks;

import collections.IntArrayList;
import collections.Stack;
import entities.Pair;
import utils.GraphUtils;

/**
 * Task533.
 */
public class Task533 {

    /**
     * Finds the number of components using stack.
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
        final IntArrayList[] adjacencyList = GraphUtils.toUndirectedAdjacencyList(n, edges);
        final boolean[] used = new boolean[adjacencyList.length];
        final Stack stack = new Stack();
        for (int startVertex = 1; startVertex <= n; startVertex++) {
            if (!used[startVertex]) {
                stack.push(startVertex);

                while (!stack.isEmpty()) {
                    final int vertex = stack.pop();
                    if (!used[vertex]) {
                        used[vertex] = true;
                        final IntArrayList neighbors = adjacencyList[vertex];
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

    /**
     * Finds the number of components by recursion.
     *
     * @cpu O(n + m) n = number of vertices, m = number of edges
     * @ram O(n + m) n = number of vertices, m = number of edges
     *
     * @param n number of vertices
     * @param edges represents connection between vertices
     * @return the number of components.
     */
    public static int countComponentsByRecursion(int n, Pair[] edges) {
        int component = 0;
        final IntArrayList[] adjacencyList = GraphUtils.toUndirectedAdjacencyList(n, edges);
        final boolean[] used = new boolean[adjacencyList.length];
        for (int startVertex = 1; startVertex <= n; startVertex++) {
            if (!used[startVertex]) {
                dfs(startVertex, adjacencyList, used);
                component++;
            }
        }
        return component;
    }

    private static void dfs(int startVertex, IntArrayList[] adjacencyList, boolean[] used) {
        used[startVertex] = true;
        for (int i = 0; i < adjacencyList[startVertex].size(); i++) {
            final int vertex = adjacencyList[startVertex].get(i);
            if (!used[vertex]) {
                dfs(vertex, adjacencyList, used);
            }
        }
    }
}