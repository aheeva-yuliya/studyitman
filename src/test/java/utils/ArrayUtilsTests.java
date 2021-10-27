package utils;

import benchmarks.SortBenchmark;
import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTests {
    @Nested
    public class BubbleSort {
        @Test
        public void shouldSortEventsWhenDependsOnYear() {
            Event[] events = new Event[]{
                    new Event(1991, 9, 8, "0"),
                    new Event(1992, 2, 20, "1"),
                    new Event(2018, 8, 9, "2")
            };
            Event[] expected = new Event[events.length];
            expected[0] = events[0];
            expected[1] = events[1];
            expected[2] = events[2];
            ArrayUtils.bubbleSort(events);
            for (int i = 0; i < events.length; i++) {
                Assertions.assertSame(expected[i], events[i]);
            }
        }

        @Test
        public void shouldSortEventsWhenDependsOnMonth() {
            Event[] events = new Event[]{
                    new Event(1991, 9, 8, "0"),
                    new Event(1991, 2, 20, "1"),
                    new Event(1991, 8, 9, "2")
            };
            Event[] expected = new Event[events.length];
            expected[0] = events[1];
            expected[1] = events[2];
            expected[2] = events[0];
            ArrayUtils.bubbleSort(events);
            for (int i = 0; i < events.length; i++) {
                Assertions.assertSame(expected[i], events[i]);
            }
        }

        @Test
        public void shouldSortEventsWhenDependsOnDay() {
            Event[] events = new Event[]{
                    new Event(1991, 9, 8, "0"),
                    new Event(1991, 9, 20, "1"),
                    new Event(1991, 9, 9, "2")
            };
            Event[] expected = new Event[events.length];
            expected[0] = events[0];
            expected[1] = events[2];
            expected[2] = events[1];
            ArrayUtils.bubbleSort(events);
            for (int i = 0; i < events.length; i++) {
                Assertions.assertSame(expected[i], events[i]);
            }
        }

        @Test
        public void shouldSortEventsWhenSameDate() {
            Event[] events = new Event[]{
                    new Event(1991, 9, 8, "0"),
                    new Event(1991, 9, 20, "1"),
                    new Event(1991, 9, 8, "2")
            };
            Event[] expected = new Event[events.length];
            expected[0] = events[0];
            expected[1] = events[2];
            expected[2] = events[1];
            ArrayUtils.bubbleSort(events);
            for (int i = 0; i < events.length; i++) {
                Assertions.assertSame(expected[i], events[i]);
            }
        }

        @Test
        public void shouldSortEventsWhenEmpty() {
            Event[] events = new Event[]{};
            ArrayUtils.bubbleSort(events);
            Assertions.assertNotNull(events);
        }

        @Test
        public void shouldSortEventsWhenOne() {
            Event[] events = new Event[]{
                    new Event(1991, 9, 8, "this")
            };
            Event[] expected = new Event[events.length];
            expected[0] = events[0];
            ArrayUtils.bubbleSort(events);
            for (int i = 0; i < events.length; i++) {
                Assertions.assertSame(expected[i], events[i]);
            }
        }

        @Test
        public void shouldSortEventsWhenTwo() {
            Event[] events = new Event[]{
                    new Event(1, 10, 3, "0"),
                    new Event(2020, 10, 2, "1")
            };
            Event[] expected = new Event[events.length];
            expected[0] = events[0];
            expected[1] = events[1];
            ArrayUtils.bubbleSort(events);
            for (int i = 0; i < events.length; i++) {
                Assertions.assertSame(expected[i], events[i]);
            }
        }

        @Test
        public void shouldSortEventsWhenThree() {
            Event[] events = new Event[]{
                    new Event(1, 10, 3, "0"),
                    new Event(2020, 10, 2, "1"),
                    new Event(1, 11, 2, "2")
            };
            Event[] expected = new Event[events.length];
            expected[0] = events[0];
            expected[1] = events[2];
            expected[2] = events[1];
            ArrayUtils.bubbleSort(events);
            for (int i = 0; i < events.length; i++) {
                Assertions.assertSame(expected[i], events[i]);
            }
        }

        @Test
        public void shouldSortWhenSomeSameElements() {
            int[] a = new int[]{9, 8, 3, 3, 5, 7};
            int[] expected = new int[]{3, 3, 5, 7, 8, 9};
            ArrayUtils.bubbleSort(a);
            Assertions.assertArrayEquals(expected, a);
        }
    }

    @Nested
    public class CountingSort {
        @Test
        public void shouldSortWhenZeroElements() {
            int[] a = new int[]{};
            ArrayUtils.countingSort(a);
            Assertions.assertNotNull(a);
        }

        @Test
        public void shouldSortWhenSomeDifferentElements() {
            int[] a = new int[]{9, 3, 7, 3, 2, 8, 1, 6, 6, 3};
            int[] expected = new int[]{1, 2, 3, 3, 3, 6, 6, 7, 8, 9};
            ArrayUtils.countingSort(a);
            Assertions.assertArrayEquals(expected, a);
        }

        @Test
        public void shouldSortWhenLongNumbers() {
            int[] a = new int[]{2147483647, 2146483648, 2147483647, 2147483647, 2147483646};
            int[] expected = new int[]{2146483648, 2147483646, 2147483647, 2147483647, 2147483647};
            ArrayUtils.countingSort(a);
            Assertions.assertArrayEquals(expected, a);
        }

        @Nested
        public class Distinct {
            @Test
            public void shouldDistinctWhenHasSome() {
                int[] a = new int[]{1, 2, 5, -10, 3, 2, 1, 4};
                int[] expected = new int[]{1, 2, 5, -10, 3, 4};
                Assertions.assertArrayEquals(expected, ArrayUtils.distinct(a));
            }

            @Test
            public void shouldDistinctWhenLongNumbers() {
                int[] a = new int[]{2147483647, 2146483648, 2147483647, 2147483647, 2147483646};
                int[] expected = new int[]{2147483647, 2146483648, 2147483646};
                Assertions.assertArrayEquals(expected, ArrayUtils.distinct(a));
            }

            @Test
            public void shouldDistinctWhenOneElement() {
                int[] a = SortBenchmark.randomArray(100, 1, 2);
                int[] expected = new int[]{1};
                Assertions.assertArrayEquals(expected, ArrayUtils.distinct(a));
            }

            @Test
            public void shouldDistinctWhenZeroElements() {
                int[] a = new int[]{};
                Assertions.assertNotNull(ArrayUtils.distinct(a));
            }
        }

        @Nested
        public class MostFrequent {
            @Test
            public void shouldFindMostFrequentWhenSome() {
                int[] a = new int[]{2, 1, 2, 5, 1, 2, 3, 1};
                Assertions.assertEquals(1, ArrayUtils.mostFrequent(a));
            }

            @Test
            public void shouldFindMostFrequentWhenItsMax() {
                int[] a = new int[]{2, 1, 2, 5, 1, 2, 3, 1, 5, 5, 5};
                Assertions.assertEquals(5, ArrayUtils.mostFrequent(a));
            }

            @Test
            public void shouldFindMostFrequentWhenItsMin() {
                int[] a = new int[]{2, 1, 2, 5, 1, 2, 3, 1, 5};
                Assertions.assertEquals(1, ArrayUtils.mostFrequent(a));
            }
        }

        @Nested
        public class CountEquals {
            @Test
            public void shouldCountEqualsWhenSomeEqual() {
                int[] a = new int[]{1, 1, 3, 2, 1};
                int[] b = new int[]{4, 2, 1, 4, 1, 2};
                Assertions.assertEquals(3, ArrayUtils.countEquals(a, b));
            }

            @Test
            public void shouldCountEqualsWhenZeroEquals() {
                int[] a = new int[]{1, 1, 3, 2, 1};
                int[] b = new int[]{5, 7, 9, 18, 54, 9};
                Assertions.assertEquals(0, ArrayUtils.countEquals(a, b));
            }

            @Test
            public void shouldCountEqualsWhenAllEqual() {
                int[] a = new int[]{1, 1, 1, 1, 1};
                int[] b = new int[]{1, 1, 1, 1, 1};
                Assertions.assertEquals(5, ArrayUtils.countEquals(a, b));
            }

            @Test
            public void shouldCountEqualsWhenNull() {
                int[] a = new int[]{};
                int[] b = new int[]{};
                Assertions.assertEquals(0, ArrayUtils.countEquals(a, b));
            }

            @Test
            public void shouldCountEqualsWhenBigNumbers() {
                int[] a = new int[]{-1000000000};
                int[] b = new int[]{1000000000};
                Assertions.assertEquals(0, ArrayUtils.countEquals(a, b));
            }

            @Test
            public void shouldCountEqualsWhenZeroEquality() {
                int[] a = SortBenchmark.randomArray(1000, 0, 1000000);
                int[] b = SortBenchmark.randomArray(1000, -1000000, 0);
                Assertions.assertEquals(0, ArrayUtils.countEquals(a, b));
            }

            @Test
            public void shouldCountEqualsWhenGreaterLength() {
                int[] a = SortBenchmark.randomArray(1000, 0, 1000);
                int[] b = SortBenchmark.randomArray(1000, 0, 1000);
                Assertions.assertEquals(1000, ArrayUtils.countEquals(a, b));
            }
        }

        @Nested
        public class CountingSortEvents {
            @Test
            public void shouldSortEventsWhenDependsOnDay() {
                Event[] events = new Event[]{
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
                for (int i = 0; i < events.length; i++) {
                    Assertions.assertSame(expected[i], events[i]);
                }
            }

            @Test
            public void shouldSortEventsWhenDependsOnOrder() {
                Event[] events = new Event[]{
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
    }

    @Nested
    public class BinarySearch {
        @Test
        public void shouldSearchWhenStandsAtZeroIndexAndOddLength() {
            int[] array = new int[]{20, 30, 40, 50, 60, 70, 80};
            Assertions.assertEquals(0, ArrayUtils.binarySearch(array, 20));
        }

        @Test
        public void souldSearchAtZeroIndexWhenEvenLength() {
            int[] array = new int[]{20, 30, 40, 50, 60, 70, 80, 90};
            Assertions.assertEquals(0, ArrayUtils.binarySearch(array, 20));
        }

        @Test
        public void shouldSearchAtLastIndexWhenOddLength() {
            int[] array = new int[]{20, 30, 40, 50, 60, 70, 80};
            Assertions.assertEquals(6, ArrayUtils.binarySearch(array, 80));
        }

        @Test
        public void shouldSearchAtLastIndexWhenEvenLength() {
            int[] array = new int[]{20, 30, 40, 50, 60, 70, 80, 90};
            Assertions.assertEquals(7, ArrayUtils.binarySearch(array, 90));
        }

        @Test
        public void shouldSearchAtMiddleIndexWhenOddLength() {
            int[] array = new int[]{20, 30, 40, 50, 60, 70, 80};
            Assertions.assertEquals(3, ArrayUtils.binarySearch(array, 50));
        }

        @Test
        public void shouldSearchAtMiddleIndexWhenEvenLength() {
            int[] array = new int[]{20, 30, 40, 50, 60, 70, 80, 90};
            Assertions.assertEquals(3, ArrayUtils.binarySearch(array, 50));
        }

        @Test
        public void shouldSearchFromLeftWhenEvenLength() {
            int[] array = new int[]{20, 30, 40, 50, 60, 70, 80, 90};
            Assertions.assertEquals(1, ArrayUtils.binarySearch(array, 30));
        }

        @Test
        public void shouldSearchFromRightWhenOddLength() {
            int[] array = new int[]{20, 30, 40, 50, 60, 70, 80, 90, 100};
            Assertions.assertEquals(7, ArrayUtils.binarySearch(array, 90));
        }

        @Test
        public void shouldSearchWhenNoElement() {
            int[] array = new int[]{1, 3, 5, 7};
            Assertions.assertEquals(0, ArrayUtils.binarySearch(array, 1));
            Assertions.assertEquals(-1, ArrayUtils.binarySearch(array, 0));
            Assertions.assertEquals(-2, ArrayUtils.binarySearch(array, 2));
            Assertions.assertEquals(-4, ArrayUtils.binarySearch(array, 6));
            Assertions.assertEquals(3, ArrayUtils.binarySearch(array, 7));
            Assertions.assertEquals(-5, ArrayUtils.binarySearch(array, 8));
        }

        @Test
        public void shouldSearchWhenNoElementInTheMiddle() {
            int[] array = new int[]{-1, 1, 1, 2, 3, 5, 5, 5, 10};
            Assertions.assertEquals(-9, ArrayUtils.binarySearch(array, 6));
        }

        @Test
        public void shouldSearchFromIndexToIndexWhenIsElement() {
            int[] array = new int[]{20, 30, 40, 50, 60, 70, 80, 90, 100};
            Assertions.assertEquals(4, ArrayUtils.binarySearch(array, 1, 6, 60));
        }

        @Test
        public void shouldSearchFromIndexToIndexWhenNoElement() {
            int[] array = new int[]{20, 30, 40, 50, 60, 70, 80, 90, 100};
            Assertions.assertEquals(-5, ArrayUtils.binarySearch(array, 1, 6, 55));
        }

        @Test
        public void shouldSearchFromIndexToIndexWhenAtLastIndex() {
            int[] array = new int[]{4, 10, 11, 11, 12, 12, 15};
            Assertions.assertEquals(-5, ArrayUtils.binarySearch(array, 0, 4, 12));
        }

        @Test
        public void shouldSearchWhenSameElements() {
            int[] array = new int[]{1, 2, 2, 2, 2, 3};
            Assertions.assertEquals(1, ArrayUtils.binarySearch(array, 2));
        }

        @Test
        public void shouldSearchWhenSameElementsAtMinIndex() {
            int[] array = new int[]{2, 2, 2, 2, 2, 3};
            Assertions.assertEquals(0, ArrayUtils.binarySearch(array, 2));
        }

        @Test
        public void shouldSearchWhenSameElementsAtFirstIndex() {
            int[] array = new int[]{1, 2, 2, 2, 2, 3};
            Assertions.assertEquals(1, ArrayUtils.binarySearch(array, 2));
        }

        @Test
        public void shouldSearchWhenSameElementsAndFindMinIndexInTheEnd() {
            int[] array = new int[]{2, 2, 2, 2, 3, 3};
            Assertions.assertEquals(4, ArrayUtils.binarySearch(array, 3));
        }

        @Test
        public void shouldSearchWhenSameElementsFindMinIndexFromTo() {
            int[] array = new int[]{2, 2, 2, 2, 3, 3};
            Assertions.assertEquals(1, ArrayUtils.binarySearch(array, 1, 3, 2));
        }
    }

    @Nested
    public class MergeSort {
        @Nested
        public class Merge {
            @Test
            public void shouldMergeWhenIntegersNormalCase() {
                int[] a = new int[]{100, 2, 4, 5, -7};
                int[] b = new int[]{-7, 2, 3};
                int[] r = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
                ArrayUtils.merge(a, 1, 4, b, 1, 3, r, 2);
                int[] expected = new int[]{1, 1, 2, 2, 3, 4, 5, 1};
                Assertions.assertArrayEquals(expected, r);
            }

            @Test
            public void shouldMergeEventsWhenDifferentDates() {
                Event[] a = new Event[]{
                        new Event(1991, 9, 8, "y"),
                        new Event(1991, 9, 8, "smth"),
                        new Event(1992, 2, 20, "i"),
                        new Event(2018, 8, 9, "l")
                };
                Event[] b = new Event[]{
                        new Event(1993, 6, 14, "le"),
                        new Event(2017, 7, 22, "w"),
                        new Event(2019, 8, 9, "l1")
                };
                Event[] r = new Event[]{
                        new Event(0, 1, 1, "something"),
                        new Event(0, 1, 1, "something"),
                        new Event(0, 1, 1, "something"),
                        new Event(0, 1, 1, "something"),
                        new Event(0, 1, 1, "something"),
                        new Event(0, 1, 1, "something"),
                        new Event(0, 1, 1, "something"),
                        new Event(0, 1, 1, "something"),
                        new Event(0, 1, 1, "something"),
                };
                Event[] expected = new Event[r.length];
                expected[0] = r[0];
                expected[1] = a[0];
                expected[2] = a[1];
                expected[3] = a[2];
                expected[4] = b[0];
                expected[5] = b[1];
                expected[6] = a[3];
                expected[7] = b[2];
                expected[8] = r[8];
                ArrayUtils.merge(a, 0, 4, b, 0, 3, r, 1);
                for (int i = 0; i < r.length; i++) {
                    Assertions.assertSame(expected[i], r[i]);
                }
            }

            @Test
            public void shouldMergeEventsWhenSame() {
                Event[] a = new Event[]{
                        new Event(1991, 9, 8, "y"),
                };
                Event[] b = new Event[]{
                        new Event(1991, 9, 8, "smth"),

                };
                Event[] r = new Event[]{
                        new Event(1, 1, 1, "something"),
                        new Event(1, 1, 1, "something"),
                        new Event(1, 1, 1, "something"),
                        new Event(1, 1, 1, "something"),
                };
                Event[] expected = new Event[r.length];
                expected[0] = r[0];
                expected[1] = a[0];
                expected[2] = b[0];
                expected[3] = r[3];
                ArrayUtils.merge(a, 0, 1, b, 0, 1, r, 1);
                for (int i = 0; i < r.length; i++) {
                    Assertions.assertSame(expected[i], r[i]);
                }
            }
        }

        @Nested
        public class SortIntegers {
            @Test
            public void shouldMergeSortWhenNormalCase() {
                int[] a = new int[]{13, 9, 1, 4, 5, 2, 3, 9, 7, 0, 1};
                int[] expected = new int[]{0, 1, 1, 2, 3, 4, 5, 7, 9, 9, 13};
                ArrayUtils.mergeSort(a);
                Assertions.assertArrayEquals(expected, a);
            }

            @Test
            public void shouldMergeSortWhenHasMaxInteger() {
                int[] a = new int[]{2147483647, 0, 1073741823, -1073741824, -2147483648};
                int[] expected = new int[]{-2147483648, -1073741824, 0, 1073741823, 2147483647};
                ArrayUtils.mergeSort(a);
                Assertions.assertArrayEquals(expected, a);
            }

            @Test
            public void shouldMergeSortFromToWhenNormalCase() {
                int[] a = new int[]{13, 9, 1, 4, 5, 2, 3, 9, 7, 0, 1};
                int[] expected = new int[]{13, 9, 1, 2, 3, 4, 5, 9, 7, 0, 1};
                ArrayUtils.mergeSort(a, 3, 8);
                Assertions.assertArrayEquals(expected, a);
            }

            @Test
            public void shouldMergeSortFromZeroToLastWhenMaxValue() {
                int[] a = new int[]{2147483647, 0, 1073741823, -1073741824, -2147483648};
                int[] expected = new int[]{-2147483648, -1073741824, 0, 1073741823, 2147483647};
                ArrayUtils.mergeSort(a, 0, 5);
                Assertions.assertArrayEquals(expected, a);
            }
        }

        @Nested
        public class SortEvents {
            @Test
            public void shouldMergeSortEventsWhenDifferentDates() {
                Event[] a = new Event[]{
                        new Event(2018, 8, 9, "l"),
                        new Event(1991, 9, 8, "y"),
                        new Event(1992, 2, 20, "i"),
                        new Event(1991, 9, 8, "smth"),
                        new Event(1993, 6, 14, "le"),
                        new Event(2017, 7, 22, "w"),
                };
                Event[] expected = new Event[a.length];
                expected[0] = a[1];
                expected[1] = a[3];
                expected[2] = a[2];
                expected[3] = a[4];
                expected[4] = a[5];
                expected[5] = a[0];
                ArrayUtils.mergeSort(a);
                for (int i = 0; i < a.length; i++) {
                    Assertions.assertSame(expected[i], a[i]);
                }
            }

            @Test
            public void shouldMergeSortEventsFromToWhenNormalCase() {
                Event[] a = new Event[]{
                        new Event(2018, 8, 9, "l"),
                        new Event(1991, 9, 8, "y"),
                        new Event(1992, 2, 20, "i"),
                        new Event(1991, 9, 8, "smth"),
                        new Event(1993, 6, 14, "le"),
                        new Event(2017, 7, 22, "w"),
                };
                Event[] expected = new Event[a.length];
                expected[0] = a[0];
                expected[1] = a[1];
                expected[2] = a[3];
                expected[3] = a[2];
                expected[4] = a[4];
                expected[5] = a[5];
                ArrayUtils.mergeSort(a, 1, 5);
                for (int i = 0; i < a.length; i++) {
                    Assertions.assertSame(expected[i], a[i]);
                }
            }
        }
    }
}