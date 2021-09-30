package tasks;

import benchmarks.SortBenchmark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task510Tests {

    @Test
    public void mostFrequentIfSome() {
        int[] a = new int[] {1, 2, 5, 1, 2, 2, 3, 1};
        Assertions.assertEquals(1, Task510.mostFrequent(a));
    }

    @Test
    public void mostFrequentIfLengthIsOne() {
        int[] a = new int[] {1};
        Assertions.assertEquals(1, Task510.mostFrequent(a));
    }

    @Test
    public void mostFrequentIfLengthIsTwo() {
        int[] a = new int[] {1, 2};
        Assertions.assertEquals(1, Task510.mostFrequent(a));
    }
}