package tasks;

/**
 * Task499
 */
public class Task499 {

    /**
     * Finds the number of subarrays in which the sum of elements equals to the parameter k.
     *
     * @cpu O(n), n = a.length
     * @ram O(1)
     *
     * @param a int[]
     * @param k int argument
     * @return a number of subarrays.
     */
    public static int solve(int[] a, int k) {
        int result = 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (l < a.length) {
            if (sum < k && r < a.length) {
                sum = sum + a[r];
                r++;
            } else {
                if (sum == k) {
                    result++;
                }
                sum = sum - a[l];
                l++;
            }
        }
        return result;
    }
}
