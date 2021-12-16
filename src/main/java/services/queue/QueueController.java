package services.queue;

import collections.ArrayList;
import entities.Ticket;
import org.springframework.web.bind.annotation.*;
import tasks.QueueManagementSystem;

/**
 * QueueController
 */
@RestController
public class QueueController {
    private final QueueManagementSystem queue = new QueueManagementSystem("bank");

    /**
     * Creates the next ticket.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return JSON object of the next ticket.
     */
    @GetMapping("/api/queue/nextTicket")
    public Ticket getNextTicket() {
        return queue.getNextTicket();
    }

    /**
     * Returns the total number of issued tickets.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return String information about the number of issued tickets for the current queue.
     */
    @GetMapping("/api/queue/totalTickets")
    public String getTotalTickets() {
        int total = queue.getTotalTickets();
        return "" + total + "";
    }

    /**
     * Starts a new day.
     *
     * @cpu O(1)
     * @ram O(1)
     */
    @PostMapping("/api/queue/toNextWorkDay")
    public void postNextWorkDay() {
        queue.toNextWorkDay();
    }

    /**
     * Creates an attendance list by day.
     *
     * @cpu O(n) n = number of days
     * @ram O(n), n = number of days
     *
     * @return a JSON object of the attendance list by day.
     */
    @GetMapping("/api/queue/getVisitsByDays")
    public int[] getVisitsByDay() {
        ArrayList arrayList = queue.getVisitsByDay();
        return arrayList.toArray();
    }

    /**
     * Returns tickets of the current queue.
     *
     * cpu O(n), n = number of tickets in current queue
     * ram O(n), n = number of tickets in current queue
     *
     * @return tickets of the current queue.
     */
    @GetMapping("/api/queue/getCurrentQueue")
    public Ticket[] getCurrentQueue() {
        return queue.getCurrentQueue();
    }

    /**
     * Returns ticket of the head of current queue.
     *
     * cpu O(n), n = number of tickets in current queue
     * ram O(1)
     *
     * @return tickets of the current queue.
     */
    @PostMapping("api/queue/callNext")
    public Ticket callNext() {
        return queue.callNext();
    }
}
