package collections.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class HashMap<K, V> implements Map<K, V> {
    private Entry<K, V>[] data;
    private int size;
    private static final double LOAD_FACTOR = 0.75;
    private int modificationCount;

    public HashMap() {
        data = new Entry[4];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

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

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        modificationCount++;
    }

    @Override
    public boolean containsKey(Object key) {
        return findEntry(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Map.Entry<K, V> entry : this) {
            if (Objects.equals(entry.getValue(), value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(final Object key) {
        Entry<K, V> entry = findEntry(key);
        return entry == null ? null : entry.value;
    }

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

    @Override
    public void clear() {
        if (size > 0) {
            Arrays.fill(data, null);
            size = 0;
            modificationCount++;
        }
    }

    @Override
    public Map.Entry<K, V>[] toArray() {
        int index = 0;
        Map.Entry<K, V>[] entries = new Entry[size];
        Iterator<Map.Entry<K, V>> iterator = iterator();
        while (iterator().hasNext()) {
            entries[index++] = iterator.next();
        }
        return entries;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new MapIterator();
    }

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
    }

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
