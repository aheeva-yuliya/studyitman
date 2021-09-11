package tasks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task408Tests {

    @Test
    public void sortEventsYear() {
        Event[] events = new Event[] {
            new Event(1991, 9, 8, "0"),
            new Event(1992, 2, 20, "1"),
            new Event(2018, 8, 9, "2")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        expected[1] = events[1];
        expected[2] = events[2];
        Task408.sort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void sortEventsMonth() {
        Event[] events = new Event[] {
            new Event(1991, 9, 8, "0"),
            new Event(1991, 2, 20, "1"),
            new Event(1991, 8, 9, "2")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[1];
        expected[1] = events[2];
        expected[2] = events[0];
        Task408.sort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void sortEventsDay() {
        Event[] events = new Event[] {
                new Event(1991, 9, 8, "0"),
                new Event(1991, 9, 20, "1"),
                new Event(1991, 9, 9, "2")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        expected[1] = events[2];
        expected[2] = events[1];
        Task408.sort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void sortEventsSameDay() {
        Event[] events = new Event[] {
                new Event(1991, 9, 8, "0"),
                new Event(1991, 9, 20, "1"),
                new Event(1991, 9, 8, "2")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        expected[1] = events[2];
        expected[2] = events[1];
        Task408.sort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void sortEventsEmpty() {
        Event[] events = new Event[] {};
        Task408.sort(events);
        Assertions.assertNotNull(events);
    }

    @Test
    public void sortEventsOne() {
        Event[] events = new Event[] {
            new Event(1991, 9, 8, "this")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        Task408.sort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void sortEventsOfTwo() {
        Event[] events = new Event[] {
                new Event(1, 10, 3, "0"),
                new Event(2020, 10, 2, "1")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        expected[1] = events[1];
        Task408.sort(events);
        Assertions.assertArrayEquals(expected, events);
    }

    @Test
    public void sortEventsOfThree() {
        Event[] events = new Event[] {
                new Event(1, 10, 3, "0"),
                new Event(2020, 10, 2, "1"),
                new Event (1, 11, 2, "2")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        expected[1] = events[2];
        expected[2] = events[1];
        Task408.sort(events);
        Assertions.assertArrayEquals(expected, events);
    }
}