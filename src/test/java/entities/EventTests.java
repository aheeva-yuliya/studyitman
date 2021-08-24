package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTests {

    @Test
    public void testToString_1918_3_25() {
        Event event = new Event(1918, 3, 25, "The independence of the BNR");
        String expected = "Event{year=1918, month=3, day=25, name='The independence of the BNR'}";
        String actual = event.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToString_1991_9_8() {
        Event event = new Event(1991, 9, 8, "My birthday");
        String expected = "Event{year=1991, month=9, day=8, name='My birthday'}";
        String actual = event.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsFalse() {
        Event a = new Event(1991, 9, 8, "my birthday");
        Event b = new Event(1992, 2, 20, "igor's birthday");
        boolean expected = false;
        boolean actual = a.equals(b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsTrue() {
        Event a = new Event(1991, 9, 8, "my birthday");
        Event b = new Event(1991, 9, 8, "my birthday");
        boolean expected = true;
        boolean actual = a.equals(b);
        Assertions.assertEquals(expected, actual);
    }
}