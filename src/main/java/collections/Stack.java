package collections;

/**
 * Stack
 */
public class Stack {
    private ArrayList arrayList = new ArrayList();

    /**
     * Pushes the element to the top of the stack.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element int argument
     */
    public void push(int element){
        arrayList.add(element);
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
        int value = 0;
        if (!isEmpty()) {
            value = arrayList.get(arrayList.size() - 1);
        }
        return value;
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
        int value = 0;
        if (! isEmpty()) {
            value = arrayList.remove(arrayList.size() - 1);
        }
        return value;
    }

    /**
     * Gets the value equals to the logical array length.
     *
     * @return the value equals to the logical array length.
     * @cpu O(1)
     * @ram O(1)
     */
    public int size() {
        return arrayList.size();
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
        return arrayList.size() == 0;
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
        return arrayList.toArray();
    }
}
