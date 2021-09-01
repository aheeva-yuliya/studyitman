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
        int[] actual = new int[5];
        for (int i = 0; i < 5; i++) {
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
        int[] actual = new int[3];
        for (int i = 0; i < 3; i++) {
            actual[i] = a.get(i);
        }
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void size() {
        ArrayList a = new ArrayList(5);
        Assertions.assertEquals(0, a.size());
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

    @Test
    public void toArraySetAllElements() {
        ArrayList a = new ArrayList(5);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        int[] expected = new int[] {1, 2, 3, 4, 5};
        int[] actual = a.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void toArrayWhenCapacityChanges() {
        ArrayList a = new ArrayList(1);
        a.add(10);
        a.add(20);
        a.add(30);
        a.add(40);
        a.add(50);
        int[] expected = new int[] {10, 20, 30, 40, 50};
        int[] actual = a.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeOneElement() {
        ArrayList a = new ArrayList(4);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        int b = a.remove(1);
        int[] expected = new int[] {1, 3, 4};
        int[] actual = a.toArray();
        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(2, b);
    }

    @Test
    public void removeTwoElements() {
        ArrayList a = new ArrayList(4);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        int b = a.remove(1);
        int[] expected = new int[] {1, 3, 4};
        int[] actual = a.toArray();
        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(2, b);
        int c = a.remove(0);
        expected = new int[] {3, 4};
        actual = a.toArray();
        Assertions.assertEquals(1, c);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testEqualsIfTrue() {
        ArrayList a = new ArrayList(3);
        a.add(1);
        a.add(2);
        a.add(3);
        ArrayList b = new ArrayList(3);
        b.add(3);
        b.add(2);
        b.add(3);
        b.set(0, 1);
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsIfFalse() {
        ArrayList a = new ArrayList(3);
        a.add(1);
        a.add(2);
        a.add(3);
        ArrayList b = new ArrayList(3);
        b.add(3);
        b.add(2);
        b.add(3);
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsDifferentCapacity() {
        ArrayList a = new ArrayList(1);
        ArrayList b = new ArrayList(2);
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsIfThatIsNull() {
        ArrayList a = new ArrayList(3);
        a.add(1);
        a.add(2);
        a.add(3);
        ArrayList b = null;
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void sortFiveElements() {
        ArrayList a = new ArrayList(3);
        a.add(8);
        a.add(3);
        a.add(6);
        a.add(1);
        a.add(2);
        a.sort();
        int[] expected = new int[] {1, 2, 3, 6, 8};
        int[] actual = a.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortElementsIfSame() {
        ArrayList a = new ArrayList(3);
        a.add(8);
        a.add(8);
        a.add(8);
        a.sort();
        int[] expected = new int[] {8, 8, 8};
        int[] actual = a.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void createAnObject() {
        ArrayList first = new ArrayList();
        first.set(0, 10);
        first.set(1, 20);
        ArrayList second = new ArrayList(first);
        Assertions.assertTrue(first.equals(second));
    }

    @Test
    public void createAnObjectWithConstructor() {
        ArrayList first = new ArrayList();
        first.add(20);
        first.add(30);
        first.add(40);
        first.add(50);
        ArrayList second = new ArrayList(first);
        second.set(0, -10);
        Assertions.assertFalse(first.equals(second));
    }

    @Test
    public void ofCreateOfElements() {
        int[] a = new int[] {-1, 1, 5};
        ArrayList actual = ArrayList.of(a);
        a[1] = 0;
        int[] expected = new int[] {-1, 1, 5};
        Assertions.assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void ofCreateOfNil() {
        ArrayList a = ArrayList.of();
        int [] expected = new int[] {};
        int [] actual = a.toArray();
        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(0, a.size());
    }

    @Test
    public void ofCreateOfThreeElements() {
        ArrayList a = ArrayList.of(-1, 1, 5);
        int [] expected = new int[] {-1, 1, 5};
        int [] actual = a.toArray();
        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(3, a.size());
    }

    @Test
    public void ofCreateOfAndEqualsCheck() {
        ArrayList a  = ArrayList.of(-1, 1, 5);
        ArrayList b = ArrayList.of(-1, 1, 5);
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void ofCreateOfAndEqualsCheckFromAdd() {
        ArrayList a  = ArrayList.of(-1, 1, 5);
        ArrayList b = new ArrayList(5);
        b.add(-1);
        b.add(1);
        b.add(5);
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void ofCreateOfAndEqualsFromAdd() {
        ArrayList a  = ArrayList.of(-1, 1, 5);
        ArrayList b = new ArrayList(5);
        b.add(-1);
        b.add(1);
        b.add(5);
        Assertions.assertTrue(b.equals(a));
    }
}