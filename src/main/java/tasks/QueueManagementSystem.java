package tasks;

import collections.IntArrayList;
import entities.Ticket;

/**
 * QueueManagementSystem.
 */
public class QueueManagementSystem {
    private final String place;
    private int total;
    private final IntArrayList visits = IntArrayList.of(0);
    private int byDay;
    private Queue queue = new Queue();

    /**
     * Creates an object of QueueManagementSystem.
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
        final Ticket ticket = new Ticket(byDay, place);
        queue.push(ticket);
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
    public IntArrayList getVisitsByDay() {
        visits.set(visits.size() - 1, byDay);
        return new IntArrayList(visits);
    }

    /**
     * Returns tickets of the current queue.
     *
     * @cpu O(n), n = number of tickets in current queue
     * @ram O(n), n = number of tickets in current queue
     *
     * @return tickets of the current queue.
     */
    public Ticket[] getCurrentQueue() {
        return queue.currentQueue();
    }

    /**
     * Returns ticket of the first of current queue.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return tickets of the current queue.
     */
    public Ticket callNext() {
        return queue.pop();
    }

    private static class Queue {
        private Node first;
        private Node last;
        private int size;

        private Queue() {
            first = null;
        }

        private static class Node {
            private final Ticket ticket;
            private Node prev;
            private Node next;

            private Node(final Ticket ticket) {
                this.ticket = ticket;
                prev = null;
                next = null;

            }
        }

        private void push(final Ticket ticket) {
            final Node temp = new Node(ticket);
            if (first == null) {
                first = temp;
            } else {
                last.next = temp;
            }
            temp.prev = last;
            last = temp;
            size++;
        }

        private Ticket pop() {
            final Ticket ticket = first.ticket;
            first = first.next;
            size--;
            return ticket;
        }

        private Ticket[] currentQueue() {
            final Ticket[] currentQueue = new Ticket[size];
            Node node = first;
            int index = 0;
            while (node != null) {
                currentQueue[index++] = node.ticket;
                node = node.next;
            }
            return currentQueue;
        }
    }
}
