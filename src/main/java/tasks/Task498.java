package tasks;

/**
 * Task498
 */
public class Task498 {
    /**
     * Calculates a moving average of every n parameter a array elements.
     *
     * @cpu O(n) n = a.length
     * @ram O(n) n = a.length
     *
     * @param a double[]
     * @param n int argument
     * @return a moving average with a window width n.
     */
    public static double[] calcMovingAverage(double[] a, int n) {
        if (a.length == 0) {
            return new double[0];
        }
        double[] result = new double[a.length - n + 1];
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (i + 1 < n) {
                sum = sum + a[i] / n;
            } else {
                if (i + 1 == n) {
                    sum = sum + a[i] / n;
                } else {
                    sum = sum + a[i] / n - a[i - n] / n;
                }
                result[i + 1 - n] = sum;
            }
        }
        return result;
    }
}
