package tasks;

/**
 * Task538
 */
public class Task538 {

    /**
     * Finds the Fn Fibonacci number.
     *
     * @cpu O(2^n) the parameter n
     * @ram O(n) the parameter n
     *
     * @param n int argument
     * @return the Fn Fibonacci number.
     */
    public static int calcFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return calcFibonacci(n - 1) + calcFibonacci(n - 2);
        }
    }
}
