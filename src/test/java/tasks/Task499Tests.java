package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task499Tests {
    @Nested
    public class Solve {
        @Test
        public void shouldSolveWhenNormalCase() {
            int[] a = new int[]{1, 2, 5, 3, 2, 4, 2, 6};
            Assertions.assertEquals(4, Task499.solve(a, 8));
        }

        @Test
        public void shouldSolveWhenAtZeroIndex() {
            int[] a = new int[]{8, 1, 2, 5, 3, 2, 4, 2, 6};
            Assertions.assertEquals(5, Task499.solve(a, 8));
        }

        @Test
        public void shouldSolveWhenAtLastIndex() {
            int[] a = new int[]{1, 2, 5, 3, 2, 4, 2, 6, 8};
            Assertions.assertEquals(5, Task499.solve(a, 8));
        }

        @Test
        public void shouldSolveWhenElementEqualsArgument() {
            int[] a = new int[]{8};
            Assertions.assertEquals(1, Task499.solve(a, 8));
        }

        @Test
        public void shouldSolveWhenAllElementsEqual() {
            int[] a = new int[]{8, 8, 8, 8};
            Assertions.assertEquals(4, Task499.solve(a, 8));
        }

        @Test
        public void souldSolveWhenNo() {
            int[] a = new int[]{1, 2, 5, 3, 2, 4, 2, 6};
            Assertions.assertEquals(0, Task499.solve(a, 0));
        }

        @Test
        public void shouldSolveWhenSumLessThanAnArgument() {
            int[] a = new int[]{1, 2, 5, 3, 2, 4, 2, 6};
            Assertions.assertEquals(0, Task499.solve(a, 100));
        }

        @Test
        public void shouldSolveWhenEmpty() {
            int[] a = new int[]{};
            Assertions.assertEquals(0, Task499.solve(a, 8));
        }
    }
}