package tasks;

import collections.ArrayList;

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
        int max = 0;
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

    /**
     * Returns an array that contains numbers in the range 0 through the parameter array length.
     * Each number X is contained exactly array[X] times. The numbers in the resulting array are in ascending order.
     *
     * @cpu O(n^2), n = array.length
     *              for line 58 O(n) * for line 59 array[i] = maximum array.length - 1 - O(n)
     *              add line 62 O(1)
     *              toArray line 66  O(n^2)
     * @ram O(n^2)  Each element could be (array.length - 1) times.
     *              arrayList line 61  maximum ≈ O(n^2)
     *              toArray line 68 O(n^2) maximum array.length * array.length - 1.
     *
     * @param array int[]
     * @return int[] with numbers in ascending order
     */
    public static int[] restore(int[] array) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                arrayList.add(i);
            }
        }
        return arrayList.toArray();
    }

    /**
     * вопрос по реализации всех методов
     * @param array int[]
     */
    public static void sort(int[] array) {
        int[] ints = count(array);
        ints = restore(ints);
        System.arraycopy(ints, 0, array, 0, array.length);
    }
}
