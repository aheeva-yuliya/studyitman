package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NodeTests {
    @Nested
    public class Get {
        @Test
        public void shouldGetElementsWhenTryGetFromDifferentLinks() {
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
        public void shouldGetNextLinkWhenHas() {
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
        public void shouldGetPreviousLinkWhenHas() {
            Node last = new Node(37, null, null);
            Node second = new Node(99, last, null);
            last.setPrev(second);
            Node first = new Node(12, second, null);
            second.setPrev(first);
            Assertions.assertSame(first, second.getPrev());
            Assertions.assertSame(second, last.getPrev());
            Assertions.assertNull(first.getPrev());
        }
    }

    @Nested
    public class Set {
        @Test
        public void shouldSetNextLinkWhenHas() {
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
        public void shouldSetPreviousLinkWhenHas() {
            Node last = new Node(37, null, null);
            Node first = new Node(12, last, null);
            last.setPrev(first);
            Assertions.assertSame(first, last.getPrev());
        }
    }
}