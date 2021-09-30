package tasks;

import utils.ArrayUtils;

/**
 * Task495
 */
public class Task495 {
    /**
     * Finds the number of pairs i and j for which i < j and a[i] + a[j] = k.
     *
     * @cpu O(nlog(n)) n = a.length
     * @ram O(1)
     *
     * @param a int[]
     * @param k int argument
     * @return a number of pairs.
     */
    public static long solveByBinarySearch(int[] a, int k) {
        if (a.length == 0) {
            return 0;
        }
        long result = 0;
        int j = a.length;
        for (int i = 0; i < j; i++) {
            int minIndex = ArrayUtils.binarySearch(a, k - a[i]);
            if (minIndex >= 0) {
                if (minIndex > i) {
                    j = minIndex;
                }
                int maxIndex = ArrayUtils.binarySearch(a, k - a[i] + 1);
                if (maxIndex < 0) {
                    maxIndex = -maxIndex - 1;
                }
                if (minIndex <= i) {
                    minIndex = i + 1;
                    j = maxIndex;
                }
                result = result + maxIndex - minIndex;
            }
        }
        return result;
    }

    /**
     * Finds the number of pairs i and j for which i < j and a[i] + a[j] = k.
     *
     * cpu O(nlog(n)) n = a.length
     * @ram O(1)
     *
     * @param a int[]
     * @param k int argument
     * @return a number of pairs.
     */
    public static long solveByTwoPointers(int[] a, int k) {
        long count = 0;
        int r = a.length - 1;
        for (int i = 0; i < r; i++) {
            while (i < r && a[i] + a[r] > k) {
                r--;
            }
            while (i < r && a[i] + a[r] == k && a[i] != a[i + 1]) {
                count++;
                r--;
            }
            int j = r;
            while (i < r && a[i] + a[r] == k && a[i] == a[i + 1]) {
                count++;
                r--;
            }
            r = j;
        }
        return count;
    }
}
