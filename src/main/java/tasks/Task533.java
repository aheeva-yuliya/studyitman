package tasks;

import collections.ArrayList;
import collections.Stack;
import entities.Pair;
import utils.GraphUtils;

public class Task533 {
    public static int countComponents(int n, Pair[] edges) {
        int countComponents = 1;
        ArrayList[] adjacencyList = GraphUtils.toUndirectedAdjacencyList(n, edges);
        boolean[] used = new boolean[adjacencyList.length];
        Stack stack = new Stack();
        for (int startVertex = 1; startVertex < adjacencyList.length; startVertex++) {
            if (!used[startVertex]) {
                stack.push(startVertex);

                while (!stack.isEmpty()) {
                    int vertex = stack.pop();
                    if (!used[vertex]) {
                        used[vertex] = true;
                        ArrayList neighbors = adjacencyList[vertex];
                        int size = neighbors.size();

                        for (int i = size - 1; i >= 0; i--) {
                            if (!used[neighbors.get(i)]) {
                                stack.push(neighbors.get(i));
                            }
                        }
                    }
                }
            }
        }
        return countComponents;
    }
}

