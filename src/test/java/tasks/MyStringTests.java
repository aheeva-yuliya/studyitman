package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyStringTests {

    @Test
    public void testToString() {
        MyString string = new MyString(new char[]{'m', 'y', ' ', 'S', 't', 'r', 'i', 'n', 'g'});
        String expected = "my String";
        Assertions.assertEquals(string.toString(), expected);
        Assertions.assertEquals(9, string.length());
    }

    @Test
    public void length() {
        MyString string = new MyString(new char[]{'c', 'o', 'u', '-', 'c', 'o', 'u'});
        Assertions.assertEquals(7, string.length());
    }

    @Test
    public void charAt() {
        MyString string = new MyString(new char[]{'c', 'o', 'u', '-', 'c', 'o', 'u'});
        Assertions.assertEquals('u', string.charAt(2));
    }

    @Test
    public void compareToIfLess() {
        MyString a = new MyString(new char[] {'a', 'b', 'c'});
        MyString d = new MyString(new char[] {'d', 'e', 'f','g'});
        Assertions.assertEquals(-1, a.compareTo(d));
    }

    @Test
    public void compareToIfNil() {
        MyString a = new MyString(new char[] {});
        MyString b = new MyString(new char[] {});
        Assertions.assertEquals(0, a.compareTo(b));
    }

    @Test
    public void compareToIfNotTheSame() {
        MyString a = new MyString(new char[] {'a'});
        MyString b = new MyString(new char[] {});
        Assertions.assertEquals(1, a.compareTo(b));
    }

    @Test
    public void compareToIfThisIsLess() {
        MyString a = new MyString(new char[] {'a'});
        MyString b = new MyString(new char[] {'a', 'b'});
        Assertions.assertEquals(-1, a.compareTo(b));
    }

    @Test
    public void testEqualsIfNot() {
        MyString a = new MyString(new char[] {'a'});
        MyString b = new MyString(new char[]{});
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsIfTrue() {
        MyString a = new MyString(new char[] {'a', 'b'});
        MyString b = new MyString(new char[]{'a', 'b'});
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsIfSame() {
        MyString a = new MyString(new char[] {'a'});
        MyString b = new MyString(new char[] {'a'});
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsIfNotTheSame() {
        MyString a = new MyString(new char[] {'a'});
        MyString b = new MyString(new char[] {'A'});
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void plusEquals() {
        MyString a = new MyString(new char[] {'a', 'b', 'c'});
        MyString b = new MyString(new char[] {'d', 'e', 'f','g'});
        MyString expected = new MyString(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'});
        MyString actual = MyString.plus(a,b);
        Assertions.assertTrue(expected.equals(actual));
    }
}