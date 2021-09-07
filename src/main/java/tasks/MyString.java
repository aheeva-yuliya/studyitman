package tasks;

/**
 * MyString
 */
public class MyString {
    private String string;

    /**
     * MyString
     * @param chars char[]
     */
    public MyString(char[] chars) {
        string = new String(chars);
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
        return string;
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
        return string.length();
    }

    /**
     * Converts the string to a new character array and gets a char at the @param index position.
     *
     * @cpu O(1)
     * @ram O(n), n = chars.length
     *
     * @param index int argument
     * @return a char at the @param index.
     */
    public char charAt(int index) {
        char[] chars = string.toCharArray();
        return chars[index];
    }

    /**
     * Compares two strings lexicographically.
     *
     * @cpu O(n), n = thisChars.length
     * @ram O(n), thisChars.length / thatChars.length
     *
     * @param that a String argument of MyString.
     * @return -1 if string lexicographically less than that.string,
     *          0 if the strings are equal,
     *          1 if string is greater than that.string.
     */
    public int compareTo(MyString that) {
        char[] thisChars = string.toCharArray();
        char[] thatChars = that.string.toCharArray();
        int length = 0;
        if (thisChars.length <= thatChars.length) {
            length = thisChars.length;
        } else {
            length = thatChars.length;
        }
        if (thisChars.length == 0 && thatChars.length > 0) {
            return -1;
        }
        if (thatChars.length == 0 && thisChars.length > 0) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            if ((int) thisChars[i] < (int) thatChars[i]
                    || (int) thisChars[i] == (int) thatChars[i] && thisChars.length < thatChars.length) {
                return -1;
            }
            if ((int) thisChars[i] > (int) thatChars[i]
                    || (int) thisChars[i] == (int) thatChars[i] && thisChars.length > thatChars.length) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Compares this string to the specified object.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param that a String argument of the MyString class.
     * @return true if the given object represents a String equivalent to this string, false otherwise.
     */
    public boolean equals(MyString that) {
        return that != null && string.equals(that.string);
    }
}
