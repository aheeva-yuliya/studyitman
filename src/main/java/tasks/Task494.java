package tasks;

import utils.ArrayUtils;

/**
 * Task494
 */
public class Task494 {

    /**
     * Counts the number of elements that are in array a equal to b[i].
     *
     * @cpu O(m * log(n) * n) n = a.length m = b.length
     * @ram O(m), m = b.length
     *
     * @param a int[]
     * @param b int[]
     * @return an array of length m, where at the i-th position is the number of elements
     *          that are in the array a equal to b[i].
     */
    public static int[] solveByBinarySearch(int[] a, int[] b) {
        int[] result = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            int index = ArrayUtils.binarySearch(a,b[i]);
            if (index < 0) {
                result[i] = 0;
            } else {
                int count = 0;
                while (index < a.length && a[index] == b[i]) {
                    count++;
                    index++;
                }
                result[i] = count;
            }
        }
        return result;
    }
}
