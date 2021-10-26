package collections;

import entities.Node;
import utils.StringBuilder;

/**
 * LinkedList
 */
public class LinkedList {
    private Node first;
    private Node last;

    /**
     * Creates an object of LinkedList.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     */
    public LinkedList() {}

    /**
     * Creates a copy of the object of LinkedList that.
     *
     * @cpu O(n) n = number of Nodes of LinkedList that
     * @ram O(n) n = number of Nodes of LinkedList that
     *
     * @param that an object of LinkedList
     */
    public LinkedList(final LinkedList that) {
        if (that != null) {
            Node next = that.first;
            while (next != null) {
                addLast(next.getElement());
                next = next.getNext();
            }
        }
    }

    /**
     * Adds an element to the beginning of the list.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element int argument
     */
    public void addFirst(final int element) {
        final Node temp = new Node(element,null,null);
        if (last == null) {
            last = temp;
        } else {
            first.setPrev(temp);
        }
        temp.setNext(first);
        first = temp;
    }

    /**
     * Gets the value of the first element of the list.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the first element of the list.
     */
    public int getFirst() {
        return first.getElement();
    }

    /**
     * Get the value of the first element of the list and removes it.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the previous first element.
     */
    public int removeFirst() {
        final int value = first.getElement();
        if (first.getNext() == null) {
            last = null;
        } else {
            first.getNext().setPrev(null);
        }
        first = first.getNext();
        return value;
    }

    /**
     * Returns a string with all elements from an object of LinkedList.
     *
     * @cpu O(n) n = number of Nodes in LinkedList
     * @ram O(n) n = number of Nodes in LinkedList
     *
     * @return a string with all elements from an object of LinkedList.
     */
    public String toString() {
        final StringBuilder listToString = new StringBuilder();
        Node current = first;
        listToString.append("[");
        while (current != null) {
            if (current.getNext() != null) {
                listToString.append(current.getElement());
                listToString.append(", ");
            } else {
                listToString.append(current.getElement());
            }
            current = current.getNext();
        }
        listToString.append("]");
        return listToString.toString();
    }

    /**
     * Adds a Node object to the end of the list.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element int argument
     */
    public void addLast(final int element) {
        final Node temp = new Node(element,null,null);
        if (first == null) {
            first = temp;
        } else {
            last.setNext(temp);
        }
        temp.setPrev(last);
        last = temp;
    }

    /**
     * Gets the last element of the LinkedList.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the last element of the LinkedList.
     */
    public int getLast() {
       return last.getElement();
    }

    /**
     * Gets the last element of the LinkedList and removes it.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the previous last element of the LinkedList.
     */
    public int removeLast() {
        final int value = last.getElement();
        if (first.getNext() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        return value;
    }

    /**
     * Creates an ArrayList formed from the elements stored in the LinkedList.
     *
     * @cpu O(n) n = number of Nodes of LinkedList
     * @ram O(n) n = number of Nodes of LinkedList
     *
     * @return an array formed from the elements in the LinkedList.
     */
    public int[] toArray() {
        final ArrayList arrayList = new ArrayList();
        Node next = first;
        while (next != null) {
            arrayList.add(next.getElement());
            next = next.getNext();
        }
        return arrayList.toArray();
    }

    /**
     * Creates an object of LinkedList formed from the parameter elements.
     *
     * @cpu O(n) n = elements.length
     * @ram O(n) n = elements.length
     *
     * @param elements variable arguments list
     * @return an object of LinkedList formed from the elements.
     */
    public static LinkedList of(final int... elements) {
        final LinkedList linkedList = new LinkedList();
        for (int element : elements) {
            linkedList.addLast(element);
        }
        return linkedList;
    }

    /**
     * Sets the parameter element to the parameter index position in the LinkedList.
     *
     * @cpu O(n) n = index
     * @ram O(1)
     *
     * @param index int argument
     * @param element int argument
     */
    public void set(final int index, final int element) {
        final Node node = search(index);
        node.setElement(element);
    }

    /**
     * Gets the value of the element at the index position in the LinkedList.
     *
     * @cpu O(n) n = index
     * @ram O(1)
     *
     * @param index int argument
     * @return the element at the index position
     */
    public int get(final int index) {
        final Node node = search(index);
        return node.getElement();
    }

    /**
     * Gets the value of the element at the index position in the LinkedList and removes it.
     *
     * @cpu O(n) n = index
     * @ram O(1)
     *
     * @param index int argument
     * @return the element at the index position
     */
    public int remove(final int index) {
        final Node node = search(index);
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

    private Node search(final int index) {
        int listIndex = 0;
        Node next = first;
        while (listIndex != index) {
            next = next.getNext();
            listIndex++;
        }
        return next;
    }

    /**
     * Finds the length of the LinkedList.
     *
     * @cpu O(n) n = number of Nodes
     * @ram O(1)
     *
     * @return the length of the LinkedList.
     */
    public int size() {
        int size = 0;
        Node next = first;
        while (next != null) {
            next = next.getNext();
            size++;
        }
        return size;
    }

    /**
     * Indicates whether some other object is "equal to" this one .
     *
     * @cpu (n + m) n = number of Nodes in this LinkedList and m = number of Nodes of that LinkedList.
     * @ram O(1)
     *
     * @param that an object of LinkedList or null
     * @return true if the objects are equal and false if aren't.
     */
    public boolean equals(LinkedList that) {
        if (that == null) {
            return false;
        }
        final int thisSize = this.size();
        final int thatSize = that.size();
        if (thisSize == 0 && thatSize == 0) {
            return true;
        } else if (thisSize > thatSize || thatSize > thisSize) {
            return false;
        } else {
            Node thisNext = this.first;
            Node thatNext = that.first;
            while (thisNext != null) {
                if (thisNext.getElement() != thatNext.getElement()) {
                    return false;
                }
                thisNext = thisNext.getNext();
                thatNext = thatNext.getNext();
            }
            return true;
        }
    }
}
