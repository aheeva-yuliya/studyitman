package collections;

import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * Collection.
 *
 * @param <T> type
 */
public interface Collection<T> extends Iterable<T> {
    /**
     * Size.
     *
     * @return size
     */
    int size();

    /**
     * Is Empty.
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Add.
     *
     * @param element element
     * @return boolean
     */
    boolean add(T element);

    /**
     * Add all.
     *
     * @param collection collection
     * @return boolean
     */
    boolean addAll(final Collection<? extends T> collection);

    /**
     * Contains.
     *
     * @param element element
     * @return boolean
     */
    boolean contains(final Object element);

    /**
     * Remove.
     *
     * @param element element
     * @return boolean
     */
    boolean remove(final Object element);

    /**
     * Contains all.
     *
     * @param collection collection
     * @return boolean
     */
    boolean containsAll(final Collection<?> collection);

    /**
     * Remove all.
     *
     * @param collection collection
     */
    void removeAll(Collection<?> collection);

    /**
     * Clear.
     */
    void clear();

    /**
     * To array.
     *
     * @return array
     */
    Object[] toArray();

    /**
     * To array.
     *
     * @param factory factory
     * @return type array
     */
    T[] toArray(IntFunction<T[]> factory);

    /**
     * Remove if.
     *
     * @param predicate predicate
     */
    void removeIf(Predicate<? super T> predicate);
}
