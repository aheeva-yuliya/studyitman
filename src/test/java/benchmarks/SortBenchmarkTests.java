package benchmarks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortBenchmarkTests {

    @Test
    public void randomArrayCreate() {
        int[] ints = SortBenchmark.randomArray(10, 5, 15);
        Assertions.assertEquals(10, ints.length);
        boolean x = true;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] >= 15 || ints[i] < 5) {
                x = false;
                return;
            }
        }
        Assertions.assertTrue(x);
    }

    @Test
    public void randomEventsCreateAndCheckYear() {
        Event[] events = SortBenchmark.randomEvents(100, 8, 10);
        boolean x = true;
        for (int i = 0; i < events.length; i++) {
            if (events[i].getYear() >= 10 || events[i].getYear() < 8) {
                x = false;
                return;
            }
            if (events[i].getMonth() > 12 || events[i].getMonth() < 1) {
                x = false;
                return;
            }
            if (events[i].getDay() > 31 || events[i].getDay() < 1) {
                x = false;
                return;
            }
        }
        Assertions.assertTrue(x);
    }
}