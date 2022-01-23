package utils;

import entities.Shape;

import java.util.Comparator;

public class MyComparator implements Comparator<Shape> {
    @Override
    public int compare(final Shape s1, final Shape s2) {
        if (s1 == null && s2 == null) {
            return 0;
        } else if (s1 != null && s2 == null) {
            return -1;

        } else if (s1 == null) {
            return 1;
        }
        final double s1Square = s1.calcSquare();
        final double s2Square = s2.calcSquare();
        if (s1Square > s2Square) {
            return 1;
        } else if (s1Square == s2Square) {
            return 0;
        }
        return -1;
    }
}
