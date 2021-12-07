package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class EventTests {
    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenEventNotNull() {
            Event event = new Event(1,1918, 3, 25, "The independence of the BNR");
            String expected = "Event{id=1, year=1918, month=3, day=25, name='The independence of the BNR'}";
            String actual = event.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnFalseWhenDifferentEvents() {
            Event a = new Event(1, 1991, 9, 8, "my birthday");
            Event b = new Event(2, 1992, 2, 20, "igor's birthday");
            Assertions.assertFalse(a.equals(b));
        }

        @Test
        public void shouldReturnTrueWhenSameEvents() {
            Event a = new Event(1, 1991, 9, 8, "my birthday");
            Event b = new Event(1, 1991, 9, 8, "my birthday");
            Assertions.assertTrue(a.equals(b));
        }

        @Test
        public void shouldReturnFalseWhenThatNull() {
            Event a = new Event(1,2022, 2, 28, "A");
            Assertions.assertFalse(a.equals(null));
        }

        @Test
        public void shouldReturnTrueWhenSameEventsContainNull() {
            Event a = new Event(1,2024, 2, 28, null);
            Event b = new Event(1,2024, 2, 28, null);
            Assertions.assertTrue(a.equals(b));
        }

        @Test
        public void shouldReturnFalseWhenOnlyOneEventContainsNull() {
            Event a = new Event(1, 2024, 2, 28, null);
            Event b = new Event(1, 2024, 2, 28, "interesting");
            Assertions.assertFalse(a.equals(b));
        }
    }

    @Nested
    public class Compare {
        @Test
        public void shouldReturnNegativeWhenFirstHappenedBefore() {
            Event a = new Event(1, 1991, 9, 8, "a");
            Event b = new Event(2, 1992, 2, 20, "b");
            Assertions.assertEquals(-1, a.compareTo(b));
        }

        @Test
        public void shouldReturnZeroWhenHappenedSameDate() {
            Event a = new Event(1, 1991, 9, 8, "a");
            Event b = new Event(2, 1991, 9, 8, "b");
            Assertions.assertEquals(0, a.compareTo(b));
        }

        @Test
        public void shouldReturnPositiveWhenFirstHappenedAfter() {
            Event a = new Event(1, 1991, 9, 8, "a");
            Event b = new Event(2, 1992, 2, 20, "b");
            Assertions.assertEquals(1, b.compareTo(a));
        }
    }
}