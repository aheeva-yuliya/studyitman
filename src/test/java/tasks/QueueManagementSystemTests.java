package tasks;

import collections.IntArrayList;
import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class QueueManagementSystemTests {
    @Nested
    public class GetNextTicketTests {
        @Test
        public void shouldGetNextTicketWhenFirst() {
            QueueManagementSystem a = new QueueManagementSystem("a");
            Ticket expected = new Ticket(1, "a");
            Ticket actual = a.getNextTicket();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldGetNextTicketWhenTwoTickets() {
            QueueManagementSystem a = new QueueManagementSystem("a");
            a.getNextTicket();
            QueueManagementSystem b = new QueueManagementSystem("b");
            Ticket expected = new Ticket(1, "b");
            Ticket actual = b.getNextTicket();
            Assertions.assertEquals(expected, actual);
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
            Assertions.assertEquals(expected, actual);
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
            Assertions.assertEquals(expectedFirst, first);
            Assertions.assertEquals(expectedSecond, second);
            Assertions.assertEquals(expectedThird, third);
        }
    }

    @Nested
    public class GetTotalTicketsTests {
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
            IntArrayList expected = IntArrayList.of(2, 1, 0);
            IntArrayList actual = system.getVisitsByDay();
            Assertions.assertEquals(3, system.getTotalTickets());
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class GetVisitsByDayTests {
        @Test
        public void shouldGetVisitsByDayWhenSomeDays() {
            QueueManagementSystem a = new QueueManagementSystem("Bank");
            a.getNextTicket();
            a.getNextTicket();
            a.toNextWorkDay();
            a.getNextTicket();
            a.toNextWorkDay();
            IntArrayList expected = IntArrayList.of(2, 1, 0);
            IntArrayList actual = a.getVisitsByDay();
            Assertions.assertEquals(expected, actual);
            Assertions.assertEquals(3, a.getTotalTickets());
        }

        @Test
        public void shouldGetVisitsByDayWhenThisDay() {
            QueueManagementSystem a = new QueueManagementSystem("Bank");
            a.getNextTicket();
            a.getNextTicket();
            a.toNextWorkDay();
            a.getNextTicket();
            IntArrayList expected = IntArrayList.of(2, 1);
            IntArrayList actual = a.getVisitsByDay();
            Assertions.assertEquals(expected, actual);
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
            IntArrayList aExpected = IntArrayList.of(2, 1, 0, 2, 0);
            IntArrayList aActual = a.getVisitsByDay();
            Assertions.assertEquals(aExpected, aActual);
            IntArrayList bExpected = IntArrayList.of(2, 0);
            IntArrayList bActual = b.getVisitsByDay();
            Assertions.assertEquals(bExpected, bActual);
            Assertions.assertEquals(5, a.getTotalTickets());
            Assertions.assertEquals(2, b.getTotalTickets());
        }

        @Test
        public void shouldGetVisitsByDayWhenZeroTickets() {
            QueueManagementSystem a = new QueueManagementSystem("a");
            a.toNextWorkDay();
            a.toNextWorkDay();
            IntArrayList expected = IntArrayList.of(0, 0, 0);
            IntArrayList actual = a.getVisitsByDay();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class GetCurrentQueueTests {
        @Test
        public void shouldGetCurrentQueueWhenNoTicketsInQueue() {
            final QueueManagementSystem a = new QueueManagementSystem("a");
            final Ticket[] expected = new Ticket[0];
            final Ticket[] actual = a.getCurrentQueue();
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldGetCurrentQueueWhenSomeTicketsInQueue() {
            final QueueManagementSystem a = new QueueManagementSystem("a");
            a.getNextTicket();
            a.getNextTicket();
            final Ticket[] expected = new Ticket[]{
                    new Ticket(1, "a"),
                    new Ticket(2, "a")
            };
            final Ticket[] actual = a.getCurrentQueue();
            for (int i = 0; i < actual.length; i++) {
                Assertions.assertEquals(expected[i], actual[i]);
            }
        }

        @Test
        public void shouldGetCurrentQueueWhenSomeTicketsWereCalledFromQueue() {
            final QueueManagementSystem a = new QueueManagementSystem("a");
            a.getNextTicket();
            a.getNextTicket();
            a.getNextTicket();
            a.callNext();
            final Ticket[] expected = new Ticket[]{
                    new Ticket(2, "a"),
                    new Ticket(3, "a")
            };
            final Ticket[] actual = a.getCurrentQueue();
            for (int i = 0; i < actual.length; i++) {
                Assertions.assertEquals(expected[i], actual[i]);
            }
        }

        @Test
        public void shouldGetOnlyCurrentQueueWhenSomeWorkingDays() {
            final QueueManagementSystem a = new QueueManagementSystem("a");
            a.getNextTicket();
            a.toNextWorkDay();
            a.getNextTicket();
            a.getNextTicket();
            final Ticket[] expected = new Ticket[]{
                    new Ticket(1, "a"),
                    new Ticket(2, "a")
            };
            final Ticket[] actual = a.getCurrentQueue();
            for (int i = 0; i < actual.length; i++) {
                Assertions.assertEquals(expected[i], actual[i]);
            }
        }
    }

    @Nested
    public class CallNextTests {
        @Test
        public void shouldRemoveFirstWhenThereOne() {
            final QueueManagementSystem a = new QueueManagementSystem("a");
            final Ticket expected = a.getNextTicket();
            final Ticket actual = a.callNext();
            Assertions.assertEquals(expected, actual);
            final Ticket[] expectedTickets = new Ticket[0];
            final Ticket[] actualTickets = a.getCurrentQueue();
            Assertions.assertArrayEquals(expectedTickets, actualTickets);
        }

        @Test
        public void shouldAlwaysRemoveFirstWhenThereSomeTickets() {
            final QueueManagementSystem a = new QueueManagementSystem("a");
            final Ticket first = a.getNextTicket();
            final Ticket second = a.getNextTicket();
            Ticket actual = a.callNext();
            Assertions.assertEquals(first, actual);
            actual = a.callNext();
            Assertions.assertEquals(second, actual);
            final Ticket[] expectedTickets = new Ticket[0];
            final Ticket[] actualTickets = a.getCurrentQueue();
            Assertions.assertArrayEquals(expectedTickets, actualTickets);
        }
    }
}
