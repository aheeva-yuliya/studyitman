package utils;

import collections.List;

import java.util.Comparator;

/**
 * CollectionUtils.
 */
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
        if (list == null || comparator == null) {
            return null;
        }
        T element = list.isEmpty() ? null : list.get(0);
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
        if (list == null || comparator == null) {
            return null;
        }
        T element = list.isEmpty() ? null : list.get(0);
        for (T t : list) {
            if (comparator.compare(element, t) < 0) {
                element = t;
            }
        }
        return element;
    }
}
