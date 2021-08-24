package entities;

/**
 * Event
 */
public class Event {
    public int year;
    public int month;
    public int day;
    public String name;
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
     * Returns a string with information about the fields of the object.
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
     * Compares all fields of the two objects.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param that Event object
     * @return boolean true if equals and false if doesn't.
     */
    public boolean equals(Event that) {
        if (this.year == that.year && this.month == that.month && this.day == that.day && this.name.equals(that.name)) {
            return true;
        }
        return false;
    }
}
