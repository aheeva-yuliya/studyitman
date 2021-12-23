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
     * Indicates whether some other object is "equal to" this one.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param obj the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        final Pair that = (Pair) obj;
        return left == that.left && right == that.right;
    }
}
