package tasks;

import collections.ArrayList;
import entities.Ticket;
/**
 * QueueManagementSystem.
 */
public class QueueManagementSystem {
    private String place;
    private int total;
    private ArrayList visits = ArrayList.of(0);
    private int byDay;

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
        byDay++;
        return new Ticket(byDay, place);
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

    /**
     * Starts a new day.
     *
     * @cpu O(1)
     * @ram O(1)
     */
    public void toNextWorkDay() {
        visits.set(visits.size() - 1, byDay);
        visits.add(0);
        byDay = 0;
    }

    /**
     * Creates an attendance list by day.
     *
     * @cpu O(1)
     * @ram O(n), n = days of attendance
     *
     * @return a new object of the ArrayList class.
     */
    public ArrayList getVisitsByDay() {
        visits.set(visits.size() - 1, byDay);
        return ArrayList.of(visits.toArray());
    }
}
