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
        int sum;
        while (l < a.length) {
            sum = a[l];
            while (sum < k && r < a.length - 1) {
                r++;
                sum = sum + a[r];
            }
            if (sum == k) {
                result++;
            }
            l++;
            r = l;
        }
        return result;
    }
}
