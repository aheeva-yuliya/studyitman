package tasks;

/**
 * Task406
 */
public class Task406 {
    /**
     * Finds the second max value of the array.
     *
     * @cpu O(n)
     * @ram O(1)
     *
     * @param array int[]
     * @return the second max value.
     */
    public static int findSecondMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
           if (array[i] > max) {
               second = max;
               max = array[i];
           } else {
               if (array[i] > second) {
                   second = array[i];
               }
           }
        }
        return second;
    }
}
