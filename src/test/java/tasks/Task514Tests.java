package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task514Tests {

    @Test
    public void solveNormalCase() {
        int[] books = new int[] {1, 2, 3};
        int[] queue = new int[] {-1, 5, 4, -1, -1};
        Assertions.assertEquals(2, Task514.solve(books,queue));
    }

    @Test
    public void solveIfBooksLengthIsOne() {
        int[] books = new int[] {1};
        int[] queue = new int[] {-1, 5, 4, -1};
        Assertions.assertEquals(5, Task514.solve(books,queue));
    }

    @Test
    public void solveIfQueueIsEmpty() {
        int[] books = new int[] {1, 2, 3};
        int[] queue = new int[] {};
        Assertions.assertEquals(3, Task514.solve(books,queue));
    }
}