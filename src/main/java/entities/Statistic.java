package entities;

/**
 * Statistic.
 */
public class Statistic {
    private final int min;
    private final int max;
    private final long count;
    private final double average;
    private final double median;

    /**
     * Statistic.
     *
     * @param min int argument
     * @param max int argument
     * @param count long argument
     * @param average double argument
     * @param median double argument
     */
    public Statistic(int min, int max, long count, double average, double median) {
        this.min = min;
        this.max = max;
        this.count = count;
        this.average = average;
        this.median = median;
    }

    /**
     * Gets the value of the instance variable "min".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "min".
     */
    public int getMin() {
        return min;
    }

    /**
     * Gets the value of the instance variable "max".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "max".
     */
    public int getMax() {
        return max;
    }

    /**
     * Gets the value of the instance variable "count".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "count".
     */
    public long getCount() {
        return count;
    }

    /**
     * Gets the value of the instance variable "average".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "average".
     */
    public double getAverage() {
        return average;
    }

    /**
     * Gets the value of the instance variable "median".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "median".
     */
    public double getMedian() {
        return median;
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
        return "Statistic{min=" + min + ", max=" + max + ", count=" + count
                + ", average=" + average + ", median=" + median + "}";
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
        final Statistic that = (Statistic) obj;
        return min == that.min && max == that.max && count == that.count
                && average == that.average && median == that.median;
    }
}
