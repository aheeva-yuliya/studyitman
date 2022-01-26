package collections.collection.set;

import collections.collection.Collection;
import collections.map.HashMap;
import collections.map.Map;
import utils.StringBuilder;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class HashSet<T> implements Set<T> {
    private final Map<T, Boolean> map;

    /**
     * HashSet.
     */
    public HashSet() {
        map = new HashMap<>();
    }

    /**
     * HashSet.
     *
     * @param capacity int
     */
    public HashSet(final int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity is less than zero.");
        }
        map = new HashMap<>(capacity);
    }

    /**
     * HashSet.
     *
     * @param collection collection
     */
    public HashSet(final Collection<? extends T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null.");
        }
        map = new HashMap<>(collection.size());
        addAll(collection);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean add(final T element) {
        map.put(element, Boolean.TRUE);
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null.");
        }
        for (T t : collection) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean contains(final Object element) {
        return map.containsKey(element);
    }

    @Override
    public boolean remove(final Object element) {
        return map.remove(element) != null;
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null.");
        }
        for (Object object : collection) {
            if (!contains(object)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void removeAll(final Collection<?> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null.");
        }
        for (Object object : collection) {
            remove(object);
        }
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object[] toArray() {
        final Object[] result = new Object[map.size()];
        int i = 0;
        for (T t : this) {
            result[i++] = t;
        }
        return result;
    }

    @Override
    public T[] toArray(final IntFunction<T[]> factory) {
        if (factory == null) {
            throw new IllegalArgumentException("IntFunction is null.");
        }
        T[] result = factory.apply(map.size());
        int i = 0;
        for (T t : this) {
            result[i++] = t;
        }
        return result;
    }

    @Override
    public void removeIf(final Predicate<? super T> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate is null.");
        }
        for (T element : this) {
            if (predicate.test(element)) {
                remove(element);
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (T element : this) {
            hash += element.hashCode();
        }
        return hash;
    }

    /**
     * Equals.
     *
     * @param obj object
     * @return boolean
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        final Set<Object> that = (Set<Object>) obj;
        if (map.size() != that.size()) {
            return false;
        }
        return containsAll(that);
    }

    @Override
    public String toString() {
        final StringBuilder listToString = new StringBuilder();
        final Iterator<T> iterator = iterator();
        listToString.append("[");
        while (iterator.hasNext()) {
            T object = iterator.next();
            listToString.append(object == null ? "null" : object.toString());
            if (iterator.hasNext()) {
                listToString.append(", ");
            }
        }
        listToString.append("]");
        return listToString.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new HashSetIterator();
    }

    private class HashSetIterator implements Iterator<T> {
        private final Iterator<Map.Entry<T, Boolean>> mapIterator = map.iterator();

        @Override
        public boolean hasNext() {
            return mapIterator.hasNext();
        }

        @Override
        public T next() {
            try {
                return mapIterator.next().getKey();
            } catch (final ConcurrentModificationException e) {
                throw new ConcurrentModificationException("Set was modified.");
            }
        }
    }
}
