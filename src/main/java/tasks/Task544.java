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
     * @cpu (n + m)
     * @ram (n + m)
     *
     * @param n int argument represents vertices
     * @param edges represents connection between vertices
     * @return the height of a given tree.
     */
    public static int findHeight(int n, Pair[] edges) {
        int height = 0;
        int maxHeight = 0;
        final ArrayList[] adjacencyList = GraphUtils.toAdjacencyList(n, edges);
        final boolean[] used = new boolean[adjacencyList.length];
        final int vertex = 1;
        return dfs(height, maxHeight, vertex, adjacencyList, used);

    }

    private static int dfs(int height, int maxHeight, int vertex, ArrayList[] adjacencyList, boolean[] used) {
        if(!used[vertex]) {
            height++;
            if (height > maxHeight) {
                maxHeight = height;
            }
            for (int i = 0; i < adjacencyList[vertex].size(); i++) {
                maxHeight = dfs(height, maxHeight, adjacencyList[vertex].get(i), adjacencyList, used);

            }
        }
        return maxHeight;
    }
}
