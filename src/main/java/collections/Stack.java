package collections;

/**
 * Stack.
 */
public class Stack {
    private final IntArrayList intArrayList = new IntArrayList();

    /**
     * Pushes the element to the top of the stack.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element int argument
     */
    public void push(int element) {
        intArrayList.add(element);
    }

    /**
     * Returns the top element of the stack. The element stays on the stack.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the top element.
     */
    public int peek() {
        return intArrayList.get(intArrayList.size() - 1);
    }

    /**
     * Gets the value of the top element of the stack and decrements the stack size value.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the top element of the stack.
     */
    public int pop() {
        return intArrayList.remove(intArrayList.size() - 1);
    }

    /**
     * Gets the value equals to the logical array length.
     *
     * @return the value equals to the logical array length.
     * @cpu O(1)
     * @ram O(1)
     */
    public int size() {
        return intArrayList.size();
    }

    /**
     * Returns boolean true if the stack is empty.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return boolean true if the stack is empty.
     */
    public boolean isEmpty() {
        return intArrayList.size() == 0;
    }

    /**
     * Creates a new int[] and copies all elements from the array of the instance variable "arrayList".
     *
     * @cpu O(n), n = instance variable "size" of the arrayList array
     * @ram O(n), n = instance variable "size" of the arrayList array
     *
     * @return int[] with all copied elements.
     */
    public int[] toArray() {
        return intArrayList.toArray();
    }
}
