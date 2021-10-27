package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringBuilderTests {
    @Nested
    public class Length {
        @Test
        public void shouldReturnLengthWhenNotEmpty() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Hello, Stas! What's up");
            Assertions.assertEquals(22, stringBuilder.length());
        }
    }

    @Nested
    public class Append {
        @Test
        public void shouldAppendStringWhenTryNotNull() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("tired already?");
            Assertions.assertEquals(stringBuilder.toString(), "tired already?");
        }

        @Test
        public void shouldAppendStringWhenNull() {
            StringBuilder stringBuilder = new StringBuilder(1);
            stringBuilder.append(null);
            Assertions.assertEquals(stringBuilder.toString(), "null");
        }


        @Test
        public void shouldAppendStringWhenTryAppendTwoStrings() {
            StringBuilder stringBuilder = new StringBuilder(1);
            stringBuilder.append("first word");
            stringBuilder.append(", ");
            stringBuilder.append("second word");
            Assertions.assertEquals(stringBuilder.toString(), "first word, second word");
        }

        @Test
        public void shouldAppendBooleanWhenTry() {
            StringBuilder stringBuilder = new StringBuilder();
            Assertions.assertSame(stringBuilder, stringBuilder.append(false));
            assertEquals(stringBuilder.toString(), "false");
        }

        @Test
        public void shouldAppendIntWhenTry() {
            StringBuilder stringBuilder = new StringBuilder();
            Assertions.assertSame(stringBuilder, stringBuilder.append(365));
            assertEquals(stringBuilder.toString(), "365");
        }

        @Test
        public void shouldAppendDoubleWhenTry() {
            StringBuilder stringBuilder = new StringBuilder();
            Assertions.assertSame(stringBuilder, stringBuilder.append(3.65));
            assertEquals(stringBuilder.toString(), "3.65");
        }

        @Test
        public void shouldAppendLongWhenTry() {
            StringBuilder stringBuilder = new StringBuilder();
            Assertions.assertSame(stringBuilder, stringBuilder.append(3650078654L));
            assertEquals(stringBuilder.toString(), "3650078654");
        }

        @Test
        public void shouldAppendWhenTryDifferentTypes() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("types: ");
            stringBuilder.append(false);
            stringBuilder.append(", ");
            stringBuilder.append(1);
            stringBuilder.append(", ");
            stringBuilder.append(2.6789);
            stringBuilder.append(", ");
            stringBuilder.append(10000000000L);
            Assertions.assertEquals(stringBuilder.toString(), "types: false, 1, 2.6789, 10000000000");
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenNotNull() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("last of these tests");
            Assertions.assertEquals(stringBuilder.toString(), "last of these tests");
        }
    }
}