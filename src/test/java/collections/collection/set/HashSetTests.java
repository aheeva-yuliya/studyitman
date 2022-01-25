package collections.collection.set;

import collections.collection.list.ArrayListT;
import entities.shapes.Circle;
import entities.shapes.Rectangle;
import entities.shapes.Shape;
import entities.shapes.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashSetTests {
    @Test
    void shouldTestHashCodeWhenContainsSome() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square);
        HashSet<Shape> set = new HashSet<>(shapes);
        Assertions.assertEquals(shapes.hashCode(), set.hashCode());
    }

    @Test
    void shouldReturnZeroAsHashCodeWhenEmpty() {
        HashSet<Shape> set = new HashSet<>();
        Assertions.assertEquals(0, set.hashCode());
    }

    @Test
    void shouldTestEqualsAndReturnTrueWhenEquals() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square);
        HashSet<Shape> set = new HashSet<>(shapes);
        Assertions.assertTrue(set.equals(shapes));
    }

    @Test
    void shouldTestEqualsAndReturnFalseWhenEquals() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square, circle);
        HashSet<Shape> set = new HashSet<>(shapes);
        Assertions.assertFalse(set.equals(shapes));
    }

    @Test
    void shouldToStringWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        HashSet<Shape> set = new HashSet<>(2);
        set.add(circle);
        set.add(rectangle);
        String expected = "[Circle{radius=5}, Rectangle{width=3, height=4}]";
        String actual = set.toString();
        Assertions.assertEquals(expected, actual);
    }
}