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
        Event[] actual = Task408.sortEvents(events);
        Assertions.assertArrayEquals(expected, actual);
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
        Event[] actual = Task408.sortEvents(events);
        Assertions.assertArrayEquals(expected, actual);
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
        Event[] actual = Task408.sortEvents(events);
        Assertions.assertArrayEquals(expected, actual);
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
        Event[] actual = Task408.sortEvents(events);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortEventsEmpty() {
        Event[] events = new Event[] {};
        Event[] actual = Task408.sortEvents(events);
        Assertions.assertNotNull(actual);
    }

    @Test
    public void sortEventsOne() {
        Event[] events = new Event[] {
            new Event(1991, 9, 8, "this")
        };
        Event[] expected = new Event[events.length];
        expected[0] = events[0];
        Event[] actual = Task408.sortEvents(events);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortEventsNull() {
        Event[] events = new Event[3];
        Event[] actual = Task408.sortEvents(events);
        Assertions.assertNotNull(actual);
    }
}