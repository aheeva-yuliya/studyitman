package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TicketTests {
    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenTry() {
            Ticket a = new Ticket(1, "a");
            String expected = "Ticket{number=1, place='a'}";
            String actual = a.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnFalseWhenTicketsNotEqual() {
            Ticket a = new Ticket(1, "a");
            Ticket b = new Ticket(2, "b");
            Assertions.assertNotEquals(a, b);
        }

        @Test
        public void shouldReturnTrueWhenTicketsEqual() {
            Ticket a = new Ticket(1, "a");
            Ticket b = new Ticket(1, "a");
            Assertions.assertEquals(a, b);
        }

        @Test
        public void shouldReturnFalseWhenThatNull() {
            Ticket a = new Ticket(20, "A");
            Assertions.assertNotEquals(null, a);
        }

        @Test
        public void shouldReturnTrueWhenEqualAndBothContainNull() {
            Ticket a = new Ticket(2024, null);
            Ticket b = new Ticket(2024, null);
            Assertions.assertEquals(a, b);
        }
    }
}