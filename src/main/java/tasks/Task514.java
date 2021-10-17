package tasks;

import collections.Stack;

/**
 * Task514
 */
public class Task514 {

    /**
     * Returns the last element of the stack.
     *
     * @cpu O(n + m) n = books.length and m = queue.length
     * @ram O(1)
     *
     * @param books int[] contains positive numbers
     * @param queue nt[] contains positive and negative numbers
     * @return the value of the last element of the stack.
     */
    public static int solve(int[] books, int[] queue) {
        Stack stack = new Stack();
        for (int book : books) {
            stack.push(book);
        }
        for (int j : queue) {
            if (j == -1) {
                stack.pop();
            } else {
                stack.push(j);
            }
        }
        return stack.peek();
    }
}
