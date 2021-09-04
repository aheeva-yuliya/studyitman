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
            int compare = events[i].compareTo(last);
            if (compare >= 0) {
                last = events[i];
            }
        }
        return last;
    }
}
