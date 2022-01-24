package collections.collection;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.MyComparator;

class LinkedListTTests {
    @Test
    public void shouldAddFirstWhenListEmptyAndWhenHasSomeElements() {
        LinkedListT<Integer> list = new LinkedListT<>();
        list.addFirst(7);
        Assertions.assertEquals(7, list.getFirst());
        list.addFirst(55);
        Assertions.assertEquals(55, list.getFirst());
        list.addFirst(51);
        Assertions.assertEquals(51, list.getFirst());
    }

    @Test
    public void shouldGetFirstWhenListContainsOneElement() {
        LinkedListT<Integer> list = new LinkedListT<>();
        list.addFirst(7);
        Assertions.assertEquals(7, list.getFirst());
    }

    @Test
    public void shouldAddLastWhenListNotEmpty() {
        LinkedListT<Integer> list = new LinkedListT<>();
        list.addLast(7);
        list.addFirst(55);
        list.addLast(51);
        list.addLast(100);
        String expected = "[55, 7, 51, 100]";
        String actual = list.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetLastWhenListContainsSomeElements() {
        LinkedListT<Integer> list = LinkedListT.of(7, 55, 51, 100);
        Assertions.assertEquals(100, list.getLast());
        String expected = "[7, 55, 51, 100]";
        String actual = list.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> list = ArrayListT.of(circle, rectangle, square);
        LinkedListT<Shape> shapes = new LinkedListT<>(list);
        shapes.remove(rectangle);
        Object[] expected = new Object[] {circle, square};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldClearWhen() {
        LinkedListT<Integer> list = LinkedListT.of(11, 12, 13);
        list.clear();
        String expected = "[]";
        String actual = list.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateLinkedListWhenTryCreateOfThatList() {
        LinkedListT<Integer> list = LinkedListT.of(11, 12, 13);
        String expected = "[11, 12, 13]";
        String actual = list.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldAddWhen() {
        Circle circle = new Circle(5);
        LinkedListT<Shape> list = new LinkedListT<>();
        list.add(circle);
        Object[] expected = new Object[] {circle};
        Object[] actual = list.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddAtIndexWhen() {
        LinkedListT<Integer> list = LinkedListT.of(7, 55, 51, 100);
        list.add(1, 200);
        String expected = "[7, 200, 55, 51, 100]";
        String actual = list.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldAddAllWhenAddAtIndex() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle);
        LinkedListT<Shape> list = LinkedListT.of(square, circle);
        Assertions.assertTrue(list.addAll(0, shapes));
        Object[] expected = new Object[] {circle, rectangle, square, circle};
        Object[] actual = list.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAtIndexWhen() {
        LinkedListT<Integer> list = new LinkedListT<>();
        list.addFirst(7);
        Assertions.assertEquals(7, list.get(0));
    }

    @Test
    void shouldSortWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        LinkedListT<Shape> shapes = LinkedListT.of(circle, rectangle, square);
        shapes.sort(new MyComparator());
        Object[] expected = new Object[] {square, rectangle, circle};
        Object[] actual = shapes.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }
}