package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task495Tests {

    @Test
    public void solveByBinarySearch() {
        int[] a = new int[] {-1, 1, 1, 2, 2, 3, 5, 5, 5, 10};
        Assertions.assertEquals(6, Task495.solveByBinarySearch(a, 4));
    }

}