package tasks;

import collections.ArrayList;
import entities.Pair;
import utils.GraphUtils;

/**
 * Task532
 */
public class Task532 {

    /**
     * Finds out whether there is a chain of people through which a man(the parameter from)
     *          knows another(the parameter to).
     *
     * @cpu O (n + m) n = people m = number of acquaintances
     * @ram O(n + m) n = people m = number of acquaintances
     *
     * @param people int argument
     * @param acquaintances represents an array of edges in a directed graph
     * @param from int argument
     * @param to int argument
     * @return true if there is a chain otherwise false.
     */
    public static boolean existsChain(int people, Pair[] acquaintances, int from, int to) {
        ArrayList[] adjacency = GraphUtils.toAdjacencyList(people, acquaintances);
        boolean[] components = new boolean[adjacency.length];
        components[from] = true;
        for (int i = from; i < adjacency.length; i++) {
            if (components[i]) {
                int size = adjacency[i].size();
                for (int j = 0; j < size; j++) {
                    components[adjacency[i].get(j)] = true;
                }
            }
        }
        return components[to];
    }
}
