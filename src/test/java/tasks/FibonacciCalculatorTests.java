package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciCalculatorTests {

    @Test
    public void calcFibonacciZeroAndOne() {
        FibonacciCalculator calculator = new FibonacciCalculator();
        Assertions.assertEquals(0, calculator.calc(0));
        Assertions.assertEquals(1, calculator.calc(1));
    }

    @Test
    public void calcFibonacciTwoAndN() {
        FibonacciCalculator calculator = new FibonacciCalculator();
        Assertions.assertEquals(1, calculator.calc(2));
        Assertions.assertEquals(5, calculator.calc(5));
        Assertions.assertEquals(55, calculator.calc(10));
    }

    @Test
    public void calcFibonacciN() {
        FibonacciCalculator calculator = new FibonacciCalculator();
        Assertions.assertEquals(610, calculator.calc(15));
    }
}