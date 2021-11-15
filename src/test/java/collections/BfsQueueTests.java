package collections;

import entities.BfsNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BfsQueueTests {

    @Nested
    public class Offer {
        @Test
        void shouldAddLastElementWhenWeAddInEmptyArray() {
            BfsQueue queue = new BfsQueue();
            BfsNode newNode = new BfsNode(1, 0);
            queue.offer(newNode);
            BfsNode node = new BfsNode(1, 0);
            Assertions.assertTrue(queue.poll().equals(node));
        }
    }

    @Nested
    public class Peek {
        @Test
        void shouldReturnFirstElementWhenLookFirstElement() {
            BfsQueue queue = new BfsQueue();
            BfsNode newNode1 = new BfsNode(1, 0);
            BfsNode newNode2 = new BfsNode(2, 0);
            BfsNode newNode3 = new BfsNode(3, 0);
            queue.offer(newNode1);
            queue.offer(newNode2);
            queue.offer(newNode3);
            BfsNode node = new BfsNode(1, 0);
            Assertions.assertTrue(queue.peek().equals(node));
        }
    }

    @Nested
    public class Poll {
        @Test
        void shouldReturnAndDeleteFirstElementWhenLookFirstElement() {
            BfsQueue queue = new BfsQueue();
            BfsNode newNode1 = new BfsNode(1, 0);
            BfsNode newNode2 = new BfsNode(2, 0);
            BfsNode newNode3 = new BfsNode(3, 0);
            queue.offer(newNode1);
            queue.offer(newNode2);
            queue.offer(newNode3);
            BfsNode node = new BfsNode(1, 0);
            BfsNode node2 = new BfsNode(2, 0);
            Assertions.assertTrue(queue.poll().equals(node));
            Assertions.assertTrue(queue.poll().equals(node2));
        }
    }

    @Nested
    public class Size {
        @Test
        void shouldReturnCountElementWhenTakeSize() {
            BfsQueue queue = new BfsQueue();
            BfsNode newNode1 = new BfsNode(1, 0);
            BfsNode newNode2 = new BfsNode(2, 0);
            BfsNode newNode3 = new BfsNode(3, 0);
            queue.offer(newNode1);
            queue.offer(newNode2);
            queue.offer(newNode3);
            Assertions.assertEquals(3, queue.size());
        }
    }

    @Nested
    public class IsEmpty {
        @Test
        void shouldReturnTrueElementWhenSizeZero() {
            BfsQueue queue = new BfsQueue();
            Assertions.assertTrue(queue.isEmpty());
        }

        @Test
        void shouldReturnFalseWhenBfsQueueNotEmpty() {
            BfsQueue queue = new BfsQueue();
            BfsNode newNode1 = new BfsNode(1, 0);
            queue.offer(newNode1);
            Assertions.assertFalse(queue.isEmpty());
        }
    }

    @Nested
    public class ToArray {
        @Test
        void shouldReturnArrayWhenConvertingBfsQueueToArray() {
            BfsNode node1 = new BfsNode(1, 0);
            BfsNode node2 = new BfsNode(2, 0);
            BfsNode node3 = new BfsNode(3, 0);
            BfsNode[] expected = new BfsNode[]{node1, node2, node3};
            BfsQueue queue = new BfsQueue();
            queue.offer(node1);
            queue.offer(node2);
            queue.offer(node3);
            BfsNode[] actual = queue.toArray();
            for (int i = 0; i < queue.size(); i++) {
                Assertions.assertTrue(expected[i].equals(actual[i]));
            }
        }
    }
}