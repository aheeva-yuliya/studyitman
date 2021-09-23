package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task498Tests {

    @Test
    public void calcMovingAverageNormalCase() {
        double[] a = new double[] {10, 100, 20, 50, 30};
        double[] expected = new double[] {55, 60, 35, 40};
        Assertions.assertArrayEquals(expected,Task498.calcMovingAverage(a, 2));
    }

    @Test
    public void calcMovingAverageLengthEqualsN() {
        double[] a = new double[] {10, 100, 20, 50, 30};
        double[] expected = new double[] {42};
        Assertions.assertArrayEquals(expected,Task498.calcMovingAverage(a, 5));
    }

    @Test
    public void calcMovingAverageIfEmpty() {
        double[] a = new double[] {};
        Assertions.assertNotNull(Task498.calcMovingAverage(a, 2));
    }
}