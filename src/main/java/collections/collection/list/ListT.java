package collections.collection.list;

import collections.collection.Collection;
import collections.collection.ListIterator;
import utils.StringBuilder;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * List.
 *
 * @param <T> type
 */
@SuppressWarnings("unchecked")
public abstract class ListT<T> {
    protected int size;
    protected int modificationCount;

    /**
     * Size.
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Is Empty.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add.
     *
     * @param element element
     * @return boolean
     */
    public abstract boolean add(final T element);

    /**
     * Add.
     *
     * @param index index
     * @param element element
     * @return boolean
     */
    public abstract boolean add(final int index, final T element);

    /**
     * Add all.
     *
     * @param collection collection
     * @return boolean
     */
    public boolean addAll(final Collection<? extends T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        for (T t : collection) {
            add(t);
        }
        return true;
    }

    /**
     * Contains.
     *
     * @param element element
     * @return boolean
     */
    public boolean contains(final Object element) {
        final ListIterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            if (Objects.equals(iterator.next(), element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Contains all.
     *
     * @param collection collection
     * @return boolean
     */
    public boolean containsAll(final Collection<?> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        for (Object t : collection) {
            if (!contains(t)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Remove.
     *
     * @param element element
     * @return boolean
     */
    public abstract boolean remove(final Object element);

    /**
     * Remove all.
     *
     * @param collection collection
     */
    public void removeAll(final Collection<?> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        final ListIterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            if (collection.contains(iterator.next())) {
                iterator.remove();
            }
        }
    }

    /**
     * Remove if.
     *
     * @param predicate predicate
     */
    public void removeIf(final Predicate<? super T> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate is null");
        }
        final ListIterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            if (predicate.test(iterator.next())) {
                iterator.remove();
            }
        }
    }

    /**
     * Equals.
     *
     * @param obj object
     * @return boolean
     */
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        final List<Object> that = (List<Object>) obj;
        if (this.size != that.size()) {
            return false;
        }
        return containsAll(that);
    }

    /**
     * To string.
     *
     * @return string
     */
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

    /**
     * Hash code.
     *
     * @return int
     */
    public int hashCode() {
        int hash = 0;
        ListIterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            hash += iterator.next().hashCode();
        }
        return hash;
    }

    /**
     * To array.
     *
     * @return array
     */
    public Object[] toArray() {
        final Object[] result = new Object[size];
        final Iterator<T> iterator = iterator();
        for (int i = 0; i < size; i++) {
            result[i] = iterator.next();
        }
        return result;
    }

    /**
     * To array.
     *
     * @param factory factory
     * @return array
     */
    public T[] toArray(final IntFunction<T[]> factory) {
        if (factory == null) {
            throw new IllegalArgumentException("IntFunction is null");
        }
        T[] result = factory.apply(size);
        final Iterator<T> iterator = iterator();
        for (int i = 0; i < size; i++) {
            result[i] = iterator.next();
        }
        return result;
    }

    /**
     * Iterator.
     *
     * @return iterator
     */
    public abstract ListIterator<T> iterator();

    protected T[] listSort(final Comparator<? super T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator is null");
        }
        T[] array = toArray(size -> (T[]) new Object[size]);
        mergeSort(array, comparator);
        return array;
    }

    private static <T> void mergeSort(T[] array, Comparator<T> comparator) {
        final int length = array.length;
        T[] currentScr = (T[]) new Object[length];
        System.arraycopy(array, 0, currentScr, 0, length);
        T[] destination = (T[]) new Object[length];
        int size = 1;
        while (size < length) {
            for (int i = 0; i < length; i += size * 2) {
                int fromTo = i + size;
                if (fromTo >= length) {
                    fromTo = length - 1;
                }
                int to = i + size * 2;
                if (to > length) {
                    to = length;
                }
                merge(currentScr, i, fromTo, currentScr, fromTo, to, destination, i, comparator);
            }
            T[] tmp = currentScr;
            currentScr = destination;
            destination = tmp;
            size = size * 2;
        }
        System.arraycopy(currentScr, 0, array, 0, length);
    }

    private static <T> void merge(T[] a, int aFrom, int aTo, T[] b, int bFrom, int bTo, T[] r, int rFrom,
                                  Comparator<T> comparator) {
        int indexA = aFrom;
        int indexB = bFrom;
        int rTo = rFrom + aTo - aFrom + bTo - bFrom;
        for (int i = rFrom; i < rTo; i++) {
            if (indexA < aTo && (indexB >= bTo || comparator.compare(a[indexA], b[indexB]) <= 0)) {
                r[i] = a[indexA];
                indexA++;
            } else {
                r[i] = b[indexB];
                indexB++;
            }
        }
    }
}