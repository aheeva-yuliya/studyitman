package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringArrayListTests {

    @Test
    public void setAndGet() {
        StringArrayList a = StringArrayList.of("hello", "hi", "bye");
        a.set(0, "hi");
        Assertions.assertEquals("hi",a.get(0));
    }

    @Test
    public void setAndGetNull() {
        StringArrayList a = StringArrayList.of("hello", "hi", "bye");
        a.set(0, null);
        Assertions.assertNull(a.get(0));
    }

    @Test
    public void size() {
        StringArrayList a = StringArrayList.of("hello", "hi", "bye");
        Assertions.assertEquals(3, a.size());
        a.add("morning");
        Assertions.assertEquals(4, a.size());

    }

    @Test
    public void add() {
        StringArrayList a = new StringArrayList();
        a.add("hello");
        a.add("hi");
        Assertions.assertEquals("hello", a.get(0));
        Assertions.assertEquals("hi", a.get(1));
    }

    @Test
    public void addNull() {
        StringArrayList a = new StringArrayList();
        a.add("hello");
        a.add(null);
        a.add("hi");
        Assertions.assertNull(a.get(1));
    }

    @Test
    public void toArray() {
        StringArrayList a = StringArrayList.of("hello", "hi", "bye");
        String[] expected = new String[] {"hello", "hi", "bye"};
        Assertions.assertArrayEquals(expected,a.toArray());
    }

    @Test
    public void toArrayNull() {
        StringArrayList a = new StringArrayList();
        a.add("hello");
        a.add(null);
        String[] expected = new String[] {"hello", null};
        Assertions.assertArrayEquals(expected,a.toArray());
    }

    @Test
    public void remove() {
        StringArrayList a = StringArrayList.of("hello", "hi", "bye");
        String expected = "hi";
        Assertions.assertEquals(expected,a.remove(1));
        String expectedString = "[hello, bye]";
        Assertions.assertEquals(expectedString,a.toString());
    }

    @Test
    public void of() {
        StringArrayList a = StringArrayList.of("hello", "hi", "bye");
        String[] expected = new String[] {"hello", "hi", "bye"};
        String[] actual = a.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ofNull() {
        StringArrayList a = StringArrayList.of("hello", null, "bye");
        String[] expected = new String[] {"hello", null, "bye"};
        String[] actual = a.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testToString() {
        StringArrayList a = StringArrayList.of("hello", "hi", "bye");
        String expected = "[hello, hi, bye]";
        String actual = a.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testToStringNull() {
        StringArrayList a = StringArrayList.of("hello", null, "bye");
        String expected = "[hello, null, bye]";
        String actual = a.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testEqualsIfYes() {
        StringArrayList a = StringArrayList.of("hello", null, "bye");
        StringArrayList b = StringArrayList.of("hello", null, "bye");
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsIfNo() {
        StringArrayList a = StringArrayList.of("hello", null, "bye");
        StringArrayList b = StringArrayList.of("hello", "hi-hi", "bye");
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsIfFalse() {
        StringArrayList a = StringArrayList.of("hello", "hi", "bye");
        StringArrayList b = StringArrayList.of("hello", null, "bye");
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void clear() {
        StringArrayList a = new StringArrayList();
        a.add("hello");
        a.clear();
        String expected = "[]";
        String actual = a.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void trimToSize() {
        StringArrayList a = new StringArrayList();
        a.add("hello");
        a.trimToSize();
        Assertions.assertEquals(1,a.size());
    }
}