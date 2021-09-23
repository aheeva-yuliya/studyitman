package tasks;

/**
 * Task497
 */
public class Task497 {

    /**
     * Returns a sorted array of length n + m containing all elements from two parameter arrays a and b.
     *
     * @cpu O(n + m), n = a.length m = b.length
     * @ram O(n + m), n = a.length m = b.length
     *
     * @param a int[]
     * @param b int[]
     * @return a sorted array out of two parameter arrays.
     */
    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int k = 0;
        int l = 0;
        for (int i = 0; i < c.length; i++) {
            if (k < a.length && l < b.length && a[k] <= b[l] || k < a.length && l == b.length) {
                c[i] = a[k];
                k++;
            } else if (l < b.length && k < a.length && b[l] <= a[k] || l < b.length && k == a.length) {
                c[i] = b[l];
                l++;
            }
        }
        return c;
    }
}
