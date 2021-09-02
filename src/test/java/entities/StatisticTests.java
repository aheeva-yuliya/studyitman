package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticTests {

    @Test
    public void getMin() {
        Statistic a = new Statistic(5, 10, 2, 3, 4);
        Assertions.assertEquals(5, a.getMin());
    }

    @Test
    public void getMax() {
        Statistic a = new Statistic(5, 10, 2, 3, 4);
        Assertions.assertEquals(10, a.getMax());
    }

    @Test
    public void getCount() {
        Statistic a = new Statistic(5, 10, 2, 3, 4);
        Assertions.assertEquals(2, a.getCount());
    }

    @Test
    public void getAverage() {
        Statistic a = new Statistic(5, 10, 2, 3, 4);
        Assertions.assertEquals(3, a.getAverage());
    }

    @Test
    public void getMedian() {
        Statistic a = new Statistic(5, 10, 2, 3, 4);
        Assertions.assertEquals(4, a.getMedian());
    }

    @Test
    public void testToString() {
        Statistic a = new Statistic(5, 10, 2, 3, 4);
        String expected = "Statistic{min=5, max=10, count=2, average=3.0, median=4.0}";
        String actual = a.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsTrue() {
        Statistic a = new Statistic(1,2,3,4,5);
        Statistic b = new Statistic(1,2,3,4,5);
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsFalse() {
        Statistic a = new Statistic(3,2,3,5,5);
        Statistic b = new Statistic(1,2,3,4,5);
        Assertions.assertFalse(a.equals(b));
    }
}