package collections.map;

import utils.StringBuilder;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

/**
 * HashMap.
 *
 * @param <K> object
 * @param <V> object
 */
@SuppressWarnings("unchecked")
public class HashMap<K, V> implements Map<K, V> {
    private Entry<K, V>[] data;
    private int size;
    private static final double LOAD_FACTOR = 0.75;
    private int modificationCount;

    /**
     * HashMap.
     */
    public HashMap() {
        data = new Entry[4];
    }

    /**
     * HashMap.
     *
     * @param capacity int
     */
    public HashMap(final int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity is less than zero.");
        }
        data = new Entry[capacity];
    }

    /**
     * HashMap.
     *
     * @param map map
     */
    public HashMap(final Map<? extends K, ? extends V> map) {
        if (map == null) {
            throw new IllegalArgumentException("Map is null.");
        }
        data = new Entry[map.size()];
        putAll(map);
    }

    /**
     * Size.
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Is empty.
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Put.
     *
     * <p>average @cpu O(1)
     * average @ram O(1)
     *
     * <p>the worst @cpu O(n)
     * the worst @ram O(1)
     *
     * @param key   object
     * @param value object
     * @return old value
     */
    @Override
    public V put(final K key,  final V value) {
        final int hash = calcHash(key);
        final int basket = calcBasket(hash);
        Entry<K, V> entry = data[basket];
        while (entry != null && (entry.hash != hash || !Objects.equals(entry.key, key))) {
            entry = entry.next;
        }
        modificationCount++;
        if (entry == null) {
            data[basket] = new Entry<>(key, value, hash, data[basket]);
            size++;
            resize();
            return null;
        } else {
            final V oldValue = entry.value;
            entry.value = value;
            return oldValue;
        }
    }

    /**
     * Put all.
     *
     * @param map map
     */
    @Override
    public void putAll(final Map<? extends K, ? extends V> map) {
        if (map == null) {
            throw new IllegalArgumentException("Map is null.");
        }
        for (Map.Entry<? extends K, ? extends V> entry : map) {
            final K key = entry.getKey();
            final V value = entry.getValue();
            put(key, value);
        }
    }

    /**
     * Contains key.
     *
     * @param key object
     * @return boolean
     */
    @Override
    public boolean containsKey(final Object key) {
        return findEntry(key) != null;
    }

    /**
     * Contains value.
     *
     * @param value object
     * @return boolean
     */
    @Override
    public boolean containsValue(final Object value) {
        for (Map.Entry<K, V> entry : this) {
            if (Objects.equals(entry.getValue(), value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get.
     *
     * @param key object
     * @return value
     */
    @Override
    public V get(final Object key) {
        Entry<K, V> entry = findEntry(key);
        return entry == null ? null : entry.value;
    }

    /**
     * Remove.
     *
     * @param key object
     * @return value
     */
    @Override
    public V remove(final Object key) {
        final int hash = calcHash(key);
        final int basket = calcBasket(hash);
        Entry<K, V> entry = data[basket];
        Entry<K, V> previous = null;
        Entry<K, V> next = entry == null ? null : entry.next;
        while (entry != null && (entry.hash != hash || !Objects.equals(entry.key, key))) {
            previous = entry;
            entry = entry.next;
            next = entry.next;
        }
        if (previous == null) {
            data[basket] = next;
        } else {
            previous.next = next;
        }
        size--;
        modificationCount++;
        return entry == null ? null : entry.value;
    }

    /**
     * Clear.
     */
    @Override
    public void clear() {
        if (size > 0) {
            Arrays.fill(data, null);
            size = 0;
            modificationCount++;
        }
    }

    /**
     * To array.
     *
     * @return array
     */
    @Override
    public Map.Entry<K, V>[] toArray() {
        int index = 0;
        Map.Entry<K, V>[] entries = new Entry[size];
        for (Map.Entry<K, V> kvEntry : this) {
            entries[index++] = kvEntry;
        }
        return entries;
    }

    /**
     * Equals.
     *
     * @param obj object
     * @return boolean
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        final Map that = (Map) obj;
        if (that.size() != this.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : this) {
            final V value = entry.getValue();
            if (!Objects.equals(value, that.get(entry.getKey()))) {
                return false;
            }
            if (value == null && !that.containsKey(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Hash code.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        for (final Map.Entry<K, V> entry : this) {
            hash += entry.hashCode();
        }
        return hash;
    }

    /**
     * To string.
     *
     * @return string
     */
    @Override
    public String toString() {
        final StringBuilder mapToString = new StringBuilder();
        final Iterator<Map.Entry<K, V>> iterator = iterator();
        mapToString.append("[");
        while (iterator.hasNext()) {
            mapToString.append(iterator.next().toString());
            if (iterator.hasNext()) {
                mapToString.append(", ");
            }
        }
        mapToString.append("]");
        return mapToString.toString();
    }

    /**
     * Iterator.
     *
     * @return iterator
     */
    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new MapIterator();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private class MapIterator implements Iterator<Map.Entry<K, V>> {
        private int nextIndex;
        private Entry<K, V> nextEntry;
        private final int previousModificationCount = modificationCount;


        public MapIterator() {
            findNextEntry();
        }

        @Override
        public boolean hasNext() {
            if (modificationCount != previousModificationCount) {
                throw new ConcurrentModificationException("Map was modified");
            }
            return nextEntry != null;
        }

        @Override
        public Map.Entry<K, V> next() {
            if (modificationCount != previousModificationCount) {
                throw new ConcurrentModificationException("Map was modified");
            }
            final Entry<K, V> current = nextEntry;
            if (nextEntry != null && nextEntry.next != null) {
                nextEntry = nextEntry.next;
            } else {
                nextEntry = null;
                findNextEntry();
            }
            return current;
        }

        private void findNextEntry() {
            while (nextIndex < data.length) {
                if (data[nextIndex] != null) {
                    nextEntry = data[nextIndex++];
                    break;
                }
                nextIndex++;
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static class Entry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;
        private final int hash;
        private Entry<K, V> next;

        public Entry(final K key, final V value, final int hash, final Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public int hashCode() {
            return 31 * hash + (value == null ? 0 : value.hashCode());
        }

        @Override
        public String toString() {
            return "Entry{key=" + key + ", value=" + value + "}";
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int calcHash(final Object key) {
        return key == null ? 0 : key.hashCode();
    }

    private int calcBasket(final int hash, final int length) {
        return Math.abs(hash % length);
    }

    private int calcBasket(final int hash) {
        return calcBasket(hash, data.length);
    }

    private void resize() {
        if (size > data.length * LOAD_FACTOR) {
            final Entry<K, V>[] newData = new Entry[data.length * 2];
            for (final Map.Entry<K, V> entry : this) {
                final int hash = calcHash(entry.getKey()); // зачем пересчитывать хэш
                final int basket = calcBasket(hash, newData.length);
                newData[basket] = new Entry<>(entry.getKey(), entry.getValue(), hash, newData[basket]);
            }
            data = newData;
        }
    }

    private Entry<K, V> findEntry(final Object key) {
        final int hash = calcHash(key);
        final int basket = calcBasket(hash);
        Entry<K, V> entry = data[basket];
        while (entry != null && (entry.hash != hash || !Objects.equals(entry.key, key))) {
            entry = entry.next;
        }
        return entry;
    }
}
