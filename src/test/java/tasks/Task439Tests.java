package tasks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task439Tests {

    @Test
    public void findLastYear() {
        Event[] events = new Event[] {
                new Event(1991, 9, 8, "not"),
                new Event(1992, 2, 20, "not"),
                new Event(2018, 8, 9, "this")
        };
        Event expected = events[2];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
    }
    @Test
    public void findLastMonth() {
        Event[] events = new Event[] {
                new Event(1991, 9, 8, "this"),
                new Event(1991, 2, 20, "not"),
                new Event(1991, 8, 9, "not")
        };
        Event expected = events[0];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
    }
    @Test
    public void findLastDay() {
        Event[] events = new Event[] {
                new Event(1991, 9, 8, "not"),
                new Event(1991, 9, 20, "this"),
                new Event(1991, 9, 9, "not")
        };
        Event expected = events[1];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
    }
    @Test
    public void findLastSameDay() {
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
    public void findLastEmpty() {
        Event[] events = new Event[] {};
        Event actual = Task439.findLast(events);
        Assertions.assertNull(actual);
    }
}