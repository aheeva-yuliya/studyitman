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
}
