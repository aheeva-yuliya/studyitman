package tasks;

import collections.ArrayList;
import entities.Pair;

/**
 * Task579
 */
public class Task579 {

    private static class Support {
        private Pair[] pairs = new Pair[16];
        private int size;
        private int from;
        private int to;
        private int rowCnt;
        private int colCnt;

        private void add(final Pair element) {
            if (size == pairs.length) {
                final Pair[] temp = new Pair[size * 2];
                System.arraycopy(pairs, 0, temp, 0, size);
                pairs = temp;
            }
            pairs[size++] = element;
        }

        private void trimToSize() {
            final Pair[] trimmed = new Pair[size];
            System.arraycopy(pairs, 0, trimmed, 0, size);
            pairs = trimmed;
        }

        private boolean check(char[][] map, final int i, final int j) {
            return i >= 0 && i < rowCnt && j >= 0 && j < colCnt
                    && (map[i][j] == 46 || map[i][j] == 102 || map[i][j] == 115);
        }

        private void createPairs(char[][] map) {
            rowCnt = map.length;
            colCnt = map[0].length;
            for (int i = 0; i < rowCnt; i++) {
                for (int j = 0; j < colCnt; j++) {
                    int vertex = i * colCnt + j;
                    if (map[i][j] == 46 || map[i][j] == 102 || map[i][j] == 115) {
                        if (map[i][j] == 115) {
                            from = vertex;
                        } else if (map[i][j] == 102) {
                            to = vertex;
                        }
                        int right;
                        if (check(map, i - 1, j)) {
                            right = (i - 1) * colCnt + j;
                            add(new Pair(vertex, right));
                        }
                        if (check(map, i + 1, j)) {
                            right = (i + 1) * colCnt + j;
                            add(new Pair(vertex, right));
                        }
                        if (check(map, i, j - 1)) {
                            right = i * colCnt + j - 1;
                            add(new Pair(vertex, right));
                        }
                        if (check(map, i, j + 1)) {
                            right = i * colCnt + j + 1;
                            add(new Pair(vertex, right));
                        }
                    }
                }
            }
        }
    }

    /**
     * Draw with '*' the minimum distance way from S to F.
     *
     * @cpu O(n + m) n - number of vertices (number of map row * number of map col),
     *               m - number of edges (number of map ('.' + 's' + 'f') multiplied by two)
     * @ram O(n + m) n - number of vertices, m - number of edges
     *
     * @param map a field of containing ('s', 'f', '.', 'x') chars.
     */
    public static void drawWay(char[][] map) {
        final Support support = new Support();
        support.createPairs(map);
        support.trimToSize();
        final ArrayList way = Task532.findMinChainByQueue(
                support.rowCnt * support.colCnt - 1, support.pairs, support.from, support.to);
        if (way != null) {
            for (int i = 0; i < way.size(); i++) {
                final int vertex = way.get(i);
                final int row = vertex / support.colCnt;
                final int col = vertex - row * support.colCnt;
                map[row][col] = 42;
            }
        }
    }
}
