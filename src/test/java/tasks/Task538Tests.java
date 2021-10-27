package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task538Tests {
    @Nested
    public class CalcFibonacci {
        @Test
        public void shouldCalcFibonacciWhenZeroAndOne() {
            Assertions.assertEquals(0, Task538.calcFibonacci(0));
            Assertions.assertEquals(1, Task538.calcFibonacci(1));
        }

        @Test
        public void shouldCalcFibonacciWhenTwoAndN() {
            Assertions.assertEquals(1, Task538.calcFibonacci(2));
            Assertions.assertEquals(5, Task538.calcFibonacci(5));
            Assertions.assertEquals(55, Task538.calcFibonacci(10));
        }
    }
}