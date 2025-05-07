package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MyStringTests {
    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenTry() {
            MyString string = new MyString(new char[]{'m', 'y', ' ', 'S', 't', 'r', 'i', 'n', 'g'});
            String expected = "my String";
            Assertions.assertEquals(string.toString(), expected);
            Assertions.assertEquals(9, string.length());
        }
    }

    @Nested
    public class Length {
        @Test
        public void shouldReturnPositiveLengthWhenSomeChars() {
            MyString string = new MyString(new char[]{'c', 'o', 'u', '-', 'c', 'o', 'u'});
            Assertions.assertEquals(7, string.length());
        }
    }

    @Nested
    public class CharAt {
        @Test
        public void shouldReturnCharAtIndex() {
            MyString string = new MyString(new char[]{'c', 'o', 'u', '-', 'c', 'o', 'u'});
            Assertions.assertEquals('u', string.charAt(2));
        }
    }

    @Nested
    public class Compare {
        @Test
        public void shouldReturnNegativeWhenFirstLess() {
            MyString a = new MyString(new char[]{'a', 'b', 'c'});
            MyString d = new MyString(new char[]{'d', 'e', 'f', 'g'});
            Assertions.assertEquals(-1, a.compareTo(d));
        }

        @Test
        public void shouldReturnZeroWhenSameLength() {
            MyString a = new MyString(new char[]{});
            MyString b = new MyString(new char[]{});
            Assertions.assertEquals(0, a.compareTo(b));
        }

        @Test
        public void shouldReturnPositiveWhenFirstGreater() {
            MyString a = new MyString(new char[]{'a'});
            MyString b = new MyString(new char[]{});
            Assertions.assertEquals(1, a.compareTo(b));
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnFalseWhenStringsDifferentLengths() {
            MyString a = new MyString(new char[]{'a'});
            MyString b = new MyString(new char[]{});
            Assertions.assertNotEquals(a, b);
        }

        @Test
        public void shouldReturnTrueWhenStringsEqual() {
            MyString a = new MyString(new char[]{'a', 'b'});
            MyString b = new MyString(new char[]{'a', 'b'});
            Assertions.assertEquals(a, b);
        }

        @Test
        public void shouldReturnFalseWhenContainDifferentChars() {
            MyString a = new MyString(new char[]{'t', 'e', 's', 't', '2'});
            MyString b = new MyString(new char[]{'t', 'e', 's', 't', '1'});
            Assertions.assertNotEquals(a, b);
        }

        @Test
        public void shouldReturnTrueWhenContainSame() {
            MyString a = new MyString(new char[]{'t', 'e', 's', 't', '2'});
            MyString b = new MyString(new char[]{'t', 'e', 's', 't', '2'});
            Assertions.assertEquals(a, b);
        }

        @Test
        public void shouldReturnFalseWhenThatNull() {
            MyString a = new MyString(new char[]{'a'});
            Assertions.assertNotEquals(null, a);
        }
    }

    @Nested
    public class Plus {
        @Test
        public void shouldConcatenateWhenTry() {
            MyString a = new MyString(new char[]{'a', 'b', 'c'});
            MyString b = new MyString(new char[]{'d', 'e', 'f', 'g'});
            MyString expected = new MyString(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'});
            MyString actual = MyString.plus(a, b);
            Assertions.assertTrue(expected.equals(actual));
        }

        @Test
        public void shouldConcatenateWhenTryConcatenateThat() {
            char[] a = new char[]{'t', 'h', 'i', 's'};
            char[] b = new char[]{' ', '+', ' ', 't', 'h', 'a', 't'};
            MyString first = new MyString(a);
            MyString second = new MyString(b);
            MyString actual = first.plus(second);
            Assertions.assertEquals("this + that", actual.toString());

        }
    }

    @Nested
    public class Change {
        @Test
        public void shouldNotChangeOriginWhenTryChangeAnElement() {
            char[] chars = new char[]{'a', 'b', 'c'};
            MyString a = new MyString(chars);
            chars[0] = 'd';
            Assertions.assertEquals("abc", a.toString());
        }

        @Test
        public void shouldReplaceWhenTryReplaceAtDifferentIndexes() {
            char[] a = new char[] {'t', 'h', 'i', 's', ' ', 'i', 's', ' ', 'm', 'y', ' ', 's', 't', 'r', 'i', 'n', 'g'};
            MyString my = new MyString(a);
            MyString actual = my.replace('s', '!');
            String expected = "thi! i! my !tring";
            Assertions.assertEquals(expected, actual.toString());
        }
    }
}