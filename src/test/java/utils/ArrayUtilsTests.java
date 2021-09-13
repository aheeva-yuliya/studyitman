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
        int[] expected = new int[a.length];
        expected[0] = a[2];
        expected[1] = a[3];
        expected[2] = a[4];
        expected[3] = a[5];
        expected[4] = a[1];
        expected[5] = a[0];
        ArrayUtils.bubbleSort(a);
        Assertions.assertArrayEquals(expected, a);
    }
}