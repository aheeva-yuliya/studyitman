package tasks;

import collections.ArrayList;
import entities.Statistic;

import java.lang.reflect.Array;

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
            sum = sum + systems[i].getTotalTickets();
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
     * @cpu O(n^2), n = systems.length
     * @ram O(n)
     *
     * @param systems QueueManagementSystem[]
     * @return the median of the number of tickets issued from all queuing systems.
     */
    public static double calcMedianVisits(QueueManagementSystem[] systems) {
        double[] actual = new double[systems.length];
        for (int i = 0; i < systems.length; i++) {
            actual[i] = systems[i].getTotalTickets();
        }
        for (int n = systems.length; n > 1; n--) {
            for(int i = 1; i < n; i++) {
                if(actual[i -1] > actual[i]) {
                    double t = actual[i - 1];
                    actual[i - 1] = actual[i];
                    actual[i] = t;
                }
            }
        }
        if (systems.length == 0) {
            return 0;
        }
        if (systems.length == 1) {
            return actual[0];
        }
        if (systems.length % 2 == 0) {
            return (actual[systems.length / 2 - 1] + actual[systems.length / 2]) / 2;
        }
        return actual[systems.length / 2];
    }

    private static int findMin(ArrayList min) {
        int[] ints = min.toArray();
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < ints.length; i++) {
            if (minimum > ints[i]) {
                minimum = ints[i];
            }
        }
        return minimum;
    }

    private static int findMax(ArrayList max) {
        int[] ints = max.toArray();
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < ints.length; i++) {
            if (maximum < ints[i]) {
                   maximum = ints[i];
            }
        }
        return maximum;
    }

    private static long calcCount(ArrayList counts) {
        int[] ints = counts.toArray();
        long count = 0;
        for (int i = 0; i < ints.length; i++) {
            count += ints[i];
        }
        return count;
    }

    private static double calcAverageByDay(ArrayList avg) {
        int[] ints = avg.toArray();
        double average = 0;
        for (int i = 0; i < ints.length; i++) {
            average += ints[i];
        }
        return average / ints.length;
    }

    private static double calcMedianByDay(ArrayList med) {
        int[] actual = med.toArray();
        for (int n = actual.length; n > 1; n--) {
            for(int i = 1; i < n; i++) {
                if(actual[i -1] > actual[i]) {
                    int t = actual[i - 1];
                    actual[i - 1] = actual[i];
                    actual[i] = t;
                }
            }
        }
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
     * Calculates statistic by day.
     *
     * @cpu O(n * m), n = systems.length m = number of visits by day
     * @ram O(n), n = systems.length
     *
     * @param systems QueueManagementSystem[]
     * @return Statistic[] with information by day.
     */
    public static Statistic[] calcStatisticByDays(QueueManagementSystem[] systems) {
        if (systems.length == 0) {
            return null;
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
        for (int j = 0; j < length; j++ ) {
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
            statistics[i] = new Statistic(min,max,count,average,median);
        }
        return statistics;
    }
}
