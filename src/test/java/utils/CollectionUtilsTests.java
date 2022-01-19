package utils;

import collections.ArrayListT;
import collections.LinkedListT;
import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.Square;
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
    void shouldFindMinWhenEmpty() {
        ArrayListT<Shape> list = ArrayListT.of();
        Assertions.assertNull(CollectionUtils.findMin(list, new MyComparator()));
    }

    @Test
    void shouldFindMinWhenNull() {
        Assertions.assertNull(CollectionUtils.findMin(null, new MyComparator()));
    }

    @Test
    void shouldFindMinWhenComparatorNull() {
        Assertions.assertNull(CollectionUtils.findMin(ArrayListT.of(), null));
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
}