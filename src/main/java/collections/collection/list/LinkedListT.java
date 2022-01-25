package collections.collection.list;

import collections.collection.Collection;
import collections.collection.ListIterator;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Objects;

public class LinkedListT<T> extends ListT<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;

    /**
     * Creates an object of LinkedList.
     *
     * @cpu O(1)
     * @ram O(1)
     */
    public LinkedListT() {
    }

    /**
     * Creates a copy of the object of LinkedList that.
     *
     * @cpu O(n) n = number of Nodes of LinkedList that
     * @ram O(n) n = number of Nodes of LinkedList that
     *
     * @param that an object of LinkedList
     */
    public LinkedListT(final Collection<? extends T> that) {
        if (that == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        addAll(that);
    }

    /**
     * Adds an element to the beginning of the list.
     *
     * @param element int argument
     * @cpu O(1)
     * @ram O(1)
     */
    public void addFirst(final T element) {
        final Node<T> temp = new Node<>(element, null, null);
        if (last == null) {
            last = temp;
        } else {
            first.setPrev(temp);
        }
        temp.setNext(first);
        first = temp;
        size++;
        modificationCount++;
    }

    /**
     * Gets the value of the first element of the list.
     *
     * @return the value of the first element of the list.
     * @cpu O(1)
     * @ram O(1)
     */
    public T getFirst() {
        return first.getElement();
    }

    /**
     * Get the value of the first element of the list and removes it.
     *
     * @return the value of the previous first element.
     * @cpu O(1)
     * @ram O(1)
     */
    public T removeFirst() {
        final T value = first.getElement();
        if (first.getNext() == null) {
            last = null;
        } else {
            first.getNext().setPrev(null);
        }
        first = first.getNext();
        size--;
        modificationCount++;
        return value;
    }

    /**
     * Adds a Node object to the end of the list.
     *
     * @param element int argument
     * @cpu O(1)
     * @ram O(1)
     */
    public void addLast(final T element) {
        final Node<T> temp = new Node<>(element, null, null);
        if (first == null) {
            first = temp;
        } else {
            last.setNext(temp);
        }
        temp.setPrev(last);
        last = temp;
        size++;
        modificationCount++;
    }

    /**
     * Gets the last element of the LinkedList.
     *
     * @return the value of the last element of the LinkedList.
     * @cpu O(1)
     * @ram O(1)
     */
    public T getLast() {
        return last.getElement();
    }

    /**
     * Gets the last element of the LinkedList and removes it.
     *
     * @return the previous last element of the LinkedList.
     * @cpu O(1)
     * @ram O(1)
     */
    public T removeLast() {
        final T value = last.getElement();
        if (first.getNext() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        size--;
        modificationCount++;
        return value;
    }


    /**
     * Creates an object of LinkedList formed from the parameter elements.
     *
     * @param elements elements
     * @param <T> type
     * @return list
     */
    @SafeVarargs
    public static <T> LinkedListT<T> of(final T... elements) {
        if (elements == null) {
            throw new IllegalArgumentException("Impossible to create of null");
        }
        final LinkedListT<T> linkedList = new LinkedListT<>();
        for (T element : elements) {
            linkedList.addLast(element);
        }
        return linkedList;
    }

    /**
     * Add.
     *
     * @param index index
     * @param element element
     * @return boolean
     */
    @Override
    public boolean add(final int index, final T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        if (index == size - 1) {
            addLast(element);
        } else {
            final Node<T> nodeAtIndex = search(index);
            addBefore(nodeAtIndex, element);
        }
        return true;
    }

    /**
     * Add.
     *
     * @param element element
     * @return boolean
     */
    @Override
    public boolean add(final T element) {
        addLast(element);
        return true;
    }

    /**
     * Add all.
     *
     * @param index index
     * @param collection collection
     * @return boolean
     */
    @Override
    public boolean addAll(final int index, final Collection<? extends T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        if (collection.isEmpty()) {
            return false;
        }
        final Node<T> atIndex = search(index);
        for (T element : collection) {
            addBefore(atIndex, element);
        }
        return true;
    }

    /**
     * Gets the value of the element at the index position in the LinkedList.
     *
     * @param index int argument
     * @return the element at the index position
     * @cpu O(n) n = index
     * @ram O(1)
     */
    @Override
    public T get(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        final Node<T> node = search(index);
        return node.getElement();
    }

    /**
     * Sets the parameter element to the parameter index position in the LinkedList.
     *
     * @param index   int argument
     * @param element int argument
     * @cpu O(n) n = index
     * @ram O(1)
     */
    @Override
    public void set(final int index, final T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        final Node<T> node = search(index);
        node.setElement(element);
        modificationCount++;
    }

    /**
     * Gets the value of the element at the index position in the LinkedList and removes it.
     *
     * @param index int argument
     * @return the element at the index position
     * @cpu O(n) n = index
     * @ram O(1)
     */
    public T remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            return removeNode(search(index));
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
        ListIterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            if (Objects.equals(iterator.next(), element)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public void sort(final Comparator<? super T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator is null");
        }
        T[] sorted = listSort(comparator);
        ListIterator<T> iterator = iterator();
        for (T object : sorted) {
            iterator.next();
            iterator.set(object);
        }
        modificationCount++;
    }

    /**
     * Clear.
     */
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
        modificationCount++;
    }

    /**
     * Iterator.
     *
     * @return iterator
     */
    @Override
    public ListIterator<T> iterator() {
        return new LinkedListTIterator();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private class LinkedListTIterator implements ListIterator<T> {
        private Node<T> next = first;
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
            return next != null;
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
            final T value = next.element;
            next = next.next;
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
            if (next != null) {
                next.prev.element = element;
            } else {
                last.element = element;
            }
            previousModificationCount = ++modificationCount;
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
            final Node<T> prev = next.getPrev();
            addBefore(prev, element);
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
            if (next == null) {
                removeLast();
            } else {
                removeNode(next.getPrev());
            }
            previousModificationCount = modificationCount;
            called = false;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Node.
     */
    private static class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(final T element, final Node<T> next, final Node<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        /**
         * Gets the value of the instance variable "element".
         *
         * @return the value of the instance variable "element".
         * @cpu O(1)
         * @ram O(1)
         */
        public T getElement() {
            return element;
        }

        /**
         * Gets the value of the instance variable "next".
         *
         * @return the value of the instance variable "next".
         * @cpu O(1)
         * @ram O(1)
         */
        public Node<T> getNext() {
            return next;
        }

        /**
         * Gets the value of the instance variable "prev".
         *
         * @return the value of the instance variable "prev".
         * @cpu O(1)
         * @ram O(1)
         */
        public Node<T> getPrev() {
            return prev;
        }

        /**
         * Sets the value of the instance variable "element".
         *
         * @param element int argument
         * @cpu O(1)
         * @ram O(1)
         */
        public void setElement(final T element) {
            this.element = element;
        }

        /**
         * Sets the value of the instance variable "next".
         *
         * @param next a link for the next Node
         * @cpu O(1)
         * @ram O(1)
         */
        public void setNext(final Node<T> next) {
            this.next = next;
        }

        /**
         * Sets the value of the instance variable "prev".
         *
         * @param prev a link for the previous Node
         * @cpu O(1)
         * @ram O(1)
         */
        public void setPrev(final Node<T> prev) {
            this.prev = prev;
        }

        /**
         * HashCode.
         *
         * @return int
         */
        public int hashCode() {
            return element.hashCode();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private Node<T> search(final int index) {
        int listIndex = 0;
        Node<T> next = first;
        while (listIndex != index) {
            next = next.getNext();
            listIndex++;
        }
        return next;
    }

    private void addBefore(final Node<T> nodeAtIndex, T element) {
        if (nodeAtIndex.getPrev() == null) {
            addFirst(element);
        } else {
            final Node<T> node = new Node<>(element, nodeAtIndex, nodeAtIndex.getPrev());
            nodeAtIndex.getPrev().setNext(node);
            nodeAtIndex.setPrev(node);
            size++;
            modificationCount++;
        }
    }

    private T removeNode(final Node<T> nodeAtIndex) {
        if (nodeAtIndex == first) {
            return removeFirst();
        } else if (nodeAtIndex == last) {
            return removeLast();
        } else {
            nodeAtIndex.getPrev().setNext(nodeAtIndex.getNext());
            nodeAtIndex.getNext().setPrev(nodeAtIndex.getPrev());
            modificationCount++;
            size--;
            return nodeAtIndex.getElement();
        }
    }
}

