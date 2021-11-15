package collections;

import entities.BfsNode;

public class BfsQueue {
    private BfsNodeAndNext firstNode = new BfsNodeAndNext(null, null);
    private BfsNodeAndNext lastNode = new BfsNodeAndNext(null, null);
    private int size = 0;

    /**
     * //     * Add last element in BfsQueue
     * //     *
     * //     * @param element - value of element
     * //     * @cpu O(1)
     * //     * @ram O(1)
     * //
     */
    public void offer(BfsNode element) {
        if (size == 0) {
            firstNode.node = element;
            firstNode.nextNode = new BfsNodeAndNext(null, null);
            lastNode = firstNode.nextNode;
        } else {
            lastNode.node = element;
            lastNode.nextNode = new BfsNodeAndNext(null, null);
            lastNode = lastNode.nextNode;
        }
        size++;
    }

    /**
     * //     * Get value first element
     * //     *
     * //     * @return value first element
     * //     * @cpu O(1)
     * //     * @ram O(1)
     * //
     */
    public BfsNode peek() {
        return firstNode.node;
    }

    /**
     * Get value first element and delete
     *
     * @return value first element
     * @cpu O(1)
     * @ram O(1)
     */
    // n - size
    public BfsNode poll() {
        if (size == 0) {
            return null;
        }
        BfsNode node = firstNode.node;
        firstNode = firstNode.nextNode;
        size--;
        return node;
    }

    /**
     * Give size of BfsQueue
     *
     * @return size of BfsQueue
     * @cpu O(1)
     * @ram O(1)
     */
    public int size() {
        return size;
    }

    /**
     * Get is BfsQueue is Empty
     *
     * @return false is size BfsQueue more than zero and true is equals zero
     * @cpu O(1)
     * @ram O(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get array of elements BfsQueue
     *
     * @return array of elements BfsQueue
     * @cpu O(n)
     * @ram O(n)
     */
    // n - size
    public BfsNode[] toArray() {
        BfsNode[] bfsNodes = new BfsNode[size];
        BfsNodeAndNext node = firstNode;
        int index = 0;
        while (node.node != null) {
            bfsNodes[index++] = node.node;
            node = node.nextNode;
        }
        return bfsNodes;
    }

    private static class BfsNodeAndNext {
        BfsNode node;
        BfsNodeAndNext nextNode;

        public BfsNodeAndNext(BfsNode node, BfsNodeAndNext nextNode) {
            this.node = node;
            this.nextNode = nextNode;
        }
    }
}
