package collections;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ListIteratorTests {

    @Test
    void shouldSetWhenArrayList() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square);
        ListIterator<Shape> listIterator = shapes.iterator();
        listIterator.next();
        listIterator.set(square);
        Object[] expected = new Object[]{square, rectangle, square};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSetWhenLinkedList() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(3);
        LinkedListT<Shape> shapes = LinkedListT.of(circle, rectangle, square);
        ListIterator<Shape> listIterator = shapes.iterator();
        listIterator.next();
        listIterator.set(square);
        Object[] expected = new Object[]{square, rectangle, square};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldInsertBeforeWhenArrayListLengthEqualsSize() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle);
        ListIterator<Shape> listIterator = shapes.iterator();
        listIterator.next();
        listIterator.insertBefore(square);
        Object[] expected = new Object[]{square, circle, rectangle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldInsertBeforeFirstWhenLinkedList() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(3);
        LinkedListT<Shape> shapes = LinkedListT.of(circle, rectangle);
        ListIterator<Shape> listIterator = shapes.iterator();
        listIterator.next();
        listIterator.insertBefore(square);
        Object[] expected = new Object[]{square, circle, rectangle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldInsertBeforeInThenMiddleWhenLinkedList() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(3);
        LinkedListT<Shape> shapes = LinkedListT.of(circle, rectangle, square);
        ListIterator<Shape> listIterator = shapes.iterator();
        listIterator.next();
        listIterator.next();
        listIterator.insertBefore(square);
        Object[] expected = new Object[]{circle, square, rectangle, square};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveWhenArrayList() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square);
        ListIterator<Shape> listIterator = shapes.iterator();
        listIterator.next();
        listIterator.remove();
        Object[] expected = new Object[]{rectangle, square};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveLastWhenLinkedList() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(3);
        LinkedListT<Shape> shapes = LinkedListT.of(circle, rectangle, square);
        ListIterator<Shape> listIterator = shapes.iterator();
        listIterator.next();
        listIterator.next();
        listIterator.next();
        listIterator.remove();
        Object[] expected = new Object[]{circle, rectangle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveInTheMiddleWhenLinkedList() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(3);
        LinkedListT<Shape> shapes = LinkedListT.of(circle, rectangle, square);
        ListIterator<Shape> listIterator = shapes.iterator();
        listIterator.next();
        listIterator.next();
        listIterator.remove();
        Object[] expected = new Object[]{circle, square};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }
}