package utils;

import collections.IntArrayList;
import entities.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GraphUtilsTests {
    @Nested
    public class ToAdjacencyList {
        @Test
        public void shouldReturnAdjacencyListWhenNormalCase() {
            Pair[] edges = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3)
            };
            IntArrayList[] expected = new IntArrayList[]{
                    IntArrayList.of(),
                    IntArrayList.of(2, 3),
                    IntArrayList.of(),
                    IntArrayList.of()
            };
            IntArrayList[] actual = GraphUtils.toAdjacencyList(3, edges);
            for (int i = 0; i < expected.length; i++) {
                Assertions.assertTrue(expected[i].equals(actual[i]));
            }
        }

        @Test
        public void shouldReturnAdjacencyListWhenEdgesEmpty() {
            Pair[] edges = new Pair[]{};
            IntArrayList[] expected = new IntArrayList[]{
                    IntArrayList.of(),
                    IntArrayList.of(),
                    IntArrayList.of(),
                    IntArrayList.of()
            };
            IntArrayList[] actual = GraphUtils.toAdjacencyList(3, edges);
            for (int i = 0; i < expected.length; i++) {
                Assertions.assertTrue(expected[i].equals(actual[i]));
            }
        }
    }

    @Nested
    public class ToUndirectedAdjacencyList {
        @Test
        public void shouldReturnUndirectedAdjacencyListWhenNormalCase() {
            Pair[] edges = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3)
            };
            IntArrayList[] expected = new IntArrayList[]{
                    IntArrayList.of(),
                    IntArrayList.of(2, 3),
                    IntArrayList.of(1),
                    IntArrayList.of(1)
            };
            IntArrayList[] actual = GraphUtils.toUndirectedAdjacencyList(3, edges);
            for (int i = 0; i < expected.length; i++) {
                Assertions.assertTrue(expected[i].equals(actual[i]));
            }
        }

        @Test
        public void shouldReturnUndirectedAdjacencyListWhenEdgesEmpty() {
            Pair[] edges = new Pair[]{};
            IntArrayList[] expected = new IntArrayList[]{
                    IntArrayList.of(),
                    IntArrayList.of(),
                    IntArrayList.of(),
                    IntArrayList.of()
            };
            IntArrayList[] actual = GraphUtils.toUndirectedAdjacencyList(3, edges);
            for (int i = 0; i < expected.length; i++) {
                Assertions.assertTrue(expected[i].equals(actual[i]));
            }
        }
    }
}