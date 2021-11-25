package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task510Tests {
    @Nested
    public class MostFrequent {
        @Test
        public void shouldFindMostFrequentWhenSome() {
            int[] a = new int[]{1, 2, 5, 1, 2, 2, 3, 1};
            Assertions.assertEquals(1, Task510.mostFrequent(a));
        }

        @Test
        public void shouldFindMostFrequentWhenLengthIsOne() {
            int[] a = new int[]{1};
            Assertions.assertEquals(1, Task510.mostFrequent(a));
        }

        @Test
        public void shouldFindMostFrequentWhenLengthIsTwo() {
            int[] a = new int[]{1, 2};
            Assertions.assertEquals(1, Task510.mostFrequent(a));
        }

        @Test
        public void shouldFindMostFrequentWhenHasMaxInt() {
            int[] a = new int[]{2147483647, 0, 1073741823, 2147483647, -1073741824, -2147483648};
            Assertions.assertEquals(2147483647, Task510.mostFrequent(a));
        }
    }
}