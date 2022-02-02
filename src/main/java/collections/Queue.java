package collections;

/**
 * Queue.
 */
public class Queue {
    private final LinkedList list;

    /**
     * Queue.
     *
     * @cpu O(1)
     * @ram O(1)
     */
    public Queue() {
        list = new LinkedList();
    }

    /**
     * Adds an element to the tail of the queue.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element int argument
     */
    public void offer(int element) {
        list.addLast(element);
    }

    /**
     * Peeks the element from the head of the queue.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the first element
     */
    public int peek() {
        return list.getFirst();
    }

    /**
     * Removes an element from the head of the queue.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the first element.
     */
    public int poll() {
        return list.removeFirst();
    }

    /**
     * Returns the size of the queue.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the size of the queue
     */
    public int size() {
        return list.size();
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
        return list.size() == 0;
    }

    /**
     * Returns an array containing all the elements of the queue.
     *
     * @cpu O(n) n = size of LinkedList
     * @ram O(n) n = size of LinkedList
     *
     * @return an array containing all the elements of the queue.
     */
    public int[] toArray() {
        return list.toArray();
    }
}
