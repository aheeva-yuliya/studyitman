package tasks;

import collections.ArrayList;
import collections.Stack;
import entities.Pair;
import utils.GraphUtils;

/**
 * Task534.
 */
public class Task534 {

    /**
     * Counts the number of vertices in the subtree rooted at X.
     *
     * @cpu O(n + m) n = number of vertices, m = number of edges
     * @ram O(n + m) n = number of vertices, m = number of edges
     *
     * @param n number of vertices
     * @param edges represents connection between vertices
     * @param x the root in a subtree
     * @return the number of vertices in the subtree rooted at X.
     */
    public static int countChildrenInSubtree(int n, Pair[] edges, int x) {
        int children = 0;
        boolean isX = false;
        int stackLength = 0;
        final ArrayList[] adjacencyList = GraphUtils.toUndirectedAdjacencyList(n, edges);
        final boolean[] used = new boolean[adjacencyList.length];
        final Stack stack = new Stack();
        stack.push(1);

        while (!stack.isEmpty() && !isX || isX && stack.size() != stackLength) {
            final int vertex = stack.pop();
            if (vertex == x) {
                isX = true;
                children = 1;
                stackLength = stack.size();
            }
            if (!used[vertex]) {
                used[vertex] = true;
                final ArrayList neighbors = adjacencyList[vertex];
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    if (!used[neighbors.get(i)]) {
                        stack.push(neighbors.get(i));
                        if (isX) {
                            children++;
                        }
                    }
                }
            }
        }
        return children;
    }

    /**
     * Counts the number of vertices in the subtree rooted at X.
     *
     * @cpu O(n + m) n = number of vertices, m = number of edges
     * @ram O(n + m) n = number of vertices, m = number of edges
     *
     * @param n number of vertices
     * @param edges represents connection between vertices
     * @param x the root in a subtree
     * @return the number of vertices in the subtree rooted at X.
     */
    public static int countChildrenInSubtreeByRecursion(int n, Pair[] edges, int x) {
        final ArrayList[] adjacencyList = GraphUtils.toUndirectedAdjacencyList(n, edges);
        final boolean[] used = new boolean[adjacencyList.length];
        return dfs(1, adjacencyList, used, x, false);
    }

    private static int dfs(int vertex, ArrayList[] adjacencyList, boolean[] used, int x, boolean flag) {
        if (vertex == x) {
            flag = true;
        }
        used[vertex] = true;
        int children = 0;
        for (int i = 0; i < adjacencyList[vertex].size(); i++) {
            int neighbor = adjacencyList[vertex].get(i);
            if (!used[neighbor]) {
                int grandchildren = dfs(neighbor, adjacencyList, used, x, flag);
                children = children + grandchildren;
            }
        }
        if (flag) {
            children = children + 1;
        }
        return children;
    }
}
