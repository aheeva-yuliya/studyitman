package tasks;

import collections.IntArrayList;
import collections.BfsQueue;
import collections.Queue;
import collections.Stack;
import entities.BfsNode;
import entities.Pair;
import utils.GraphUtils;

/**
 * Task532.
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
        final IntArrayList[] adjacencyList = GraphUtils.toAdjacencyList(people, acquaintances);
        final boolean[] used = new boolean[adjacencyList.length];
        final Stack stack = new Stack();
        stack.push(from);
        used[from] = true;
        while (!stack.isEmpty()) {
            final int vertex = stack.pop();
            final IntArrayList neighbors = adjacencyList[vertex];
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
        final IntArrayList[] adjacencyList = GraphUtils.toAdjacencyList(people, acquaintances);
        final boolean[] used = new boolean[adjacencyList.length];
        final Queue queue = new Queue();
        queue.offer(from);
        used[from] = true;
        while (!queue.isEmpty()) {
            final int vertex = queue.poll();
            final IntArrayList neighbors = adjacencyList[vertex];
            for (int i = neighbors.size() - 1; i >= 0; i--) {
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
        final IntArrayList[] adjacencyList = GraphUtils.toAdjacencyList(people, acquaintances);
        final int[] used = new int[adjacencyList.length];
        final Queue queue = new Queue();
        queue.offer(from);
        while (!queue.isEmpty()) {
            final int vertex = queue.poll();
            final IntArrayList neighbors = adjacencyList[vertex];
            for (int i = neighbors.size() - 1; i >= 0; i--) {
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
    public static int findMinChainLengthByQueue(int people, Pair[] acquaintances, int from, int to) {
        final IntArrayList chain = findMinChainByQueue(people, acquaintances, from, to);
        if (chain == null) {
            return -1;
        }
        return chain.size() - 1;
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
    public static IntArrayList findMinChainByQueue(int people, Pair[] acquaintances, int from, int to) {
        final IntArrayList[] adjacencyList = GraphUtils.toAdjacencyList(people, acquaintances);
        final boolean[] used = new boolean[adjacencyList.length];
        final BfsQueue queue = new BfsQueue();
        int distance = 0;
        queue.offer(new BfsNode(from, distance, null));
        used[from] = true;
        while (!queue.isEmpty()) {
            distance = queue.peek().getDistance() + 1;
            BfsNode prev = queue.peek();
            final int vertex = queue.poll().getVertex();
            final IntArrayList neighbors = adjacencyList[vertex];
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                final int neighbor = neighbors.get(i);
                if (neighbor == to) {
                    final IntArrayList chain = new IntArrayList();
                    final IntArrayList support = new IntArrayList();
                    support.add(to);
                    while (prev != null) {
                        support.add(prev.getVertex());
                        prev = prev.getPrev();
                    }
                    int[] supportChain = support.toArray();
                    for (int j = supportChain.length - 1; j >= 0; j--) {
                        chain.add(supportChain[j]);
                    }
                    return chain;
                } else if (!used[neighbor]) {
                    queue.offer(new BfsNode(neighbor, distance, prev));
                    used[neighbor] = true;
                }
            }
        }
        return null;
    }
}
