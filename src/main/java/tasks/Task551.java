package tasks;

/**
 * Task551.
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

    /**
     * Node.
     */
    public static class Node {
        private int element;
        private Node next;
        private Node prev;

        /**
         * Creates Node object.
         *
         * @cpu O(1)
         * @ram O(1)
         *
         * @param element int argument
         * @param next Node argument
         * @param prev Node argument
         */
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
         * Sets the value of the instance variable "element".
         *
         * @cpu O(1)
         * @ram O(1)
         *
         * @param element int argument
         */
        public void setElement(final int element) {
            this.element = element;
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
}
