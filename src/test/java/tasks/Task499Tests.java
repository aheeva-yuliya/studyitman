package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task499Tests {

    @Test
    public void solveNormalCase() {
        int[] a = new int[] {1, 2, 5, 3, 2, 4, 2, 6};
        Assertions.assertEquals(4,Task499.solve(a,8));
    }

    @Test
    public void solveIfElementEqualsArgument() {
        int[] a = new int[] {8};
        Assertions.assertEquals(1,Task499.solve(a,8));
    }

    @Test
    public void solveIfSumLessThanAnArgument() {
        int[] a = new int[] {1, 2, 5, 3, 2, 4, 2, 6};
        Assertions.assertEquals(0,Task499.solve(a,100));
    }

    @Test
    public void solveIfEmpty() {
        int[] a = new int[] {};
        Assertions.assertEquals(0,Task499.solve(a,8));
    }
}