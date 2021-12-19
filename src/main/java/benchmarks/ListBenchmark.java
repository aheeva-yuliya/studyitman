package benchmarks;

import collections.ArrayList;
import collections.LinkedList;

/**
 * ListBenchmark.
 */
public class ListBenchmark {

    /**
     * Creates an object of ArrayList with the capacity equals to the parameter length
     *          and adds all integers from 0 to length.
     *
     * @cpu O(n) n = length
     * @ram O(n) n = length
     *
     * @param length int argument
     * @return an object of ArrayList.
     */
    public static ArrayList createArrayListWithCapacity(final int length) {
        final ArrayList withCapacity = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            withCapacity.add(i);
        }
        return withCapacity;
    }

    /**
     * Creates an object of ArrayList containing all integers from 0 to length.
     *
     * @cpu O(n) n = length
     * @ram O(n) n = length
     *
     * @param length int argument
     * @return an object of ArrayList
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
     * createArrayListWithCapacity: 0.162s
     * createArrayList: 0.328s
     * createLinkedList: 2.188s
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        createArrayListWithCapacity(10000000);
        long finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        start = System.currentTimeMillis();
        createArrayList(10000000);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);

        start = System.currentTimeMillis();
        createLinkedList(10000000);
        finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000.0);
    }
}
