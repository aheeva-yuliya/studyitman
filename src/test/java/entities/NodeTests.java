package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NodeTests {

    @Test
    public void getElement() {
        Node last = new Node(37, null, null);
        Node second = new Node(99, last, null);
        last.setPrev(second);
        second.setNext(last);
        Node first = new Node(12, second, null);
        second.setPrev(first);
        Assertions.assertEquals(12, first.getElement());
        Assertions.assertEquals(99, second.getElement());
        Assertions.assertEquals(37, last.getElement());
    }

    @Test
    public void getNext() {
        Node last = new Node(37, null, null);
        Node second = new Node(99, last, null);
        Node first = new Node(12, second, null);
        second.setPrev(first);
        last.setPrev(second);
        Assertions.assertSame(second, first.getNext());
        Assertions.assertSame(last, second.getNext());
        Assertions.assertNull(last.getNext());
    }

    @Test
    public void setNext() {
        Node last = new Node(37, null, null);
        Node second = new Node(99, last, null);
        Node first = new Node(12, second, null);
        second.setPrev(first);
        last.setPrev(second);
        Assertions.assertSame(second, first.getNext());
        Assertions.assertSame(last, second.getNext());
        Assertions.assertNull(last.getNext());
    }

    @Test
    public void getPrev() {
        Node last = new Node(37, null, null);
        Node second = new Node(99, last, null);
        last.setPrev(second);
        Node first = new Node(12, second, null);
        second.setPrev(first);
        Assertions.assertSame(first, second.getPrev());
        Assertions.assertSame(second, last.getPrev());
        Assertions.assertNull(first.getPrev());
    }

    @Test
    public void setPrev() {
        Node last = new Node(37, null, null);
        Node first = new Node(12, last, null);
        last.setPrev(first);
        Assertions.assertSame(first, last.getPrev());
    }
}