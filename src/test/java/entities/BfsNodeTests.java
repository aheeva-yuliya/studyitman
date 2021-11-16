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
    }

    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWithValuesWhenNotNull() {
            BfsNode node = new BfsNode(10, 20);
            String expected = "BfsNode{vertex=10, distance=20}";
            String actual = node.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenEquals() {
            BfsNode first = new BfsNode(10, 20);
            BfsNode second = new BfsNode(10, 20);
            Assertions.assertTrue(first.equals(second));
        }

        @Test
        public void shouldReturnFalseWhenNotEqual() {
            BfsNode first = new BfsNode(10, 20);
            BfsNode second = new BfsNode(20, 20);
            Assertions.assertFalse(first.equals(second));
        }

        @Test
        public void shouldReturnFalseWhenSecondNull() {
            BfsNode first = new BfsNode(10, 20);
            Assertions.assertFalse(first.equals(null));
        }
    }
}