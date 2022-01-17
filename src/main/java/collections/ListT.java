package collections;

import utils.StringBuilder;

import java.util.Iterator;

/**
 * List.
 *
 * @param <T> type
 */
public abstract class ListT<T> {
    protected int size;

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
    public boolean addAll(final Collection<T> collection) {
        for (T t : collection) {
            add(t);
        }
        return true;
    }

    /**
     * Add all.
     *
     * @param index index
     * @param collection collection
     * @return boolean
     */
    public boolean addAll(int index, final Collection<T> collection) {
        for (T t : collection) {
            add(index++, t);
        }
        return true;
    }

    /**
     * Contains.
     *
     * @param element element
     * @return boolean
     */
    public boolean contains(final T element) {
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
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
    public boolean containsAll(final Collection<T> collection) {
        for (T t : collection) {
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
    public abstract boolean remove(final T element);

    /**
     * Remove all.
     *
     * @param collection collection
     */
    public void removeAll(final Collection<T> collection) {
        for (T t : collection) {
            remove(t);
        }
    }

    /**
     * Equals.
     *
     * @param that collection
     * @return boolean
     */
    public boolean equals(final Collection<T> that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
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
     * Iterator.
     *
     * @return iterator
     */
    public abstract Iterator<T> iterator();
}
