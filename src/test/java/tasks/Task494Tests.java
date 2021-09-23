package tasks;

import benchmarks.SortBenchmark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task494Tests {

    @Test
    public void solveByBinarySearchNormalCase() {
        int[] a = new int[] {-1, 1, 1, 2, 3, 5, 5, 5, 10};
        int[] b = new int[] {5, 3, 1, 4, 1};
        int[] expected = new int[] {3, 1, 2, 0, 2};
        Assertions.assertArrayEquals(expected, Task494.solveByBinarySearch(a, b));
    }

    @Test
    public void solveByBinarySearchMaxLength() {
        int[] a = SortBenchmark.randomArray(1000000, 2, 3);
        int[] b = new int[] {5, 2, 1, 4, 1};
        int[] expected = new int[] {0, 1000000, 0, 0, 0};
        Assertions.assertArrayEquals(expected, Task494.solveByBinarySearch(a, b));
    }

    @Test
    public void solveByBinarySearchIfEmpty() {
        int[] a = new int[] {};
        int[] b = new int[] {5, 3, 1, 4, 1};
        int[] expected = new int[] {0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, Task494.solveByBinarySearch(a, b));
    }

    @Test
    public void solveByTwoPointersNormalCase() {
        int[] a = new int[] {-1, 1, 1, 2, 3, 5, 5, 5, 10};
        int[] b = new int[] {1, 1, 3, 4, 5};
        int[] expected = new int[] {2, 2, 1, 0, 3};
        Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a,b));
    }

    @Test
    public void solveByTwoPointersMaxLength() {
        int[] a = SortBenchmark.randomArray(1000000, 2, 3);
        int[] b = new int[] {5, 2, 1, 4, 1};
        int[] expected = new int[] {0, 1000000, 0, 0, 0};
        Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a, b));
    }

    @Test
    public void solveByTwoPointersIfEmpty() {
        int[] a = new int[] {};
        int[] b = new int[] {5, 3, 1, 4, 1};
        int[] expected = new int[] {0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a, b));
    }
}