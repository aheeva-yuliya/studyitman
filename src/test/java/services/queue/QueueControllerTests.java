package services.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class QueueControllerTests {

    @Nested
    public class EndToEnd {
        @Test
        public void shouldReturnTwoTicketsWhenTwoDaysWithOneTicket () {
            QueueController controller = new QueueController();
            String expected = "Ticket{number=1, place='bank'}";
            String actual = controller.getNextTicket();
            Assertions.assertEquals(expected, actual);
            Assertions.assertEquals("1", controller.getTotalTickets());
            Assertions.assertEquals("[1]", controller.getVisitsByDay());
            controller.postNextWorkDay();
            String expectedSecond = "Ticket{number=1, place='bank'}";
            String actualSecond = controller.getNextTicket();
            Assertions.assertEquals(expectedSecond, actualSecond);
            Assertions.assertEquals("2", controller.getTotalTickets());
            Assertions.assertEquals("[1, 1]", controller.getVisitsByDay());
        }

        @Test
        public void shouldReturnOneTicketWhenTwoDaysWithoutTicketsLastDayOneTicket () {
            QueueController controller = new QueueController();
            Assertions.assertEquals("0", controller.getTotalTickets());
            Assertions.assertEquals("[0]", controller.getVisitsByDay());
            controller.postNextWorkDay();
            Assertions.assertEquals("0", controller.getTotalTickets());
            Assertions.assertEquals("[0, 0]", controller.getVisitsByDay());
            controller.postNextWorkDay();
            String expected = "Ticket{number=1, place='bank'}";
            String actual  = controller.getNextTicket();
            Assertions.assertEquals(expected, actual);
            Assertions.assertEquals("1", controller.getTotalTickets());
            Assertions.assertEquals("[0, 0, 1]", controller.getVisitsByDay());
        }
    }
}