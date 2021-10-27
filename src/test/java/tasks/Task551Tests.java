package tasks;

import entities.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task551Tests {
    @Nested
    public class Build {
        @Test
        public void shouldBuildLinkedListWhenSingle() {
            Node node = Task551.buildLinkedList();
            Assertions.assertEquals(12, node.getElement());
            Assertions.assertEquals(99, node.getNext().getElement());
            Assertions.assertEquals(37, node.getNext().getNext().getElement());
        }

        @Test
        public void shouldBuildLinkedListWhenDouble() {
            Node node = Task551.buildLinkedList();
            Assertions.assertEquals(12, node.getNext().getPrev().getElement());
            Assertions.assertEquals(99, node.getNext().getNext().getPrev().getNext().getPrev().getElement());
        }
    }
}