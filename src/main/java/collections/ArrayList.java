package collections;

/**
 * ArrayList
 */
public class ArrayList {
    private int[] array;
    /**
     * ArrayList creates a new int[] with the length equals @param argument.
     * @param capacity int argument
     */
    public ArrayList(int capacity) {
        array = new int[capacity];
    }
    /**
     * Sets the value equals to @param element to the index of the array equals to the @param index.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param index int argument
     * @param element int argument
     */
    public void set(int index, int element) {
        array[index] = element;
    }
    /**
     * Gets the value of an array element from the index which equals to @param index.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param index int argument
     * @return the value of an array element.
     */
    public int get(int index) {
        return array[index];
    }
    /**
     * Gets the value equals to the array length.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value equals to the array length.
     */
    public int size() {
        return array.length;
    }
}
