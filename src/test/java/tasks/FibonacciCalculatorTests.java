package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FibonacciCalculatorTests {
    @Nested
    public class CalcFibonacci {
        @Test
        public void shouldCalcFibonacciWhenZeroAndOne() {
            FibonacciCalculator calculator = new FibonacciCalculator();
            Assertions.assertEquals(0, calculator.calc(0));
            Assertions.assertEquals(1, calculator.calc(1));
        }

        @Test
        public void shouldCalcFibonacciWhenTwoAndN() {
            FibonacciCalculator calculator = new FibonacciCalculator();
            Assertions.assertEquals(1, calculator.calc(2));
            Assertions.assertEquals(5, calculator.calc(5));
            Assertions.assertEquals(55, calculator.calc(10));
        }

        @Test
        public void shouldCalcFibonacciWhenNOperations() {
            FibonacciCalculator calculator = new FibonacciCalculator();
            Assertions.assertEquals(610, calculator.calc(15));
        }
    }
}