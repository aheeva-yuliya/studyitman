package tasks;

import benchmarks.SortBenchmark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task497Tests {

    @Test
    public void mergeSameLength() {
        int[] a = new int[] {5, 6, 9, 9, 10, 15, 25, 30};
        int[] b = new int[] {3, 7, 9, 10, 11, 12, 15, 18};
        int[] expected = new int[] {3, 5, 6, 7, 9, 9, 9, 10, 10, 11, 12, 15, 15, 18, 25, 30};
        Assertions.assertArrayEquals(expected, Task497.merge(a,b));
    }

    @Test
    public void mergeDifferentLength() {
        int[] a = new int[] {5, 6, 9, 9, 10, 15, 25, 30};
        int[] b = new int[] {3, 7, 9, 10};
        int[] expected = new int[] {3, 5, 6, 7, 9, 9, 9, 10, 10, 15, 25, 30};
        Assertions.assertArrayEquals(expected, Task497.merge(a,b));
    }

    @Test
    public void mergeIfOneEmpty() {
        int[] a = new int[] {5, 6, 9, 9, 10, 15, 25, 30};
        int[] b = new int[] {};
        int[] expected = new int[] {5, 6, 9, 9, 10, 15, 25, 30};
        Assertions.assertArrayEquals(expected, Task497.merge(a,b));
    }

    @Test
    public void mergeIfBothEmpty() {
        int[] a = new int[] {};
        int[] b = new int[] {};
        Assertions.assertNotNull(Task497.merge(a,b));
    }

    @Test
    public void mergeIfMaxLength() {
        int[] a = SortBenchmark.randomArray(1000000, 1, 2);
        int[] b = SortBenchmark.randomArray(1000000, 2, 3);
        int[] c = Task497.merge(a,b);
        int[] expected = new int[a.length + b.length];
        System.arraycopy(a, 0, expected, 0, a.length);
        System.arraycopy(b, 0, expected, a.length, b.length);
        Assertions.assertArrayEquals(expected, c);
    }
}