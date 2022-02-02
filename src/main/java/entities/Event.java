package entities;

/**
 * Event.
 */
public class Event {
    private int id;
    private int year;
    private int month;
    private int day;
    private String name;

    public Event() {}

    /**
     * Event.
     *
     * @param year int argument
     * @param month int argument
     * @param day int argument
     * @param name String argument
     */
    public Event(int year, int month, int day, String name) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
    }

    /**
     * Event.
     *
     * @param id int argument
     * @param year int argument
     * @param month int argument
     * @param day int argument
     * @param name String argument
     */
    public Event(int id, int year, int month, int day, String name) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
    }

    /**
     * Sets the value of the instance variable "id".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param id int argument
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the value of the instance variable "id".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "id"
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the value of the instance variable "year".
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
     * Gets the value of the instance variable "month".
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
     * Gets the value of the instance variable "day".
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
     * Gets the value of the instance variable "name".
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
        return "Event{id=" + id + ", year=" + year + ", month=" + month + ", day=" + day + ", name='" + name + "'}";
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
        final Event that = (Event) obj;
        return year == that.year && month == that.month && day == that.day && id == that.id
                && (name != null && name.equals(that.name) || name == null && that.name == null);
    }

    /**
     * Compares two Event objects.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param that Event object
     * @return a positive if the current object happened later than the param one
     *         int 0 if the current object happened on the same date
     *         a negative number if the current object happened before the param one.
     */
    public int compareTo(Event that) {
        if (this.year > that.year || this.year == that.year && this.month > that.month
                || this.year == that.year && this.month == that.month && this.day > that.day) {
            return 1;
        } else if (this.year == that.year && this.month == that.month && this.day == that.day) {
            return 0;
        }
        return -1;
    }
}
