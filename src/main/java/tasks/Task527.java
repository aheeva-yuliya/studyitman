package tasks;

import collections.ArrayList;
import collections.Stack;

/**
 * Task527
 */
public class Task527 {

    /**
     * Returns a boolean array of n(the number of vertices) elements. The i-th index of the array is true
     *      if the vertex is reachable from the vertex 0, otherwise false.
     *
     * @cpu O(n + m) n = number of vertices m = number of edges
     * @ram O(n) n = number of vertices
     *
     * @param adjacencyList pairs for a given grath
     * @return a boolean array of elements.
     */
    public static boolean[] findComponent(ArrayList[] adjacencyList) {
        final boolean[] components = new boolean[adjacencyList.length];
        final Stack stack = new Stack();
        stack.push(0);
        components[0] = true;
        while (!stack.isEmpty()) {
            final int vertex = stack.pop();
            final ArrayList neighbors = adjacencyList[vertex];
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                if (!components[neighbors.get(i)]) {
                    stack.push(neighbors.get(i));
                    components[neighbors.get(i)] = true;
                }
            }
        }
        return components;
    }
}
