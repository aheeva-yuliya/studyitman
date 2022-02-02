package collections.map;

/**
 * Map.
 *
 * @param <K> key
 * @param <V> value
 */
public interface Map<K, V> extends Iterable<Map.Entry<K, V>> {
    /**
     * Size.
     *
     * @return size
     */
    int size();

    /**
     * Is empty.
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Put.
     *
     * @param key   object
     * @param value object
     * @return old value
     */
    V put(K key, V value);

    /**
     * Put all.
     *
     * @param map map
     */
    void putAll(Map<? extends K, ? extends V> map);

    /**
     * Contains key.
     *
     * @param key object
     * @return boolean
     */
    boolean containsKey(Object key);

    /**
     * Contains value.
     *
     * @param value object
     * @return boolean
     */
    boolean containsValue(Object value);

    /**
     * Get.
     *
     * @param key object
     * @return value
     */
    V get(Object key);

    /**
     * Remove.
     *
     * @param key object
     * @return value
     */
    V remove(Object key);

    /**
     * Clear.
     */
    void clear();

    /**
     * To array.
     *
     * @return array
     */
    Entry<K, V>[] toArray();

    /**
     * Entry.
     *
     * @param <K> key
     * @param <V> value
     */
    interface Entry<K, V> {
        /**
         * Get key.
         *
         * @return key
         */
        K getKey();

        /**
         * Get value.
         *
         * @return value
         */
        V getValue();
    }
}
