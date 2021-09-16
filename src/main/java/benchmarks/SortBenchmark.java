package benchmarks;

import entities.Event;
import utils.ArrayUtils;

import java.util.Random;

/**
 * SortBenchmark
 */
public class SortBenchmark {
    /**
     * Creates an int[] with the elements generated by a stream of pseudorandom numbers.
     *
     * @cpu O(n)
     * @ram O(n)
     *
     * @param n int argument represents the length of the future array
     * @param min int argument represents the lower bound
     * @param max int argument represents the upper bound
     * @return int[] of pseudorandom numbers
     */
    public static int[] randomArray(int n, int min, int max) {
        Random rnd = new Random(1);
        int[] random = new int[n];
        for (int i = 0; i < n; i++) {
            random[i] = rnd.nextInt(max - min) + min;
        }
        return random;
    }

    /**
     * Creates an Event[] with the fields of the objects generated by a stream of pseudorandom numbers.
     *
     * @cpu O(n)
     * @ram O(n)
     *
     * @param n int argument represents the length of the future array
     * @param min int argument represents the lower bound of the field year
     * @param max int argument represents the upper bound of the field year
     * @return Event[] of pseudorandom events
     */
    public static Event[] randomEvents(int n, int min, int max) {
        Random rnd = new Random(1);
        Event[] random = new Event[n];
        for (int i = 0; i < n; i++) {
            int year = rnd.nextInt(max - min) + min;
            int month = rnd.nextInt(12) + 1;
            int day = rnd.nextInt(31) + 1;
            String name = Long.toString(rnd.nextLong());
            random[i] = new Event(year, month, day, name);
        }
        return random;
    }

    /**
     * bsp1: 0.28s
     * bsp2: 0.27s
     * bsp3: 23.59s
     * bsp4: 23.50s
     *
     * bso1: 1.22s
     * bso2: 0.96s
     * bso3: 225.82s
     * bso4: 236.07s
     *
     * сsp1: 0.001s
     * сsp2: OutOfMemory
     * сsp3: 0.003s
     * сsp4: OutOfMemory
     */
    public static void main(String[] args) {
        int[] bsp1 = randomArray(10000, -10000, 10000);
        long start = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bsp1);
        long finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        int[] bsp2 = randomArray(10000, -1000000000, 1000000000);
        start = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bsp2);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        int[] bsp3 = randomArray(100000, -10000, 10000);
        start = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bsp3);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        int[] bsp4 = randomArray(100000, -1000000000, 1000000000);
        start = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bsp4);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        Event[] bso1 = randomEvents(10000, 2000, 2021);
        start = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bso1);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        Event[] bso2 = randomEvents(10000, -1000000, 1000000);
        start = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bso2);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        Event[] bso3 = randomEvents(100000, 2000, 2021);
        start = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bso3);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        Event[] bso4 = randomEvents(100000, -1000000, 1000000);
        start = System.currentTimeMillis();
        ArrayUtils.bubbleSort(bso4);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        int[] csp1 = randomArray(10000, -10000, 10000);
        start = System.currentTimeMillis();
        ArrayUtils.countingSort(csp1);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        int[] csp2 = randomArray(10000, -1000000000, 1000000000);
        start = System.currentTimeMillis();
        ArrayUtils.countingSort(csp2);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        int[] csp3 = randomArray(100000, -10000, 10000);
        start = System.currentTimeMillis();
        ArrayUtils.countingSort(csp3);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        int[] csp4 = randomArray(100000, -1000000000, 1000000000);
        start = System.currentTimeMillis();
        ArrayUtils.countingSort(csp4);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);
    }
}
