package entities;

/**
 * Ticket
 */
public class Ticket {
    private int number;
    private String place;

    /**
     * Ticket
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
     * Compares all instance variables of two objects.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param that Event object
     * @return boolean true if two objects are equal and false if aren't.
     */
    public boolean equals(Ticket that) {
        return that != null && number == that.number
                && (place != null && place.equals(that.place) || place == null && that.place == null);
    }
}
