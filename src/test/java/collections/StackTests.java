package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StackTests {
    @Nested
    public class Push {
        @Test
        public void shouldPushWhenStackEmpTyAndNotEmpty() {
            Stack stack = new Stack();
            stack.push(5);
            stack.push(2);
            stack.push(3);
            int[] expected = new int[]{5, 2, 3};
            Assertions.assertArrayEquals(expected, stack.toArray());
        }
    }

    @Nested
    public class Peek {
        @Test
        public void shouldPeekButNotRemoveWhenStackNotEmpty() {
            Stack stack = new Stack();
            stack.push(7);
            stack.push(2);
            Assertions.assertEquals(2, stack.peek());
            int[] expected = new int[]{7, 2};
            Assertions.assertArrayEquals(expected, stack.toArray());
        }
    }

    @Nested
    public class Pop {
        @Test
        public void shouldPopWhenStackNotEmpty() {
            Stack stack = new Stack();
            stack.push(7);
            stack.push(2);
            Assertions.assertEquals(2, stack.pop());
            int[] expected = new int[]{7};
            Assertions.assertArrayEquals(expected, stack.toArray());
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnTwoWhenStackContainsTwoElements() {
            Stack stack = new Stack();
            stack.push(7);
            stack.push(5);
            stack.push(3);
            stack.pop();
            Assertions.assertEquals(2, stack.size());
        }
    }

    @Nested
    public class IsEmpty {
        @Test
        public void shouldReturnTrueWhenStackEmpty() {
            Stack stack = new Stack();
            Assertions.assertTrue(stack.isEmpty());
        }

        @Test
        public void shouldReturnFalseWhenStackNotEmpty() {
            Stack stack = new Stack();
            stack.push(10);
            Assertions.assertFalse(stack.isEmpty());
        }
    }

    @Nested
    public class ToArray {
        @Test
        public void shouldReturnArrayWhenStackNotEmpty() {
            Stack stack = new Stack();
            stack.push(10);
            stack.push(5);
            int[] expected = new int[]{10, 5};
            Assertions.assertArrayEquals(expected, stack.toArray());
        }

        @Test
        public void shouldReturnArrayWhenStackEmpty() {
            Stack stack = new Stack();
            Assertions.assertNotNull(stack.toArray());
        }
    }
}