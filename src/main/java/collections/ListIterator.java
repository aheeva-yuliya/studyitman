package collections;

import java.util.Iterator;

/**
 * ListIterator.
 *
 * @param <T> type
 */
public interface ListIterator<T> extends Iterator<T> {
    /**
     * Set.
     *
     * @param element type
     */
    void set(final T element);

    /**
     * Insert before.
     *
     * @param element type
     */
    void insertBefore(final T element);
}
