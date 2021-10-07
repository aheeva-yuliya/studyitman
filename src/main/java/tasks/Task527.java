package tasks;

import collections.ArrayList;

/**
 * Task527
 */
public class Task527 {
    /**
     * Returns a boolean array of n(the number of vertices) elements. The i-th index of the array is true
     *      if the vertex is reachable from the vertex 0, otherwise false.
     *
     * @cpu O(n + m) n = number of vertices and m = the number of edges
     * @ram O(n) n = number of vertices
     *
     * @param adjacencyList pairs for a given grath
     * @return a boolean array of elements.
     */
    public static boolean[] findComponent(ArrayList[] adjacencyList) {
        boolean[] components = new boolean[adjacencyList.length];
        components[0] = true;
        for (int i = 0; i < adjacencyList.length; i++) {
            if (components[i]) {
                int size = adjacencyList[i].size();
                for (int j = 0; j < size; j++) {
                    components[adjacencyList[i].get(j)] = true;
                }
            }
        }
        return components;
    }
}
