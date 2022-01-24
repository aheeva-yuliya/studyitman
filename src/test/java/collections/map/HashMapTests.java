package collections.map;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class HashMapTests {
    @Test
    void shouldReturnSizeWhen() {
        Circle circle = new Circle(5);
        HashMap<Integer, Shape> map = new HashMap<>();
        map.put(10, circle);
        Assertions.assertEquals(1, map.size());
    }

    @Test
    void shouldIsEmptyWhen() {
        Circle circle = new Circle(5);
        HashMap<Integer, Shape> map = new HashMap<>();
        Assertions.assertTrue(map.isEmpty());
        map.put(10, circle);
        Assertions.assertFalse(map.isEmpty());
    }

    @Nested
    public class PutTests {
        @Test
        void shouldPutWhenEmpty() {
            Circle circle = new Circle(5);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(10, circle);
        }

        @Test
        void shouldPutWhenContainsSome() {
            Circle circle = new Circle(5);
            Rectangle rectangle =  new Rectangle(3, 4);
            Square square = new Square(3);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(10, circle);
            map.put(16, rectangle);
            map.put(1, square);
        }

        @Test
        void shouldPutWhenSameKey() {
            Circle circle = new Circle(5);
            Rectangle rectangle =  new Rectangle(3, 4);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(10, circle);
            map.put(10, rectangle);
        }
    }

    @Test
    void putAll() {
    }

    @Test
    void shouldContainsKeyWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        HashMap<Integer, Shape> map = new HashMap<>();
        map.put(10, circle);
        map.put(16, rectangle);
        Assertions.assertTrue(map.containsKey(16));
        Assertions.assertFalse(map.containsKey(21));
    }

    @Test
    void shouldContainsValueWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        HashMap<Integer, Shape> map = new HashMap<>();
        map.put(10, circle);
        map.put(16, rectangle);
        Assertions.assertTrue(map.containsValue(rectangle));
        Assertions.assertFalse(map.containsValue(10));
    }

    @Nested
    public class GetTests {
        @Test
        void shouldGetWhenDifferentHash() {
            Circle circle = new Circle(5);
            Rectangle rectangle = new Rectangle(3, 4);
            Square square = new Square(3);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(10, circle);
            map.put(16, rectangle);
            map.put(1, square);
            Assertions.assertEquals(rectangle, map.get(16));
        }

        @Test
        void shouldGetWhenSameHash() {
            Circle circle = new Circle(5);
            Rectangle rectangle = new Rectangle(3, 4);
            Square square = new Square(3);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(10, circle);
            map.put(16, rectangle);
            map.put(32, square);
            Assertions.assertEquals(rectangle, map.get(16));
        }
    }

    @Nested
    public class RemoveTests {
        @Test
        void shouldRemoveWhenDifferentHash() {
            Circle circle = new Circle(5);
            Rectangle rectangle = new Rectangle(3, 4);
            Square square = new Square(3);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(10, circle);
            map.put(16, rectangle);
            map.put(1, square);
            Assertions.assertEquals(rectangle, map.remove(16));
        }

        @Test
        void shouldRemoveFromTheMiddleWhenSameHash() {
            Circle circle = new Circle(5);
            Rectangle rectangle = new Rectangle(3, 4);
            Square square = new Square(3);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(64, circle);
            map.put(16, rectangle);
            map.put(32, square);
            Assertions.assertEquals(rectangle, map.remove(16));
        }

        @Test
        void shouldRemoveFromTheBeginningWhenSameHash() {
            Circle circle = new Circle(5);
            Rectangle rectangle = new Rectangle(3, 4);
            Square square = new Square(3);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(64, circle);
            map.put(16, rectangle);
            map.put(32, square);
            Assertions.assertEquals(square, map.remove(32));
        }

        @Test
        void shouldRemoveFromTheEndWhenSameHash() {
            Circle circle = new Circle(5);
            Rectangle rectangle = new Rectangle(3, 4);
            Square square = new Square(3);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(64, circle);
            map.put(16, rectangle);
            map.put(32, square);
            Assertions.assertEquals(circle, map.remove(64));
        }

        @Test
        void shouldReturnNullWhenNoKey() {
            Circle circle = new Circle(5);
            Rectangle rectangle = new Rectangle(3, 4);
            Square square = new Square(3);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(64, circle);
            map.put(16, rectangle);
            map.put(32, square);
            Assertions.assertNull(map.remove(15));
        }
    }

    @Test
    void shouldClearWhen() {
        HashMap<Integer, Shape> map = new HashMap<>();
        map.put(64, new Circle(5));
        map.clear();
        Assertions.assertTrue(map.isEmpty());
    }

    @Test
    void toArray() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        HashMap<Integer, Shape> map = new HashMap<>();
        map.put(10, circle);
        map.put(16, rectangle);
        map.put(1, square);
        Object[] actual = map.toArray();
    }

    @Test
    void iterator() {
    }
}