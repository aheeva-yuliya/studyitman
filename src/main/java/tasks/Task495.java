package tasks;

import utils.ArrayUtils;

/**
 * Task495
 */
public class Task495 {
    /**
     * Finds the number of pairs i and j for which i < j and a[i] + a[j] = k.
     *
     * @cpu O(nlogn) n = a.length
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
            if (minIndex > 0) {
                j = minIndex;
                int maxIndex = ArrayUtils.binarySearch(a, k - a[i] + 1);
                if (maxIndex > 0) {
                    result = result + maxIndex - 1 - minIndex;
                }
                if (maxIndex < 0) {
                    maxIndex = -maxIndex - 1;
                    result = result + maxIndex - minIndex;
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
        for (int i = 0; i < j; i++) {
            while (a[i] + a[j] > k) {
                j--;
            }
            long pairs = 0;
            while (i < j && a[i] + a[j] == k) {
                pairs++;
                j--;
            }
            long times = 1;
            while (i < j && a[i + 1] == a[i]) {
                times++;
                i++;
            }
            count = count + pairs * times;
        }
        return count;
    }
}
