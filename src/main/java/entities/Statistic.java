package entities;

/**
 * Statistic
 */
public class Statistic {
    private final int min;
    private final int max;
    private final long count;
    private final double average;
    private final double median;

    /**
     * Statistic
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
        return "Statistic{min=" + min + ", max=" + max +", count=" + count
                + ", average=" + average + ", median=" + median + "}";
    }

    /**
     * Compares all instance variables of two objects.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param that Statistic object
     * @return boolean true if objects are equal and false if aren't.
     */
    public boolean equals(Statistic that) {
        return that != null && min == that.min && max == that.max && count == that.count
                && average == that.average && median == that.median;
    }
}
