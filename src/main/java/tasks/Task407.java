package tasks;

public class Task407 {
    static int[] findSum(int[][] matrix) {
        int[] sum = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum[i] = sum[i] + matrix[i][j];
            }
        }
        return sum;
    }

    public static void sortMatrixRowsDesc(int[][] matrix) {
        int[] sum = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum[i] = sum[i] + matrix[i][j];
            }
        }
        for (int n = sum.length; n > 1; n--) {
            for (int i = 1; i < n; i++) {
                if (sum[i - 1] < sum[i]) {
                    int t = sum[i - 1];
                    sum[i - 1] = sum[i];
                    sum[i] = t;
                    int[] temp = matrix[i - 1];
                    matrix[i - 1] = matrix[i];
                    matrix[i] = temp;
                }
            }
        }
    }

    static int[][] sortMatrixRowsDescReturn(int[][] matrix) {
        int[] sum = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum[i] = sum[i] + matrix[i][j];
            }
        }
        for (int n = sum.length; n > 1; n--) {
            for (int i = 1; i < n; i++) {
                if (sum[i - 1] < sum[i]) {
                    int t = sum[i - 1];
                    sum[i - 1] = sum[i];
                    sum[i] = t;
                    int[] temp = matrix[i - 1];
                    matrix[i - 1] = matrix[i];
                    matrix[i] = temp;
                }
            }
        }
        return matrix;
    }
}
