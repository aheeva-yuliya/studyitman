package collections.collection.list;

import entities.shapes.Circle;
import entities.shapes.Rectangle;
import entities.shapes.Shape;
import entities.shapes.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.collection.MyComparator;

class ArrayListTTests {
    @Test
    void shouldTestAddWhenAdd() {
        ArrayListT<Shape> shapes = new ArrayListT<>(3);
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(square);
        Object[] expected = new Object[] {circle, rectangle, square};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldTestAdd1WhenAddAtIndex() {
        ArrayListT<Shape> shapes = new ArrayListT<>();
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(0, square);
        Object[] expected = new Object[] {square, circle, rectangle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddAllWhenAddAtIndex() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle);
        LinkedListT<Shape> list = LinkedListT.of(square, circle);
        Assertions.assertTrue(shapes.addAll(0, list));
        Object[] expected = new Object[] {square, circle, circle, rectangle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddAllWhenAddAtIndexAndEnoughCapacity() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square, square);
        shapes.add(circle);
        LinkedListT<Shape> list = LinkedListT.of(square, circle);
        Assertions.assertTrue(shapes.addAll(2, list));
        Object[] expected = new Object[] {circle, rectangle, square, circle, square, square, circle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square);
        shapes.remove(rectangle);
        Object[] expected = new Object[] {circle, square};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldOfWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle);
        Object[] expected = new Object[] {circle, rectangle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldClearWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square);
        shapes.clear();
        Object[] expected = new Object[] {};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square);
        Shape actual = shapes.get(2);
        Assertions.assertEquals(square, actual);
    }

    @Test
    void shouldSetWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        LinkedListT<Shape> list = LinkedListT.of(circle, rectangle, square);
        ArrayListT<Shape> shapes = new ArrayListT<>(list);
        shapes.set(2, circle);
        Object[] expected = new Object[] {circle, rectangle, circle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square);
        shapes.sort(new MyComparator());
        Object[] expected = new Object[] {square, rectangle, circle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortWhenContainsNull() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, null, rectangle, square);
        shapes.sort(new MyComparator());
        Object[] expected = new Object[] {square, rectangle, circle, null};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }
}