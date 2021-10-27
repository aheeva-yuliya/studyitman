package tasks;

import collections.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task527Tests {
    @Nested
    public class FindComponent {
        @Test
        public void shouldFindComponentWhenSomeTrueSomeFalse() {
            ArrayList[] adjacencyList = new ArrayList[]{
                    ArrayList.of(1, 3),
                    ArrayList.of(0, 4),
                    ArrayList.of(5),
                    ArrayList.of(0),
                    ArrayList.of(1),
                    ArrayList.of(2)
            };
            boolean[] expected = new boolean[]{true, true, false, true, true, false};
            Assertions.assertArrayEquals(expected, Task527.findComponent(adjacencyList));
        }

        @Test
        public void shouldFindComponentWhenAllConnected() {
            ArrayList[] adjacencyList = new ArrayList[]{
                    ArrayList.of(1, 2, 3, 4, 5),
                    ArrayList.of(0, 2, 3, 4, 5),
                    ArrayList.of(0, 1, 3, 4, 5),
                    ArrayList.of(0, 2, 1, 4, 5),
                    ArrayList.of(0, 1, 2, 3, 5),
                    ArrayList.of(0, 1, 2, 3, 4),
            };
            boolean[] expected = new boolean[]{true, true, true, true, true, true};
            Assertions.assertArrayEquals(expected, Task527.findComponent(adjacencyList));
        }

        @Test
        public void shouldFindComponentWhenReachableCase() {
            ArrayList[] adjacencyList = new ArrayList[]{
                    ArrayList.of(1),
                    ArrayList.of(0, 4),
                    ArrayList.of(3),
                    ArrayList.of(2, 5),
                    ArrayList.of(1, 5),
                    ArrayList.of(3, 4)
            };
            boolean[] expected = new boolean[]{true, true, true, true, true, true};
            Assertions.assertArrayEquals(expected, Task527.findComponent(adjacencyList));
        }


        @Test
        public void shouldFindComponentWhenAllNotReachable() {
            ArrayList[] adjacencyList = new ArrayList[]{
                    ArrayList.of(),
                    ArrayList.of(3, 4, 5),
                    ArrayList.of(5),
                    ArrayList.of(1),
                    ArrayList.of(1),
                    ArrayList.of(2)
            };
            boolean[] expected = new boolean[]{true, false, false, false, false, false};
            Assertions.assertArrayEquals(expected, Task527.findComponent(adjacencyList));
        }

        @Test
        public void shouldFindComponentWhenSomeNotReachable() {
            ArrayList[] adjacencyList = new ArrayList[]{
                    ArrayList.of(1, 3),
                    ArrayList.of(0, 4),
                    ArrayList.of(5),
                    ArrayList.of(0),
                    ArrayList.of(1, 6, 7, 8),
                    ArrayList.of(2),
                    ArrayList.of(4),
                    ArrayList.of(4),
                    ArrayList.of(4, 9),
                    ArrayList.of(8),
                    ArrayList.of()
            };
            boolean[] expected = new boolean[]{true, true, false, true, true, false, true, true, true, true, false};
            Assertions.assertArrayEquals(expected, Task527.findComponent(adjacencyList));
        }
    }
}