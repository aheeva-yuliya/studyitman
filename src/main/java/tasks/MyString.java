package tasks;


/**
 * MyString
 */
public class MyString {
    private final char[] data;

    /**
     * Creates an object of MyString by coping all elements from the parameter chars.
     *
     * @cpu O(n), n = chars.length
     * @ram O(n), n = chars.length
     *
     * @param chars char[]
     */
    public MyString(char[] chars) {
        data = new char[chars.length];
        System.arraycopy(chars, 0, data, 0, chars.length);
    }

    /**
     * Gets an instance variable String from the field of the class.
     *
     * @cpu O(n), n = data.length
     * @ram O(n), n = data.length
     *
     * @return a String argument.
     */
    public String toString() {
        return new String(data);
    }

    /**
     * Returns the length of this string.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the length of the sequence of characters represented by this object.
     */
    public int length() {
        return data.length;
    }

    /**
     * Converts the string to a new character array and gets a char at the parameter index position.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param index int argument
     * @return a char at the @param index.
     */
    public char charAt(int index) {
        return data[index];
    }

    /**
     * Compares two strings lexicographically.
     *
     * @cpu O(n), n = the smallest of two lengths
     * @ram O(1)
     *
     * @param that a String argument of MyString.
     * @return a negative number if string lexicographically less than that.string,
     *         0 if the strings are equal,
     *         a positive number if string is greater than that.string.
     */
    public int compareTo(MyString that) {
        int length = Math.min(this.data.length, that.data.length);
        if (this.data.length == 0 && that.data.length > 0) {
            return -1;
        }
        if (that.data.length == 0 && this.data.length > 0) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            if ((int) this.data[i] < (int) that.data[i]
                    || (int) this.data[i] == (int) that.data[i] && this.data.length < that.data.length) {
                return -1;
            }
            if ((int) this.data[i] > (int) that.data[i]
                    || (int) this.data[i] == (int) that.data[i] && this.data.length > that.data.length) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Compares this object to the specified object.
     *
     * @cpu O(n), n = data.length
     * @ram O(1)
     *
     * @param that a String argument of the MyString class.
     * @return true if the given object represents a String equivalent to this string, false otherwise.
     */
    public boolean equals(MyString that) {
        if (that != null && data.length == that.data.length) {
            for (int i = 0; i < data.length; i++) {
                if ((int) data[i] != (int) that.data[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Creates a new object using string concatenation.
     *
     * @cpu O(n + m), n = a.data.length m = b.data.length
     * @ram O(n + m), n = a.data.length m = b.data.length
     *
     * @param a an object of MyString
     * @param b an object of MyString
     * @return a new object of MyString.
     */
    public static MyString plus(MyString a, MyString b) {
        char[] result = new char[a.data.length + b.data.length];
        System.arraycopy(a.data, 0, result, 0, a.data.length);
        System.arraycopy(b.data, 0, result, a.data.length, b.data.length);
        return new MyString(result);
    }

    /**
     * Creates a new object using string concatenation.
     *
     * @cpu O(n + m), n = data.length m = that.data.length
     * @ram O(n + m), n = data.length m = that.data.length
     *
     * @param that an object of MyString
     * @return a new object of MyString.
     */
    public MyString plus(MyString that) {
        char[] result = new char[data.length + that.data.length];
        System.arraycopy(data, 0, result, 0, data.length);
        System.arraycopy(that.data, 0, result, data.length, that.data.length);
        return new MyString(result);
    }

    public MyString replace(char target, char replacement) {
        char[] result = new char[data.length];
        System.arraycopy(data, 0, result, 0, data.length);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == target) {
                result[i] = replacement;
            }
        }
        return new MyString(result);
    }
}
