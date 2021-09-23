package tasks;

/**
 * Task498
 */
public class Task498 {
    /**
     * Calculates a moving average of every n parameter a array elements.
     *
     * @cpu O(n * m) n = parameter n and m = a.length
     * @ram O(m - n) n = parameter n and m = a.length
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
        for (int i = 0; i < result.length; i++) {
            double sum = 0;
            for (int j = i; j < i + n; j++) {
                sum += a[j];
            }
            result[i] = sum / n;
        }
        return result;
    }
}
