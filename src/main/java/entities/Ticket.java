package entities;

/**
 * Ticket.
 */
public class Ticket {
    private int number;
    private String place;

    public Ticket() {}

    /**
     * Ticket.
     *
     * @param number int argument
     * @param place String argument
     */
    public Ticket(int number, String place) {
        this.number = number;
        this.place = place;
    }

    /**
     * Gets the value of the instance variable "number".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "number".
     */
    public int getNumber() {
        return number;
    }

    /**
     * Gets the value of the instance variable "place".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "place".
     */
    public String getPlace() {
        return place;
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
        return "Ticket{number=" + number + ", place='" + place + "'}";
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
        final Ticket that = (Ticket) obj;
        return number == that.number
                && (place != null && place.equals(that.place) || place == null && that.place == null);
    }
}
