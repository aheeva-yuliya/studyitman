package benchmarks;

import collections.ArrayList;
import collections.IntArrayList;
import collections.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ListBenchmarkTests {
    @Nested
    public class CreateTests {
        @Test
        public void shouldCreateIntArrayListWhenTryCreateWithCapacity() {
            IntArrayList array = ListBenchmark.createIntArrayListWithCapacity(10);
            int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            Assertions.assertArrayEquals(expected, array.toArray());
        }

        @Test
        public void shouldCreateIntArrayListWhenTryCreateWithDefaultConstructor() {
            IntArrayList array = ListBenchmark.createIntArrayList(10);
            int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            Assertions.assertArrayEquals(expected, array.toArray());
        }

        @Test
        public void shouldCreateLinkedListWhenTryCreateWithDefaultConstructor() {
            LinkedList list = ListBenchmark.createLinkedList(10);
            int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            Assertions.assertArrayEquals(expected, list.toArray());
        }

        @Test
        public void shouldCreateArrayListWhenTryCreateWithDefaultConstructor() {
            ArrayList array = ListBenchmark.createArrayList(10);
            Object[] expected = new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            Assertions.assertArrayEquals(expected, array.toArray());
        }
    }
}