package utils;

import collections.ArrayList;
import entities.Event;

/**
 * ArrayUtils
 */
public class ArrayUtils {

    /**
     * Sorts the objects of the parameter events by ascending date.
     *
     * @param events Event[]
     * @cpu O(n ^ 2)
     * @ram O(1)
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
     * @param array int[]
     * @cpu O(n ^ 2)
     * @ram O(1)
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
     * @cpu O(n), n = array.length
     * @ram O(m), m depends on minimum and maximum values of the parameter array
     *
     * @param array int[]
     */
    public static void countingSort(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k : array) {
            if (max < k) {
                max = k;
            }
            if (min > k) {
                min = k;
            }
        }
        int[] cnt = new int[max - min + 1];
        for (int element : array) {
            cnt[element - min] += 1;
        }
        int index = 0;
        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                array[index] = i + min;
                index += 1;
            }
        }
    }

    public static int[] distinct(int[] array) {
        ArrayList arrayList = new ArrayList();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k : array) {
            if (max < k) {
                max = k;
            }
            if (min > k) {
                min = k;
            }
        }
        int[] cnt = new int[max - min + 1];
        for (int element : array) {
            cnt[element - min] += 1;
        }
        int element;
        for (int j : array) {
            element = j;
            if (cnt[element - min] > 0) {
                arrayList.add(element);
                cnt[element - min] = 0;
            }
        }
        return arrayList.toArray();
    }
}
