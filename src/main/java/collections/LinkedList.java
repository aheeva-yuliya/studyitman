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
     * Adds an element to the beginning of the list.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element int argument
     */
    public void addFirst(final int element) {
        Node temp = new Node(element,null,null);
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
        int value = first.getElement();
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
        StringBuilder listToString = new StringBuilder();
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
    public void addLast(int element) {
        Node temp = new Node(element,null,null);
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
        int value = last.getElement();
        if (first.getNext() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        return value;
    }
}
