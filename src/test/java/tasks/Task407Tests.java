package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task407Tests {
    @Nested
    public class SortMatrix {
        @Test
        public void shouldSortMatrixRowsDescWhenNxN() {
            int[][] matrix = new int[][]{
                    {1, 2, 3, 3},
                    {4, 5, 6, 2},
                    {7, 1, 1, 1}
            };
            int[][] expected = new int[][]{
                    {4, 5, 6, 2},
                    {7, 1, 1, 1},
                    {1, 2, 3, 3}
            };
            Task407.sortMatrixRowsDesc(matrix);
            Assertions.assertArrayEquals(expected, matrix);
        }

        @Test
        public void shouldSortMatrixRowsDescWhenNxM() {
            int[][] matrix = new int[][]{
                    {1, 2, 3},
                    {4, 5, 6, 2},
                    {7, 1, 1, 1}
            };
            int[][] expected = new int[][]{
                    {4, 5, 6, 2},
                    {7, 1, 1, 1},
                    {1, 2, 3}
            };
            Task407.sortMatrixRowsDesc(matrix);
            Assertions.assertArrayEquals(expected, matrix);
        }

        @Test
        public void shouldSortMatrixRowsDescWhenSameSum() {
            int[][] matrix = new int[][]{
                    {1, 2, 3, 3},
                    {4, 5, 6, 2},
                    {7, 1, 5, 4}
            };
            int[][] expected = new int[][]{
                    {4, 5, 6, 2},
                    {7, 1, 5, 4},
                    {1, 2, 3, 3}
            };
            Task407.sortMatrixRowsDesc(matrix);
            Assertions.assertArrayEquals(expected, matrix);
        }

        @Test
        public void shouldSortMatrixRowsDescWhenOneElement() {
            int[][] matrix = new int[][]{
                    {1}
            };
            int[][] expected = new int[][]{
                    {1}
            };
            Task407.sortMatrixRowsDesc(matrix);
            Assertions.assertArrayEquals(expected, matrix);
        }
    }
}