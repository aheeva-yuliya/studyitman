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
     * @cpu O(n), n = size
     * @ram O(n), n = size
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
     * @cpu O(n), n = size
     * @ram O(n), n = size
     *
     * @return int[] with all copied elements.
     */
    public int[] toArray() {
        int[] data = new int[size];
        System.arraycopy(array, 0, data, 0, size);
        return data;
    }
    /**
     * Removes the element at the position @param index.
     *
     * @cpu O(n)
     * @ram O(n)
     *
     * @param index int argument
     * @return the deleted element.
     */
    public int remove(int index){
        int value = array[index];
        int[] temp = new int[size - 1];
        System.arraycopy(array, 0, temp, 0, index);
        System.arraycopy(array, index + 1, temp, index,size - index - 1);
        array = temp;
        size--;
        return value;
    }
    /**
     * Compares two objects.
     *
     * @cpu O(n), n = size
     * @ram O(1)
     *
     * @param that an object argument
     * @return true if the objects are equal and false if aren't.
     */
    public boolean equals(ArrayList that) {
        if (that == null || size != that.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (array[i] != that.array[i]) {
                return false;
            }
        }
        return true;
    }
}
