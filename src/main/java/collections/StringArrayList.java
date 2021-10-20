package collections;

import utils.StringBuilder;

/**
 * StringArrayList
 */
public class StringArrayList {
    private String[] data;
    private int size;

    /**
     * Creates an object of StringArrayList with the length of String[] data equals 16.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     */
    public StringArrayList() {
        data = new String[16];
    }

    /**
     * The constructor creates an object with a data field length equals to the parameter capacity.
     *
     * @cpu O(1)
     * @ram O(n), n = capacity
     *
     * @param capacity int argument
     */
    public StringArrayList(int capacity) {
        data = new String[capacity];
    }

    /**
     * Sets the value equals to the parameter element to the index of the array equals to the parameter index.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param index int argument
     * @param element String argument
     */
    public void set(int index, String element) {
        data[index] = element;
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
    public String get(int index) {
        return data[index];
    }

    /**
     * Gets the value equals to the logical data length.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value equals to the logical data length.
     */
    public int size() {
        return size;
    }

    /**
     * Adds the value of the parameter element to the end of the existing array.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element String argument
     */
    public void add(String element) {
        if (size == data.length) {
            String[] temp = new String[size * 2];
            System.arraycopy(data, 0, temp, 0, size);
            data = temp;
        }
        data[size++] = element;
    }

    /**
     * Creates a new String[] and copies all elements from the instance variable "data".
     *
     * @cpu O(n), n = instance variable "size"
     * @ram O(n), n = instance variable "size"
     *
     * @return String[] with all copied elements.
     */
    public String[] toArray() {
        String[] array = new String[size];
        System.arraycopy(data, 0, array, 0, size);
        return array;
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
    public String remove(int index){
        String value = data[index];
        System.arraycopy(data, index + 1, data, index,size - index - 1);
        data[size - 1] = null;
        size--;
        return value;
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
    public static StringArrayList of(String... elements) {
        StringArrayList arrayList = new StringArrayList(elements.length);
        arrayList.size = elements.length;
        System.arraycopy(elements, 0, arrayList.data, 0, elements.length);
        return arrayList;
    }

    /**
     * Returns a String object representing the specified String[] from the instance variable data of StringArrayList.
     *
     * @cpu O(n + m), n = size m = the sum of the lengths of all strings in data
     * @ram O(n + m), n = size m = the sum of the lengths of all strings in data
     *
     * @return a String object.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size - 1; i++) {
            stringBuilder.append(data[i]);
            stringBuilder.append(", ");
        }
        if (size - 1 >= 0) {
            stringBuilder.append(data[size - 1]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
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
    public boolean equals(StringArrayList that) {
        if (that == null || size != that.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (data[i] == null && that.data[i] != null || data[i] != null && !data[i].equals(that.data[i])) {
                return false;
            }
        }
        return true;
    }


    /**
     * Removes all elements from StringArrayList.
     *
     * @cpu O(n) n = size of the data
     * @ram O(1)
     *
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Decreases the capacity of the StringArrayList to the current size.
     *
     * @cpu O(n) n = size
     * @ram O(n) n = size
     *
     */
    public void trimToSize() {
        String[] copy = new String[size];
        System.arraycopy(data,0,copy,0,size);
        data = copy;
    }
}
