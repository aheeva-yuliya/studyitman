package collections.collection;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ListTTests {
    @Test
    void shouldSizeWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle);
        LinkedListT<Shape> list = LinkedListT.of(square);
        Assertions.assertEquals(2, shapes.size());
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void shouldIsEmptyWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle);
        LinkedListT<Shape> list = LinkedListT.of();
        Assertions.assertFalse(shapes.isEmpty());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void shouldAddAllWhenAdd() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle);
        LinkedListT<Shape> list = LinkedListT.of(square, rectangle);
        Assertions.assertTrue(shapes.addAll(list));
        Object[] expected = new Object[] {circle, rectangle, square, rectangle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnWhenAskedContains() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle);
        Assertions.assertTrue(shapes.contains(circle));
        Assertions.assertFalse(shapes.contains(square));
    }

    @Test
    void shouldReturnTrueWhenBothCollectionsContainNull() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, null, rectangle);
        Assertions.assertTrue(shapes.contains(null));
    }

    @Test
    void shouldContainsAllWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle);
        LinkedListT<Shape> list = LinkedListT.of(circle, square);
        Assertions.assertFalse(shapes.containsAll(list));
        shapes.add(square);
        Assertions.assertTrue(shapes.containsAll(list));
    }

    @Test
    void shouldRemoveAllWhen() {
        Circle circle = new Circle(5);
        Circle circle2 = new Circle(5);
        Circle circle3 = new Circle(3);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square, circle2);
        LinkedListT<Shape> list = LinkedListT.of(circle, square, circle3);
        shapes.removeAll(list);
        Object[] expected = new Object[] {rectangle, circle2};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldTestEqualsWhen() {
        Circle circle = new Circle(5);
        Circle circle2 = new Circle(5);
        Circle circle3 = new Circle(3);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square, circle2);
        ArrayListT<Shape> shapes1 = ArrayListT.of(circle, rectangle, square, circle2);
        Assertions.assertTrue(shapes.equals(shapes1));
        LinkedListT<Shape> list = LinkedListT.of(circle, square, circle3);
        Assertions.assertFalse(shapes.equals(list));
        LinkedListT<Shape> list1 = LinkedListT.of(circle, rectangle, square, circle2);
        Assertions.assertTrue(shapes.equals(list1));
    }

    @Test
    void shouldTestToStringWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square);
        String expected = "[Circle{radius=5}, Rectangle{width=3, height=4}, Square{side=3}]";
        String actual = shapes.toString();
        Assertions.assertEquals(expected, actual);
        LinkedListT<Shape> list = LinkedListT.of();
        expected = "[]";
        actual = list.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldTestToStringWhenOneOfElementsIsNull() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, null, square);
        String expected = "[Circle{radius=5}, Rectangle{width=3, height=4}, null, Square{side=3}]";
        String actual = shapes.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldToArrayWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle);
        Object[] expected = new Object[] {circle, rectangle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldToArrayTWhenLinkedList() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        LinkedListT<Shape> list = LinkedListT.of(circle, rectangle, square, rectangle);
        Shape[] expected = new Shape[] {circle, rectangle, square, rectangle};
        Shape[] actual = list.toArray(Shape[]::new);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldToArrayTWhenLinkedListContainsNull() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        LinkedListT<Shape> list = LinkedListT.of(circle, null, rectangle, square, rectangle);
        Shape[] expected = new Shape[] {circle, null, rectangle, square, rectangle};
        Shape[] actual = list.toArray(Shape[]::new);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldToArrayTWhenArrayList() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square, rectangle);
        Shape[] expected = new Shape[] {circle, rectangle, square, rectangle};
        Shape[] actual = shapes.toArray(Shape[]::new);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveIfWhenArrayList() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, circle);
        shapes.removeIf(shape -> shape.equals(circle));
        Object[] expected = new Object[] {rectangle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveIfWhenLinkedListContainsNull() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        LinkedListT<Shape> shapes = LinkedListT.of(circle, rectangle, circle);
        shapes.removeIf(shape -> true);
        Object[] expected = new Object[] {};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrowWhenNegativeIndex() {
        IndexOutOfBoundsException exception =
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> new ArrayListT<Shape>().get(-1));
        Assertions.assertEquals("Index -1 out of bounds for size 0", exception.getMessage());
    }

    @Test
    void shouldThrowWhenCollectionNull() {
        ArrayListT<Shape> shapes = ArrayListT.of();
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class, () -> shapes.addAll(null));
        Assertions.assertEquals("Collection is null", exception.getMessage());
    }

    @Test
    void shouldThrowWhenComparatorNull() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square);
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class, () -> shapes.sort(null));
        Assertions.assertEquals("Comparator is null", exception.getMessage());
    }
}