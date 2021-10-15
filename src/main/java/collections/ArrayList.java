package collections;

import utils.ArrayUtils;
import utils.StringBuilder;

/**
 * ArrayList
 */
public class ArrayList {
    private int[] array;
    private int size;

    /**
     * Creates an object of ArrayList with the length of int[] array equals 16.
     *
     * @cpu O(1)
     * @ram O(1)
     */
    public ArrayList() {
        array = new int[16];
    }

    /**
     * Creates an object of ArrayList with the length of int[] array equals to the parameter capacity.
     *
     * @cpu O(1)
     * @ram O(n), n = parameter capacity
     *
     * @param capacity int argument
     */
    public ArrayList(int capacity) {
        array = new int[capacity];
    }

    /**
     * ArrayList
     *
     * @cpu O(n), n = parameter that array.length
     * @ram O(n), n = parameter that array.length
     *
     * @param that a class object
     */
    public ArrayList (ArrayList that) {
        size = that.size;
        array = new int[that.array.length];
        System.arraycopy(that.array, 0, array, 0, that.array.length);
    }

    /**
     * Sets the value equals to the parameter element to the index of the array equals to the parameter index.
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
     * Gets the value of an array element from the index which equals to parameter index.
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
     * Adds the value of the parameter element to the end of the existing array. Creates a new temporary
     * int[] and a new instance variable "array" and copies all the elements
     * if the instance variables "size" and "array".length are equal.
     *
     * @cpu O(1)
     * @ram O(1)
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
     * @cpu O(n), n = instance variable "size"
     * @ram O(n), n = instance variable "size"
     *
     * @return int[] with all copied elements.
     */
    public int[] toArray() {
        int[] data = new int[size];
        System.arraycopy(array, 0, data, 0, size);
        return data;
    }

    /**
     * Removes the element at the position of parameter index.
     *
     * @cpu O(n), n = instance variable "size"
     * @ram O(1)
     *
     * @param index int argument
     * @return the deleted element.
     */
    public int remove(int index){
        int value = array[index];
        System.arraycopy(array, index + 1, array, index,size - index - 1);
        size--;
        return value;
    }

    /**
     * Indicates whether some other object is "equal to" this one .
     *
     * @cpu O(n), n = instance variable "size"
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

    /**
     * Sorts all the elements in ArrayList in ascending order.
     *
     * @cpu O(nlog(n)), n = instance variable "size"
     * @ram O(n) n = instance variable "size"
     */
    public void sort() {
       ArrayUtils.mergeSort(array, 0, size);
    }

    /**
     * Creates a new object of the class depending on the parameter argument.
     *
     * @cpu O(n), n = elements.length
     * @ram O(n), n = elements.length
     *
     * @param elements variable arguments list
     * @return an object of the class.
     */
    public static ArrayList of(int... elements) {
        ArrayList arrayList = new ArrayList(elements.length);
        arrayList.size = elements.length;
        System.arraycopy(elements, 0, arrayList.array, 0, elements.length);
        return arrayList;
    }

    /**
     * Returns a String object representing the specified int[] from the instance variable array of ArrayList.
     *
     * @cpu O(n), n = size
     * @ram O(n), n = size
     *
     * @return a String object.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size - 1; i++) {
            stringBuilder.append(array[i]);
            stringBuilder.append(", ");
        }
        if (size - 1 >= 0) {
            stringBuilder.append(array[size - 1]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * Removes all elements from ArrayList.
     *
     * @cpu O(n) n = the length of the instance variable array
     * @ram O(1)
     *
     */
    public void clear() {
        for (int i = array.length - 1; i >= 0; i--) {
            remove(i);
        }
    }

    /**
     * Decreases the capacity of the ArrayList to the current size.
     *
     * @cpu O(n) n = the length of the instance variable array
     * @ram O(1)
     *
     */
    public void trimToSize() {
        int to = size;
        size = array.length;
        for (int i = size - 1; i >= to; i--) {
            remove(i);
        }
    }
}
