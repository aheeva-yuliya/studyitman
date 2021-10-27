package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task498Tests {
    @Nested
    public class CalcMovingAverage {
        @Test
        public void shouldCalcMovingAverageWhenEven() {
            double[] a = new double[]{10, 100, 20, 50, 30};
            double[] expected = new double[]{55, 60, 35, 40};
            Assertions.assertArrayEquals(expected, Task498.calcMovingAverage(a, 2));
        }

        @Test
        public void shouldCalcMovingAverageWhenOdd() {
            double[] a = new double[]{9, 90, 21, 48, 30, 33, 3};
            double[] expected = new double[]{40, 53, 33, 37, 22};
            Assertions.assertArrayEquals(expected, Task498.calcMovingAverage(a, 3));
        }

        @Test
        public void shouldCalcMovingAverageWhenLengthEqualsN() {
            double[] a = new double[]{10, 100, 20, 50, 30};
            double[] expected = new double[]{42};
            Assertions.assertArrayEquals(expected, Task498.calcMovingAverage(a, 5));
        }

        @Test
        public void shouldCalcMovingAverageWhenLengthIsOne() {
            double[] a = new double[]{10};
            double[] expected = new double[]{10};
            Assertions.assertArrayEquals(expected, Task498.calcMovingAverage(a, 1));
        }

        @Test
        public void shouldCalcMovingAverageWhenEmpty() {
            double[] a = new double[]{};
            Assertions.assertNotNull(Task498.calcMovingAverage(a, 2));
        }
    }
}