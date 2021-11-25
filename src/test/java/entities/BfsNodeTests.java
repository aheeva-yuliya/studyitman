package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BfsNodeTests {
    @Nested
    public class Get {
        @Test
        public void shouldGetVertexValueWhenHas() {
            BfsNode node = new BfsNode(10, 20);
            Assertions.assertEquals(10, node.getVertex());
        }

        @Test
        public void shouldGetDistanceValueWhenHas() {
            BfsNode node = new BfsNode(10, 20);
            Assertions.assertEquals(20, node.getDistance());
        }

        @Test
        public void shouldGetPrevValueWhenHas() {
            BfsNode prev = new BfsNode(1, 1, null);
            BfsNode node = new BfsNode(10, 20, prev);
            Assertions.assertEquals(prev, node.getPrev());
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWithValuesWhenPrevNull() {
            BfsNode node = new BfsNode(10, 20, null);
            String expected = "BfsNode{vertex=10, distance=20, prev=null}";
            String actual = node.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnStringWithValuesWhenPrevNotNull() {
            BfsNode node = new BfsNode(10, 20, new BfsNode(20, 30, null));
            String expected = "BfsNode{vertex=10, distance=20, prev=BfsNode{vertex=20, distance=30, prev=null}}";
            String actual = node.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenEqualsAndPrevNull() {
            BfsNode first = new BfsNode(10, 20, null);
            BfsNode second = new BfsNode(10, 20, null);
            Assertions.assertTrue(first.equals(second));
        }

        @Test
        public void shouldReturnTrueWhenEqualsAndPrevNotNull() {
            BfsNode first = new BfsNode(10, 20, new BfsNode(5, 5, null));
            BfsNode second = new BfsNode(10, 20, new BfsNode(5, 5, null));
            Assertions.assertTrue(first.equals(second));
        }

        @Test
        public void shouldReturnFalseWhenNotEqual() {
            BfsNode first = new BfsNode(10, 20, new BfsNode(5, 10, null));
            BfsNode second = new BfsNode(10, 20, new BfsNode(10, 5, null));
            Assertions.assertFalse(first.equals(second));
        }

        @Test
        public void shouldReturnFalseWhenThatNull() {
            BfsNode first = new BfsNode(10, 20, null);
            Assertions.assertFalse(first.equals(null));
        }
    }
}