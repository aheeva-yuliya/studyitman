package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayListTests {

    @Test
    public void setTwoElements() {
        ArrayList a = new ArrayList(5);
        a.add(5);
        a.add(5);
        a.add(5);
        a.set(0, 10);
        a.set(2, 10);
        int[] expected = new int[] {10, 5, 10};
        int[] actual = a.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAnElementFromTheFirstIndex() {
        ArrayList a = new ArrayList(3);
        a.add(5);
        a.add(10);
        a.add(20);
        Assertions.assertEquals(10, a.get(1));
    }

    @Test
    public void sizeZero() {
        ArrayList a = new ArrayList(5);
        Assertions.assertEquals(0, a.size());
    }

    @Test
    public void sizeTwo() {
        ArrayList a = new ArrayList(5);
        a.add(5);
        a.add(10);
        Assertions.assertEquals(2, a.size());
    }

    @Test
    public void addThenLengthIsOne() {
        ArrayList a = new ArrayList(1);
        a.add(10);
        a.add(20);
        a.add(30);
        int[] expected = new int[] {10, 20, 30};
        Assertions.assertArrayEquals(expected,a.toArray());
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
        Assertions.assertArrayEquals(expected, a.toArray());
    }

    @Test
    public void removeFromTheFirstIndex() {
        ArrayList a = new ArrayList(4);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        int b = a.remove(1);
        int[] expected = new int[] {1, 3, 4};
        Assertions.assertArrayEquals(expected, a.toArray());
        Assertions.assertEquals(2, b);
    }

    @Test
    public void removeFromLastIndex() {
        ArrayList a = new ArrayList(4);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        int b = a.remove(3);
        int[] expected = new int[] {1, 2, 3};
        Assertions.assertArrayEquals(expected, a.toArray());
        Assertions.assertEquals(4, b);
    }

    @Test
    public void removeFromTheFirstAndZeroIndexes() {
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
        Assertions.assertArrayEquals(expected, a.toArray());
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

    @Test
    public void testToStringFromStringBuilder() {
        ArrayList a = ArrayList.of(8, 9, 7, 6, 2, 3, 5, 4);
        Assertions.assertEquals("[8, 9, 7, 6, 2, 3, 5, 4]", a.toString());
    }

    @Test
    public void testToStringFromStringBuilderWithEmpyArray() {
        ArrayList a = ArrayList.of();
        Assertions.assertEquals("[]", a.toString());
    }

    @Test
    public void testToStringFromStringBuilderWithArrayOfOneElement() {
        ArrayList a = ArrayList.of(1);
        Assertions.assertEquals("[1]", a.toString());
    }

    @Test
    public void sortMergeNormalCase() {
        ArrayList a = ArrayList.of(7, 18, 9, -5, 8, 9, 90, 0, 54, 78, 99, 75, 89, 82, -76);
        a.add(7);
        a.add(22);
        a.sort();
        int[] expected = new int[] {-76, -5, 0, 7, 7, 8, 9, 9, 18, 22, 54, 75, 78, 82, 89, 90, 99};
        Assertions.assertArrayEquals(expected, a.toArray());
    }
}