package collections;

import java.util.Comparator;

public class LinkedListT<T> extends ListT<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;

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
    }

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
        if (index == 0) {
            addFirst(element);
        } else if (index == size - 1) {
            addLast(element);
        } else {
            final Node<T> nodeAtIndex = search(index);
            final Node<T> prev = nodeAtIndex.getPrev();
            final Node<T> node = new Node<>(element, nodeAtIndex, prev);
            nodeAtIndex.setPrev(node);
            prev.setNext(node);
            size++;
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
     * Gets the value of the element at the index position in the LinkedList.
     *
     * @param index int argument
     * @return the element at the index position
     * @cpu O(n) n = index
     * @ram O(1)
     */
    @Override
    public T get(final int index) {
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
        final Node<T> node = search(index);
        node.setElement(element);
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
        final Node<T> node = search(index);
        if (node == first) {
            return removeFirst();
        } else if (node == last) {
            return removeLast();
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            return node.getElement();
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
        int i = 0;
        Node<T> node = first;
        while (i < size) {
            if (node.element.equals(element)) {
                if (node.prev != null) {
                    node.prev.setNext(node.next);
                }
                if (node.next != null) {
                    node.next.setPrev(node.prev);
                }
                size--;
                return true;
            }
            i++;
            node = node.next;
        }
        return false;
    }

    @Override
    public void sort(final Comparator<? super T> comparator) {
        T[] sorted = listSort(comparator);
        ListIterator<T> iterator = iterator();
        for (T object : sorted) {
            iterator.next();
            iterator.set(object);
        }
    }


    /**
     * Clear.
     */
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
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

    private class LinkedListTIterator implements ListIterator<T> {
        private Node<T> next = first;

        /**
         * Has next.
         *
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            return next != null;
        }

        /**
         * Next.
         *
         * @return next
         */
        @Override
        public T next() {
            final T value = next.element;
            next = next.next;
            return value;
        }

        @Override
        public void set(final T element) {
            if (next != null) {
                next.prev.element = element;
            } else {
                last.element = element;
            }
        }

        @Override
        public void insertBefore(final T element) {
            final Node<T> prev = next.getPrev();
            if (prev.getPrev() == null) {
                addFirst(element);
            } else {
                final Node<T> node = new Node<>(element, prev, prev.getPrev());
                prev.getPrev().setNext(node);
                prev.setPrev(node);
                size++;
            }
        }

        @Override
        public void remove() {
            if (next == null) {
                removeLast();
            } else {
                final Node<T> prev = next.getPrev();
                if (prev.getPrev() == null) {
                    removeFirst();
                } else {
                    prev.prev.setNext(prev.next);
                    prev.next.setPrev(prev.prev);
                    size--;
                }
            }
        }
    }

    private Node<T> search(final int index) {
        int listIndex = 0;
        Node<T> next = first;
        while (listIndex != index) {
            next = next.getNext();
            listIndex++;
        }
        return next;
    }
}

