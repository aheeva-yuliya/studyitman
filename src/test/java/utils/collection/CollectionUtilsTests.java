package utils.collection;

import collections.collection.list.ArrayListT;
import collections.collection.list.LinkedListT;
import entities.items.Item;
import entities.shapes.Circle;
import entities.shapes.Rectangle;
import entities.shapes.Shape;
import entities.shapes.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CollectionUtilsTests {
    @Test
    void shouldFindMinWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> list = ArrayListT.of(circle, rectangle, square);
        Assertions.assertEquals(square, CollectionUtils.findMin(list, new MyComparator()));
    }

    @Test
    void shouldFindMaxWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> list = ArrayListT.of(circle, rectangle, square);
        Assertions.assertEquals(circle, CollectionUtils.findMax(list, new MyComparator()));
    }

    @Test
    void shouldBinarySearchWhenComparable() {
        LinkedListT<Integer> numbers = LinkedListT.of(4, 6, 8, 8, 8, 8, 10, 87, 106, 115);
        Assertions.assertEquals(2, CollectionUtils.binarySearch(numbers, 8));
    }

    @Test
    void shouldSortWhenComparable() {
        LinkedListT<Integer> numbers = LinkedListT.of(4, 67, 8, 4, 2, 87, 6, 5);
        CollectionUtils.sort(numbers);
        Object[] expected = new Object[] {2, 4, 4, 5, 6, 8, 67, 87};
        Object[] actual = numbers.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReverseWhen() {
        LinkedListT<Integer> numbers = LinkedListT.of(4, 67, 8, 4, 2, 87, 6, 5);
        CollectionUtils.reverse(numbers);
        Object[] expected = new Object[] {5, 6, 87, 2, 4, 8, 67, 4};
        Object[] actual = numbers.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShuffleWhen() {
        LinkedListT<Integer> numbers = LinkedListT.of(4, 67, 8, 4, 2, 87, 6, 5, 54, 92, 43, 11);
        Integer[] expected = numbers.toArray(Integer[]::new);
        CollectionUtils.shuffle(numbers);
        Integer[] actual = numbers.toArray(Integer[]::new);
        boolean isEqual = true;
        for (int i = 0; i < actual.length; i++) {
            if (!expected[i].equals(actual[i])) {
                isEqual = false;
                break;
            }
        }
        Assertions.assertFalse(isEqual);
    }

    @Test
    void shouldThrowWhenComparatorNull() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> list = ArrayListT.of(circle, rectangle, square);
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class, () -> CollectionUtils.findMax(list, null));
        Assertions.assertEquals("Comparator is null", exception.getMessage());
    }

    @Test
    void shouldReturnNullWhenFindMinAndListIsEmpty() {
        Assertions.assertNull(CollectionUtils.findMin(ArrayListT.of(), new MyComparator()));
    }

    @Test
    void shouldFindPositionsWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Object> a = ArrayListT.of(circle, rectangle, square, circle, null, new Item(1, "t", 5));
        ArrayListT<Object> b = ArrayListT.of(null, square, new Item(5, "t", 2), circle);
        int[] expected = new int[] {4, 2, -1, 0};
        int[] actual = CollectionUtils.findPositions(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCreateWithoutDuplicatesWhen() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> a = ArrayListT.of(circle, null, null, null, null, square, circle, null, square, rectangle);
        ArrayListT<Shape> expected = ArrayListT.of(circle, null, square, rectangle);
        var actual = CollectionUtils.createWithoutDuplicates(a);
        Assertions.assertEquals(expected, actual);
    }
}