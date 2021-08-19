package tasks;

import entities.Event;

/**
 * Task408
 */
public class Task408 {
    /**
     * Sorts by ascending date
     *
     * @cpu O(n^2)
     * @ram O(1)
     *
     * @param events Event[]
     */
    public static void sort(Event[] events) {
        for (int n = events.length; n > 1; n--) {
            for (int i = 1; i < n; i++) {
                if (events[i] != null && events[i -1] != null && events[i - 1].year > events[i].year) {
                    Event temp = events[i - 1];
                    events[i - 1] = events[i];
                    events[i] = temp;
                } else if (events[i] != null && events[i - 1] != null && events[i - 1].year == events[i].year) {
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
}
