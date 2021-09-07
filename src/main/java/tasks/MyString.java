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
     * Compares the length of two strings.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param that a String argument of MyString.
     * @return -1 if the length of this.string < the length of that.string,
     *          0 if the lengths are equal,
     *          1 if the length of this.string > the length of that.string.
     */
    public int compareTo(MyString that) {
        if (string.length() < that.length()) {
            return -1;
        }
        if (string.length() == that.length()) {
            return 0;
        }
        return 1;
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
