package tasks;

/**
 * Task499
 */
public class Task499 {

    /**
     * Finds the number of subarrays in which the sum of elements equals to the parameter k.
     *
     * @cpu O(n * k), k = parameter k and n = a.length
     * @ram O(1)
     *
     * @param a int[]
     * @param k int argument
     * @return a number of subarrays.
     */
    public static int solve(int[] a, int k) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            int r = i;
            int sum = 0;
            do {
                sum += a[r];
                r++;
            } while (sum < k && r < a.length);
            if (sum == k) {
                result++;
            }
        }
        return result;
    }
}
