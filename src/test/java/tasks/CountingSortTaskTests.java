package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountingSortTaskTests {

    @Test
    public void countNormalCase() {
        int[] array = new int[]{6, 2, 8, 1, 1, 5, 7, 9, 3, 4};
        int[] expected = new int[]{0, 2, 1, 1, 1, 1, 1, 1, 1, 1};
        Assertions.assertArrayEquals(expected, CountingSortTask.count(array));
    }

    @Test
    public void countIfZeroElements() {
        int[] array = new int[]{};
        Assertions.assertNotNull(CountingSortTask.count((array)));
    }

    @Test
    public void countSame() {
        int[] array = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] expected = new int[]{0, 0, 9};
        Assertions.assertArrayEquals(expected, CountingSortTask.count(array));
    }

    @Test
    public void restoreNormalCase() {
        int[] array = new int[]{0, 2, 1, 1, 0, 1};
        int[] expected = new int[]{1, 1, 2, 3, 5};
        Assertions.assertArrayEquals(expected, CountingSortTask.restore(array));
    }

    @Test
    public void restoreIfZeroElements() {
        int[] array = new int[]{};
        Assertions.assertNotNull(CountingSortTask.restore(array));
    }

    @Test
    public void restoreMaxOfPossible() {
        int[] array = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] expected = new int[]{
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
                7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
                8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        Assertions.assertArrayEquals(expected, CountingSortTask.restore(array));
    }

    @Test
    public void sortNormalCase() {
        int[] array = new int[]{5, 9, 7, 9, 5, 10, 3};
        int[] expected = new int[] {3, 5, 5, 7, 9, 9, 10};
        CountingSortTask.sort(array);
        Assertions.assertArrayEquals(expected, array);
    }
}