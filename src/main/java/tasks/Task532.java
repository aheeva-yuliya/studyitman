package tasks;

import collections.ArrayList;
import collections.Stack;
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
     * @cpu O (n + m) people from to acquaintances
     * @ram O(n + m) n = people m = number of acquaintances
     *
     * @param people int argument
     * @param acquaintances represents an array of edges in a directed graph
     * @param from int argument
     * @param to int argument
     * @return true if there is a chain otherwise false.
     */
    public static boolean existsChain(int people, Pair[] acquaintances, int from, int to) {
        final ArrayList[] adjacencyList = GraphUtils.toAdjacencyList(people, acquaintances);
        final boolean[] used = new boolean[adjacencyList.length];
        final Stack stack = new Stack();
        stack.push(from);
        while (!stack.isEmpty()) {
            final int vertex = stack.pop();
            used[vertex] = true;
            final ArrayList neighbors = adjacencyList[vertex];
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                if (!used[neighbors.get(i)]) {
                    if (neighbors.get(i) == to) {
                        return true;
                    }
                    stack.push(neighbors.get(i));
                }
            }
        }
        return false;
    }
}
