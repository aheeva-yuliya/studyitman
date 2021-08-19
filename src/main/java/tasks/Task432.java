package tasks;

/**
 * Task432
 */
public class Task432 {
    /**
     * Calcs all unique prime divisors.
     *
     * @cpu O(nlogn)
     * @ram O(1)
     *
     * @param x long argument
     * @return an array containing factors in ascending order.
     */
    public static long[] calcPrimeNumbers(long x) {
        long[] countDivs = new long[10];
        if (x == 1) {
            countDivs = new long[0];
            return countDivs;
        }
        boolean isPrime = true;
        for (long i = 2; i < 100; i++) {
            if (x % i == 0) {
                isPrime = false;
            }
        }
        if (isPrime) {
            countDivs = new long[] {x};
            return countDivs;
        }
        int count = 0;
        for(long i = 2; i <= x; i++) {
            if (x % i == 0) {
                countDivs[count] = i;
                count++;
                do {
                    x = x / i;
                } while(x % i == 0);
            }
        }
        long[] primeDivs = new long[count];
        for (int i = 0; i < count; i++) {
            primeDivs[i] = countDivs[i];
        }
        return primeDivs;
    }
}
