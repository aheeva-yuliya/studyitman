package collections;

/**
 * ArrayList
 */
public class ArrayList {
    private int[] array;
    private int size;
    private int capacity;
    /**
     * ArrayList
     * @param capacity int argument
     */
    public ArrayList(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
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
     * @cpu O(n), n = instance variable "size"
     * @ram O(n), n = instance variable "size"
     *
     * @param element int argument
     */
    public void add(int element) {
        if (size == capacity) {
            int[] temp = new int[size];
            System.arraycopy(array, 0, temp, 0, size);
            capacity *= 2;
            array = new ArrayList(capacity).array;
            System.arraycopy(temp, 0, array, 0, size);
        }
        array[size] = element;
        size++;
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
}
