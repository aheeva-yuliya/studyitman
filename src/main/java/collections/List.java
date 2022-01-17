package collections;

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
    boolean add(int index, T element);

    /**
     * Add all.
     *
     * @param collection collection
     * @param index index
     * @return boolean
     */
    boolean addAll(int index, Collection<T> collection);

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
    void set(int index, T element);

    /**
     * Remove.
     *
     * @param index index
     * @return type
     */
    T remove(int index);
}
