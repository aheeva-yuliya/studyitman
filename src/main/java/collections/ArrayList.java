package collections;

/**
 * ArrayList
 */
public class ArrayList {
    private int[] array;
    private int size;
    /**
     * ArrayList
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
     * Adds the value of the @param element to the end of the existing array. Creates a new temporary
     * int[] and a new instance variable "array" and copies all the elements
     * if the instance variables "size" and "capacity" are equal.
     *
     * @cpu O(n), n = array.length
     * @ram O(n), n = array.length
     *
     * @param element int argument
     */
    public void add(int element) {
        if (size == array.length) {
            int[] temp = new int[size * 2];
            System.arraycopy(array, 0, temp, 0, size);
            array = temp;
        }
        array[size++] = element;
    }
    /**
     * Gets the value equals to the logical array length.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value equals to the logical array length.
     */
    public int size() {
        return size;
    }

    /**
     * Creates a new int[] and copies all elements from the instance variable "array".
     *
     * @cpu O(n), n = array.length
     * @ram O(n), n = array.length
     *
     * @return int[] with all copied elements.
     */
    public int[] toArray() {
        int[] data = new int[array.length];
        System.arraycopy(array, 0, data, 0, array.length);
        return data;
    }
}
