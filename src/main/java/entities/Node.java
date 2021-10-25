package entities;

/**
 * Node
 */
public class Node {
    private final int element;
    private Node next;
    private Node prev;

    public Node(final int element, final Node next) {
        this.element = element;
        this.next = next;
    }

    public Node(final int element, final Node next, final Node prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
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
     * Gets the value of the instance variable "prev".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "prev".
     */
    public Node getPrev() {
        return prev;
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

    /**
     * Sets the value of the instance variable "prev".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param prev a link for the previous Node
     */
    public void setPrev(final Node prev) {
        this.prev = prev;
    }
}
