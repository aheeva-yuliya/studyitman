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
        Assertions.assertNotNull(CountingSortTask.count((array)));
    }

    @Test
    public void countSame() {
        int[] array = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] expected = new int[] {0, 0, 9};
        Assertions.assertArrayEquals(expected, CountingSortTask.count(array));
    }

    @Test
    public void restoreNormalCase() {
        int[] array = new int[] {0, 2, 1, 1, 0, 1};
        int[] expected = new int[] {1, 1, 2, 3, 5};
        Assertions.assertArrayEquals(expected, CountingSortTask.restore(array));
    }

    @Test
    public void restoreIfZeroElements() {
        int[] array = new int[]{};
        Assertions.assertNotNull(CountingSortTask.restore(array));
    }
}