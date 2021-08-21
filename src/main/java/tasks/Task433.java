package tasks;

/**
 * Task433
 */
public class Task433 {
    /**
     * Finds greatest common divisor.
     *
     * @cpu O(log(n))
     * @ram O(1)
     *
     * @param a argument
     * @param b argument
     * @return greatest common divisor of two arguments.
     */
    public static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
