package tasks;

import collections.ArrayList;

/**
 * CountingSortTask
 */
public class CountingSortTask {

    /**
     * Counts how many times each element occurs in the parameter array.
     *
     * @cpu O(n), n = the length of the parameter array
     * @ram O(m), m = the maximum value of the parameter array
     *
     * @param array int[]
     * @return an array containing at position "i" the number of elements equal to "i" in the original array.
     */
    public static int[] count(int[] array) {
        if(array.length == 0) {
            return new int[]{};
        }
        int max = maxValue(array);
        int[] result = new int[max + 1];
        for (int num : array) {
            result[num]++;
        }
        return result;
    }

    private static int maxValue(int[] array) {
        int max = 0;
        for (int j : array) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    /**
     * Returns an array that contains numbers in the range 0 through the parameter array length.
     * Each number X is contained exactly array[X] times. The numbers in the resulting array are in ascending order.
     *
     * @cpu O(n + l), n = array.length and l = the sum of the elements of the array
     * @ram O(l)  l = the sum of the elements of the array
     *
     * @param array int[]
     * @return int[] with numbers in ascending order
     */
    public static int[] restore(int[] array) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                arrayList.add(i);
            }
        }
        return arrayList.toArray();
    }

    /**
     * Sorts the elements of the parameter int[] array in ascending order.
     *
     * @cpu O(n + m), n = array.length and m = the maximum value of the parameter array
     * @ram O(n + m), n = array.length and m = the maximum value of the parameter array
     *
     * @param array int[]
     */
    public static void sort(int[] array) {
        int[] ints = count(array);
        ints = restore(ints);
        System.arraycopy(ints, 0, array, 0, array.length);
    }
}
