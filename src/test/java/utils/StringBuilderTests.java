package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderTests {

    @Test
    public void length() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello, Stas! What's up");
        Assertions.assertEquals(22, stringBuilder.length());
    }

    @Test
    public void appendString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tired already?");
        Assertions.assertEquals(stringBuilder.toString(), "tired already?");
    }

    @Test
    public void appendStringTwoStrings() {
        StringBuilder stringBuilder = new StringBuilder(1);
        stringBuilder.append("first word");
        stringBuilder.append(", ");
        stringBuilder.append("second word");
        Assertions.assertEquals(stringBuilder.toString(), "first word, second word");
    }

    @Test
    public void appendBoolean() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(false);
        assertEquals(stringBuilder.toString(), "false");
    }

    @Test
    public void appendInt() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(365);
        assertEquals(stringBuilder.toString(), "365");
    }

    @Test
    public void appendDouble() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(3.65);
        assertEquals(stringBuilder.toString(), "3.65");
    }

    @Test
    public void appendLong() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(3650078654L);
        assertEquals(stringBuilder.toString(), "3650078654");
    }

    @Test
    public void appendStringDifferentTypes() {
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

    @Test
    public void testToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("last of these tests");
        Assertions.assertEquals(stringBuilder.toString(), "last of these tests");
    }
}