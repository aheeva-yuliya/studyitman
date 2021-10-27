package tasks;

import benchmarks.SortBenchmark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task494Tests {
    @Nested
    public class Solve {
        @Nested
        public class BinarySearch {
            @Test
            public void shouldSolveByBinarySearchWhenHasInsertionPoint() {
                int[] a = new int[]{-1, 1, 1, 2, 3, 5, 5, 5, 10};
                int[] b = new int[]{5, 3, 1, 4, 1};
                int[] expected = new int[]{3, 1, 2, 0, 2};
                Assertions.assertArrayEquals(expected, Task494.solveByBinarySearch(a, b));
            }

            @Test
            public void shouldSolveByBinarySearchWhenHasNotInsertionPoint() {
                int[] a = new int[]{-1, 1, 1, 2, 3, 4, 5, 5, 5, 6, 10};
                int[] b = new int[]{5, 3, 1, 4, 1};
                int[] expected = new int[]{3, 1, 2, 1, 2};
                Assertions.assertArrayEquals(expected, Task494.solveByBinarySearch(a, b));
            }

            @Test
            public void shouldSolveByBinarySearchWhenGreaterLength() {
                int[] a = SortBenchmark.randomArray(1000, 2, 3);
                int[] b = new int[]{5, 2, 1, 4, 1};
                int[] expected = new int[]{0, 1000, 0, 0, 0};
                Assertions.assertArrayEquals(expected, Task494.solveByBinarySearch(a, b));
            }

            @Test
            public void shouldSolveByBinarySearchWhenEmpty() {
                int[] a = new int[]{};
                int[] b = new int[]{5, 3, 1, 4, 1};
                int[] expected = new int[]{0, 0, 0, 0, 0};
                Assertions.assertArrayEquals(expected, Task494.solveByBinarySearch(a, b));
            }
        }

        @Nested
        public class TwoPointers {
            @Test
            public void shouldSolveByTwoPointersWhenFirstOfALess() {
                int[] a = new int[]{-1, 1, 1, 2, 3, 5, 5, 5, 10};
                int[] b = new int[]{1, 1, 3, 4, 5};
                int[] expected = new int[]{2, 2, 1, 0, 3};
                Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a, b));
            }

            @Test
            public void shouldSolveByTwoPointersWhenFirstOfAGreater() {
                int[] a = new int[]{2, 3, 5, 5, 5, 10};
                int[] b = new int[]{1, 1, 3, 4, 5};
                int[] expected = new int[]{0, 0, 1, 0, 3};
                Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a, b));
            }

            @Test
            public void shouldSolveByTwoPointersWhenSame() {
                int[] a = new int[]{5, 5, 5, 5};
                int[] b = new int[]{1, 1, 3, 4, 5};
                int[] expected = new int[]{0, 0, 0, 0, 4};
                Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a, b));
            }

            @Test
            public void shouldSolveByTwoPointersWhenSameEqual() {
                int[] a = new int[]{5, 5, 5, 5};
                int[] b = new int[]{5};
                int[] expected = new int[]{4};
                Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a, b));
            }

            @Test
            public void shouldSolveByTwoPointersWhenSameNotEqual() {
                int[] a = new int[]{5, 5, 5, 5};
                int[] b = new int[]{9};
                int[] expected = new int[]{0};
                Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a, b));
            }

            @Test
            public void shouldSolveByTwoPointersWhenGreaterLength() {
                int[] a = SortBenchmark.randomArray(1000, 2, 3);
                int[] b = new int[]{1, 2, 3, 4, 5};
                int[] expected = new int[]{0, 1000, 0, 0, 0};
                Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a, b));
            }

            @Test
            public void shouldSolveByTwoPointersWhenEmpty() {
                int[] a = new int[]{};
                int[] b = new int[]{1, 1, 1, 4, 5};
                int[] expected = new int[]{0, 0, 0, 0, 0};
                Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a, b));
            }
        }
    }
}