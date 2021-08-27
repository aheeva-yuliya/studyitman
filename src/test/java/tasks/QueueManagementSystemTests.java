package tasks;

import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagementSystemTests {

    @Test
    public void getNextTicketFirst() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        Ticket expected = new Ticket(1, "a");
        Ticket actual = a.getNextTicket();
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void getNextTicketTwoTickets() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        a.place = "b";
        Ticket expected = new Ticket(2, "b");
        Ticket actual = a.getNextTicket();
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void getNextTicketThreeTickets() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        a.place = "b";
        a.getNextTicket();
        a.place = "c";
        Ticket actual = a.getNextTicket();
        Ticket expected = new Ticket(3, "c");
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void getTotalTicketsOne() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getTotalTickets();
        Assertions.assertEquals(1, a.total);
    }

    @Test
    public void getTotalTicketsTwo() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getTotalTickets();
        a.getTotalTickets();
        Assertions.assertEquals(2, a.total);
    }
}