package tasks;

import entities.Event;

/**
 * Task439
 */
public class Task439 {
    /**
     * Finds the latest event.
     *
     * @cpu O(n)
     * @ram O(1)
     *
     * @param events Event[]
     * @return the latest event.
     */
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
