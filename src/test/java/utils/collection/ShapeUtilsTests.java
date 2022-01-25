package utils.collection;

import collections.collection.list.ArrayListT;
import entities.shapes.Circle;
import entities.shapes.Rectangle;
import entities.shapes.Shape;
import entities.shapes.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ShapeUtilsTests {

    @Test
    void findMinSquare() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square);
        Shape actual = ShapeUtils.findMinSquare(shapes);
        Assertions.assertEquals(square, actual);
    }

    @Test
    void calcAvgPerimeter() {
        Circle circle = new Circle(5);
        Rectangle rectangle =  new Rectangle(3, 4);
        Square square = new Square(3);
        ArrayListT<Shape> shapes = ArrayListT.of(circle, rectangle, square);
        double actual = ShapeUtils.calcAvgPerimeter(shapes);
        Assertions.assertEquals(19.133333333333336, actual);
    }
}