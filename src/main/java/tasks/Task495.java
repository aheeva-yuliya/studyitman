package tasks;

import utils.ArrayUtils;

/**
 * Task495.
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
        int index = ArrayUtils.binarySearch(a, k - 1);
        if (index < 0) {
            index = -index - 1;
        }
        for (int i = 0; i < index; i++) {
            int minIndex = ArrayUtils.binarySearch(a, k - a[i]);
            if (minIndex >= 0) {
                int maxIndex = ArrayUtils.binarySearch(a, k - a[i] + 1);
                if (maxIndex < 0) {
                    maxIndex = -maxIndex - 1;
                }
                if (minIndex <= i) {
                    minIndex = i + 1;
                }
                result = result + maxIndex - minIndex;
            }
        }
        return result;
    }

    /**
     * Finds the number of pairs i and j for which i < j and a[i] + a[j] = k.
     *
     * @cpu O(n) n = a.length
     * @ram O(1)
     *
     * @param a int[]
     * @param k int argument
     * @return a number of pairs.
     */
    public static long solveByTwoPointers(int[] a, int k) {
        long count = 0;
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            while (l < r && a[l] + a[r] > k) {
                r--;
            }
            while (l < r && a[l] + a[r] < k) {
                l++;
            }
            while (l < r && a[l] + a[r] == k) {
                int timesR = 1;
                int timesL = 1;
                if (a[l] != a[r]) {
                    while (a[r] == a[r - 1]) {
                        timesR++;
                        r--;
                    }
                    while (a[l] == a[l + 1]) {
                        timesL++;
                        l++;
                    }
                    count = count + timesR * timesL;
                    l++;
                    r--;
                }
                if (a[l] == a[r]) {
                    while (l < r) {
                        count = count + r - l;
                        l++;
                    }
                }
            }
        }
        return count;
    }
}
