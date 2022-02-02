package collections.collection.list;

import collections.collection.Collection;
import collections.collection.ListIterator;

import java.util.Comparator;

/**
 * List.
 *
 * @param <T> type
 */
public interface List<T> extends Collection<T> {
    /**
     * Add.
     *
     * @param element element
     * @param index index
     * @return boolean
     */
    boolean add(final int index, final T element);

    /**
     * Add all.
     *
     * @param collection collection
     * @param index index
     * @return boolean
     */
    boolean addAll(final int index, final Collection<? extends T> collection);

    /**
     * Get.
     *
     * @param index index
     * @return type
     */
    T get(int index);

    /**
     * Set.
     *
     * @param index index
     * @param element element
     */
    void set(final int index, final T element);

    /**
     * Remove.
     *
     * @param index index
     * @return type
     */
    T remove(final int index);

    /**
     * Sort.
     *
     * @param comparator comparator
     */
    void sort(final Comparator<? super T> comparator);

    /**
     * ListIterator.
     *
     * @return ListIterator.
     */
    ListIterator<T> iterator();
}
