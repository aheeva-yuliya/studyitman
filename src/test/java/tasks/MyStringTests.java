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
}