package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class IntArrayListTests {
    @Nested
    public class Set {
        @Test
        public void shouldSetWhenTrySetFirstAndThirdElements() {
            IntArrayList a = new IntArrayList(5);
            a.add(5);
            a.add(5);
            a.add(5);
            a.set(0, 10);
            a.set(2, 10);
            int[] expected = new int[]{10, 5, 10};
            int[] actual = a.toArray();
            Assertions.assertArrayEquals(expected, actual);
        }
    }

    @Nested
    public class Get {
        @Test
        public void shouldGetWhenTryGetSecondElement() {
            IntArrayList a = new IntArrayList(3);
            a.add(5);
            a.add(10);
            a.add(20);
            Assertions.assertEquals(10, a.get(1));
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnZeroWhenArraySizeZero() {
            IntArrayList a = new IntArrayList(5);
            Assertions.assertEquals(0, a.size());
        }

        @Test
        public void shouldReturnTwoWhenArraySizeTwo() {
            IntArrayList a = new IntArrayList(5);
            a.add(5);
            a.add(10);
            Assertions.assertEquals(2, a.size());
        }
    }

    @Nested
    public class Add {
        @Test
        public void shouldAddWhenLengthIsOne() {
            IntArrayList a = new IntArrayList(1);
            a.add(10);
            a.add(20);
            a.add(30);
            int[] expected = new int[]{10, 20, 30};
            Assertions.assertArrayEquals(expected, a.toArray());
        }

        @Test
        public void shouldAddWhenCapacityMultipliesByTwo() {
            IntArrayList a = new IntArrayList(1);
            a.add(2);
            a.add(7);
            a.add(1);
            a.add(3);
            a.add(8);
            a.add(4);
            int[] expected = new int[]{2, 7, 1, 3, 8, 4};
            Assertions.assertArrayEquals(expected, a.toArray());
        }
    }

    @Nested
    public class Remove {
        @Test
        public void shouldRemoveWhenTryRemoveFromTheFirstIndex() {
            IntArrayList a = new IntArrayList(4);
            a.add(1);
            a.add(2);
            a.add(3);
            a.add(4);
            int b = a.remove(1);
            int[] expected = new int[]{1, 3, 4};
            Assertions.assertArrayEquals(expected, a.toArray());
            Assertions.assertEquals(2, b);
        }

        @Test
        public void shouldRemoveWhenTryRemoveFromTheLastIndex() {
            IntArrayList a = new IntArrayList(4);
            a.add(1);
            a.add(2);
            a.add(3);
            a.add(4);
            int b = a.remove(3);
            int[] expected = new int[]{1, 2, 3};
            Assertions.assertArrayEquals(expected, a.toArray());
            Assertions.assertEquals(4, b);
        }

        @Test
        public void shouldRemoveWhenTryRemoveFromTheFirstAndZeroIndexes() {
            IntArrayList a = new IntArrayList(4);
            a.add(1);
            a.add(2);
            a.add(3);
            a.add(4);
            int b = a.remove(1);
            int[] expected = new int[]{1, 3, 4};
            int[] actual = a.toArray();
            Assertions.assertArrayEquals(expected, actual);
            Assertions.assertEquals(2, b);
            int c = a.remove(0);
            expected = new int[]{3, 4};
            actual = a.toArray();
            Assertions.assertEquals(1, c);
            Assertions.assertArrayEquals(expected, actual);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenArrayListsContainEqualElements() {
            IntArrayList a = new IntArrayList(3);
            a.add(1);
            a.add(2);
            a.add(3);
            IntArrayList b = new IntArrayList(3);
            b.add(3);
            b.add(2);
            b.add(3);
            b.set(0, 1);
            Assertions.assertEquals(a, b);
        }

        @Test
        public void shouldReturnFalseWhenArrayListsContainDifferentElements() {
            IntArrayList a = new IntArrayList(3);
            a.add(1);
            a.add(2);
            a.add(3);
            IntArrayList b = new IntArrayList(3);
            b.add(3);
            b.add(2);
            b.add(3);
            Assertions.assertNotEquals(a, b);
        }

        @Test
        public void shouldReturnTrueWhenArrayListsContainSameElementsButDifferentCapacities() {
            IntArrayList a = new IntArrayList(1);
            IntArrayList b = new IntArrayList(2);
            Assertions.assertEquals(a, b);
        }

        @Test
        public void shouldReturnFalseWhenThatIsNull() {
            IntArrayList a = new IntArrayList(3);
            a.add(1);
            a.add(2);
            a.add(3);
            Assertions.assertNotEquals(a, null);
        }
    }

    @Nested
    public class Sort {
        @Test
        public void shouldSortInAscendingOrderWhenTrySortDifferentElements() {
            IntArrayList a = new IntArrayList(3);
            a.add(8);
            a.add(3);
            a.add(6);
            a.add(1);
            a.add(2);
            a.sort();
            int[] expected = new int[]{1, 2, 3, 6, 8};
            Assertions.assertArrayEquals(expected, a.toArray());
        }

        @Test
        public void shouldSortWhenTrySortSameElements() {
            IntArrayList a = new IntArrayList(3);
            a.add(8);
            a.add(8);
            a.add(8);
            a.sort();
            int[] expected = new int[]{8, 8, 8};
            int[] actual = a.toArray();
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldSortUsingMergeSortWhenTrySort() {
            IntArrayList a = IntArrayList.of(7, 18, 9, -5, 8, 9, 90, 0, 54, 78, 99, 75, 89, 82, -76);
            a.add(7);
            a.add(22);
            a.sort();
            int[] expected = new int[] {-76, -5, 0, 7, 7, 8, 9, 9, 18, 22, 54, 75, 78, 82, 89, 90, 99};
            Assertions.assertArrayEquals(expected, a.toArray());
        }
    }

    @Nested
    public class Create {
        @Test
        public void shouldCreateWhenTryCreateFromAnObject() {
            IntArrayList first = new IntArrayList();
            first.set(0, 10);
            first.set(1, 20);
            IntArrayList second = new IntArrayList(first);
            Assertions.assertTrue(first.equals(second));
        }

        @Test
        public void shouldCreateWhenTryCreateOfElements() {
            int[] a = new int[]{-1, 1, 5};
            IntArrayList actual = IntArrayList.of(a);
            a[1] = 0;
            int[] expected = new int[]{-1, 1, 5};
            Assertions.assertArrayEquals(expected, actual.toArray());
        }

        @Test
        public void shouldCreateWhenTryCreateOfNil() {
            IntArrayList a = IntArrayList.of();
            int[] expected = new int[]{};
            int[] actual = a.toArray();
            Assertions.assertArrayEquals(expected, actual);
            Assertions.assertEquals(0, a.size());
        }

        @Test
        public void shouldCreateAndCheckIfEqualWhenTryCreateOfElements() {
            IntArrayList a = IntArrayList.of(-1, 1, 5);
            IntArrayList b = IntArrayList.of(-1, 1, 5);
            Assertions.assertTrue(a.equals(b));
        }

        @Test
        public void shouldCreateOneWhenTryCreateOfElementsAndCreateAnotherWhenTryAdd() {
            final IntArrayList a = IntArrayList.of(-1, 1, 5);
            final IntArrayList b = new IntArrayList(5);
            b.add(-1);
            b.add(1);
            b.add(5);
            Assertions.assertTrue(a.equals(b));
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldMakeAStringWhenTryDoItUsingStringBuilder() {
            IntArrayList a = IntArrayList.of(8, 9, 7, 6, 2, 3, 5, 4);
            Assertions.assertEquals("[8, 9, 7, 6, 2, 3, 5, 4]", a.toString());
        }

        @Test
        public void shouldMakeAStringWhenEmptyArray() {
            IntArrayList a = IntArrayList.of();
            Assertions.assertEquals("[]", a.toString());
        }

        @Test
        public void shouldMakeAStringWhenLengthIsOne() {
            IntArrayList a = IntArrayList.of(1);
            Assertions.assertEquals("[1]", a.toString());
        }
    }

    @Nested
    public class Clear {
        @Test
        public void shouldClearWhenArrayContainsSomeElements() {
            IntArrayList a = IntArrayList.of(7, 18, 9, -5, 8, 9, 90, 0);
            a.clear();
            Assertions.assertEquals(0, a.size());
        }

        @Test
        public void shouldClearWhenArrayEmpty() {
            IntArrayList a = new IntArrayList();
            a.clear();
            Assertions.assertEquals(0, a.size());
        }
    }

    @Nested
    public class TrimToSize {
        @Test
        public void shouldTrimToSizeWhenCapacityGreaterThanSize() {
            IntArrayList a = new IntArrayList();
            a.add(100);
            Assertions.assertEquals(0, a.get(1));
            a.trimToSize();
            Assertions.assertEquals(1, a.size());
        }
    }
}