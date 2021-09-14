package utils;

import entities.Event;

/**
 * ArrayUtils
 */
public class ArrayUtils {

    /**
     * Sorts the objects of the parameter events by ascending date.
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
     * Sorts the elements of the parameter int[] array in ascending order.
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

    /**
     * Sorts the elements of the parameter int[] array in ascending order.
     *
     * @cpu O(n + m), n = array.length, m = max(array)
     * @ram O(m)
     *
     * @param array int[]
     */
    public static void countingSort(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int[] cnt = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            cnt[array[i]]++;
        }
        for (int i = 0, j = 0; i < cnt.length; i++) {
            for (int k = cnt[i]; k > 0; k--) {
                array[j++] = i;
            }
        }
    }
}
