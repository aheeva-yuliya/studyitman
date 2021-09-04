package entities;

/**
 * Event
 */
public class Event {
    private int year;
    private int month;
    private int day;
    private String name;

    /**
     * Event
     * @param year int argument
     * @param month int argument
     * @param day int argument
     * @param name String argument
     */
    public Event (int year, int month, int day, String name) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
    }

    /**
     * Gets the value of the instance variable "year"
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "year"
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the value of the instance variable "month"
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "month"
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets the value of the instance variable "day"
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "day"
     */
    public int getDay() {
        return day;
    }

    /**
     * Gets the value of the instance variable "name"
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "name"
     */
    public String getName() {
        return name;
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
        return "Event{year=" + year + ", month=" + month + ", day=" + day + ", name='" + name + "'}";
    }

    /**
     * Compares all instance variables of two objects.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param that Event object
     * @return boolean true if objects are equal and false if aren't.
     */
    public boolean equals(Event that) {
        return that != null && year == that.year && month == that.month && day == that.day
                && (name != null && name.equals(that.name) || name == null && that.name == null);
    }

    /**
     * Compares two Event objects.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param that Event object
     * @return int 1 if the current object happened later than the param one
     *         int 0 if the current object happened on the same date
     *         int -1 if the current object happened before the param one.
     */
    public int compareTo(Event that) {
        if (this.year > that.year || this.year == that.year && this.month > that.month
                || this.year == that.year && this.month == that.month && this.day > that.day) {
            return 1;
        } else if (this.year == that.year && this.month == that.month && this.day == that.day) {
            return 0;
        } return -1;
    }
}
