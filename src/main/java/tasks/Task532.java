package tasks;

import collections.ArrayList;
import collections.Queue;
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
        final ArrayList[] adjacencyList = GraphUtils.toAdjacencyList(people, acquaintances);
        final boolean[] used = new boolean[adjacencyList.length];
        final Stack stack = new Stack();
        stack.push(from);
        used[from] = true;
        while (!stack.isEmpty()) {
            final int vertex = stack.pop();
            final ArrayList neighbors = adjacencyList[vertex];
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                if (!used[neighbors.get(i)]) {
                    if (neighbors.get(i) == to) {
                        return true;
                    }
                    stack.push(neighbors.get(i));
                    used[neighbors.get(i)] = true;
                }
            }
        }
        return false;
    }

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
    public static boolean existsChainByBfs(int people, Pair[] acquaintances, int from, int to) {
        final ArrayList[] adjacencyList = GraphUtils.toAdjacencyList(people, acquaintances);
        final boolean[] used = new boolean[adjacencyList.length];
        final Queue queue = new Queue();
        queue.offer(from);
        used[from] = true;
        while (!queue.isEmpty()) {
            final int vertex = queue.poll();
            final ArrayList neighbors = adjacencyList[vertex];
            for (int i = neighbors.size() - 1; i>= 0; i--) {
                if (!used[neighbors.get(i)]) {
                    if (neighbors.get(i) == to) {
                        return true;
                    }
                    queue.offer(neighbors.get(i));
                    used[neighbors.get(i)] = true;
                }
            }
        }
        return false;
    }

    /**
     * Finds the minimum chain length through which from knows to.
     *
     * @cpu O (n + m) n = people m = number of acquaintances
     * @ram O(n + m) n = people m = number of acquaintances
     *
     * @param people int argument
     * @param acquaintances represents an array of edges in a directed graph
     * @param from int argument
     * @param to int argument
     * @return the minimum chain length if from know to, otherwise -1.
     */
    public static int findMinChainLengthByVisits(int people, Pair[] acquaintances, int from, int to) {
        final ArrayList[] adjacencyList = GraphUtils.toAdjacencyList(people, acquaintances);
        final int[] used = new int[adjacencyList.length];
        final Queue queue = new Queue();
        queue.offer(from);
        while (!queue.isEmpty()) {
            final int vertex = queue.poll();
            final ArrayList neighbors = adjacencyList[vertex];
            for (int i = neighbors.size() - 1; i>= 0; i--) {
                if (used[neighbors.get(i)] == 0) {
                    queue.offer(neighbors.get(i));
                    used[neighbors.get(i)] = used[vertex] + 1;
                    if (neighbors.get(i) == to) {
                        return used[neighbors.get(i)];
                    }
                }
            }
        }
        return -1;
    }
}
