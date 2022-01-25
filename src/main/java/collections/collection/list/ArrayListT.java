package collections.collection.list;

import collections.collection.Collection;
import collections.collection.ListIterator;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Objects;
import java.util.RandomAccess;

/**
 * ArrayList.
 *
 * @param <T> type
 */
@SuppressWarnings("unchecked")
public class ArrayListT<T> extends ListT<T> implements List<T>, RandomAccess {
    private T[] array;

    /**
     * ArrayList.
     */
    public ArrayListT() {
        array = (T[]) new Object[2];
    }

    /**
     * ArrayList.
     *
     * @param that collection
     */
    public ArrayListT(final Collection<? extends T> that) {
        if (that == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        array = (T[]) new Object[that.size()];
        addAll(that);
    }

    /**
     * ArrayList.
     *
     * @param capacity int
     */
    public ArrayListT(final int capacity) {
        array = (T[]) new Object[capacity];
    }

    /**
     * Add.
     *
     * @param element element
     * @return boolean
     */
    @Override
    public boolean add(final T element) {
        if (size == array.length) {
            T[] temp = (T[]) new Object[size * 2];
            System.arraycopy(array, 0, temp, 0, size);
            array = temp;
        }
        array[size++] = element;
        modificationCount++;
        return true;
    }

    /**
     * Add.
     *
     * @param index   index
     * @param element element
     * @return boolean
     */
    @Override
    public boolean add(final int index, final T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        if (array.length == size) {
            T[] data = (T[]) new Object[size * 2];
            System.arraycopy(array, 0, data, 0, index);
            System.arraycopy(array, index, data, index + 1, size - index);
            array = data;
        } else {
            System.arraycopy(array, 0, array, 0, index);
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
        modificationCount++;
        return true;
    }

    /**
     * Add all.
     *
     * @param index index
     * @param collection collection
     * @return boolean
     */
    public boolean addAll(int index, final Collection<? extends T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (array.length < size + collection.size()) {
            T[] data = (T[]) new Object[size + collection.size()];
            System.arraycopy(array, 0, data, 0, index);
            System.arraycopy(array, index, data, index + collection.size(), size - index);
            array = data;
        } else {
            System.arraycopy(array, index, array, index + collection.size(), size - index);
        }
        for (T t : collection) {
            array[index++] = t;
        }
        size += collection.size();
        modificationCount++;
        return true;
    }

    /**
     * Remove.
     *
     * @param element element
     * @return boolean
     */
    @Override
    public boolean remove(final Object element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], element)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                array[size - 1] = null;
                size--;
                modificationCount++;
                return true;
            }
        }
        return false;
    }

    /**
     * Remove.
     *
     * @param index index
     * @return type
     */
    @Override
    public T remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        final T value = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        modificationCount++;
        return value;
    }

    @Override
    public void sort(final Comparator<? super T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator is null");
        }
        array = listSort(comparator);
        modificationCount++;
    }

    /**
     * Clear.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        modificationCount++;
    }

    /**
     * Get.
     *
     * @param index index
     * @return type
     */
    @Override
    public T get(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        return array[index];
    }

    /**
     * Set.
     *
     * @param index   index
     * @param element element
     */
    @Override
    public void set(final int index, final T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        array[index] = element;
        modificationCount++;
    }

    /**
     * Of.
     *
     * @param elements element
     * @param <T>      type
     * @return list
     */
    @SafeVarargs
    public static <T> ArrayListT<T> of(final T... elements) {
        if (elements == null) {
            throw new IllegalArgumentException("Impossible to create of null");
        }
        final ArrayListT<T> list = new ArrayListT<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    /**
     * Iterator.
     *
     * @return iterator.
     */
    @Override
    public ListIterator<T> iterator() {
        return new ArrayListTIterator();
    }

    private class ArrayListTIterator implements ListIterator<T> {
        private int index;
        private int previousModificationCount = modificationCount;
        private boolean called;

        /**
         * Has next.
         *
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            if (modificationCount != previousModificationCount) {
                throw new ConcurrentModificationException("Collection was modified");
            }
            return index < size;
        }

        /**
         * Next.
         *
         * @return next
         */
        @Override
        public T next() {
            if (modificationCount != previousModificationCount) {
                throw new ConcurrentModificationException("Collection was modified");
            }
            T value = array[index];
            index++;
            called = true;
            return value;
        }

        @Override
        public void set(final T element) {
            if (modificationCount != previousModificationCount) {
                throw new ConcurrentModificationException("Collection was modified");
            }
            if (!called) {
                throw new IllegalStateException("Method has been invoked at an illegal time");
            }
            ArrayListT.this.set(index - 1, element);
            previousModificationCount = modificationCount;
            called = false;
        }

        @Override
        public void insertBefore(final T element) {
            if (modificationCount != previousModificationCount) {
                throw new ConcurrentModificationException("Collection was modified");
            }
            if (!called) {
                throw new IllegalStateException("Method has been invoked at an illegal time");
            }
            ArrayListT.this.add(index - 1, element);
            previousModificationCount = modificationCount;
            called = false;
        }

        @Override
        public void remove() {
            if (modificationCount != previousModificationCount) {
                throw new ConcurrentModificationException("Collection was modified");
            }
            if (!called) {
                throw new IllegalStateException("Method has been invoked at an illegal time");
            }
            ArrayListT.this.remove(index - 1);
            previousModificationCount = modificationCount;
            called = false;
        }
    }
}
