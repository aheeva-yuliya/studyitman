package tasks;

/**
 * QueueManagementSystemUtils.
 */
public class QueueManagementSystemUtils {
    /**
     * Finds the sum of the amount of issued tickets.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param systems QueueManagementSystem[]
     * @return the sum of the amount of issued tickets.
     */
    public static long calcTotalVisits(QueueManagementSystem[] systems) {
        return systems.length;
    }
}
