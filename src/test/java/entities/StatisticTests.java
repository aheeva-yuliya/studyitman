package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StatisticTests {
    @Nested
    public class Get {
        @Test
        public void shouldGetMinWhenHas() {
            Statistic a = new Statistic(5, 10, 2, 3, 4);
            Assertions.assertEquals(5, a.getMin());
        }

        @Test
        public void shouldGetMaxWhenHas() {
            Statistic a = new Statistic(5, 10, 2, 3, 4);
            Assertions.assertEquals(10, a.getMax());
        }

        @Test
        public void shouldGetCountWhenHas() {
            Statistic a = new Statistic(5, 10, 2, 3, 4);
            Assertions.assertEquals(2, a.getCount());
        }

        @Test
        public void shouldGetAverageWhenHas() {
            Statistic a = new Statistic(5, 10, 2, 3, 4);
            Assertions.assertEquals(3, a.getAverage());
        }

        @Test
        public void shouldGetMedianWhenHas() {
            Statistic a = new Statistic(5, 10, 2, 3, 4);
            Assertions.assertEquals(4, a.getMedian());
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenTry() {
            Statistic a = new Statistic(5, 10, 2, 3, 4);
            String expected = "Statistic{min=5, max=10, count=2, average=3.0, median=4.0}";
            String actual = a.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenStatisticsEqual() {
            Statistic a = new Statistic(1, 2, 3, 4, 5);
            Statistic b = new Statistic(1, 2, 3, 4, 5);
            Assertions.assertEquals(a, b);
        }

        @Test
        public void shouldReturnFalseWhenStatisticsNotEqual() {
            Statistic a = new Statistic(3, 2, 3, 5, 5);
            Statistic b = new Statistic(1, 2, 3, 4, 5);
            Assertions.assertNotEquals(a, b);
        }
    }
}