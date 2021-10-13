package tasks;

import collections.ArrayList;
import collections.Stack;
import entities.Pair;
import utils.GraphUtils;

/**
 * Task534
 */
public class Task534 {

    public static int countChildrenInSubtree(int n, Pair[] edges, int x) {
        int children = 0;
        boolean isX = false;
        int stackLength = 0;
        final ArrayList[] adjacencyList = GraphUtils.toUndirectedAdjacencyList(n, edges);
        final boolean[] used = new boolean[adjacencyList.length];
        final Stack stack = new Stack();
        for (int startVertex = 1; startVertex <= n; startVertex++) {
            if (!used[startVertex] && !isX) {
                stack.push(startVertex);

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

            }

        }
        return children;
    }
}
