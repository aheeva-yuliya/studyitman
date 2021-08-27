package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueManagementSystemUtilsTests {

    @Test
    public void calcTotalVisitsIfNil() {
        QueueManagementSystem[] a = new QueueManagementSystem[] {};
        Assertions.assertEquals(0, QueueManagementSystemUtils.calcTotalVisits(a));
    }

    @Test
    public void calcTotalVisitsIfOne() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        QueueManagementSystem[] actual = new QueueManagementSystem[] {a};
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcTotalVisits(actual));
    }

    @Test
    public void calcTotalVisitsTwoTicketsOfTwoQueue() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        a.getNextTicket();
        QueueManagementSystem b = new QueueManagementSystem("b");
        b.getNextTicket();
        b.getNextTicket();
        QueueManagementSystem[] ab = new QueueManagementSystem[] {a, b};
        Assertions.assertEquals(4, QueueManagementSystemUtils.calcTotalVisits(ab));
    }

    @Test
    public void calcAverageVisitsIfNil() {
        QueueManagementSystem[] a = new QueueManagementSystem[] {};
        Assertions.assertEquals(0, QueueManagementSystemUtils.calcAverageVisits(a));
    }

    @Test
    public void calcAverageVisitsIfOne() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        QueueManagementSystem[] actual = new QueueManagementSystem[] {a};
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcAverageVisits(actual));
    }

    @Test
    public void calcAverageVisitsSixTicketsOfTwoQueue() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        a.getNextTicket();
        QueueManagementSystem b = new QueueManagementSystem("b");
        b.getNextTicket();
        b.getNextTicket();
        b.getNextTicket();
        b.getNextTicket();
        QueueManagementSystem[] ab = new QueueManagementSystem[] {a, b};
        Assertions.assertEquals(3, QueueManagementSystemUtils.calcAverageVisits(ab));
    }

    @Test
    public void calcAverageVisitsSevenTicketsOfThreeQueue() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        QueueManagementSystem b = new QueueManagementSystem("b");
        b.getNextTicket();
        b.getNextTicket();
        b.getNextTicket();
        b.getNextTicket();
        QueueManagementSystem c = new QueueManagementSystem("c");
        c.getNextTicket();
        c.getNextTicket();
        QueueManagementSystem[] abc = new QueueManagementSystem[] {a, b, c};
        Assertions.assertEquals(2.3333333333333335, QueueManagementSystemUtils.calcAverageVisits(abc));
    }

    @Test
    public void calcMedianVisitsIfNil() {
        QueueManagementSystem[] a = new QueueManagementSystem[] {};
        Assertions.assertEquals(0, QueueManagementSystemUtils.calcMedianVisits(a));
    }

    @Test
    public void calcMedianVisitsIfOne() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        QueueManagementSystem[] actual = new QueueManagementSystem[] {a};
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcMedianVisits(actual));
    }

    @Test
    public void calcMedianVisitsSevenTicketsOfThreeQueue() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        QueueManagementSystem b = new QueueManagementSystem("b");
        b.getNextTicket();
        b.getNextTicket();
        b.getNextTicket();
        b.getNextTicket();
        QueueManagementSystem c = new QueueManagementSystem("c");
        c.getNextTicket();
        c.getNextTicket();
        QueueManagementSystem[] abc = new QueueManagementSystem[] {a, b, c};
        Assertions.assertEquals(2, QueueManagementSystemUtils.calcMedianVisits(abc));
    }

    @Test
    public void calcMedianVisitsSevenTicketsOfFourQueue() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        QueueManagementSystem b = new QueueManagementSystem("b");
        b.getNextTicket();
        b.getNextTicket();
        b.getNextTicket();
        b.getNextTicket();
        QueueManagementSystem c = new QueueManagementSystem("c");
        c.getNextTicket();
        c.getNextTicket();
        c.getNextTicket();
        QueueManagementSystem d = new QueueManagementSystem("d");
        d.getNextTicket();
        d.getNextTicket();
        QueueManagementSystem[] abcd = new QueueManagementSystem[] {a, b, c, d};
        Assertions.assertEquals(2.5, QueueManagementSystemUtils.calcMedianVisits(abcd));
    }
}