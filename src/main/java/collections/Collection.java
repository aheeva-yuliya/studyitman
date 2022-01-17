package collections;

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
    boolean addAll(Collection<T> collection);

    /**
     * Contains.
     *
     * @param element element
     * @return boolean
     */
    boolean contains(T element);

    /**
     * Remove.
     *
     * @param element element
     * @return boolean
     */
    boolean remove(T element);

    /**
     * Contains all.
     *
     * @param collection collection
     * @return boolean
     */
    boolean containsAll(Collection<T> collection);

    /**
     * Remove all.
     *
     * @param collection collection
     */
    void removeAll(Collection<T> collection);

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
}
