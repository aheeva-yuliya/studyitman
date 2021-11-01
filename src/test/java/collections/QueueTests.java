package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class QueueTests {
    @Nested
    public class Offer {
        @Test
        public void shouldAddToTheEndWhenTryAddInt() {
            Queue queue = new Queue();
            queue.offer(7);
            queue.offer(5);
            Assertions.assertEquals(7, queue.peek());
        }
    }

    @Nested
    public class Peek {
        @Test
        public void shouldPeekFirstWhenSizeOne() {
            Queue queue = new Queue();
            queue.offer(7);
            Assertions.assertEquals(7, queue.peek());
            Assertions.assertEquals(1, queue.size());
        }
    }

    @Nested
    public class Poll {
        @Test
        public void shouldRemoveFirstWhenHaveSome() {
            Queue queue = new Queue();
            queue.offer(7);
            queue.offer(5);
            queue.offer(3);
            Assertions.assertEquals(7, queue.poll());
            Assertions.assertEquals(2, queue.size());
            Assertions.assertEquals(5, queue.poll());
            Assertions.assertEquals(1, queue.size());
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnSizeWhenTryPoll() {
            Queue queue = new Queue();
            queue.offer(7);
            queue.offer(5);
            queue.offer(3);
            Assertions.assertEquals(7, queue.poll());
            Assertions.assertEquals(2, queue.size());
            Assertions.assertEquals(5, queue.poll());
            Assertions.assertEquals(1, queue.size());
        }
    }

    @Nested
    public class IsEmpty {
        @Test
        public void shouldReturnTrueWhenSizeZero() {
            Queue queue = new Queue();
            Assertions.assertTrue(queue.isEmpty());
        }

        @Test
        public void shouldReturnFalseWhenSizeNotZero() {
            Queue queue = new Queue();
            queue.offer(8);
            Assertions.assertFalse(queue.isEmpty());
        }
    }

    @Nested
    public class ToArray {
        @Test
        public void shouldReturnArrayWithZeoLengthWhenQueueEmpty() {
            Queue queue = new Queue();
            int[] expected = new int[0];
            Assertions.assertArrayEquals(expected, queue.toArray());
        }

        @Test
        public void shouldReturnArrayWhenQueueNotEmpty() {
            Queue queue = new Queue();
            queue.offer(7);
            queue.offer(5);
            int[] expected = new int[] {7, 5};
            Assertions.assertArrayEquals(expected, queue.toArray());
        }
    }
}