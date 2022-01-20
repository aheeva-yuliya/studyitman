package collections;

import java.util.Comparator;
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
        if (that != null) {
            array = (T[]) new Object[that.size()];
            addAll(that);
        } else {
            array = (T[]) new Object[2];
        }
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
        if (index < size) {
            T[] data = (T[]) new Object[size + 1];
            System.arraycopy(array, 0, data, 0, index);
            System.arraycopy(array, index, data, index + 1, size - index);
            data[index] = element;
            array = data;
            size++;
            return true;
        } else {
            return false;
        }
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
            if (array[i].equals(element)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                array[size - 1] = null;
                size--;
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
        T value = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return value;
    }

    @Override
    public void sort(final Comparator<? super T> comparator) {
        array = listSort(comparator);
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
    }

    /**
     * Get.
     *
     * @param index index
     * @return type
     */
    @Override
    public T get(final int index) {
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
        array[index] = element;
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

        /**
         * Has next.
         *
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * Next.
         *
         * @return next
         */
        @Override
        public T next() {
            T value = array[index];
            index++;
            return value;
        }

        @Override
        public void set(final T element) {
            array[index - 1] = element;
        }

        @Override
        public void insertBefore(final T element) {
            final int indexBefore = index - 1;
            if (size == array.length) {
                T[] temp = (T[]) new Object[size * 2];
                System.arraycopy(array, 0, temp, 0, indexBefore);
                System.arraycopy(array, indexBefore, temp, index, size - indexBefore);
                array = temp;
            } else {
                System.arraycopy(array, indexBefore, array, index, size - indexBefore);
            }
            array[indexBefore] = element;
            size++;
            index++;
        }

        @Override
        public void remove() {
            ArrayListT.this.remove(index - 1);
        }
    }
}
