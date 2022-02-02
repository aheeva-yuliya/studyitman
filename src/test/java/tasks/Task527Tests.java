package tasks;

import collections.IntArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task527Tests {
    @Nested
    public class FindComponent {
        @Test
        public void shouldFindComponentWhenSomeTrueSomeFalse() {
            IntArrayList[] adjacencyList = new IntArrayList[]{
                    IntArrayList.of(1, 3),
                    IntArrayList.of(0, 4),
                    IntArrayList.of(5),
                    IntArrayList.of(0),
                    IntArrayList.of(1),
                    IntArrayList.of(2)
            };
            boolean[] expected = new boolean[]{true, true, false, true, true, false};
            Assertions.assertArrayEquals(expected, Task527.findComponent(adjacencyList));
        }

        @Test
        public void shouldFindComponentWhenAllConnected() {
            IntArrayList[] adjacencyList = new IntArrayList[]{
                    IntArrayList.of(1, 2, 3, 4, 5),
                    IntArrayList.of(0, 2, 3, 4, 5),
                    IntArrayList.of(0, 1, 3, 4, 5),
                    IntArrayList.of(0, 2, 1, 4, 5),
                    IntArrayList.of(0, 1, 2, 3, 5),
                    IntArrayList.of(0, 1, 2, 3, 4),
            };
            boolean[] expected = new boolean[]{true, true, true, true, true, true};
            Assertions.assertArrayEquals(expected, Task527.findComponent(adjacencyList));
        }

        @Test
        public void shouldFindComponentWhenReachableCase() {
            IntArrayList[] adjacencyList = new IntArrayList[]{
                    IntArrayList.of(1),
                    IntArrayList.of(0, 4),
                    IntArrayList.of(3),
                    IntArrayList.of(2, 5),
                    IntArrayList.of(1, 5),
                    IntArrayList.of(3, 4)
            };
            boolean[] expected = new boolean[]{true, true, true, true, true, true};
            Assertions.assertArrayEquals(expected, Task527.findComponent(adjacencyList));
        }


        @Test
        public void shouldFindComponentWhenAllNotReachable() {
            IntArrayList[] adjacencyList = new IntArrayList[]{
                    IntArrayList.of(),
                    IntArrayList.of(3, 4, 5),
                    IntArrayList.of(5),
                    IntArrayList.of(1),
                    IntArrayList.of(1),
                    IntArrayList.of(2)
            };
            boolean[] expected = new boolean[]{true, false, false, false, false, false};
            Assertions.assertArrayEquals(expected, Task527.findComponent(adjacencyList));
        }

        @Test
        public void shouldFindComponentWhenSomeNotReachable() {
            IntArrayList[] adjacencyList = new IntArrayList[]{
                    IntArrayList.of(1, 3),
                    IntArrayList.of(0, 4),
                    IntArrayList.of(5),
                    IntArrayList.of(0),
                    IntArrayList.of(1, 6, 7, 8),
                    IntArrayList.of(2),
                    IntArrayList.of(4),
                    IntArrayList.of(4),
                    IntArrayList.of(4, 9),
                    IntArrayList.of(8),
                    IntArrayList.of()
            };
            boolean[] expected = new boolean[]{true, true, false, true, true, false, true, true, true, true, false};
            Assertions.assertArrayEquals(expected, Task527.findComponent(adjacencyList));
        }
    }
}