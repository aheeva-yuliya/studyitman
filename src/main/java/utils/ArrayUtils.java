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
        int[] minMax = findMinAndMax(array);
        int min = minMax[0];
        int max = minMax[1];
        int[] cnt = count(array, min, max);
        int index = 0;
        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                array[index] = i + min;
                index += 1;
            }
        }
    }

    private static int[] findMinAndMax(int[] array) {
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
        return new int[] {min, max};
    }

    private static int[] count(int[] array, int min, int max) {
        int[] cnt = new int[max - min + 1];
        for (int element : array) {
            cnt[element - min] += 1;
        }
        return cnt;
    }

    /**
     * Returns an array containing only unique elements of the parameter int[] array.
     *
     * @cpu O(n), n = array.length
     * @ram O(m + n), m depends of the minimum and maximum values of the parameter array - line 108
     *                n = array.length - size of ArrayList lines 104, 117
     * @param array int[]
     * @return an array containing only unique elements
     */
    public static int[] distinct(int[] array) {
        ArrayList arrayList = new ArrayList();
        int[] minMax = findMinAndMax(array);
        int min = minMax[0];
        int max = minMax[1];
        int[] cnt = count(array, min, max);
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

    /**
     * Finds the number that occurs the most times in the parameter array.
     *
     * @cpu O(n), n = array.length - count line 135 - findMinAndMax line 132
     *          line 138 ?? O(1)
     * @ram O(m), m depends on the minimum and maximum values of the parameter array - line 138
     *
     * @param array int[]
     * @return the number that occurs the most times.
     *         If there are some then returns the minimum number found.
     */
    public static int mostFrequent(int[] array) {
        int[] minMax = findMinAndMax(array);
        int min = minMax[0];
        int max = minMax[1];
        int[] cnt = count(array, min, max);
        int mostFrequentElement = max;
        int times = 1;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > times) {
                times = cnt[i];
                mostFrequentElement = i + min;
            } else if (cnt[i] == times) {
                int secondMost = i + min;
                if (mostFrequentElement > secondMost) {
                    mostFrequentElement = secondMost;
                }
            }
        }
        return mostFrequentElement;
    }

    /**
     * Finds the number of elements that are contained in two arrays at the same time.
     *      Each element is counted once.
     *
     * @cpu O(n + k), n = a.length k = b.length lines 164-165, lines 168-169
     *                 line 172 O(1) ?
     * @ram O(m), m depends on the min and max values of the parameters a and b - lines 169-170
     *
     * @param a int[]
     * @param b int[]
     * @return the number of elements that are contained in two arrays at the same time.
     */
    public static int countEquals(int[] a, int[] b) {
        int[] minMaxForA = findMinAndMax(a);
        int[] minMaxForB = findMinAndMax(b);
        int min = Math.min(minMaxForA[0], minMaxForB[0]);
        int max = Math.max(minMaxForA[1], minMaxForB[1]);
        int[] cntA = count(a, min, max);
        int[] cntB = count(b, min, max);
        int count = 0;
        for (int i = 0; i < cntA.length; i++) {
            if (cntA[i] <= cntB[i]) {
                count = count + cntA[i];
            } else {
                count = count + cntB[i];
            }
        }
        return count;
    }
}
