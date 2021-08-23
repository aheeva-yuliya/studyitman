package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task407Tests {

    @Test
    public void sortMatrixRowsDescReturnNxN() {
        int[][] matrix = new int[][] {
                {1, 2, 3, 3},
                {4, 5, 6, 2},
                {7, 1, 1, 1}
        };
        int[][] expected = new int[][] {
                {4, 5, 6, 2},
                {7, 1, 1, 1},
                {1, 2, 3, 3}
        };
        Task407.sortMatrixRowsDesc(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    @Test
    public void sortMatrixRowsDescReturnNxM() {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6, 2},
                {7, 1, 1, 1}
        };
        int[][] expected = new int[][] {
                {4, 5, 6, 2},
                {7, 1, 1, 1},
                {1, 2, 3}
        };
        Task407.sortMatrixRowsDesc(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    @Test
    public void sortMatrixRowsDescReturnSameSum() {
        int[][] matrix = new int[][] {
                {1, 2, 3, 3},
                {4, 5, 6, 2},
                {7, 1, 5, 4}
        };
        int[][] expected = new int[][] {
                {4, 5, 6, 2}, // 17
                {7, 1, 5, 4}, // 17
                {1, 2, 3, 3}
        };
        Task407.sortMatrixRowsDesc(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    @Test
    public void sortMatrixRowsDescReturnOne() {
        int[][] matrix = new int[][] {
                {1}
        };
        int[][] expected = new int[][] {
                {1}
        };
        Task407.sortMatrixRowsDesc(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }
}