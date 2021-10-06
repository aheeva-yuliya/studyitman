package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackTests {

    @Test
    public void pushNormalCase() {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(2);
        stack.push(3);
        int[] expected = new int[] {5, 2, 3};
        Assertions.assertArrayEquals(expected, stack.toArray());
    }

    @Test
    public void peekIfNotEmpty() {
        Stack stack = new Stack();
        stack.push(7);
        stack.push(2);
        Assertions.assertEquals(2,stack.peek());
        int[] expected = new int[] {7, 2};
        Assertions.assertArrayEquals(expected, stack.toArray());
    }

    @Test
    public void peekIfEmpty() {
        Stack stack = new Stack();
        Assertions.assertEquals(0,stack.peek());
        Assertions.assertNotNull(stack.toArray());
    }

    @Test
    public void popNormalCase() {
        Stack stack = new Stack();
        stack.push(7);
        stack.push(2);
        Assertions.assertEquals(2,stack.pop());
        int[] expected = new int[] {7};
        Assertions.assertArrayEquals(expected, stack.toArray());
    }

    @Test
    public void popIfEmpty() {
        Stack stack = new Stack();
        Assertions.assertEquals(0,stack.pop());
        Assertions.assertNotNull(stack.toArray());
    }

    @Test
    public void sizePushAndPop() {
        Stack stack = new Stack();
        stack.push(7);
        stack.push(5);
        stack.push(3);
        stack.pop();
        Assertions.assertEquals(2, stack.size());
    }

    @Test
    public void isEmptyIfYes() {
        Stack stack = new Stack();
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void isEmptyIfNo() {
        Stack stack = new Stack();
        stack.push(10);
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    public void toArrayNormalCase() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(5);
        int[] expected = new int[] {10, 5};
        Assertions.assertArrayEquals(expected, stack.toArray());
    }

    @Test
    public void toArrayIfEmpty() {
        Stack stack = new Stack();
        Assertions.assertNotNull(stack.toArray());
    }
}