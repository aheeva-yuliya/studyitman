package collections;

import entities.Event;
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
            Assertions.assertEquals(game, a.get(0));
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
            final Game game = new Game(5, "t", 10, 1, 15);
            final Item item = new Item(6, "title", 8);
            final Event event = new Event();
            a.add(game);
            a.add(item);
            a.add(event);
            Assertions.assertSame(game, a.get(0));
            Assertions.assertSame(item, a.get(1));
            Assertions.assertSame(event, a.get(2));
        }

        @Test
        public void shouldAddWhenTryAddNull() {
            final ArrayList a = new ArrayList();
            a.add("hello");
            a.add(null);
            a.add("hi");
            Assertions.assertNull(a.get(1));
        }

        @Test
        public void shouldAddNewObjectWhenListEmpty() {
            final ArrayList a = new ArrayList();
            final Object object = new Object();
            a.add(object);
            Assertions.assertSame(object, a.get(0));
        }
    }

    @Nested
    public class ToArrayTests {
        @Test
        public void shouldReturnArrayWhenListNotEmpty() {
            final Game game = new Game(5, "t", 10, 1, 15);
            final Item item = new Item(6, "title", 8);
            final Event event = new Event();
            final ArrayList a = ArrayList.of(game, item, event);
            final Object[] expected = new Object[]{game, item, event};
            Assertions.assertArrayEquals(expected, a.toArray());
        }

        @Test
        public void shouldReturnArrayWhenTryAddNull() {
            final ArrayList a = new ArrayList();
            a.add("hello");
            a.add(null);
            final Object[] expected = new Object[]{"hello", null};
            Assertions.assertArrayEquals(expected, a.toArray());
        }
    }

    @Nested
    public class RemoveTests {
        @Test
        public void shouldRemoveWhenTryRemoveFromMiddle() {
            final ArrayList a = ArrayList.of("hello", "hi", "bye");
            final String expected = "hi";
            Assertions.assertEquals(expected, a.remove(1));
            final String expectedString = "[hello, bye]";
            Assertions.assertEquals(expectedString, a.toString());
        }

        @Test
        public void shouldRemoveWhenTryRemoveFromFirstANdLastIndexes() {
            final ArrayList a = ArrayList.of("hello", "hi", "bye");
            final String expectedZero = "hello";
            Assertions.assertEquals(expectedZero, a.remove(0));
            final String expectedLast = "bye";
            Assertions.assertEquals(expectedLast, a.remove(1));
            final String expectedString = "[hi]";
            Assertions.assertEquals(expectedString, a.toString());
        }
    }

    @Nested
    public class OfTests {
        @Test
        public void shouldCreateWhenTryCreateOfSomeElements() {
            final ArrayList a = ArrayList.of("hello", "hi", "bye");
            final Object[] expected = new String[]{"hello", "hi", "bye"};
            final Object[] actual = a.toArray();
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCreateWhenTryCreateOfNewObjectElement() {
            final Object o = new Object();
            final ArrayList a = ArrayList.of("hello", o, "bye");
            final Object[] expected = new Object[]{"hello",  o, "bye"};
            final Object[] actual = a.toArray();
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCreateWhenTryCreateOfDifferentObjectsElements() {
            final Game game = new Game(5, "t", 10, 1, 15);
            final Item item = new Item(6, "title", 8);
            final Event event = new Event();
            final ArrayList a = ArrayList.of(game, item, event);
            final Object[] expected = new Object[]{game, item, event};
            final Object[] actual = a.toArray();
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCreateWhenTryCreateOfNull() {
            final ArrayList a = ArrayList.of("hello", null, "bye");
            final Object[] expected = new String[]{"hello", null, "bye"};
            final Object[] actual = a.toArray();
            Assertions.assertArrayEquals(expected, actual);
        }
    }

    @Nested
    public class ToStringTests {
        @Test
        public void shouldReturnStringWhenListContainsSomeStringElements() {
            final ArrayList a = ArrayList.of("hello", "hi", "bye");
            final String expected = "[hello, hi, bye]";
            final String actual = a.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnStringWhenListContainsSomeObjectElements() {
            final Item item = new Item(6, "title", 8);
            final Event event = new Event();
            final ArrayList a = ArrayList.of(item, event);
            final String expected =
                    "[Item{id=6, title='title', price=8}, Event{id=0, year=0, month=0, day=0, name='null'}]";
            final String actual = a.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnStringWhenListContainsNewObjectElement() {
            final ArrayList a = ArrayList.of(new Object());
            final String expected = "[Object{}]";
            final String actual = a.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnStringWhenListContainsNull() {
            final ArrayList a = ArrayList.of("hello", null, "bye");
            final String expected = "[hello, null, bye]";
            final String actual = a.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class EqualsTests {
        @Test
        public void shouldReturnTueWhenListsContainSameElements() {
            final ArrayList a = ArrayList.of("hello", null, "bye");
            final ArrayList b = ArrayList.of("hello", null, "bye");
            Assertions.assertEquals(a, b);
        }

        @Test
        public void shouldReturnFalseWhenListsContainDifferentElements() {
            final ArrayList a = ArrayList.of("hello", null, "bye");
            final ArrayList b = ArrayList.of("hello", "hi-hi", "bye");
            Assertions.assertNotEquals(a, b);
        }

        @Test
        public void shouldReturnFalseWhenListsContainDifferentObjectElements() {
            final ArrayList a = ArrayList.of("hello", null, "bye");
            final ArrayList b = ArrayList.of(new Object(), "hi-hi", "bye");
            Assertions.assertNotEquals(a, b);
        }

        @Test
        public void shouldReturnTrueWhenSameEmptyArrayList() {
            final ArrayList a = ArrayList.of();
            final ArrayList b = ArrayList.of();
            Assertions.assertEquals(a, b);
        }

        @Test
        public void shouldReturnFalseWhenNotArrayListToCompare() {
            final ArrayList a = ArrayList.of();
            final Object b = new Object();
            Assertions.assertNotEquals(a, b);
        }

        @Test
        public void shouldReturnFalseWhenNullToCompare() {
            final ArrayList a = ArrayList.of();
            Assertions.assertNotEquals(a, null);
        }
    }
}