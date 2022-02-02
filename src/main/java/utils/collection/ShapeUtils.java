package utils.collection;

import collections.collection.list.ArrayListT;
import entities.shapes.Shape;

public class ShapeUtils {
    /**
     * Find Min Square.
     *
     * @param shapes shapes
     * @return shape
     */
    public static Shape findMinSquare(final ArrayListT<Shape> shapes) {
        if (shapes == null) {
            return null;
        }
        Shape withMinSquare = shapes.isEmpty() ? null : shapes.get(0);
        for (int i = 1; i < shapes.size(); i++) {
            assert withMinSquare != null;
            if (withMinSquare.calcSquare() > shapes.get(i).calcSquare()) {
                withMinSquare = shapes.get(i);
            }
        }
        return withMinSquare;
    }

    /**
     * Calc Avg Perimeter.
     *
     * @param shapes shapes
     * @return double
     */
    public static double calcAvgPerimeter(final ArrayListT<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            return 0;
        }
        double avg = 0;
        for (Shape shape : shapes) {
            avg += shape.calcPerimeter();
        }
        return avg / shapes.size();
    }
}
