package benchmarks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortBenchmarkTests {

    @Test
    public void randomArrayCreate() {
        int[] ints = SortBenchmark.randomArray(10, 5, 15);
        Assertions.assertEquals(10, ints.length);
        for (int i = 0; i < ints.length; i++) {
            Assertions.assertTrue(ints[i] < 15 || ints[i] >= 5);
        }
    }

    @Test
    public void randomArrayCreateAndCheck() {
        int[] ints = SortBenchmark.randomArray(100, 67, 150);
        Assertions.assertEquals(100, ints.length);
        for (int i = 0; i < ints.length; i++) {
            Assertions.assertTrue(ints[i] < 150 || ints[i] >= 67);
        }
    }

    @Test
    public void randomEventsCreate() {
        Event[] events = SortBenchmark.randomEvents(100, 8, 10);
        for (int i = 0; i < events.length; i++) {
            Assertions.assertTrue(events[i].getYear() < 10 && events[i].getYear() >= 8);
            Assertions.assertTrue(events[i].getMonth() <= 12 && events[i].getMonth() >= 1);
            Assertions.assertTrue(events[i].getDay() <= 31 && events[i].getDay() >= 1);
            Assertions.assertTrue(events[i].getName().length() <= 20 && events[i].getName().length() > 0);
        }
    }

    @Test
    public void randomEventsCreateAndCheckYEvents() {
        Event[] events = SortBenchmark.randomEvents(100, 1, 2000);
        for (int i = 0; i < events.length; i++) {
            Assertions.assertTrue(events[i].getYear() < 2000 && events[i].getYear() >= 1);
            Assertions.assertTrue(events[i].getMonth() <= 12 && events[i].getMonth() >= 1);
            Assertions.assertTrue(events[i].getDay() <= 31 && events[i].getDay() >= 1);
            Assertions.assertTrue(events[i].getName().length() <= 20 && events[i].getName().length() > 0);
        }
    }
}