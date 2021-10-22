package entities;

/**
 * Node
 */
public class Node {
    private final int element;
    private Node next;

    public Node(final int element, final Node next) {
        this.element = element;
        this.next = next;
    }

    /**
     * Gets the value of the instance variable "element".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "element".
     */
    public int getElement() {
        return element;
    }

    /**
     * Gets the value of the instance variable "next".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "next".
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the value of the instance variable "next".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param next a link for the next Node
     */
    public void setNext(final Node next) {
        this.next = next;
    }
}
