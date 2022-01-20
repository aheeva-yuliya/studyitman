package benchmarks;

import collections.ArrayList;
import collections.IntArrayList;
import collections.LinkedList;

/**
 * ListBenchmark.
 */
public class ListBenchmark {

    /**
     * Creates an object of IntArrayList with the capacity equals to the parameter length
     *          and adds all integers from 0 to length.
     *
     * @cpu O(n) n = length
     * @ram O(n) n = length
     *
     * @param length int argument
     * @return an object of IntArrayList.
     */
    public static IntArrayList createIntArrayListWithCapacity(final int length) {
        final IntArrayList withCapacity = new IntArrayList(length);
        for (int i = 0; i < length; i++) {
            withCapacity.add(i);
        }
        return withCapacity;
    }

    /**
     * Creates an object of IntArrayList containing all integers from 0 to length.
     *
     * @cpu O(n) n = length
     * @ram O(n) n = length
     *
     * @param length int argument
     * @return an object of IntArrayList
     */
    public static IntArrayList createIntArrayList(final int length) {
        final IntArrayList intArrayList = new IntArrayList();
        for (int i = 0; i < length; i++) {
            intArrayList.add(i);
        }
        return intArrayList;
    }

    /**
     * Creates an object of IntArrayList containing all integers from 0 to length.
     *
     * @cpu O(n) n = length
     * @ram O(n) n = length
     *
     * @param length int argument
     * @return an object of IntArrayList
     */
    public static ArrayList createArrayList(final int length) {
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    /**
     * Creates an object of LinkedList containing all integers from 0 to length.
     *
     * @cpu O(n) n = length
     * @ram O(n) n = length
     *
     * @param length int argument
     * @return an object of LinkedList
     */
    public static LinkedList createLinkedList(final int length) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < length; i++) {
            linkedList.addLast(i);
        }
        return linkedList;
    }

    /**
     * Main.
     *
     * @param args String[] arguments
     *
     * createIntArrayListWithCapacity: 0.027s
     * createIntArrayList: 0.092s
     * createLinkedList: 0.788s
     * createArrayList: 0.33s
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        createIntArrayListWithCapacity(10000000);
        long finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        start = System.currentTimeMillis();
        createIntArrayList(10000000);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        start = System.currentTimeMillis();
        createLinkedList(10000000);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        start = System.currentTimeMillis();
        createArrayList(10_000_000);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);
    }
}
