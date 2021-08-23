package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task406Tests {

    @Test
    public void findSecondMaxAtMinIndex() {
        int[] a = new int[] {10, 3, 7, 1, 20, 4, 2, 7, 5};
        int actual = Task406.findSecondMax(a);
        Assertions.assertEquals(10, actual);
    }

    @Test
    public void findSecondMaxWhileSome() {
        int[] a = new int[] {1, 4, 10, 8, 5, 10, 20, 6, 9};
        int actual = Task406.findSecondMax(a);
        Assertions.assertEquals(10, actual);
    }

    @Test
    public void findSecondMaxofTwo() {
        int[] a = new int[] {10, 10};
        int actual = Task406.findSecondMax(a);
        Assertions.assertEquals(10, actual);
    }
}
