package tasks;

import entities.Event;

public class Task439 {
    public static Event findLast(Event[] events) {
        Event last = new Event();
        for (int i = 0; i < events.length; i++) {
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
