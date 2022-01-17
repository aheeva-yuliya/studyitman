package utils;

import collections.ArrayListT;
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
        Rectangle rectangle =  new Rectangle(3, 4);
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
}