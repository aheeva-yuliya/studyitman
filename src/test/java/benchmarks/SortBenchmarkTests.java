package benchmarks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SortBenchmarkTests {
    @Nested
    public class Create {
        @Test
        public void shouldCreateWhenTryCreateRandomArray() {
            int[] ints = SortBenchmark.randomArray(10, 5, 15);
            Assertions.assertEquals(10, ints.length);
            for (int anInt : ints) {
                Assertions.assertTrue(anInt < 15 || anInt >= 5);
            }
        }

        @Test
        public void shouldCreateAndCheckWhenTryCreateRandomArray() {
            int[] ints = SortBenchmark.randomArray(100, 67, 150);
            Assertions.assertEquals(100, ints.length);
            for (int anInt : ints) {
                Assertions.assertTrue(anInt < 150 || anInt >= 67);
            }
        }

        @Test
        public void shouldCreateWhenTryCreateRandomEvents() {
            Event[] events = SortBenchmark.randomEvents(100, 8, 10);
            for (Event event : events) {
                Assertions.assertTrue(event.getYear() < 10 && event.getYear() >= 8);
                Assertions.assertTrue(event.getMonth() <= 12 && event.getMonth() >= 1);
                Assertions.assertTrue(event.getDay() <= 31 && event.getDay() >= 1);
                Assertions.assertTrue(event.getName().length() <= 20 && event.getName().length() > 0);
            }
        }

        @Test
        public void shouldCreateAndCheckWhenTryCreateRandomEvents() {
            Event[] events = SortBenchmark.randomEvents(100, 1, 2000);
            for (Event event : events) {
                Assertions.assertTrue(event.getYear() < 2000 && event.getYear() >= 1);
                Assertions.assertTrue(event.getMonth() <= 12 && event.getMonth() >= 1);
                Assertions.assertTrue(event.getDay() <= 31 && event.getDay() >= 1);
                Assertions.assertTrue(event.getName().length() <= 20 && event.getName().length() > 0);
            }
        }
    }
}