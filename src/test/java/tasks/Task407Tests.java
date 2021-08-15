package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task407Tests {
    @Test
    public void findSumNxN() {
        int[][] matrix = new int[][] {
                {1, 2 ,3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] expected = new int[] {6, 15, 24};
        int[] actual = Task407.findSum(matrix);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findSumNxM() {
        int[][] matrix = new int[][] {
                {1, 2 ,3},
                {4, 5,},
                {7, 8, 9}
        };
        int[] expected = new int[] {6, 9, 24};
        int[] actual = Task407.findSum(matrix);
        Assertions.assertArrayEquals(expected, actual);
    }

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
        int[][] actual = Task407.sortMatrixRowsDescReturn(matrix);
        Assertions.assertArrayEquals(expected, actual);
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
        int[][] actual = Task407.sortMatrixRowsDescReturn(matrix);
        Assertions.assertArrayEquals(expected, actual);
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
        int[][] actual = Task407.sortMatrixRowsDescReturn(matrix);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortMatrixRowsDescReturnOne() {
        int[][] matrix = new int[][] {
                {1}
        };
        int[][] expected = new int[][] {
                {1}
        };
        int[][] actual = Task407.sortMatrixRowsDescReturn(matrix);
        Assertions.assertArrayEquals(expected, actual);
    }
}