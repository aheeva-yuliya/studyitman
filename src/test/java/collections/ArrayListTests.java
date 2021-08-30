package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTests {

    @Test
    public void setTwoElements() {
        ArrayList a = new ArrayList(5);
        a.set(3, 10);
        a.set(0, 10);
        int[] expected = new int[] {10, 0, 0, 10, 0};
        int[] actual = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            actual[i] = a.get(i);
        }
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllElements() {
        ArrayList a = new ArrayList(3);
        a.set(0, 1);
        a.set(1, 2);
        a.set(2, 3);
        int[] expected = new int[] {1, 2, 3};
        int[] actual = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            actual[i] = a.get(i);
        }
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void size() {
        ArrayList a = new ArrayList(10);
        Assertions.assertEquals(10, a.size());
    }
}