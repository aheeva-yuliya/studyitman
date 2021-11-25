package collections;

import entities.BfsNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BfsQueueTests {
    @Nested
    public class Offer {
        @Test
        public void shouldAddLastElementWhenAddInEmptyArray() {
            BfsQueue queue = new BfsQueue();
            queue.offer(new BfsNode(1, 0));
            BfsNode node = new BfsNode(1, 0);
            Assertions.assertTrue(queue.poll().equals(node));
        }

        @Test
        public void shouldAddLastElementWhenNotEmptyArray() {
            BfsQueue queue = new BfsQueue();
            queue.offer(new BfsNode(1, 0));
            queue.offer(new BfsNode(2, 1));
            BfsNode node = new BfsNode(1, 0);
            Assertions.assertTrue(queue.poll().equals(node));
        }
    }

    @Nested
    public class Peek {
        @Test
        public void shouldReturnFirstElementWhenHaveSome() {
            BfsQueue queue = new BfsQueue();
            queue.offer(new BfsNode(1, 0));
            queue.offer(new BfsNode(2, 1));
            queue.offer(new BfsNode(3, 1));
            BfsNode node = new BfsNode(1, 0);
            Assertions.assertTrue(queue.peek().equals(node));
        }
    }

    @Nested
    public class Poll {
        @Test
        public void shouldReturnAndDeleteFirstElementWhenHasSome() {
            BfsQueue queue = new BfsQueue();
            queue.offer(new BfsNode(1, 0));
            queue.offer(new BfsNode(2, 1));
            queue.offer(new BfsNode(3, 1));
            BfsNode expected = new BfsNode(1, 0);
            BfsNode actual = queue.poll();
            Assertions.assertTrue(expected.equals(actual));
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnThreeWhenSizeThree() {
            BfsQueue queue = new BfsQueue();
            queue.offer(new BfsNode(1, 0));
            queue.offer(new BfsNode(2, 1));
            queue.offer(new BfsNode(3, 1));
            Assertions.assertEquals(3, queue.size());
        }
    }

    @Nested
    public class IsEmpty {
        @Test
        public void shouldReturnTrueWhenEmpty() {
            BfsQueue queue = new BfsQueue();
            Assertions.assertTrue(queue.isEmpty());
        }

        @Test
        public void shouldReturnFalseWhenNotEmpty() {
            BfsQueue queue = new BfsQueue();
            queue.offer(new BfsNode(1, 0));
            Assertions.assertFalse(queue.isEmpty());
        }
    }

    @Nested
    public class ToArray {
        @Test
        public void shouldReturnArrayWhenConvertingBfsQueueToArray() {
            BfsNode first = new BfsNode(1, 0);
            BfsNode second = new BfsNode(2, 0);
            BfsNode third = new BfsNode(3, 0);
            BfsNode[] expected = new BfsNode[]{first, second, third};
            BfsQueue queue = new BfsQueue();
            queue.offer(first);
            queue.offer(second);
            queue.offer(third);
            BfsNode[] actual = queue.toArray();
            for (int i = 0; i < queue.size(); i++) {
                Assertions.assertTrue(expected[i].equals(actual[i]));
            }
        }
    }
}