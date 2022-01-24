package utils;

import collections.collection.List;
import collections.collection.ListIterator;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * CollectionUtils.
 */
@SuppressWarnings("unchecked")
public class CollectionUtils {
    /**
     * Find min.
     *
     * @param list list
     * @param comparator comparator
     * @param <T> type
     * @return type
     */
    public static <T> T findMin(final List<T> list, final Comparator<T> comparator) {
        if (list == null) {
            throw new IllegalArgumentException("List is null");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator is null");
        }
        if (list.isEmpty()) {
            return null;
        }
        T element = list.get(0);
        for (T t : list) {
            if (comparator.compare(element, t) > 0) {
                element = t;
            }
        }
        return element;
    }

    /**
     * Find max.
     *
     * @param list list
     * @param comparator comparator
     * @param <T> type
     * @return type
     */
    public static <T> T findMax(final List<T> list, final Comparator<T> comparator) {
        if (list == null) {
            throw new IllegalArgumentException("List is null");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator is null");
        }
        return findMin(list, (o1, o2) -> Integer.compare(0, comparator.compare(o1, o2)));
    }

    /**
     * Binary search.
     *
     * @param list list
     * @param obj obj
     * @param comparator comparator
     * @param <T> type
     * @return int
     */
    public static <T> int binarySearch(final List<T> list, T obj, final Comparator<T> comparator) {
        if (list == null) {
            throw new IllegalArgumentException("List is null");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator is null");
        }
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (comparator.compare(obj, list.get(m)) < 0) {
                r = m - 1;
            } else if (comparator.compare(obj, list.get(m)) > 0) {
                l = m + 1;
            } else {
                if (m - 1 >= 0 && comparator.compare(obj, list.get(m - 1)) == 0) {
                    r = m - 1;
                } else {
                    return m;
                }
            }
        }
        return -(l + 1);
    }

    /**
     * Binary search.
     *
     * @param list list
     * @param obj obj
     * @param <T> type
     * @return int
     */
    public static <T extends Comparable<T>> int binarySearch(final List<T> list, T obj) {
        return binarySearch(list, obj, (Comparable::compareTo));
    }

    /**
     * Sort.
     *
     * @param list list
     * @param <T> type
     */
    public static <T extends Comparable<T>> void sort(final List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List is null");
        }
        list.sort(Comparable::compareTo);
    }

    /**
     * Reverse.
     *
     * @param list list
     * @param <T> type
     */
    public static <T> void reverse(final List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List is null");
        }
        final T[] objects = list.toArray(size -> (T[]) new Object[size]);
        ListIterator<T> iterator = list.iterator();
        for (int i = objects.length - 1; i >= 0; i--) {
            iterator.next();
            iterator.set(objects[i]);
        }
    }

    /**
     * Shuffle.
     *
     * @param list list
     * @param <T> type
     */
    public static <T> void shuffle(final List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List is null");
        }
        final T[] objects = list.toArray(size -> (T[]) new Object[size]);
        final int length = objects.length;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(i, length);
            T temp = objects[randomIndex];
            objects[randomIndex] = objects[i];
            objects[i] = temp;
        }
        ListIterator<T> iterator = list.iterator();
        for (T object : objects) {
            iterator.next();
            iterator.set(object);
        }
    }
}
