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
        a.set(0, 3);
        int[] expected = new int[] {3, 2, 3};
        int[] actual = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            actual[i] = a.get(i);
        }
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void size() {
        ArrayList a = new ArrayList(5);
        Assertions.assertEquals(5, a.size());
    }

    @Test
    public void addThenLengthIsOne() {
        ArrayList a = new ArrayList(1);
        a.add(10);
        a.add(20);
        a.add(30);
        int[] expected = new int[] {10, 20, 30};
        int[] actual = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            actual[i] = a.get(i);
        }
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void addCapacityMultipliesByTwo() {
        ArrayList a = new ArrayList(1);
        a.add(2);
        a.add(7);
        a.add(1);
        a.add(3);
        a.add(8);
        a.add(4);
        int[] expected = new int[] {2, 7, 1, 3, 8, 4};
        int[] actual = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            actual[i] = a.get(i);
        }
        Assertions.assertArrayEquals(expected, actual);
    }
}