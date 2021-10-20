package tasks;

import collections.ArrayList;
import entities.Pair;
import utils.GraphUtils;

/**
 * Task544
 */
public class Task544 {

    /**
     * Finds the height of a given tree.
     *
     * @cpu (n + m) n = number of vertices, m = number of edges
     * @ram (n + m) n = number of vertices, m = number of edges
     *
     * @param n int argument represents vertices
     * @param edges represents connection between vertices
     * @return the height of a given tree.
     */
    public static int findHeight(int n, Pair[] edges) {
        final ArrayList[] adjacencyList = GraphUtils.toAdjacencyList(n, edges);
        return dfs(1, adjacencyList);

    }

    private static int dfs(int vertex, ArrayList[] adjacencyList) {
        int maxHeight = 0;
        for (int i = 0; i < adjacencyList[vertex].size(); i++) {
            int neighbor = adjacencyList[vertex].get(i);
            int height = dfs(neighbor, adjacencyList);
            maxHeight = Math.max(height, maxHeight);
        }
        return maxHeight + 1;
    }
}
