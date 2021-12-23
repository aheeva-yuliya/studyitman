package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringArrayListTests {
    @Nested
    public class SetAndGet {
        @Test
        public void shouldSetAndGetWhenTrySetAndGetAtFirstIndex() {
            StringArrayList a = StringArrayList.of("hello", "hi", "bye");
            a.set(0, "hi");
            Assertions.assertEquals("hi", a.get(0));
        }

        @Test
        public void shouldSetAndGetWhenTrySetAndGetNull() {
            StringArrayList a = StringArrayList.of("hello", "hi", "bye");
            a.set(0, null);
            Assertions.assertNull(a.get(0));
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnCorrectSizeWhenAdding() {
            StringArrayList a = StringArrayList.of("hello", "hi", "bye");
            Assertions.assertEquals(3, a.size());
            a.add("morning");
            Assertions.assertEquals(4, a.size());

        }
    }

    @Nested
    public class Add {
        @Test
        public void shouldAddWhenListEmptyAndNotEmpty() {
            StringArrayList a = new StringArrayList();
            a.add("hello");
            a.add("hi");
            Assertions.assertEquals("hello", a.get(0));
            Assertions.assertEquals("hi", a.get(1));
        }

        @Test
        public void shouldAddWhenTryAddNull() {
            StringArrayList a = new StringArrayList();
            a.add("hello");
            a.add(null);
            a.add("hi");
            Assertions.assertNull(a.get(1));
        }
    }

    @Nested
    public class ToArray {
        @Test
        public void shouldReturnArrayWhenListNotEmpty() {
            StringArrayList a = StringArrayList.of("hello", "hi", "bye");
            String[] expected = new String[]{"hello", "hi", "bye"};
            Assertions.assertArrayEquals(expected, a.toArray());
        }

        @Test
        public void shouldReturnArrayWhenTryAddNull() {
            StringArrayList a = new StringArrayList();
            a.add("hello");
            a.add(null);
            String[] expected = new String[]{"hello", null};
            Assertions.assertArrayEquals(expected, a.toArray());
        }
    }

    @Nested
    public class Remove {
        @Test
        public void shouldRemoveWhenTryRemoveFromMiddle() {
            StringArrayList a = StringArrayList.of("hello", "hi", "bye");
            String expected = "hi";
            Assertions.assertEquals(expected, a.remove(1));
            String expectedString = "[hello, bye]";
            Assertions.assertEquals(expectedString, a.toString());
        }

        @Test
        public void shouldRemoveWhenTryRemoveFromFirstANdLastIndexes() {
            StringArrayList a = StringArrayList.of("hello", "hi", "bye");
            String expectedZero = "hello";
            Assertions.assertEquals(expectedZero, a.remove(0));
            String expectedLast = "bye";
            Assertions.assertEquals(expectedLast, a.remove(1));
            String expectedString = "[hi]";
            Assertions.assertEquals(expectedString, a.toString());
        }
    }

    @Nested
    public class Create {
        @Test
        public void shouldCreateWhenTryCreateOfSomeElements() {
            StringArrayList a = StringArrayList.of("hello", "hi", "bye");
            String[] expected = new String[]{"hello", "hi", "bye"};
            String[] actual = a.toArray();
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCreateWhenTryCreatOfNull() {
            StringArrayList a = StringArrayList.of("hello", null, "bye");
            String[] expected = new String[]{"hello", null, "bye"};
            String[] actual = a.toArray();
            Assertions.assertArrayEquals(expected, actual);
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenListContainsSomeElements() {
            StringArrayList a = StringArrayList.of("hello", "hi", "bye");
            String expected = "[hello, hi, bye]";
            String actual = a.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnStringWhenListContainsNull() {
            StringArrayList a = StringArrayList.of("hello", null, "bye");
            String expected = "[hello, null, bye]";
            String actual = a.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTueWhenListsContainSameElements() {
            StringArrayList a = StringArrayList.of("hello", null, "bye");
            StringArrayList b = StringArrayList.of("hello", null, "bye");
            Assertions.assertEquals(a, b);
        }

        @Test
        public void shouldReturnFalseWhenListsContainDifferentElements() {
            StringArrayList a = StringArrayList.of("hello", null, "bye");
            StringArrayList b = StringArrayList.of("hello", "hi-hi", "bye");
            Assertions.assertNotEquals(a, b);
        }
    }

    @Nested
    public class Clear {
        @Test
        public void shouldClearWhenListNotEmpty() {
            StringArrayList a = new StringArrayList();
            a.add("hello");
            a.clear();
            String expected = "[]";
            String actual = a.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class TrimToSize {
        @Test
        public void shouldTrimToSizeWhenCapacityGreaterThanSize() {
            StringArrayList a = new StringArrayList();
            a.add("hello");
            a.trimToSize();
            Assertions.assertEquals(1, a.size());
        }
    }
}