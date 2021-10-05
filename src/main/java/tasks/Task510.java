package tasks;

import utils.ArrayUtils;

/**
 * Task510
 */
public class Task510 {

    /**
     * Finds the most frequent number.
     *
     * @cpu O(nlog(n)) n = array.length
     * @ram O(n) n = array.length
     *
     * @param array int[]
     * @return the most frequent number. If there are some returns the smallest.
     */
    public static int mostFrequent(int[] array) {
        int most = 0;
        int mostFrequent = 0;
        int[] tmp = new int[array.length];
        System.arraycopy(array, 0, tmp, 0, array.length);
        ArrayUtils.mergeSort(tmp);
        for (int i = 0; i < tmp.length; i++) {
            int last;
            if (tmp[i] == Integer.MAX_VALUE) {
                last = array.length;
            } else {
                last = ArrayUtils.binarySearch(tmp, tmp[i] + 1);
            }
            if (last < 0) {
                last = -last - 1;
            }
            int times = last - i;
            if (most < times) {
                most = times;
                mostFrequent = tmp[i];
            }
            if (array.length > 1) {
                i = last - 1;
            }
        }
        return mostFrequent;
    }
}
