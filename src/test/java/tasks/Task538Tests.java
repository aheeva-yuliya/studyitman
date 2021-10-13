package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task538Tests {

    @Test
    public void calcFibonacciIfZeroAndOne() {
        Assertions.assertEquals(0, Task538.calcFibonacci(0));
        Assertions.assertEquals(1,Task538.calcFibonacci(1));
    }

    @Test
    public void calcFibonacciIfTwoAndN() {
        Assertions.assertEquals(1, Task538.calcFibonacci(2));
        Assertions.assertEquals(5, Task538.calcFibonacci(5));
        Assertions.assertEquals(55,Task538.calcFibonacci(10));
    }
}