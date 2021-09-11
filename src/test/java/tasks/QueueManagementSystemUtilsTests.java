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
    public void calcTotalVisitsTwoTicketsOfTwoQueue() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        QueueManagementSystem b = new QueueManagementSystem("b");
        QueueManagementSystem[] ab = new QueueManagementSystem[] {of(a, 1), of(b, 3)};
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
        QueueManagementSystem[] actual = new QueueManagementSystem[] {of(a, 1)};
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcAverageVisits(actual));
    }

    @Test
    public void calcAverageVisitsSixTicketsOfTwoQueue() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        QueueManagementSystem b = new QueueManagementSystem("b");
        QueueManagementSystem[] ab = new QueueManagementSystem[] {of(a, 2), of(b, 4)};
        Assertions.assertEquals(3, QueueManagementSystemUtils.calcAverageVisits(ab));
    }

    @Test
    public void calcAverageVisitsSevenTicketsOfThreeQueue() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        QueueManagementSystem b = new QueueManagementSystem("b");
        QueueManagementSystem c = new QueueManagementSystem("c");
        QueueManagementSystem[] abc = new QueueManagementSystem[] {of(a, 1), of(b, 4),
                of(c, 2)};
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
        QueueManagementSystem[] actual = new QueueManagementSystem[] {of(a, 1)};
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcMedianVisits(actual));
    }

    @Test
    public void calcMedianVisitsSevenTicketsOfThreeQueue() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        QueueManagementSystem b = new QueueManagementSystem("b");
        QueueManagementSystem c = new QueueManagementSystem("c");
        QueueManagementSystem[] abc = new QueueManagementSystem[] {of(a, 1), of(b, 4),
                of(c, 2)};
        Assertions.assertEquals(2, QueueManagementSystemUtils.calcMedianVisits(abc));
    }

    @Test
    public void calcMedianVisitsTicketsOfFourQueues() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        QueueManagementSystem b = new QueueManagementSystem("b");
        QueueManagementSystem c = new QueueManagementSystem("c");
        QueueManagementSystem d = new QueueManagementSystem("d");
        QueueManagementSystem[] aBCD = new QueueManagementSystem[] {of(a, 10, 5), of(b, 20, 10, 5),
                of(c, 20, 20, 20), of(d, 10)};
        Assertions.assertEquals(25, QueueManagementSystemUtils.calcMedianVisits(aBCD));
    }

    @Test
    public void calcStatisticByDaysOneQueue() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        of(a, 1, 2, 3);
        QueueManagementSystem[] fromA = new QueueManagementSystem[] {a};
        Statistic[] statistics = QueueManagementSystemUtils.calcStatisticByDays(fromA);
        String expected0 = "Statistic{min=1, max=1, count=1, average=1.0, median=1.0}";
        String actual0 = statistics[0].toString();
        String expected1 = "Statistic{min=2, max=2, count=2, average=2.0, median=2.0}";
        String actual1 = statistics[1].toString();
        String expected2 = "Statistic{min=3, max=3, count=3, average=3.0, median=3.0}";
        String actual2 = statistics[2].toString();
        String expected4 = "Statistic{min=0, max=0, count=0, average=0.0, median=0.0}";
        String actual4 = statistics[3].toString();
        Assertions.assertEquals(expected0, actual0);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected4, actual4);
    }

    @Test
    public void calcStatisticByDaysFourDays() {
        QueueManagementSystem a = new QueueManagementSystem("a");
        QueueManagementSystem b = new QueueManagementSystem("b");
        QueueManagementSystem c = new QueueManagementSystem("c");
        QueueManagementSystem d = new QueueManagementSystem("d");
        QueueManagementSystem[] fromABCD = new QueueManagementSystem[] {of(a, 4, 2, 1), of(b, 2),
                of(c, 4 ), of(d, 2, 2, 5)};
        Statistic[] statistics = QueueManagementSystemUtils.calcStatisticByDays(fromABCD);
        String expected0 = "Statistic{min=2, max=4, count=6, average=3.0, median=3.0}";
        String actual0 = statistics[0].toString();
        String expected1 = "Statistic{min=2, max=2, count=4, average=2.0, median=2.0}";
        String actual1 = statistics[1].toString();
        String expected2 = "Statistic{min=1, max=5, count=12, average=3.0, median=3.0}";
        String actual2 = statistics[2].toString();
        String expected3 = "Statistic{min=0, max=0, count=0, average=0.0, median=0.0}";
        String actual3 = statistics[3].toString();
        Assertions.assertEquals(expected0, actual0);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);
    }

    @Test
    public void calcStatisticByDaysIfNil() {
        QueueManagementSystem[] a = new QueueManagementSystem[0];
        Assertions.assertNotNull(QueueManagementSystemUtils.calcStatisticByDays(a));
    }

    private static QueueManagementSystem of(QueueManagementSystem queue, int... elements) {
        for (int element : elements) {
            for (int j = 0; j < element; j++) {
                queue.getNextTicket();
            }
            queue.toNextWorkDay();
        }
        return queue;
    }
}