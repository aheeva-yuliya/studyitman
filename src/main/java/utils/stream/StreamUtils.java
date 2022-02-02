package utils.stream;

import entities.streamed.Tag;
import entities.streamed.Task;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamUtils {
    /**
     * Count Number Of Done Tasks.
     *
     * @param tasks tasks
     * @param from from
     * @param to to
     * @return map
     */
    public static Map<LocalDate, Long> countNumberOfDoneTasks(final List<Task> tasks,
                                                              final LocalDate from,
                                                              final LocalDate to) {
        if (tasks == null) {
            throw new IllegalArgumentException("List<Task> is null.");
        }
        if (from == null || to == null) {
            throw new IllegalArgumentException("LocalDate from or LocalDate to is null.");
        }
        if (from.isAfter(to)) {
            throw new IllegalArgumentException("LocalDate from is after to.");
        }
        return tasks
                .stream()
                .filter(task -> task != null
                        && task.getCompletedDate() != null
                        && !task.getCompletedDate().isBefore(from)
                        && !task.getCompletedDate().isAfter(to))
                .collect(Collectors.groupingBy(Task::getCompletedDate, Collectors.counting()));

    }

    /**
     * Sort By Date Counting Done Tasks.
     *
     * @param tasks tasks
     * @param from from
     * @param to to
     * @return list
     */
    public static List<Map.Entry<LocalDate, Long>> sortByDateCountingDoneTasks(final List<Task> tasks,
                                                                               final LocalDate from,
                                                                               final LocalDate to) {
        var map = countNumberOfDoneTasks(tasks, from, to);
        return from.datesUntil(to.plusDays(1L))
                .map(localDate -> Map.entry(localDate, map.get(localDate) == null ? 0 : map.get(localDate)))
                .collect(Collectors.toList());
    }

    /**
     * Filter tasks.
     *
     * @param tasks tasks
     * @param tags tags
     * @param completed boolean
     * @param from date
     * @param to date
     * @return list
     */
    public static List<Task> filterTasks(final List<Task> tasks,
                                         final List<Tag> tags,
                                         final boolean completed,
                                         final LocalDate from,
                                         final LocalDate to) {
        if (tasks == null) {
            throw new IllegalArgumentException("List<Task> is null.");
        }
        return tasks
                .stream()
                .filter(task -> task != null && task.getTags() != null && task.getTags().containsAll(tags))
                .filter(task -> {
                    if (!completed) {
                        return task.getCompletedDate() == null;
                    }
                    return true;
                })
                .filter(task -> {
                    if (from != null) {
                        return task.getPlannedDate() != null && !task.getPlannedDate().isBefore(from);
                    }
                    return true;
                })
                .filter(task -> {
                    if (to != null) {
                        return task.getPlannedDate() != null && !task.getPlannedDate().isAfter(to);
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }
}


