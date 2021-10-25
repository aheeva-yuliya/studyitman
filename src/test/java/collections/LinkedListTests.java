package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        LinkedList list = new LinkedList();
        list.addFirst(7);
        list.addFirst(55);
        list.addFirst(51);
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
        LinkedList list = new LinkedList();
        list.addFirst(7);
        list.addFirst(55);
        list.addFirst(51);
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
        LinkedList list = new LinkedList();
        list.addFirst(7);
        list.addLast(55);
        list.addLast(51);
        list.addLast(100);
        Assertions.assertEquals(100,list.getLast());
        String expected = "[7, 55, 51, 100]";
        String actual = list.toString();
        Assertions.assertEquals(expected,actual);
    }


    @Test
    public void removeLastIfSome() {
        LinkedList list = new LinkedList();
        list.addFirst(7);
        list.addFirst(55);
        list.addFirst(51);
        Assertions.assertEquals(7,list.removeLast());
        Assertions.assertEquals("[51, 55]",list.toString());
    }

    @Test
    public void removeLastIfTwo() {
        LinkedList list = new LinkedList();
        list.addFirst(7);
        list.addFirst(55);
        Assertions.assertEquals(7,list.removeLast());
        Assertions.assertEquals("[55]",list.toString());
    }

    @Test
    public void removeLastIfOne() {
        LinkedList list = new LinkedList();
        list.addFirst(7);
        Assertions.assertEquals(7,list.removeLast());
        Assertions.assertEquals("[]",list.toString());
    }
}