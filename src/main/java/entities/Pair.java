package entities;

/**
 * Pair.
 */
public class Pair {
    private final int left;
    private final int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Gets the value of the instance variable "left".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "left".
     */
    public int getLeft() {
        return left;
    }

    /**
     * Gets the value of the instance variable "right".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "right".
     */
    public int getRight() {
        return right;
    }

    /**
     * Returns a string with information about the instance variables of the object.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return a string with information.
     */
    public String toString() {
        return "Pair{left=" + left + ", right=" + right + "}";
    }

    /**
     * Compares all instance variables of two objects.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param that Pair object
     * @return boolean true if objects are equal and false if aren't.
     */
    public boolean equals(Pair that) {
        return that != null && left == that.left && right == that.right;
    }
}
