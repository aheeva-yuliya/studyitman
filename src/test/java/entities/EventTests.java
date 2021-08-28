package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTests {

    @Test
    public void testToStringTryFirstDate() {
        Event event = new Event(1918, 3, 25, "The independence of the BNR");
        String expected = "Event{year=1918, month=3, day=25, name='The independence of the BNR'}";
        String actual = event.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToStringTryAnother() {
        Event event = new Event(1991, 9, 8, "My birthday");
        String expected = "Event{year=1991, month=9, day=8, name='My birthday'}";
        String actual = event.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsFalse() {
        Event a = new Event(1991, 9, 8, "my birthday");
        Event b = new Event(1992, 2, 20, "igor's birthday");
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsTrue() {
        Event a = new Event(1991, 9, 8, "my birthday");
        Event b = new Event(1991, 9, 8, "my birthday");
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsNull() {
        Event a = new Event (2022, 2, 28, "A");
        Event b = null;
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsStringNull() {
        Event a = new Event (2024, 2, 28, null );
        Event b = new Event (2024, 2, 28, null);
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsStringNullAndNotNull() {
        Event a = new Event(2024, 2, 28, null);
        Event b = new Event(2024, 2, 28, "interesting");
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void compareToIfBefore() {
        Event a = new Event(1991, 9, 8, "a");
        Event b = new Event(1992, 2, 20, "b");
        Assertions.assertEquals(-1, a.compareTo(b));
    }

    @Test
    public void compareToIfTheSame() {
        Event a = new Event(1991, 9, 8, "a");
        Event b = new Event(1991, 9, 8, "b");
        Assertions.assertEquals(0, a.compareTo(b));
    }

    @Test
    public void compareToIfAfter() {
        Event a = new Event(1991, 9, 8, "a");
        Event b = new Event(1992, 2, 20, "b");
        Assertions.assertEquals(1, b.compareTo(a));
    }
}