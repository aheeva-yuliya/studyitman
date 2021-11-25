package tasks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task439Tests {
    @Nested
    public class FindLast {
        @Test
        public void shouldFindLastWhenDependsOnYear() {
            Event[] events = new Event[]{
                    new Event(1991, 9, 8, "not"),
                    new Event(1992, 2, 20, "not"),
                    new Event(2018, 8, 9, "this")
            };
            Event expected = events[2];
            Event actual = Task439.findLast(events);
            Assertions.assertSame(expected, actual);
        }

        @Test
        public void shouldFindLastWhenDependsOnMonth() {
            Event[] events = new Event[]{
                    new Event(1991, 9, 8, "this"),
                    new Event(1991, 2, 20, "not"),
                    new Event(1991, 8, 9, "not")
            };
            Event expected = events[0];
            Event actual = Task439.findLast(events);
            Assertions.assertSame(expected, actual);
        }

        @Test
        public void shouldFindLastWhenDependsOnDay() {
            Event[] events = new Event[]{
                    new Event(1991, 9, 8, "not"),
                    new Event(1991, 9, 20, "this"),
                    new Event(1991, 9, 9, "not")
            };
            Event expected = events[1];
            Event actual = Task439.findLast(events);
            Assertions.assertSame(expected, actual);
        }

        @Test
        public void shouldFindLastWhenSameDate() {
            Event[] events = new Event[]{
                    new Event(1991, 9, 8, "not"),
                    new Event(1991, 9, 20, "not"),
                    new Event(1991, 9, 20, "this")
            };
            Event expected = events[2];
            Event actual = Task439.findLast(events);
            Assertions.assertSame(expected, actual);
        }

        @Test
        public void shouldFindLastWhenEmpty() {
            Event[] events = new Event[]{};
            Event actual = Task439.findLast(events);
            Assertions.assertNull(actual);
        }

        @Test
        public void shouldFindLastWhenOnlyOne() {
            Event[] events = new Event[]{
                    new Event(1991, 9, 8, "this")
            };
            Event expected = events[0];
            Event actual = Task439.findLast(events);
            Assertions.assertSame(expected, actual);
        }

        @Test
        public void shouldFindLastWhenTwo() {
            Event[] events = new Event[]{
                    new Event(1, 10, 3, "0"),
                    new Event(2020, 10, 2, "1")
            };
            Event expected = events[1];
            Event actual = Task439.findLast(events);
            Assertions.assertSame(expected, actual);
        }
    }
}