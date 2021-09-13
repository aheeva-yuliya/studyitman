package tasks;

/**
 * CountingSortTask
 */
public class CountingSortTask {

    /**
     * Counts how many times each element occurs in the parameter array.
     *
     * @cpu O(n * m), n = the maximum value of the parameter array and m = the length of the parameter array
     * @ram O(n), n = the maximum value of the parameter array
     *
     * @param array int[]
     * @return an array containing at position "i" the number of elements equal to "i" in the original array.
     */
    public static int[] count(int[] array) {
        if(array.length == 0) {
            return new int[]{};
        }
        int max = Integer.MIN_VALUE;
        for (int j : array) {
            if (j > max) {
                max = j;
            }
        }
        int[] result = new int[max + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = countI(i, array);
        }
        return result;
    }

    private static int countI(int i, int[] array) {
        int count = 0;
        for (int k : array) {
            if (k == i) {
                count++;
            }
        }
        return count;
    }
}
