package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagementSystemUtilsTests {

    @Test
    public void calcTotalVisitsIfNil() {
        QueueManagementSystem[] a = new QueueManagementSystem[] {};
        Assertions.assertEquals(0, QueueManagementSystemUtils.calcTotalVisits(a));
    }

    @Test
    public void calcTotalVisitsIfOne() {
        QueueManagementSystem[] a = new QueueManagementSystem[] {
                new QueueManagementSystem("u")
        };
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcTotalVisits(a));
    }

    @Test
    public void calcTotalVisitsIfTwo() {
        QueueManagementSystem[] a = new QueueManagementSystem[] {
                new QueueManagementSystem("u"),
                new QueueManagementSystem("z")
        };
        Assertions.assertEquals(2, QueueManagementSystemUtils.calcTotalVisits(a));
    }
}