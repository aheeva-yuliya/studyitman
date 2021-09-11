package tasks;

import collections.ArrayList;
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
        a.getNextTicket();
        a.getNextTicket();
        QueueManagementSystem b = new QueueManagementSystem("b");
        b.getNextTicket();
        Assertions.assertEquals(3, a.getTotalTickets());
        Assertions.assertEquals(1, b.getTotalTickets());
    }

    @Test
    public void toNextWorkDayWithoutTickets() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.toNextWorkDay();
        a.toNextWorkDay();
        ArrayList expected = ArrayList.of(0, 0, 0);
        ArrayList actual = a.getVisitsByDay();
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void getVisitsByDay() {
        QueueManagementSystem a = new QueueManagementSystem("Bank");
        a.getNextTicket();
        a.getNextTicket();
        a.toNextWorkDay();
        a.getNextTicket();
        a.toNextWorkDay();
        ArrayList expected = ArrayList.of(2, 1, 0);
        ArrayList actual = a.getVisitsByDay();
        Assertions.assertTrue(expected.equals(actual));
        Assertions.assertEquals(3, a.getTotalTickets());
    }

    @Test
    public void getVisitsByDayThisDay() {
        QueueManagementSystem a = new QueueManagementSystem("Bank");
        a.getNextTicket();
        a.getNextTicket();
        a.toNextWorkDay();
        a.getNextTicket();
        ArrayList expected = ArrayList.of(2, 1);
        ArrayList actual = a.getVisitsByDay();
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void getVisitsByDayFromTwoQueue() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        a.getNextTicket();
        a.toNextWorkDay();
        a.getNextTicket();
        a.toNextWorkDay();
        a.toNextWorkDay();
        QueueManagementSystem b = new QueueManagementSystem("b");
        b.getNextTicket();
        b.getNextTicket();
        b.toNextWorkDay();
        a.getNextTicket();
        a.getNextTicket();
        a.toNextWorkDay();
        ArrayList aExpected = ArrayList.of(2, 1, 0, 2, 0);
        ArrayList aActual = a.getVisitsByDay();
        Assertions.assertTrue(aExpected.equals(aActual));
        ArrayList bExpected = ArrayList.of(2, 0);
        ArrayList bActual = b.getVisitsByDay();
        Assertions.assertTrue(bExpected.equals(bActual));
        Assertions.assertEquals(5, a.getTotalTickets());
        Assertions.assertEquals(2, b.getTotalTickets());
    }

    @Test
    public void getTotalTicketsAfterTwoDays() {
        QueueManagementSystem system = new QueueManagementSystem("bank");
        system.getNextTicket();
        system.getNextTicket();
        system.toNextWorkDay();
        system.getNextTicket();
        system.toNextWorkDay();
        Assertions.assertEquals(3, system.getTotalTickets());
    }

    @Test
    public void getTotalTicketsAfterThreeDays() {
        QueueManagementSystem system = new QueueManagementSystem("bank");
        system.getNextTicket();
        system.getNextTicket();
        system.toNextWorkDay();
        system.getNextTicket();
        system.toNextWorkDay();
        ArrayList expected = ArrayList.of(2, 1, 0);
        ArrayList actual = system.getVisitsByDay();
        Assertions.assertEquals(3, system.getTotalTickets());
        Assertions.assertTrue(expected.equals(actual));
    }
}
