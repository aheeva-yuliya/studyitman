package tasks;

import entities.Ticket;
/**
 * QueueManagementSystem.
 */
public class QueueManagementSystem {
    public String place;
    public int currentNumber;
    public int total;
    /**
     * QueueManagementSystem
     * @param place a String argument
     */
    public QueueManagementSystem(String place) {
        this.place = place;
    }
    /**
     * Creates the next ticket.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the next ticket.
     */
    public Ticket getNextTicket() {
        total++;
        return new Ticket(total, place);
    }
    /**
     * Finds the total number of issued tickets.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the number of issued tickets for the current queue.
     */
    public int getTotalTickets() {
        return total;
    }
}
