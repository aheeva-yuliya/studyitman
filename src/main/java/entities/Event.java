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
}
