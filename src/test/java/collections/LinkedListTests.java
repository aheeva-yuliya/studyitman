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
    public void removeFirst() {
        LinkedList list = new LinkedList();
        list.addFirst(7);
        list.addFirst(55);
        list.addFirst(51);
        Assertions.assertEquals(51,list.removeFirst());
        Assertions.assertEquals(55,list.getFirst());
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
    public void testToStringIfEmpty() {
        LinkedList list = new LinkedList();
        String expected = "[]";
        String actual = list.toString();
        Assertions.assertEquals(expected,actual);
    }
}