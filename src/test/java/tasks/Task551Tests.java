package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task551Tests {
    @Nested
    public class Build {
        @Test
        public void shouldBuildLinkedListWhenSingle() {
            Task551.Node node = Task551.buildLinkedList();
            Assertions.assertEquals(12, node.getElement());
            Assertions.assertEquals(99, node.getNext().getElement());
            Assertions.assertEquals(37, node.getNext().getNext().getElement());
        }

        @Test
        public void shouldBuildLinkedListWhenDouble() {
            Task551.Node node = Task551.buildLinkedList();
            Assertions.assertEquals(12, node.getNext().getPrev().getElement());
            Assertions.assertEquals(99, node.getNext().getNext().getPrev().getNext().getPrev().getElement());
        }
    }

    @Nested
    public class NodeTests {
        @Nested
        public class Get {
            @Test
            public void shouldGetElementsWhenTryGetFromDifferentLinks() {
                Task551.Node last = new Task551.Node(37, null, null);
                Task551.Node second = new Task551.Node(99, last, null);
                last.setPrev(second);
                second.setNext(last);
                Task551.Node first = new Task551.Node(12, second, null);
                second.setPrev(first);
                Assertions.assertEquals(12, first.getElement());
                Assertions.assertEquals(99, second.getElement());
                Assertions.assertEquals(37, last.getElement());
            }

            @Test
            public void shouldGetNextLinkWhenHas() {
                Task551.Node last = new Task551.Node(37, null, null);
                Task551.Node second = new Task551.Node(99, last, null);
                Task551.Node first = new Task551.Node(12, second, null);
                second.setPrev(first);
                last.setPrev(second);
                Assertions.assertSame(second, first.getNext());
                Assertions.assertSame(last, second.getNext());
                Assertions.assertNull(last.getNext());
            }

            @Test
            public void shouldGetPreviousLinkWhenHas() {
                Task551.Node last = new Task551.Node(37, null, null);
                Task551.Node second = new Task551.Node(99, last, null);
                last.setPrev(second);
                Task551.Node first = new Task551.Node(12, second, null);
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
                Task551.Node last = new Task551.Node(37, null, null);
                Task551.Node second = new Task551.Node(99, last, null);
                Task551.Node first = new Task551.Node(12, second, null);
                second.setPrev(first);
                last.setPrev(second);
                Assertions.assertSame(second, first.getNext());
                Assertions.assertSame(last, second.getNext());
                Assertions.assertNull(last.getNext());
            }

            @Test
            public void shouldSetPreviousLinkWhenHas() {
                Task551.Node last = new Task551.Node(37, null, null);
                Task551.Node first = new Task551.Node(12, last, null);
                last.setPrev(first);
                Assertions.assertSame(first, last.getPrev());
            }
        }
    }
}