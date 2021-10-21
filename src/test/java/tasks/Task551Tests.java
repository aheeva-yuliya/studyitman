package tasks;

import entities.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task551Tests {

    @Test
    public void buildLinkedList() {
        Node node = Task551.buildLinkedList();
        Assertions.assertEquals(12,node.getElement());
        Assertions.assertEquals(99,node.getNext().getElement());
        Assertions.assertEquals(37,node.getNext().getNext().getElement());
    }
}