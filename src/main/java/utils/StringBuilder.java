package utils;

import tasks.MyString;

/**
 * StringBuilder
 */
public class StringBuilder {
    private char[] data;
    private int size;

    /**
     * StringBuilder default constructor
     */
    public StringBuilder() {
        data = new char[16];
    }

    /**
     * The constructor creates an object with a data field length equals to the @param capacity
     * @param capacity int argument
     */
    public StringBuilder(int capacity) {
        data = new char[capacity];
    }

    /**
     * Returns the length of current data field.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the instance variable size.
     */
    public int length() {
        return size;
    }

    /**
     * Appends the characters from the @param String to the current StringBuilder.
     *
     * @cpu O(n), n = chars.length задать этот вопрос
     * @ram O(n), n = chars.length
     *
     * @param s String argument
     * @return a reference to the current StringBuilder.
     */
    public StringBuilder append(String s) {
        char[] chars = new char[size];
        System.arraycopy(data, 0, chars, 0, size);
        MyString a = new MyString(chars);
        if (s == null) {
            s = "null";
        }
        chars = s.toCharArray();
        MyString b = new MyString(chars);
        data = MyString.plus(a,b).toString().toCharArray();
        size = data.length;
        return this;
    }

    /**
     * Creates a String from the specified boolean.
     * Appends the String representation of the @param x to the current StringBuilder.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param x boolean argument
     * @return a reference to the current StringBuilder.
     */
    public StringBuilder append(boolean x) {
        String string = Boolean.toString(x);
        return append(string);
    }

    /**
     * Creates a String from the specified integer.
     * Appends the String representation of the @param x to the current StringBuilder.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param x int argument
     * @return a reference to the current StringBuilder.
     */
    public StringBuilder append(int x) {
        String string = Integer.toString(x);
        return append(string);
    }

    /**
     * Creates a String from the specified double argument.
     * Appends the String representation of the @param x to the current StringBuilder.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param x double argument
     * @return a reference to the current StringBuilder.
     */
    public StringBuilder append(double x) {
        String string = Double.toString(x);
        return append(string);
    }

    /**
     * Creates a String from the specified long.
     * Appends the String representation of the @param x to the current StringBuilder.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param x long argument
     * @return a reference to the current StringBuilder.
     */
    public StringBuilder append(long x) {
        String string = Long.toString(x);
        return append(string);

    }

    /**
     * Creates a new String from the sequence of characters currently contained in the character array argument.
     *
     * @cpu O(1)
     * @ram O(n) n = data.length
     *
     * @return a new String from the sequence of characters currently contained in the character array argument.
     */
    public String toString() {
        return new String(data);
    }

}
