package tasks;

import collections.ArrayList;
import entities.Ticket;

/**
 * QueueManagementSystem.
 */
public class QueueManagementSystem {
    private final String place;
    private int total;
    private final ArrayList visits = ArrayList.of(0);
    private int byDay;
    private Queue queue = new Queue();

    /**
     * Creates an object of QueueManagementSystem
     *
     * @cpu O(1)
     * @ram O(1)
     *
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
        Ticket ticket = new Ticket(byDay, place);
        queue.offer(ticket);
        return ticket;
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
        queue = new Queue();
    }

    /**
     * Creates an attendance list by day.
     *
     * @cpu O(1)
     * @ram O(n), n = the length of instance variable visits
     *
     * @return a new object of the ArrayList class.
     */
    public ArrayList getVisitsByDay() {
        visits.set(visits.size() - 1, byDay);
        return new ArrayList(visits);
    }

    /**
     * Returns tickets of the current queue.
     *
     * cpu O(n), n = number of tickets in current queue
     * ram O(n), n = number of tickets in current queue
     *
     * @return tickets of the current queue.
     */
    public Ticket[] getCurrentQueue() {
        final Ticket[] currentQueue = new Ticket[queue.size];
        System.arraycopy(queue.list, 0, currentQueue, 0, queue.size);
        return currentQueue;
    }

    /**
     * Returns ticket of the head of current queue.
     *
     * cpu O(n), n = number of tickets in current queue
     * ram O(1)
     *
     * @return tickets of the current queue.
     */
    public Ticket callNext() {
        return queue.poll();
    }

    private static class Queue {
        private Ticket[] list = new Ticket[2];
        private int size;

        private void offer(Ticket ticket) {
            if (size == list.length) {
                Ticket[] temp = new Ticket[size * 2];
                System.arraycopy(list, 0, temp, 0, size);
                list = temp;
            }
            list[size++] = ticket;
        }

        private Ticket poll() {
            Ticket value = list[0];
            System.arraycopy(list,  1, list, 0,size - 1);
            size--;
            return value;
        }
    }
}
