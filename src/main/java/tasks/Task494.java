package tasks;

import utils.ArrayUtils;

/**
 * Task494
 */
public class Task494 {

    /**
     * Counts the number of elements that are in array a equal to b[i].
     *
     * @cpu O(m * log(n))  n = a.length m = b.length
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
            int indexMin = ArrayUtils.binarySearch(a,b[i]);
            if (indexMin < 0) {
                result[i] = 0;
            } else {
                int indexMax = ArrayUtils.binarySearch(a,b[i] + 1);
                if (indexMax < 0) {
                    indexMax = -indexMax - 1;
                }
                result[i] = indexMax - indexMin;
            }
        }
        return result;
    }

    /**
     * Counts the number of elements that are in array a equal to b[i].
     *
     * @cpu O(m * log(n)) n = a.length and m = b.length
     * @ram O(m), m = b.length
     *
     * @param a int[]
     * @param b int[]
     * @return an array of length m, where at the i-th position is the number of elements
     *          that are in the array a equal to b[i].
     */
    public static int[] solveByTwoPointers(int[] a, int[] b) {
        int[] result = new int[b.length];
        int point = 0;
        for (int i = 0; i < b.length; i++) {
            int count = 0;
            if (i > 0 && b[i] == b[i - 1]) {
                count = result[i - 1];
            }
            while (point < a.length && a[point] <= b[i]) {
                if (a[point] == b[i]) {
                    count++;
                }
                point++;
            }
            result[i] = count;
        }
        return result;
    }
}
