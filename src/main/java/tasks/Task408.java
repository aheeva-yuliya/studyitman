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
                int compare = events[i - 1].compareTo(events[i]);
                if (compare == 1) {
                    Event temp = events[i - 1];
                    events[i - 1] = events[i];
                    events[i] = temp;
                }
            }
        }
    }
}
