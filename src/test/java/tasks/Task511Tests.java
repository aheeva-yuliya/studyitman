package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task511Tests {
    @Nested
    public class CountEquals {
        @Test
        public void shouldCountEqualsWhenHasSome() {
            int[] a = new int[]{1, 1, 3, 2, 1};
            int[] b = new int[]{4, 2, 1, 4, 1, 2};
            Assertions.assertEquals(3, Task511.countEquals(a, b));
        }

        @Test
        public void shouldCountEqualsWhenNoSame() {
            int[] a = new int[]{1, 1, 3, 2, 1};
            int[] b = new int[]{4, 5, -1, 4, 10, 22};
            Assertions.assertEquals(0, Task511.countEquals(a, b));
        }

        @Test
        public void shouldCountEqualsWhenAllSame() {
            int[] a = new int[]{1, 1, 1};
            int[] b = new int[]{1, 1, 1, 1, 1, 1, 1};
            Assertions.assertEquals(3, Task511.countEquals(a, b));
        }

        @Test
        public void shouldCountEqualsWhenLengthIsZero() {
            int[] a = new int[]{1, 1, 1};
            int[] b = new int[]{};
            Assertions.assertEquals(0, Task511.countEquals(a, b));
        }

        @Test
        public void shouldCountEqualsWhenOnlyMaxInt() {
            int[] a = new int[]{2147483647, 2147483647};
            int[] b = new int[]{2147483647, 2147483647, 2147483647};
            Assertions.assertEquals(2, Task511.countEquals(a, b));
        }

        @Test
        public void shouldCountEqualsWhenHasMaxInt() {
            int[] a = new int[]{2147483647, 0, 1073741823, 2147483647, -1073741824, -2147483648};
            int[] b = new int[]{2147483647, 2147483647, 2147483647};
            Assertions.assertEquals(2, Task511.countEquals(a, b));
        }
    }
}