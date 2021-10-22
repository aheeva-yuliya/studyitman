package collections;

import entities.Node;
import utils.StringBuilder;

/**
 * LinkedList
 */
public class LinkedList {
    private Node first;

    /**
     * Adds an element to the beginning of the list.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element int argument
     */
    public void addFirst(final int element) {
        first = new Node(element, first);
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
     * @cpu O(n) n = number of Nodes in LinkedList
     * @ram O(1)
     *
     * @param element int argument
     */
    public void addLast(int element) {
        Node temp = first;
        if (temp == null) {
            addFirst(element);
        } else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(element, null));
        }
    }

    /**
     * Gets the last element of the LinkedList.
     *
     * @cpu O(n) n = number of Nodes in LinkedList.
     * @ram O(1)
     *
     * @return the value of the last element of the LinkedList.
     */
    public int getLast() {
        Node temp = first;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp.getElement();
    }

    /**
     * Gets the last element of the LinkedList and removes it.
     *
     * @cpu O(n) n = number of Nodes in LinkedList.
     * @ram O(1)
     *
     * @return the previous last element of the LinkedList.
     */
    public int removeLast() {
        Node temp = first;
        int value;
        if (temp.getNext() != null) {
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        value =  temp.getNext().getElement();
        temp.setNext(null);
        } else {
            value = temp.getElement();
            first = null;
        }
        return value;
    }
}
