package tasks;


/**
 * MyString
 */
public class MyString {
    private final char[] data;

    /**
     * MyString
     * @param chars char[]
     */
    public MyString(char[] chars) {
        data = chars;
    }

    /**
     * Gets an instance variable String from the field of the class.
     *
     * @cpu O(1)
     * @ram O(1)
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
     * Converts the string to a new character array and gets a char at the @param index position.
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
     * @cpu O(n), data.length / that.data.length
     * @ram O(1)
     *
     * @param that a String argument of MyString.
     * @return -1 if string lexicographically less than that.string,
     *          0 if the strings are equal,
     *          1 if string is greater than that.string.
     */
    public int compareTo(MyString that) {
        int length;
        if (this.data.length <= that.data.length) {
            length = this.data.length;
        } else {
            length = that.data.length;
        }
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
     * @cpu O(1)
     * @ram O(n) data.length / that.data.length
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
}
