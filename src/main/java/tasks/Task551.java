package tasks;

import entities.Node;

/**
 * Task551
 */
public class Task551 {

    /**
     * Creates three Node objects that link to each other up and down the chain.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return a  doubly linked list with the elements 12, 99, 37.
     */
    public static Node buildLinkedList() {
        Node last = new Node(37, null, null);
        Node second = new Node(99, last, null);
        last.setPrev(second);
        Node first = new Node(12, second, null);
        second.setPrev(first);
        return first;
    }
}
