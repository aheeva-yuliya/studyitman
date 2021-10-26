package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTests {

    @Test
    public void addFirst() {
        LinkedList list = new LinkedList();
        list.addFirst(7);
        Assertions.assertEquals(7,list.getFirst());
        list.addFirst(55);
        Assertions.assertEquals(55,list.getFirst());
        list.addFirst(51);
        Assertions.assertEquals(51,list.getFirst());
    }

    @Test
    public void getFirst() {
        LinkedList list = new LinkedList();
        list.addFirst(7);
        Assertions.assertEquals(7,list.getFirst());
    }

    @Test
    public void removeFirstIfSome() {
        LinkedList list = LinkedList.of(51, 55, 7);
        Assertions.assertEquals(51,list.removeFirst());
        Assertions.assertEquals(55,list.getFirst());
        Assertions.assertEquals("[55, 7]", list.toString());
    }

    @Test
    public void removeFirstIfOne() {
        LinkedList list = new LinkedList();
        list.addFirst(7);
        Assertions.assertEquals(7,list.removeFirst());
        Assertions.assertEquals("[]", list.toString());
    }

    @Test
    public void testToStringIfNotEmpty() {
        LinkedList list = LinkedList.of(51, 55, 7);
        String expected = "[51, 55, 7]";
        String actual = list.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testToStringIfOneNode() {
        LinkedList list = new LinkedList();
        list.addFirst(7);
        String expected = "[7]";
        String actual = list.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testToStringIfEmpty() {
        LinkedList list = new LinkedList();
        String expected = "[]";
        String actual = list.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void addLastIfNotEmpty() {
        LinkedList list = new LinkedList();
        list.addLast(7);
        list.addFirst(55);
        list.addLast(51);
        list.addLast(100);
        String expected = "[55, 7, 51, 100]";
        String actual = list.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void addLastIfEmpty() {
        LinkedList list = new LinkedList();
        list.addLast(100);
        String expected = "[100]";
        String actual = list.toString();
        Assertions.assertEquals(expected,actual);
    }


    @Test
    public void getLast() {
        LinkedList list = LinkedList.of(7, 55, 51, 100);
        Assertions.assertEquals(100,list.getLast());
        String expected = "[7, 55, 51, 100]";
        String actual = list.toString();
        Assertions.assertEquals(expected,actual);
    }


    @Test
    public void removeLastIfSome() {
        LinkedList list = LinkedList.of(51, 55, 7);
        Assertions.assertEquals(7,list.removeLast());
        Assertions.assertEquals("[51, 55]",list.toString());
    }

    @Test
    public void removeLastIfTwo() {
        LinkedList list = LinkedList.of(55, 7);
        Assertions.assertEquals(7,list.removeLast());
        Assertions.assertEquals("[55]",list.toString());
    }

    @Test
    public void removeLastIfOne() {
        LinkedList list = LinkedList.of(7);
        Assertions.assertEquals(7,list.removeLast());
        Assertions.assertEquals("[]",list.toString());
    }

    @Test
    public void linkedListThatCopyOfSome() {
        LinkedList list = LinkedList.of(11, 12, 13);
        LinkedList copy = new LinkedList(list);
        Assertions.assertEquals("[11, 12, 13]",copy.toString());
    }

    @Test
    public void linkedListThatCopyOfOne() {
        LinkedList list = LinkedList.of(11);
        LinkedList copy = new LinkedList(list);
        Assertions.assertEquals("[11]",copy.toString());
    }

    @Test
    public void linkedListThatCopyIfEmpty() {
        LinkedList list = new LinkedList();
        LinkedList copy = new LinkedList(list);
        Assertions.assertEquals("[]",copy.toString());
    }

    @Test
    public void toArraySomeElements() {
        LinkedList list = LinkedList.of(11, 12, 13);
        int[] expected = new int[] {11, 12, 13};
        int[] actual = list.toArray();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void toArrayIfEmpty() {
        LinkedList list = new LinkedList();
        int[] expected = new int[] {};
        int[] actual = list.toArray();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void ofSomeElement() {
        LinkedList list = LinkedList.of(67, 78, 94, 100, 33);
        String expected = "[67, 78, 94, 100, 33]";
        String actual = list.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void ofIfEmpty() {
        LinkedList list = LinkedList.of();
        String expected = "[]";
        String actual = list.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void set() {
        LinkedList list = LinkedList.of(12, 13, 14, 15, 16);
        list.set(2,100);
        String expected = "[12, 13, 100, 15, 16]";
        String actual = list.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void get() {
        LinkedList list = LinkedList.of(12, 13, 14, 15, 16);
        Assertions.assertEquals(14,list.get(2));
    }

    @Test
    public void removeFromTheMiddle() {
        LinkedList list = LinkedList.of(12, 13, 14, 15, 16);
        Assertions.assertEquals(14,list.remove(2));
        Assertions.assertEquals("[12, 13, 15, 16]",list.toString());
    }

    @Test
    public void removeFromTheFirstIndex() {
        LinkedList list = LinkedList.of(12, 13, 14, 15, 16);
        Assertions.assertEquals(12,list.remove(0));
        Assertions.assertEquals("[13, 14, 15, 16]",list.toString());
    }

    @Test
    public void removeFromTheLastIndex() {
        LinkedList list = LinkedList.of(12, 13, 14, 15, 16);
        Assertions.assertEquals(16,list.remove(4));
        Assertions.assertEquals("[12, 13, 14, 15]",list.toString());
    }

    @Test
    public void sizeIfSome() {
        LinkedList list = LinkedList.of(12, 13, 14, 15, 16);
        Assertions.assertEquals(5,list.size());
    }

    @Test
    public void sizeIfEmpty() {
        LinkedList list = new LinkedList();
        Assertions.assertEquals(0,list.size());
    }

    @Test
    public void testEqualsIfYesSameLength() {
        LinkedList a = LinkedList.of(12, 13, 14, 15, 16);
        LinkedList b = LinkedList.of(12, 13, 14, 15, 16);
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsIfNoSameLength() {
        LinkedList a = LinkedList.of(12, 13, 14, 15, 16);
        LinkedList b = LinkedList.of(12, 13, 100, 15, 16);
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsIfDifferentLength() {
        LinkedList a = LinkedList.of(12, 13, 14, 15, 16);
        LinkedList b = LinkedList.of(12, 13, 14, 15, 16, 17);
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsIfThisEmpty() {
        LinkedList a = new LinkedList();
        LinkedList b = LinkedList.of(12, 13, 100, 15, 16);
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsIfThatEmpty() {
        LinkedList a = new LinkedList();
        LinkedList b = LinkedList.of(12, 13, 100, 15, 16);
        Assertions.assertFalse(b.equals(a));
    }

    @Test
    public void testEqualsIfYesBothEmpty() {
        LinkedList a = new LinkedList();
        LinkedList b = new LinkedList();
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsIfNull() {
        LinkedList a = new LinkedList();
        LinkedList b = null;
        Assertions.assertFalse(a.equals(b));
    }
}