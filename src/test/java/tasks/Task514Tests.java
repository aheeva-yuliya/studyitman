package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task514Tests {
    @Nested
    public class Solve {
        @Test
        public void shouldSolveWhenNormalCase() {
            int[] books = new int[]{1, 2, 3};
            int[] queue = new int[]{-1, 5, 4, -1, -1};
            Assertions.assertEquals(2, Task514.solve(books, queue));
        }

        @Test
        public void shouldSolveWhenBooksLengthIsOne() {
            int[] books = new int[]{1};
            int[] queue = new int[]{-1, 5, 4, -1};
            Assertions.assertEquals(5, Task514.solve(books, queue));
        }

        @Test
        public void shouldSolveWhenQueueIsEmpty() {
            int[] books = new int[]{1, 2, 3};
            int[] queue = new int[]{};
            Assertions.assertEquals(3, Task514.solve(books, queue));
        }
    }
}