package tasks;

import utils.ArrayUtils;

/**
 *
 */
public class Task495 {
    /**
     * Finds the number of pairs i and j for which i < j and a[i] + a[j] = k.
     *
     * @cpu O(n^2) n = a.length
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
        int key = a[0];
        key = k - key;
        int length = ArrayUtils.binarySearch(a,key) + Task494.solveByBinarySearch(a,new int[] {key})[0];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[i] + a[j] == k) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * Finds the number of pairs i and j for which i < j and a[i] + a[j] = k.
     *
     * cpu O(n) n = a.length
     * @ram O(1)
     *
     * @param a int[]
     * @param k int argument
     * @return a number of pairs.
     */
    public static long solveByTwoPointers(int[] a, int k) {
        long count = 0;
        int j = a.length - 1;
        int r = j;
        for (int i = 0; i < r + 1; i++) {
            j = r;
            while (a[i] + a[j] > k && i < j) {
                j--;
            }
            if (a[i] + a[j] == k) {
                r = j;
                while (a[i] + a[j] == k && i < j) {
                    count++;
                    j--;
                }
            }
        }
        return count;
    }
}
