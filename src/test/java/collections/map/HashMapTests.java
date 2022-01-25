package collections.map;

import entities.shapes.Circle;
import entities.shapes.Rectangle;
import entities.shapes.Shape;
import entities.shapes.Square;
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
    public class EqualsTests {
        @Test
        void shouldReturnTrueWhenEquals() {
            Circle circle = new Circle(5);
            Rectangle rectangle = new Rectangle(3, 4);
            Square square = new Square(3);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(null, circle);
            map.put(7, square);
            map.put(10, rectangle);
            HashMap<Integer, Shape> that = new HashMap<>(map);
            Assertions.assertEquals(map, that);
        }

        @Test
        void shouldReturnFalseWhenNotEquals() {
            Circle circle = new Circle(5);
            Rectangle rectangle = new Rectangle(3, 4);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(null, circle);
            HashMap<Integer, Shape> that = new HashMap<>();
            that.put(null, rectangle);
            Assertions.assertNotEquals(map, that);
        }
    }

    @Test
    void shouldTestHashCodeWhen() {
        Circle circle = new Circle(5);
        Square square = new Square(3);
        HashMap<Integer, Shape> map = new HashMap<>();
        map.put(null, circle);
        map.put(7, square);
        Assertions.assertEquals(225, map.hashCode());
    }

    @Test
    void shouldTestToStringWhen() {
        Circle circle = new Circle(5);
        Square square = new Square(3);
        HashMap<Integer, Shape> map = new HashMap<>();
        map.put(null, circle);
        map.put(7, square);
        String expected = "[Entry{key=null, value=Circle{radius=5}}, Entry{key=7, value=Square{side=3}}]";
        String actual = map.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Nested
    public class PutTests {
        @Test
        void shouldPutWhenEmpty() {
            Circle circle = new Circle(5);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(10, circle);
            String expected = "[Entry{key=10, value=Circle{radius=5}}]";
            String actual = map.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldPutWhenContainsSome() {
            Circle circle = new Circle(5);
            Square square = new Square(3);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(10, circle);
            map.put(1, square);
            String expected = "[Entry{key=1, value=Square{side=3}}, Entry{key=10, value=Circle{radius=5}}]";
            String actual = map.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldPutWhenSameKey() {
            Circle circle = new Circle(5);
            Rectangle rectangle =  new Rectangle(3, 4);
            HashMap<Integer, Shape> map = new HashMap<>();
            map.put(10, circle);
            map.put(10, rectangle);
            String expected = "[Entry{key=10, value=Rectangle{width=3, height=4}}]";
            String actual = map.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    /////////
    @Nested
    public class PutAllTests {
        @Test
        void shouldPutAllWhenThatNotEmpty() {
            HashMap<Number, Number> map = new HashMap<>(3);
            map.put(61, 61);
            map.put(38., 38.);
            map.put(90L, 90L);
            HashMap<Integer, Integer> that = new HashMap<>(2);
            that.put(10, 10);
            that.put(83, 83);
            map.putAll(that);
        }

        @Test
        void shouldThrowExceptionWhenThatIsNull() {
            HashMap<Number, Number> map = new HashMap<>();
            map.put(61, 61);
            IllegalArgumentException exception =
                    Assertions.assertThrows(IllegalArgumentException.class, () -> map.putAll(null));
            Assertions.assertEquals("Map is null.", exception.getMessage());
        }
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

    ///////////
    @Test
    void shouldToArrayWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        HashMap<Integer, Shape> map = new HashMap<>();
        map.put(10, circle);
        map.put(16, rectangle);
        map.put(1, square);
        map.toArray();
    }
}