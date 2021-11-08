package services.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class QueueControllerTests {

    @Nested
    public class EndToEnd {
        @Test
        public void shouldReturnTwoTicketsWhenTwoDaysWithOneTicket () {
            final QueueController controller = new QueueController();
            final String expected = "Ticket{number=1, place='bank'}";
            final String actual = controller.getNextTicket().toString();
            Assertions.assertEquals(expected, actual);
            Assertions.assertEquals("1", controller.getTotalTickets());
            Assertions.assertArrayEquals(new int[]{1}, controller.getVisitsByDay());
            controller.postNextWorkDay();
            final String expectedSecond = "Ticket{number=1, place='bank'}";
            final String actualSecond = controller.getNextTicket().toString();
            Assertions.assertEquals(expectedSecond, actualSecond);
            Assertions.assertEquals("2", controller.getTotalTickets());
            Assertions.assertArrayEquals(new int[] {1, 1}, controller.getVisitsByDay());
        }

        @Test
        public void shouldReturnOneTicketWhenTwoDaysWithoutTicketsLastDayOneTicket () {
            final QueueController controller = new QueueController();
            Assertions.assertEquals("0", controller.getTotalTickets());
            Assertions.assertArrayEquals(new int[] {0}, controller.getVisitsByDay());
            controller.postNextWorkDay();
            Assertions.assertEquals("0", controller.getTotalTickets());
            Assertions.assertArrayEquals(new int[] {0, 0}, controller.getVisitsByDay());
            controller.postNextWorkDay();
            final String expected = "Ticket{number=1, place='bank'}";
            final String actual  = controller.getNextTicket().toString();
            Assertions.assertEquals(expected, actual);
            Assertions.assertEquals("1", controller.getTotalTickets());
            Assertions.assertArrayEquals(new int[]{0, 0, 1}, controller.getVisitsByDay());
        }
    }
}