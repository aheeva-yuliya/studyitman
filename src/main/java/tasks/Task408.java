package tasks;

import entities.Event;

public class Task408 {
    public static void sort(Event[] events) {
        if (events.length == 0) {
            events = null;
        }
        for (int n = events.length; n > 1; n--) {
            for (int i = 1; i < n; i++) {
                if (events[i - 1].year > events[i].year) {
                    Event temp = events[i - 1];
                    events[i - 1] = events[i];
                    events[i] = temp;
                } else if (events[i - 1].year == events[i].year) {
                    if (events[i - 1].month > events[i].month) {
                        Event temp = events[i - 1];
                        events[i - 1] = events[i];
                        events[i] = temp;
                    } else if (events[i - 1].month == events[i].month) {
                        if (events[i - 1].day > events[i].day) {
                            Event temp = events[i - 1];
                            events[i - 1] = events[i];
                            events[i] = temp;
                        }
                    }
                }
            }
        }
    }

    static Event[] sortEvents(Event[] events) {
        if (events.length == 0) {
            return null;
        }
        for (int n = events.length; n > 1; n--) {
            for (int i = 1; i < n; i++) {
                if (events[i - 1].year > events[i].year) {
                    Event temp = events[i - 1];
                    events[i - 1] = events[i];
                    events[i] = temp;
                } else if (events[i - 1].year == events[i].year) {
                    if (events[i - 1].month > events[i].month) {
                        Event temp = events[i - 1];
                        events[i - 1] = events[i];
                        events[i] = temp;
                    } else if (events[i - 1].month == events[i].month) {
                        if (events[i - 1].day > events[i].day) {
                            Event temp = events[i - 1];
                            events[i - 1] = events[i];
                            events[i] = temp;
                        }
                    }
                }
            }
        }
        return events;
    }
}
