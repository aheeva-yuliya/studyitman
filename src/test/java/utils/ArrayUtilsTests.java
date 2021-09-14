package utils;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayUtilsTests {

    @Test
    public void bubbleSortEventsYear() {
        Event[] events = new Event[] {
            new Event(1991, 9, 8, "0"),
            new Event(1992, 2, 20, "1"),
            new Event(2018, 8, 9, "2")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        expected[1] = events[1];
        expected[2] = events[2];
        ArrayUtils.bubbleSort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void bubbleSortEventsMonth() {
        Event[] events = new Event[] {
            new Event(1991, 9, 8, "0"),
            new Event(1991, 2, 20, "1"),
            new Event(1991, 8, 9, "2")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[1];
        expected[1] = events[2];
        expected[2] = events[0];
        ArrayUtils.bubbleSort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void bubbleSortEventsDay() {
        Event[] events = new Event[] {
                new Event(1991, 9, 8, "0"),
                new Event(1991, 9, 20, "1"),
                new Event(1991, 9, 9, "2")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        expected[1] = events[2];
        expected[2] = events[1];
        ArrayUtils.bubbleSort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void bubbleSortEventsSameDay() {
        Event[] events = new Event[] {
                new Event(1991, 9, 8, "0"),
                new Event(1991, 9, 20, "1"),
                new Event(1991, 9, 8, "2")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        expected[1] = events[2];
        expected[2] = events[1];
        ArrayUtils.bubbleSort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void bubbleSortEventsEmpty() {
        Event[] events = new Event[] {};
        ArrayUtils.bubbleSort(events);
        Assertions.assertNotNull(events);
    }

    @Test
    public void bubbleSortEventsOne() {
        Event[] events = new Event[] {
            new Event(1991, 9, 8, "this")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        ArrayUtils.bubbleSort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void bubbleSortEventsOfTwo() {
        Event[] events = new Event[] {
                new Event(1, 10, 3, "0"),
                new Event(2020, 10, 2, "1")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        expected[1] = events[1];
        ArrayUtils.bubbleSort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void bubbleSortEventsOfThree() {
        Event[] events = new Event[] {
                new Event(1, 10, 3, "0"),
                new Event(2020, 10, 2, "1"),
                new Event (1, 11, 2, "2")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        expected[1] = events[2];
        expected[2] = events[1];
        ArrayUtils.bubbleSort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void bubbleSortSomeSameElements() {
        int[] a = new int[] {9, 8, 3, 3, 5, 7};
        int[] expected = new int[] {3, 3, 5, 7, 8, 9};
        ArrayUtils.bubbleSort(a);
        Assertions.assertArrayEquals(expected, a);
    }

    @Test
    public void countingSortIfZeroElements() {
        int[] a = new int[] {};
        ArrayUtils.countingSort(a);
        Assertions.assertNotNull(a);
    }

    @Test
    public void countingSort() {
        int[] a = new int[] {9, 3, 7, 3, 2, 8, 1, 6, 6, 3};
        int[] expected = new int[] {1, 2, 3, 3, 3, 6, 6, 7, 8, 9};
        ArrayUtils.countingSort(a);
        Assertions.assertArrayEquals(expected, a);
    }

    @Test
    public void countSortLongNumbers() {
        int[] a = new int[] {2147483647, 2146483648, 2147483647, 2147483647, 2147483646};
        int[] expected = new int[] {2146483648, 2147483646, 2147483647, 2147483647,2147483647};
        ArrayUtils.countingSort(a);
        Assertions.assertArrayEquals(expected, a);
    }
}