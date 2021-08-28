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
        QueueManagementSystem b = new QueueManagementSystem("b");
        Ticket expected = new Ticket(1, "b");
        Ticket actual = b.getNextTicket();
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void getNextTicketThreeTickets() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        QueueManagementSystem b = new QueueManagementSystem("b");
        b.getNextTicket();
        QueueManagementSystem c = new QueueManagementSystem("c");
        c.getNextTicket();
        c.getNextTicket();
        c.getNextTicket();
        Ticket actual = c.getNextTicket();
        Ticket expected = new Ticket(4, "c");
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void getNextTicketThreeTicketsFromBank() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        Ticket first = a.getNextTicket();
        Ticket second = a.getNextTicket();
        Ticket third = a.getNextTicket();
        Ticket expectedFirst = new Ticket(1, "a");
        Ticket expectedSecond = new Ticket(2, "a");
        Ticket expectedThird = new Ticket(3, "a");
        Assertions.assertTrue(expectedFirst.equals(first));
        Assertions.assertTrue(expectedSecond.equals(second));
        Assertions.assertTrue(expectedThird.equals(third));
    }

    @Test
    public void getTotalTicketsOne() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        Assertions.assertEquals(1, a.getTotalTickets());
    }

    @Test
    public void getTotalTicketsTwo() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        QueueManagementSystem b = new QueueManagementSystem("b");
        b.getNextTicket();
        b.getNextTicket();
        Assertions.assertEquals(1, a.getTotalTickets());
        Assertions.assertEquals(2, b.getTotalTickets());
    }

    @Test
    public void getTotalTicketsThree() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        QueueManagementSystem b = new QueueManagementSystem("b");
        b.getNextTicket();
        a.getNextTicket();
        a.getNextTicket();
        Assertions.assertEquals(3, a.getTotalTickets());
        Assertions.assertEquals(1, b.getTotalTickets());
    }
}
