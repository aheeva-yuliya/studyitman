package collections;

import entities.BfsNode;

public class BfsQueue {
    private Node first;
    private Node last;
    private int size;

    private static class Node {
        private final BfsNode bfsNode;
        private Node prev;
        private Node next;

        public Node(BfsNode bfsNode, Node prev, Node next) {
            this.bfsNode = bfsNode;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Adds an element to the end of BfsQueue.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element - an object of BfsNode
     */
    public void offer(BfsNode element) {
        final Node temp = new Node(element,null,null);
        if (first == null) {
            first = temp;
        } else {
            last.next = temp;
        }
        temp.prev = last;
        last = temp;
        size++;
    }

    /**
     * Gets the value of the first element of the BfsQueue.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return value first element
     */
    public BfsNode peek() {
        return first.bfsNode;
    }

    /**
     * Gets the value of the first element and removes it.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return value first element
     */
    public BfsNode poll() {
        final BfsNode node = first.bfsNode;
        if (first.next == null) {
            last = null;
        } else {
            first.next.prev = null;
        }
        first = first.next;
        size--;
        return node;
    }

    /**
     * Returns the size of BfsQueue.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return size of BfsQueue
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the queue is empty.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return true if the queue is empty, otherwise false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an array containing all the elements of the queue.
     *
     * @cpu O(n) n = size of BfsQueue
     * @ram O(n) n = size of BfsQueue
     *
     * @return an array containing all the elements of the queue.
     */
    public BfsNode[] toArray() {
        final BfsNode[] bfsNodes = new BfsNode[size];
        Node node = first;
        int index = 0;
        while (node != null) {
            bfsNodes[index++] = node.bfsNode;
            node = node.next;
        }
        return bfsNodes;
    }
}
