package tasks;

/**
 * QueueManagementSystemUtils.
 */
public class QueueManagementSystemUtils {
    /**
     * Finds the sum of the amount of issued tickets.
     *
     * @cpu O(n), n = systems.length
     * @ram O(1)
     *
     * @param systems QueueManagementSystem[]
     * @return the sum of the amount of issued tickets.
     */
    public static long calcTotalVisits(QueueManagementSystem[] systems) {
        long sum = 0;
        for (int i = 0; i < systems.length; i++) {
            sum = sum + systems[i].total;
        }
        return sum;
    }
    /**
     * Calculates the average number of tickets issued from all queuing systems.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param systems QueueManagementSystem[]
     * @return the average number of tickets issued from all queuing systems.
     */
    public static double calcAverageVisits(QueueManagementSystem[] systems) {
        if (systems.length == 0) {
            return 0;
        }
        double length = systems.length;
        return calcTotalVisits(systems) / length;
    }
    /**
     * Calculates the median of the number of issued tickets.
     *
     * @cpu O(n^2)
     * @ram O(1)
     *
     * @param systems QueueManagementSystem[]
     * @return the median of the number of tickets issued from all queuing systems.
     */
    public static double calcMedianVisits(QueueManagementSystem[] systems) {
        for (int n = systems.length; n > 1; n--) {
            for(int i = 1; i < n; i++) {
                if(systems[i -1].total > systems[i].total) {
                    int t = systems[i - 1].total;
                    systems[i - 1].total = systems[i].total;
                    systems[i].total = t;
                }
            }
        }
        if (systems.length == 0) {
            return 0;
        }
        if (systems.length == 1) {
            return systems[0].total * 1.0;
        }
        if (systems.length % 2 == 0) {
            return (systems[systems.length / 2 - 1].total + systems[systems.length / 2].total) / 2.0;
        }
        return systems[systems.length / 2].total * 1.0;
    }
}
