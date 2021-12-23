package tasks;

import collections.IntArrayList;

/**
 * FibonacciCalculator.
 */
public class FibonacciCalculator {
    private final IntArrayList cache = IntArrayList.of(0, 1);

    /**
     * Finds the Fn Fibonacci number using cache.
     *
     * @cpu O(n) the parameter n
     * @ram O(n) the parameter n
     *
     * @param n int argument
     * @return the Fn Fibonacci number.
     */
    public int calc(int n) {
        if (cache.size() > n) {
            return cache.get(n);
        } else {
            cache.add(calc(n - 1) + calc(n - 2));
        }
        return cache.get(n);
    }
}
