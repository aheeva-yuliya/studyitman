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
     * @cpu O(n + m), n = array.length and m = maximum - minimum values of the parameter array
     * @ram O(m), m = maximum - minimum values of the parameter array
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
            if (element <= max && element >= min) {
                cnt[element - min] += 1;
            }
        }
        return cnt;
    }

    /**
     * Returns an array containing only unique elements of the parameter int[] array.
     *
     * @cpu O(n), n = array.length
     * @ram O(m + n), m = maximum - minimum values of the parameter array
     *                n = array.length
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
     * @cpu O(n + m), n = array.length and m = maximum - minimum values of the parameter array
     * @ram O(m), m = maximum - minimum values of the parameter array
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
     * @cpu O(k + l + m), k = a.length, l = b.length, m = the smallest maximum - the greatest minimum
     * @ram O(m), m = the smallest maximum - the greatest minimum
     *
     * @param a int[]
     * @param b int[]
     * @return the number of elements that are contained in two arrays at the same time.
     */
    public static int countEquals(int[] a, int[] b) {
        int[] minMaxA = findMinAndMax(a);
        int[] minMaxB = findMinAndMax(b);
        int min = Math.max(minMaxA[0], minMaxB[0]);
        int max = Math.min(minMaxA[1], minMaxB[1]);
        if (min > max) {
            return 0;
        }
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

    /**
     * Sorts the objects of the parameter events by counting sort.
     *
     * @cpu O(n + m), n = events.length
     *     and m = maximum - minimum of the dates, each date equals to the number of days from the beginning of the era
     * @ram O(n + m), n = events.length
     *     and m = maximum - minimum of the dates, each date equals to the number of days from the beginning of the era
     *
     *  @param events Event[]
     */
    public static void countingSort(Event[] events) {
        int[] dates = new int[events.length];
        for (int i = 0; i < events.length; i++) {
            dates[i] = events[i].getDay() + events[i].getMonth() * 31 + events[i].getYear() * 372;
        }
        int[] minMax = findMinAndMax(dates);
        int min = minMax[0];
        int max = minMax[1];
        int[] cnt = count(dates, min, max);
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] = cnt[i] + cnt[i - 1];
        }
        Event[] sorted = new Event[events.length];
        int index;
        for(int i = dates.length - 1; i >= 0; i--) {
            index = cnt[dates[i] - min] - 1;
            sorted[index] = events[i];
            cnt[dates[i] - min]--;
        }
        System.arraycopy(sorted, 0, events, 0, events.length);
    }

    /**
     * Finds the index of the element of the parameter array equal to the parameter key.
     *
     * @cpu O(log(n)) n = array.length
     * @ram O(1)
     *
     * @param array int[]
     * @param key int argument
     * @return the minimum index of the element equal to key or
     *          -(insertionPoint + 1) if there is no such element, where insertionPoint equal to
     *          the index at which the key element can be inserted while keeping the array sorted.
     */
    public static int binarySearch(int[] array, int key) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (key < array[m]) {
                r = m - 1;
            } else if (key > array[m]) {
                l = m + 1;
            } else {
                if (m - 1 >= 0 && array[m - 1] == key) {
                    r = m - 1;
                } else {
                    return m;
                }
            }
        }
        return -(l + 1);
    }

    /**
     * Finds the index of the element of the parameter array equal to the parameter key
     *      from the index equal to the parameter fromIndex to the index equal to the parameter toIndex.
     *
     * @cpu O(log(n)) n = array.length
     * @ram O(1)
     *
     * @param array int[]
     * @param key int argument
     * @param fromIndex int argument = low bound of the search
     * @param toIndex int argument = high bound of the search
     * @return the minimum index of the element equal to key or
     *          -(insertionPoint + 1) if there is no such element, where insertionPoint equal to
     *          the index at which the key element can be inserted while keeping the array sorted.
     */
    public static int binarySearch(int[] array, int fromIndex, int toIndex, int key) {
        int l = fromIndex;
        int r = toIndex - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (key < array[m]) {
                r = m - 1;
            } else if (key > array[m]) {
                l = m + 1;
            } else {
                if (m - 1 >= fromIndex && array[m - 1] == key) {
                    r = m - 1;
                } else {
                    return m;
                }
            }
        }
        return -(l + 1);
    }

    /**
     * Copies values from array a (interval [aFrom, aTo)) and array b (interval [bFrom, bTo))
     *          into array r (by interval [rFrom, rFrom + aTo - aFrom + bTo - bFrom).
     *
     * @cpu O(n) n = rFrom + aTo - aFrom + bTo - bFrom - rFrom
     * @ram O(1)
     *
     * @param a int[] sorted in ascending order from position aFrom to position aTo
     * @param aFrom int argument
     * @param aTo int argument
     * @param b int[] sorted in ascending order from position bFrom to position bTo
     * @param bFrom int argument
     * @param bTo int argument
     * @param r int[]
     * @param rFrom int argument
     */
    public static void merge(int[] a, int aFrom, int aTo, int[] b, int bFrom, int bTo, int[] r, int rFrom) {
        int indexA = aFrom;
        int indexB = bFrom;
        int rTo = rFrom + aTo - aFrom + bTo - bFrom;
        for (int i = rFrom; i < rTo; i++) {
            if (indexA < aTo && (indexB >= bTo || a[indexA] < b[indexB])) {
                r[i] = a[indexA];
                indexA++;
            } else {
                r[i] = b[indexB];
                indexB++;
            }
        }
    }

    /**
     * Sorts the elements of the parameter int[] a in ascending order.
     *
     * @cpu O(nlog(n)) n = a.length
     * @ram O(n), n = a.length
     *
     * @param a int[]
     */
    public static void mergeSort(int[] a) {
        int[] tmp;
        int[] currentScr = a;
        int[] t = new int[a.length];
        int size = 1;
        while (size < a.length) {
            for (int i = 0; i < a.length; i += size * 2) {
                int fromTo = i + size;
                if (fromTo >= a.length) {
                    fromTo = a.length - 1;
                }
                int to = i + size * 2;
                if (to >= a.length) {
                    to = a.length;
                }
                merge(currentScr, i, fromTo, currentScr, fromTo, to, t, i);
            }
            tmp = currentScr;
            currentScr = t;
            t = tmp;
            size = size * 2;
        }
        System.arraycopy(currentScr, 0, a, 0, a.length);
    }

    /**
     * Sorts the elements of the parameter int[] array in ascending order
     *          from index of the parameter fromIndex including to the index of the parameter toIndex excluding.
     *
     * @cpu O(nlog(n)) n = array.length
     * @ram O(n) n = array.length
     *
     * @param array int[]
     * @param fromIndex int argument
     * @param toIndex int argument
     */
    public static void mergeSort(int[] array, int fromIndex, int toIndex) {
        int[] tmp;
        int[] currentScr = array;
        int[] t = new int[array.length];
        int size = 1;
        while (size < toIndex) {
            for (int i = fromIndex; i < toIndex; i += size * 2) {
                int fromTo = i + size;
                if (fromTo >= toIndex) {
                    fromTo = toIndex - 1;
                }
                int to = i + size * 2;
                if (to >= toIndex) {
                    to = toIndex;
                }
                merge(currentScr, i, fromTo, currentScr, fromTo, to, t, i);
            }
            tmp = currentScr;
            currentScr = t;
            t = tmp;
            size = size * 2;
        }
        System.arraycopy(currentScr, fromIndex, array, fromIndex, toIndex - fromIndex);
    }

    /**
     * Copies objects from array a (interval [aFrom, aTo)) and array b (interval [bFrom, bTo))
     *          into array r (by interval [rFrom, rFrom + aTo - aFrom + bTo - bFrom).
     *
     * @cpu O(n) n = rFrom + aTo - aFrom + bTo - bFrom - rFrom
     * @ram O(1)
     *
     * @param a Event[] sorted in ascending order from position aFrom to position aTo
     * @param aFrom int argument
     * @param aTo int argument
     * @param b Event[] sorted in ascending order from position bFrom to position bTo
     * @param bFrom int argument
     * @param bTo int argument
     * @param r Event[]
     * @param rFrom int argument
     */
    public static void merge(Event[] a, int aFrom, int aTo, Event[] b, int bFrom, int bTo, Event[] r, int rFrom) {
        int indexA = aFrom;
        int indexB = bFrom;
        int rTo = rFrom + aTo - aFrom + bTo - bFrom;
        for (int i = rFrom; i < rTo; i++) {
            if (indexA < aTo && (indexB >= bTo || a[indexA].compareTo(b[indexB]) <= 0)) {
                r[i] = a[indexA];
                indexA++;
            } else {
                r[i] = b[indexB];
                indexB++;
            }
        }
    }

    /**
     * Sorts the parameter events array by ascending date.
     *
     * @cpu O(nlog(n)) n= events.length
     * @ram O(n) n = events.length
     *
     * @param events Event[]
     */
    public static void mergeSort(Event[] events) {
        Event[] tmp;
        Event[] currentScr = events;
        Event[] t = new Event[events.length];
        int size = 1;
        while (size < events.length) {
            for (int i = 0; i < events.length; i += size * 2) {
                int fromTo = i + size;
                if (fromTo >= events.length) {
                    fromTo = events.length - 1;
                }
                int to = i + size * 2;
                if (to >= events.length) {
                    to = events.length;
                }
                merge(currentScr, i, fromTo, currentScr, fromTo, to, t, i);
            }
            tmp = currentScr;
            currentScr = t;
            t = tmp;
            size = size * 2;
        }
        System.arraycopy(currentScr, 0, events, 0, events.length);
    }

    /**
     * Sorts the parameter events array by ascending date
     *          from the index equals to the parameter fromIndex including
     *          to the index equals to the parameter toIndex excluding.
     *
     * @cpu O(nlog(n)) n = array.length
     * @ram O(n) n = array.length
     *
     * @param array Event[]
     * @param fromIndex int argument
     * @param toIndex int argument
     */
    public static void mergeSort(Event[] array, int fromIndex, int toIndex) {
        Event[] tmp;
        Event[] currentScr = array;
        Event[] t = new Event[array.length];
        int size = 1;
        while (size < toIndex) {
            for (int i = fromIndex; i < toIndex; i += size * 2) {
                int fromTo = i + size;
                if (fromTo >= toIndex) {
                    fromTo = toIndex - 1;
                }
                int to = i + size * 2;
                if (to >= toIndex) {
                    to = toIndex;
                }
                merge(currentScr, i, fromTo, currentScr, fromTo, to, t, i);
            }
            tmp = currentScr;
            currentScr = t;
            t = tmp;
            size = size * 2;
        }
        System.arraycopy(currentScr, fromIndex, array, fromIndex, toIndex - fromIndex);
    }
}
