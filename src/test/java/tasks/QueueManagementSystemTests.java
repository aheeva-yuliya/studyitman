package tasks;

import collections.ArrayList;
import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class QueueManagementSystemTests {
    @Nested
    public class Get {
        @Nested
        public class NextTicket {
            @Test
            public void shouldGetNextTicketWhenFirst() {
                QueueManagementSystem a = new QueueManagementSystem("a");
                Ticket expected = new Ticket(1, "a");
                Ticket actual = a.getNextTicket();
                Assertions.assertTrue(expected.equals(actual));
            }

            @Test
            public void shouldGetNextTicketWhenTwoTickets() {
                QueueManagementSystem a = new QueueManagementSystem("a");
                a.getNextTicket();
                QueueManagementSystem b = new QueueManagementSystem("b");
                Ticket expected = new Ticket(1, "b");
                Ticket actual = b.getNextTicket();
                Assertions.assertTrue(expected.equals(actual));
            }

            @Test
            public void shouldGetNextTicketWhenThreeTickets() {
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
            public void shouldGetNextTicketWhenThreeTicketsFromBank() {
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
        }

        @Nested
        public class TotalTickets {
            @Test
            public void shouldGetTotalTicketsWhenOne() {
                QueueManagementSystem a = new QueueManagementSystem("a");
                a.getNextTicket();
                Assertions.assertEquals(1, a.getTotalTickets());
            }

            @Test
            public void shouldGetTotalTicketsWhenTwo() {
                QueueManagementSystem a = new QueueManagementSystem("a");
                a.getNextTicket();
                QueueManagementSystem b = new QueueManagementSystem("b");
                b.getNextTicket();
                b.getNextTicket();
                Assertions.assertEquals(1, a.getTotalTickets());
                Assertions.assertEquals(2, b.getTotalTickets());
            }

            @Test
            public void shouldGetTotalTicketsWhenThree() {
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
            public void shouldGetTotalTicketsWhenTwoDays() {
                QueueManagementSystem system = new QueueManagementSystem("bank");
                system.getNextTicket();
                system.getNextTicket();
                system.toNextWorkDay();
                system.getNextTicket();
                system.toNextWorkDay();
                Assertions.assertEquals(3, system.getTotalTickets());
            }

            @Test
            public void shouldGetTotalTicketsWhenThreeDays() {
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

        @Nested
        public class VisitsByDay{
            @Test
            public void shouldGetVisitsByDayWhenSomeDays() {
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
            public void shouldGetVisitsByDayWhenThisDay() {
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
            public void shouldGetVisitsByDayWhenTwoQueue() {
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
            public void shouldGetVisitsByDayWhenZeroTickets() {
                QueueManagementSystem a = new QueueManagementSystem("a");
                a.toNextWorkDay();
                a.toNextWorkDay();
                ArrayList expected = ArrayList.of(0, 0, 0);
                ArrayList actual = a.getVisitsByDay();
                Assertions.assertTrue(expected.equals(actual));
            }
        }
    }
}
