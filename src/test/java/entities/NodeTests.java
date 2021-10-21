package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NodeTests {

    @Test
    public void getElement() {
        Node last = new Node(37, null);
        Node second = new Node(99, last);
        Node first = new Node(12, second);
        Assertions.assertEquals(12, first.getElement());
        Assertions.assertEquals(99, second.getElement());
        Assertions.assertEquals(37, last.getElement());
    }

    @Test
    public void getNext() {
        Node last = new Node(37, null);
        Node second = new Node(99, last);
        Node first = new Node(12, second);
        Assertions.assertSame(second, first.getNext());
        Assertions.assertSame(last, second.getNext());
        Assertions.assertNull(last.getNext());
    }

    @Test
    public void setNext() {
        Node last = new Node(37, null);
        Node second = new Node(99, last);
        Node first = new Node(12, second);
        last.setNext(first);
        first.setNext(null);
        Assertions.assertSame(last, second.getNext());
        Assertions.assertSame(first, last.getNext());
        Assertions.assertNull(first.getNext());
    }
}