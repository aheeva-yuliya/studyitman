package utils;

import benchmarks.SortBenchmark;
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
        for(int i = 0; i < events.length; i++) {
            Assertions.assertSame(expected[i], events[i]);
        }
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
        for(int i = 0; i < events.length; i++) {
            Assertions.assertSame(expected[i], events[i]);
        }
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
        for(int i = 0; i < events.length; i++) {
            Assertions.assertSame(expected[i], events[i]);
        }
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
        for(int i = 0; i < events.length; i++) {
            Assertions.assertSame(expected[i], events[i]);
        }
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
        for(int i = 0; i < events.length; i++) {
            Assertions.assertSame(expected[i], events[i]);
        }
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
        for(int i = 0; i < events.length; i++) {
            Assertions.assertSame(expected[i], events[i]);
        }
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
        for(int i = 0; i < events.length; i++) {
            Assertions.assertSame(expected[i], events[i]);
        }
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

    @Test
    public void distinctNormalCase() {
        int[] a = new int[] {1, 2, 5, -10, 3, 2, 1, 4};
        int[] expected = new int[] {1, 2, 5, -10, 3, 4};
        Assertions.assertArrayEquals(expected, ArrayUtils.distinct(a));
    }

    @Test
    public void distinctLongNumbers() {
        int[] a = new int[] {2147483647, 2146483648, 2147483647, 2147483647, 2147483646};
        int[] expected = new int[] {2147483647, 2146483648, 2147483646};
        Assertions.assertArrayEquals(expected, ArrayUtils.distinct(a));
    }

    @Test
    public void distinctMaximumElements() {
        int[] a = SortBenchmark.randomArray(1000000, 1, 2);
        int[] expected = new int[] {1};
        Assertions.assertArrayEquals(expected, ArrayUtils.distinct(a));
    }

    @Test
    public void distinctIfZeroElements() {
        int[] a = new int[] {};
        Assertions.assertNotNull(ArrayUtils.distinct(a));
    }

    @Test
    public void mostFrequentFindIfAny() {
        int[] a = new int[] {2, 1, 2, 5, 1, 2, 3, 1};
        Assertions.assertEquals(1, ArrayUtils.mostFrequent(a));
    }

    @Test
    public void mostFrequentFindIfItsMax() {
        int[] a = new int[] {2, 1, 2, 5, 1, 2, 3, 1, 5, 5, 5};
        Assertions.assertEquals(5, ArrayUtils.mostFrequent(a));
    }

    @Test
    public void mostFrequentFindIfItsMin() {
        int[] a = new int[] {2, 1, 2, 5, 1, 2, 3, 1, 5};
        Assertions.assertEquals(1, ArrayUtils.mostFrequent(a));
    }

    @Test
    public void countEqualsNormalCase() {
        int[] a = new int[] {1, 1, 3, 2, 1};
        int[] b = new int[] {4, 2, 1, 4, 1, 2};
        Assertions.assertEquals(3, ArrayUtils.countEquals(a, b));
    }

    @Test
    public void countEqualsNormalCaseAnother() {
        int[] a = new int[] {5, 1, 3, 1, 1, 4, 6, 9, 8};
        int[] b = new int[] {3, 6, 8, 0, 0, 5, 0, 0, 1, 0, 0, 0, 20};
        Assertions.assertEquals(5, ArrayUtils.countEquals(a, b));
    }

    @Test
    public void countEqualsIfZero() {
        int[] a = new int[] {1, 1, 3, 2, 1};
        int[] b = new int[] {5, 7, 9, 18, 54, 9};
        Assertions.assertEquals(0, ArrayUtils.countEquals(a, b));
    }

    @Test
    public void countEqualsIfAll() {
        int[] a = new int[] {1, 1, 1, 1, 1};
        int[] b = new int[] {1, 1, 1, 1, 1};
        Assertions.assertEquals(5, ArrayUtils.countEquals(a, b));
    }

    @Test
    public void countEqualsIfNull() {
        int[] a = new int[] {};
        int[] b = new int[] {};
        Assertions.assertEquals(0, ArrayUtils.countEquals(a, b));
    }

    @Test
    public void countEqualsBigNumbers() {
        int[] a = new int[] {-1000000000};
        int[] b = new int[] {1000000000};
        Assertions.assertEquals(0, ArrayUtils.countEquals(a, b));
    }

    @Test
    public void countEqualsMaximumLengthAndZeroEquality() {
        int[] a = SortBenchmark.randomArray(1000000, 0, 1000000);
        int[] b = SortBenchmark.randomArray(1000000, -1000000, 0);
        Assertions.assertEquals(0, ArrayUtils.countEquals(a, b));
    }

    @Test
    public void countEqualsMaximumLength() {
        int[] a = SortBenchmark.randomArray(1000000, 0, 1000);
        int[] b = SortBenchmark.randomArray(1000000, 0, 1000);
        Assertions.assertEquals(1000000, ArrayUtils.countEquals(a, b));
    }

    @Test
    public void countingSortForEvents() {
        Event[] events = new Event[] {
                new Event(0, 0, 9, "something"),
                new Event(0, 0, 8, "y"),
                new Event(0, 0, 9, "l"),
                new Event(0, 0, 20, "i")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[1];
        expected[1] = events[0];
        expected[2] = events[2];
        expected[3] = events[3];
        ArrayUtils.countingSort(events);
        for(int i = 0; i < events.length; i++) {
            Assertions.assertSame(expected[i], events[i]);
        }
    }

    @Test
    public void countingSortForEventsNormalCase() {
        Event[] events = new Event[] {
            new Event(2018, 8, 9, "something"),
            new Event(1991, 9, 8, "y"),
            new Event(2018, 8, 9, "l"),
            new Event(1992, 2, 20, "i"),
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[1];
        expected[1] = events[3];
        expected[2] = events[0];
        expected[3] = events[2];
        ArrayUtils.countingSort(events);
        for (int i = 0; i < events.length; i++) {
            Assertions.assertTrue(events[i].equals(expected[i]));
        }
    }
}