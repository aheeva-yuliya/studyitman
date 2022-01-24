package collections.map;

public interface Map<K, V> extends Iterable<Map.Entry<K, V>> {
    int size();
    boolean isEmpty();
    V put(K key, V value);
    void putAll(Map<? extends K, ? extends V> map);
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    V get(Object key);
    V remove(Object key);
    void clear();
    Entry<K, V>[] toArray();

    interface Entry<K, V> {
        K getKey();
        V getValue();
    }
}
