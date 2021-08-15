package tasks;

import entities.Event;

public class Task439 {
    public static Event findLast(Event[] events) {
        if (events.length == 0) {
            return null;
        }
        Event last = events[0];
        for (int i = 1; i < events.length; i++) {
            if (events[i].year > last.year) {
                last = events[i];
            } else if (events[i].year == last.year) {
                if (events[i].month > last.month) {
                    last = events[i];
                } else if (events[i].month == last.month) {
                    if (events[i].day >= last.day) {
                        last = events[i];
                    }
                }
            }
        }
        return last;
    }
}
