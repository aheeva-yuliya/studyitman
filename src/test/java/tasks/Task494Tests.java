package tasks;

import benchmarks.SortBenchmark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task494Tests {

    @Test
    public void solveByBinarySearchNormalCaseWithInsertionPoint() {
        int[] a = new int[] {-1, 1, 1, 2, 3, 5, 5, 5, 10};
        int[] b = new int[] {5, 3, 1, 4, 1};
        int[] expected = new int[] {3, 1, 2, 0, 2};
        Assertions.assertArrayEquals(expected, Task494.solveByBinarySearch(a, b));
    }

    @Test
    public void solveByBinarySearchNormalCaseWithoutInsertionPoint() {
        int[] a = new int[] {-1, 1, 1, 2, 3, 4, 5, 5, 5, 6, 10};
        int[] b = new int[] {5, 3, 1, 4, 1};
        int[] expected = new int[] {3, 1, 2, 1, 2};
        Assertions.assertArrayEquals(expected, Task494.solveByBinarySearch(a, b));
    }

    @Test
    public void solveByBinarySearchGreaterLength() {
        int[] a = SortBenchmark.randomArray(1000, 2, 3);
        int[] b = new int[] {5, 2, 1, 4, 1};
        int[] expected = new int[] {0, 1000, 0, 0, 0};
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
    public void solveByTwoPointersIfFirstOfALess() {
        int[] a = new int[] {-1, 1, 1, 2, 3, 5, 5, 5, 10};
        int[] b = new int[] {1, 1, 3, 4, 5};
        int[] expected = new int[] {2, 2, 1, 0, 3};
        Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a,b));
    }

    @Test
    public void solveByTwoPointersIfFirstOfAGreater() {
        int[] a = new int[] {2, 3, 5, 5, 5, 10};
        int[] b = new int[] {1, 1, 3, 4, 5};
        int[] expected = new int[] {0, 0, 1, 0, 3};
        Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a,b));
    }

    @Test
    public void solveByTwoPointersIfSame() {
        int[] a = new int[] {5, 5, 5, 5};
        int[] b = new int[] {1, 1, 3, 4, 5};
        int[] expected = new int[] {0, 0, 0, 0, 4};
        Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a,b));
    }

    @Test
    public void solveByTwoPointersIfSameEqual() {
        int[] a = new int[] {5, 5, 5, 5};
        int[] b = new int[] {5};
        int[] expected = new int[] {4};
        Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a,b));
    }

    @Test
    public void solveByTwoPointersIfSameNotEqual() {
        int[] a = new int[] {5, 5, 5, 5};
        int[] b = new int[] {9};
        int[] expected = new int[] {0};
        Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a,b));
    }

    @Test
    public void solveByTwoPointersGreaterLength() {
        int[] a = SortBenchmark.randomArray(1000, 2, 3);
        int[] b = new int[] {1, 2, 3, 4, 5};
        int[] expected = new int[] {0, 1000, 0, 0, 0};
        Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a, b));
    }

    @Test
    public void solveByTwoPointersIfEmpty() {
        int[] a = new int[] {};
        int[] b = new int[] {1, 1, 1, 4, 5};
        int[] expected = new int[] {0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, Task494.solveByTwoPointers(a, b));
    }
}