package collections;

import entities.BfsNode;

public class BfsQueue {
    private BfsNode node;
    private BfsNode[] queue = new BfsNode[16];
    private int size;

    public void offer(BfsNode element) {
        if (size == queue.length) {
            BfsNode[] temp = new BfsNode[size * 2];
            System.arraycopy(queue, 0, temp, 0, size);
            queue = temp;
        }
        queue[size++] = element;

    }

    public BfsNode peek() {
        return queue[0];
    }

    public BfsNode poll() {
        BfsNode node = queue[0];
        System.arraycopy(queue, 1, queue, 0, size);
        queue[size - 1] = null;
        size--;
        return node;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public BfsNode[] toArray() {
        return queue;
    }
}
