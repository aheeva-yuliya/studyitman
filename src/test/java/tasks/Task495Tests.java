package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task495Tests {

    @Test
    public void solveByBinarySearch() {
        int[] a = new int[] {-1, 1, 1, 2, 2, 3, 5, 5, 5, 10};
        Assertions.assertEquals(6, Task495.solveByBinarySearch(a, 4));
    }

    @Test
    public void solveByBinarySearchIfNull() {
        int[] a = new int[] {};
        Assertions.assertEquals(0, Task495.solveByBinarySearch(a, 10));
    }

    @Test
    public void solveByTwoPointersNormalCase() {
        int[] a = new int[] {1, 1, 1, 2, 3, 3, 4, 5, 5, 6, 6, 6, 7, 8, 9, 9, 10};
        Assertions.assertEquals(8, Task495.solveByTwoPointers(a, 6));
    }

    @Test
    public void solveByTwoPointersExample() {
        int[] a = new int[] {-1, 1, 2, 3, 5, 10};
        Assertions.assertEquals(2, Task495.solveByTwoPointers(a, 4));
    }

    @Test
    public void solveByTwoPointersLengthIsOne() {
        int[] a = new int[] {2};
        Assertions.assertEquals(0, Task495.solveByTwoPointers(a, 2));
    }

    @Test
    public void solveByTwoPointersIfNull() {
        int[] a = new int[] {};
        Assertions.assertEquals(0, Task495.solveByTwoPointers(a, 2));
    }

    @Test
    public void solveByTwoPointersIfLengthIsTwo() {
        int[] a = new int[] {2, 2};
        Assertions.assertEquals(1, Task495.solveByTwoPointers(a, 4));
    }
}