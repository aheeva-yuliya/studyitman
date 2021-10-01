package tasks;

import utils.ArrayUtils;

/**
 * Task511
 */
public class Task511 {
    /**
     * Counts the number of elements that are contained simultaneously in two arrays. Each element is counted once.
     *
     * @cpu O(n * (log(n) + log(m)), n = a.length and m = b.length
     * @ram O(n + m), n = a.length and m = b.length
     *
     * @param a int[]
     * @param b int[]
     * @return the number of same elements
     */
    public static int countEquals(int[] a, int[] b) {
        int equals = 0;
        int[] tempA = new int [a.length];
        System.arraycopy(a,0, tempA, 0, a.length);
        int[] tempB = new int[b.length];
        System.arraycopy(b, 0, tempB, 0, b.length);
        ArrayUtils.mergeSort(tempA);
        ArrayUtils.mergeSort(tempB);
        for (int i = 0; i < a.length; i++) {
            int indexMinB = ArrayUtils.binarySearch(tempB, tempA[i]);
            if (indexMinB >= 0) {
                int indexMaxA;
                int indexMaxB;
                if (tempA[i] == 2147483647) {
                    indexMaxA = tempA.length;
                    indexMaxB = tempB.length;
                } else {
                    indexMaxB = ArrayUtils.binarySearch(tempB, tempA[i] + 1);
                    if (indexMaxB < 0) {
                        indexMaxB = -indexMaxB - 1;
                    }
                    indexMaxA = ArrayUtils.binarySearch(tempA, tempA[i] + 1);
                    if (indexMaxA < 0) {
                        indexMaxA = -indexMaxA - 1;
                    }
                }
                int count = Math.min(indexMaxB - indexMinB, indexMaxA - i);
                equals = equals + count;
                i = indexMaxA - 1;
            }
        }
        return equals;
    }
}
