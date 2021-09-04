package tasks;

import entities.Statistic;
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

    @Test
    public void calcStatisticByDaysFourQueues() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        a.getNextTicket();
        a.getNextTicket();
        a.getNextTicket();
        a.toNextWorkDay();
        a.getNextTicket();
        a.getNextTicket();
        a.toNextWorkDay();
        a.getNextTicket();
        QueueManagementSystem b = new QueueManagementSystem("b");
        b.getNextTicket();
        b.getNextTicket();
        QueueManagementSystem c = new QueueManagementSystem("c");
        c.getNextTicket();
        c.toNextWorkDay();
        c.getNextTicket();
        c.getNextTicket();
        QueueManagementSystem d = new QueueManagementSystem("d");
        d.getNextTicket();
        d.getNextTicket();
        d.toNextWorkDay();
        d.getNextTicket();
        d.getNextTicket();
        QueueManagementSystem[] fromABCD = new QueueManagementSystem[] {a, b, c, d};
        Statistic[] statistics = QueueManagementSystemUtils.calcStatisticByDays(fromABCD);
        String expected0 = "Statistic{min=4, max=4, count=4, average=4.0, median=4.0}";
        String actual0 = statistics[0].toString();
        String expected1 = "Statistic{min=1, max=2, count=5, average=1.6666666666666667, median=2.0}";
        String actual1 = statistics[1].toString();
        String expected2 = "Statistic{min=1, max=2, count=7, average=1.75, median=2.0}";
        String actual2 = statistics[2].toString();
        Assertions.assertEquals(expected0, actual0);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    public void calcStatisticByDaysOneQueue() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        a.getNextTicket();
        a.toNextWorkDay();
        a.getNextTicket();
        a.getNextTicket();
        a.toNextWorkDay();
        a.getNextTicket();
        a.getNextTicket();
        a.getNextTicket();
        QueueManagementSystem[] fromA = new QueueManagementSystem[] {a};
        Statistic[] statistics = QueueManagementSystemUtils.calcStatisticByDays(fromA);
        String expected0 = "Statistic{min=1, max=1, count=1, average=1.0, median=1.0}";
        String actual0 = statistics[0].toString();
        String expected1 = "Statistic{min=2, max=2, count=2, average=2.0, median=2.0}";
        String actual1 = statistics[1].toString();
        String expected2 = "Statistic{min=3, max=3, count=3, average=3.0, median=3.0}";
        String actual2 = statistics[2].toString();
        Assertions.assertEquals(expected0, actual0);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

}