package collections;

import entities.items.Game;
import entities.items.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ArrayListTests {
    @Nested
    public class SetAndGetTests {
        @Test
        public void shouldSetAndGetWhenTrySetAndGetStringAtZeroIndex() {
            final ArrayList a = ArrayList.of("hello", "hi", "bye");
            a.set(0, "hi");
            Assertions.assertEquals("hi", a.get(0));
        }

        @Test
        public void shouldSetAndGetWhenTrySetAndGetNull() {
            final ArrayList a = ArrayList.of("hello", "hi", "bye");
            a.set(0, null);
            Assertions.assertNull(a.get(0));
        }

        @Test
        public void shouldSetAndGetWhenTrySetAndGetAnObjectAtZeroIndex() {
            final ArrayList a = ArrayList.of("hello", "hi", "bye");
            final Object game = new Game(5, "t", 10, 1, 15);
            a.set(0, game);
            Assertions.assertEquals("Game{Item{id=5, title='t', price=10}, playersMin=1, playersMax=15}", a.get(0));
        }

    }

    @Nested
    public class SizeTest {
        @Test
        public void shouldReturnCorrectSizeWhenAdding() {
            final ArrayList a = ArrayList.of("hello", "hi", "bye");
            Assertions.assertEquals(3, a.size());
            a.add("morning");
            Assertions.assertEquals(4, a.size());
        }
    }

    @Nested
    public class AddTests {
        @Test
        public void shouldAddStringObjectWhenFirstListEmptyAndAfterNotEmpty() {
            final ArrayList a = new ArrayList();
            a.add("hello");
            a.add("hi");
            Assertions.assertEquals("hello", a.get(0));
            Assertions.assertEquals("hi", a.get(1));
        }

        @Test
        public void shouldAddDifferentObjectsAsStringWhenFirstListEmptyAndAfterNotEmpty() {
            final ArrayList a = new ArrayList();
            a.add(new Game(5, "t", 10, 1, 15));
            a.add(new Item(6, "title", 8));
            Assertions.assertEquals("Game{Item{id=5, title='t', price=10}, playersMin=1, playersMax=15}", a.get(0));
            Assertions.assertEquals("Item{id=6, title='title', price=8}", a.get(1));
        }

        @Test
        public void shouldAddWhenTryAddNull() {
            final ArrayList a = new ArrayList();
            a.add("hello");
            a.add(null);
            a.add("hi");
            Assertions.assertNull(a.get(1));
        }
    }

    @Nested
    public class ToArrayTests {
        @Test
        public void shouldReturnArrayWhenListNotEmpty() {
            final ArrayList a = ArrayList.of(
                    new Game(5, "t", 10, 1, 15),
                    new Item(6, "title", 8)
            );
            Object[] expected = new Object[]{
                    "Game{Item{id=5, title='t', price=10}, playersMin=1, playersMax=15}",
                    "Item{id=6, title='title', price=8}"
            };
            Assertions.assertArrayEquals(expected, a.toArray());
        }

        @Test
        public void shouldReturnArrayWhenTryAddNull() {
            final ArrayList a = new ArrayList();
            a.add("hello");
            a.add(null);
            Object[] expected = new Object[]{"hello", null};
            Assertions.assertArrayEquals(expected, a.toArray());
        }
    }

    @Nested
    public class RemoveTests {
        @Test
        public void shouldRemoveWhenTryRemoveFromMiddle() {
            ArrayList a = ArrayList.of("hello", "hi", "bye");
            String expected = "hi";
            Assertions.assertEquals(expected, a.remove(1));
            String expectedString = "[hello, bye]";
            Assertions.assertEquals(expectedString, a.toString());
        }

        @Test
        public void shouldRemoveWhenTryRemoveFromFirstANdLastIndexes() {
            ArrayList a = ArrayList.of("hello", "hi", "bye");
            String expectedZero = "hello";
            Assertions.assertEquals(expectedZero, a.remove(0));
            String expectedLast = "bye";
            Assertions.assertEquals(expectedLast, a.remove(1));
            String expectedString = "[hi]";
            Assertions.assertEquals(expectedString, a.toString());
        }
    }

    @Nested
    public class OfTests {
        @Test
        public void shouldCreateWhenTryCreateOfSomeElements() {
            ArrayList a = ArrayList.of("hello", "hi", "bye");
            Object[] expected = new String[]{"hello", "hi", "bye"};
            Object[] actual = a.toArray();
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCreateWhenTryCreateOfNull() {
            ArrayList a = ArrayList.of("hello", null, "bye");
            Object[] expected = new String[]{"hello", null, "bye"};
            Object[] actual = a.toArray();
            Assertions.assertArrayEquals(expected, actual);
        }
    }

    @Nested
    public class ToStringTests {
        @Test
        public void shouldReturnStringWhenListContainsSomeElements() {
            ArrayList a = ArrayList.of("hello", "hi", "bye");
            String expected = "[hello, hi, bye]";
            String actual = a.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnStringWhenListContainsNull() {
            ArrayList a = ArrayList.of("hello", null, "bye");
            String expected = "[hello, null, bye]";
            String actual = a.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class EqualsTests {
        @Test
        public void shouldReturnTueWhenListsContainSameElements() {
            ArrayList a = ArrayList.of("hello", null, "bye");
            ArrayList b = ArrayList.of("hello", null, "bye");
            Assertions.assertEquals(a, b);
        }

        @Test
        public void shouldReturnFalseWhenListsContainDifferentElements() {
            ArrayList a = ArrayList.of("hello", null, "bye");
            ArrayList b = ArrayList.of("hello", "hi-hi", "bye");
            Assertions.assertNotEquals(a, b);
        }
    }
}