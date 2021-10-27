package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task495Tests {
    @Nested
    public class BinarySearch {
        @Test
        public void shouldSolveByBinarySearchWhenNormalCase() {
            int[] a = new int[]{-2, -1, 1, 1, 2, 2, 2, 2, 2, 3, 5, 5, 5, 10};
            Assertions.assertEquals(15, Task495.solveByBinarySearch(a, 4));
        }

        @Test
        public void shouldSolveByBinarySearchWhenNoInsertionPoint() {
            int[] a = new int[]{-2, -1, 1, 1, 2, 2, 2, 2, 2, 3, 4, 5, 5, 5, 10};
            Assertions.assertEquals(15, Task495.solveByBinarySearch(a, 4));
        }

        @Test
        public void shouldSolveByBinarySearchWhenSame() {
            int[] a = new int[]{2, 2, 2, 2, 2};
            Assertions.assertEquals(10, Task495.solveByBinarySearch(a, 4));
        }

        @Test
        public void shouldSolveByBinarySearchWhenSumFromZeroAndLast() {
            int[] a = new int[]{0, 1, 1, 2, 2, 3, 10};
            Assertions.assertEquals(1, Task495.solveByBinarySearch(a, 10));
        }

        @Test
        public void shouldSolveByBinarySearchWhenEmpty() {
            int[] a = new int[]{};
            Assertions.assertEquals(0, Task495.solveByBinarySearch(a, 10));
        }
    }

    @Nested
    public class TwoPointers {
        @Test
        public void shouldSolveByTwoPointersWhenNormalCase() {
            int[] a = new int[]{-2, -1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 5, 5, 5, 10};
            Assertions.assertEquals(19, Task495.solveByTwoPointers(a, 4));
        }

        @Test
        public void shouldSolveByTwoPointersWhenLengthIsOne() {
            int[] a = new int[]{2};
            Assertions.assertEquals(0, Task495.solveByTwoPointers(a, 2));
        }

        @Test
        public void shouldSolveByTwoPointersWhenEmpty() {
            int[] a = new int[]{};
            Assertions.assertEquals(0, Task495.solveByTwoPointers(a, 2));
        }

        @Test
        public void shouldSolveByTwoPointersWhenLengthIsTwo() {
            int[] a = new int[]{2, 2};
            Assertions.assertEquals(1, Task495.solveByTwoPointers(a, 4));
        }

        @Test
        public void shouldSolveByTwoPointersWhenSame() {
            int[] a = new int[]{2, 2, 2, 2, 2};
            Assertions.assertEquals(10, Task495.solveByTwoPointers(a, 4));
        }

        @Test
        public void shouldSolveByTwoPointersWhenSomeSameElements() {
            int[] a = new int[]{-1, 1, 1, 2, 2, 3, 5, 5, 5, 10};
            Assertions.assertEquals(6, Task495.solveByTwoPointers(a, 4));
        }
    }
}