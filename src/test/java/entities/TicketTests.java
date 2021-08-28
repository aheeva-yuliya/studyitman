package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTests {

    @Test
    public void testToStringTryFirst() {
        Ticket a = new Ticket(1, "a");
        String expected = "Ticket{number=1, place='a'}";
        String actual = a.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToStringTryAnother() {
        Ticket a = new Ticket(2, "b");
        String expected = "Ticket{number=2, place='b'}";
        String actual = a.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsFalse() {
        Ticket a = new Ticket(1, "a");
        Ticket b = new Ticket(2, "b");
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsTrue() {
        Ticket a = new Ticket(1, "a");
        Ticket b = new Ticket(1, "a");
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsNull() {
        Ticket a = new Ticket (20, "A");
        Ticket b = null;
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsStringNull() {
        Ticket a = new Ticket (2024, null);
        Ticket b = new Ticket (2024, null);
        Assertions.assertTrue(a.equals(b));
    }
}