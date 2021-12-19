package tasks;

import collections.ArrayList;
import entities.Statistic;
import utils.ArrayUtils;


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
        for (QueueManagementSystem system : systems) {
            sum += system.getTotalTickets();
        }
        return sum;
    }

    /**
     * Calculates the average number of tickets issued from all queuing systems.
     *
     * @cpu O(n), n = systems.length
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
     * @cpu O(nlog(n), n = systems.length
     * @ram O(n)
     *
     * @param systems QueueManagementSystem[]
     * @return the median of the number of tickets issued from all queuing systems.
     */
    public static double calcMedianVisits(QueueManagementSystem[] systems) {
        int[] actual = new int[systems.length];
        for (int i = 0; i < systems.length; i++) {
            actual[i] = systems[i].getTotalTickets();
        }
        ArrayUtils.mergeSort(actual);
        if (systems.length == 0) {
            return 0;
        }
        if (systems.length == 1) {
            return actual[0];
        }
        if (systems.length % 2 == 0) {
            return (actual[systems.length / 2 - 1] + actual[systems.length / 2]) / 2.0;
        }
        return actual[systems.length / 2];
    }

    private static int findMin(ArrayList min) {
        int[] ints = min.toArray();
        int minimum = Integer.MAX_VALUE;
        for (int anInt : ints) {
            if (minimum > anInt) {
                minimum = anInt;
            }
        }
        return minimum;
    }

    private static int findMax(ArrayList max) {
        int[] ints = max.toArray();
        int maximum = Integer.MIN_VALUE;
        for (int anInt : ints) {
            if (maximum < anInt) {
                maximum = anInt;
            }
        }
        return maximum;
    }

    private static long calcCount(ArrayList counts) {
        int[] ints = counts.toArray();
        long count = 0;
        for (int anInt : ints) {
            count += anInt;
        }
        return count;
    }

    private static double calcAverageByDay(ArrayList avg) {
        int[] ints = avg.toArray();
        double average = 0;
        for (int anInt : ints) {
            average += anInt;
        }
        return average / ints.length;
    }

    private static double calcMedianByDay(ArrayList med) {
        int[] actual = med.toArray();
        ArrayUtils.mergeSort(actual);
        if (actual.length == 0) {
            return 0;
        }
        if (actual.length == 1) {
            return actual[0];
        }
        if (actual.length % 2 == 0) {
            return (actual[actual.length / 2 - 1] + actual[actual.length / 2]) / 2.0;
        }
        return actual[actual.length / 2];
    }

    /**
     * Calculates statistics by days.
     *
     * @cpu O(m * nlog(n)), n = number of systems and m = number of days
     *                  (min, max, count, average - O(n); median - O(n^2); for line183 - O(m))
     * @ram O(n * m), n = systems.length m = number of days
     *
     * @param systems QueueManagementSystem[]
     * @return Statistic[] with information by day.
     */
    public static Statistic[] calcStatisticByDays(QueueManagementSystem[] systems) {
        if (systems.length == 0) {
            return new Statistic[0];
        }
        ArrayList[] arrays = new ArrayList[systems.length];
        int maxSize = 0;
        for (int i = 0; i < systems.length; i++) {
            arrays[i] = systems[i].getVisitsByDay();
            if (maxSize < arrays[i].size()) {
                maxSize = arrays[i].size();
            }
        }
        Statistic[] statistics = new Statistic[maxSize];
        ArrayList[] forStatistics = new ArrayList[maxSize];
        for (int i = 0; i < maxSize; i++) {
            forStatistics[i] = new ArrayList(1);
        }
        int length = maxSize;
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < systems.length; i++) {
                if (arrays[i].size() == maxSize) {
                    forStatistics[j].add(arrays[i].get(0));
                }
                if (arrays[i].size() > maxSize) {
                    forStatistics[j].add(arrays[i].get(arrays[i].size() - maxSize));
                }
            }
            maxSize--;
        }
        for (int i = 0; i < length; i++) {
            int min = findMin(forStatistics[i]);
            int max = findMax(forStatistics[i]);
            long count = calcCount(forStatistics[i]);
            double average = calcAverageByDay(forStatistics[i]);
            double median = calcMedianByDay(forStatistics[i]);
            statistics[i] = new Statistic(min, max, count, average, median);
        }
        return statistics;
    }
}
