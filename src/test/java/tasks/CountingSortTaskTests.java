package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTaskTests {

    @Test
    public void countNormalCase() {
        int[] array = new int[] {6, 2, 8, 1, 1, 5, 7, 9, 3, 4};
        int[] expected = new int[] {0, 2, 1, 1, 1, 1, 1, 1, 1, 1};
        Assertions.assertArrayEquals(expected, CountingSortTask.count(array));
    }

    @Test
    public void countIfZeroElements() {
        int[] array = new int[]{};
        int[] expected = new int[] {0};
        Assertions.assertArrayEquals(expected,CountingSortTask.count((array)));
    }

    @Test
    public void countSame() {
        int[] array = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] expected = new int[] {0, 0, 9};
        Assertions.assertArrayEquals(expected, CountingSortTask.count(array));
    }
}