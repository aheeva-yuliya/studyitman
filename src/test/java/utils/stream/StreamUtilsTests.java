package utils.stream;

import entities.streamed.Tag;
import entities.streamed.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;


class StreamUtilsTests {
    @Test
    void shouldCountNumberOfDoneTasksWhenListWithoutNull() {
        List<Task> tasks =  createList();
        Map<LocalDate, Long> expected = new HashMap<>();
        expected.put(LocalDate.of(2022, 1, 1), 2L);
        expected.put(LocalDate.of(2022, 1, 2), 2L);
        expected.put(LocalDate.of(2022, 1, 3), 1L);
        expected.put(LocalDate.of(2022, 1, 4), 1L);
        Map<LocalDate, Long> actual = StreamUtils.countNumberOfDoneTasks(
                tasks,
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 1, 4));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSortByDateCountingDoneTasksWhenSomeOfDatesHasNoDoneTasks() {
        List<Task> tasks =  createList();
        var expected = List.of(
                new Entry<>(LocalDate.of(2021, 12, 30), 0L),
                new Entry<>(LocalDate.of(2021, 12, 31), 0L),
                new Entry<>(LocalDate.of(2022, 1, 1), 2L),
                new Entry<>(LocalDate.of(2022, 1, 2), 2L),
                new Entry<>(LocalDate.of(2022, 1, 3), 1L),
                new Entry<>(LocalDate.of(2022, 1, 4), 1L),
                new Entry<>(LocalDate.of(2022, 1, 5), 0L)
        );
        var actual = StreamUtils.sortByDateCountingDoneTasks(tasks,
                LocalDate.of(2021, 12, 30),
                LocalDate.of(2022, 1, 5));
        Assertions.assertEquals(expected, actual);
    }

    @Nested
    public class FilterTests {
        @Test
        void shouldFilterTasksWhenNeededTags() {
            List<Task> tasks = createList();
            var expected = List.of(tasks.get(1), tasks.get(4));
            var actual = StreamUtils.filterTasks(
                    tasks, List.of(new Tag("geography")), true, null, null);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldFilterTasksWhenCompletedFalse() {
            List<Task> tasks = createList();
            var expected = List.of(tasks.get(0));
            var actual = StreamUtils.filterTasks(
                    tasks, List.of(new Tag("history")), false, null, null);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldFilterTasksWhenFromNotNull() {
            List<Task> tasks = createList();
            var expected = List.of(tasks.get(0), tasks.get(4));
            var actual = StreamUtils.filterTasks(
                    tasks, List.of(new Tag("history")), true, LocalDate.of(2022, 1, 1), null);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldFilterTasksWhenToNotNull() {
            List<Task> tasks = createList();
            var expected = List.of(tasks.get(1), tasks.get(2));
            var actual = StreamUtils.filterTasks(
                    tasks, List.of(new Tag("history")), true, null, LocalDate.of(2021, 12, 12));
            Assertions.assertEquals(expected, actual);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private  List<Task> createList() {
        Tag geography = new Tag("geography");
        Tag biology = new Tag("biology");
        Tag history = new Tag("history");
        Tag literature = new Tag("literature");
        Tag physics = new Tag("physics");
        Tag math = new Tag("math");
        Tag informatics = new Tag("informatics");

        return List.of(
                new Task(
                        "task1",
                        LocalDate.of(2022, 1, 3),
                        null,
                        Set.of(history, biology)),
                new Task("task2",
                        LocalDate.of(2021, 12, 11),
                        LocalDate.of(2022, 1, 2),
                        Set.of(history, biology, physics, geography)),
                new Task(
                        "task3",
                        LocalDate.of(2021, 12, 12),
                        LocalDate.of(2022, 1, 1),
                        Set.of(history, biology, math, literature)),
                new Task(
                        "task4",
                        LocalDate.of(2021, 12, 13),
                        LocalDate.of(2022, 1, 1),
                        Set.of(history, biology, informatics, math)),
                new Task(
                        "task5",
                        LocalDate.of(2022, 1, 1),
                        LocalDate.of(2022, 1, 2),
                        Set.of(history, biology, geography, literature, physics, math, informatics)),
                new Task(
                        "task6",
                        LocalDate.of(2022, 1, 1),
                        null,
                        Set.of(literature)),
                new Task(
                        "task7",
                        LocalDate.of(2022, 1, 1),
                        LocalDate.of(2022, 1, 4),
                        Set.of(literature)),
                new Task(
                        "task8",
                        LocalDate.of(2022, 1, 1),
                        LocalDate.of(2022, 1, 3),
                        Set.of(math, physics, informatics))
        );
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static class Entry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return null;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> that = (Map.Entry<?, ?>) obj;
            return Objects.equals(key, that.getKey()) && Objects.equals(value, that.getValue());
        }
    }
}