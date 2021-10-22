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
        while (current != null && current.getNext() != null) {
            listToString.append(current.getElement());
            listToString.append(", ");
            current = current.getNext();
            if (current.getNext() == null) {
                listToString.append(current.getElement());
            }
        }
        listToString.append("]");
        return listToString.toString();
    }
}
