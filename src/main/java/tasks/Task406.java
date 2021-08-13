package tasks;

public class Task406 {
    public static int findSecondMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
           if (array[i] > max) {
               third = second;
               second = max;
               max = array[i];
           } else {
               if (array[i] > second) {
                   third = second;
                   second = array[i];
               } else {
                   if (array[i] < third) {
                       third = array[i];
                   }
               }
           }
        }
        return second;
    }
}
