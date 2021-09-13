package utils;

import entities.Event;

/**
 * ArrayUtils
 */
public class ArrayUtils {

    /**
     * Sorts by ascending date
     *
     * @cpu O(n^2)
     * @ram O(1)
     *
     * @param events Event[]
     */
    public static void bubbleSort(Event[] events) {
        for (int n = events.length; n > 1; n--) {
            for (int i = 1; i < n; i++) {
                int compare = events[i - 1].compareTo(events[i]);
                if (compare > 0) {
                    Event temp = events[i - 1];
                    events[i - 1] = events[i];
                    events[i] = temp;
                }
            }
        }
    }

    /**
     * Sorts the elements of the parameter int[] array in ascending order
     *
     * @cpu O(n^2)
     * @ram O(1)
     *
     * @param array int[]
     */
    public static void bubbleSort(int[] array) {
        for (int n = array.length; n > 1; n--) {
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int t = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = t;
                }
            }
        }
    }
}
