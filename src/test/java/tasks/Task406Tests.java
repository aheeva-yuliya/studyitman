package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task406Tests {
    @Nested
    public class FindSecondMax {
        @Test
        public void shouldFindSecondMaxWhenMinAtFirstIndex() {
            int[] a = new int[]{10, 3, 7, 1, 20, 4, 2, 7, 5};
            int actual = Task406.findSecondMax(a);
            Assertions.assertEquals(10, actual);
        }

        @Test
        public void shouldFindSecondMaxWhenSome() {
            int[] a = new int[]{1, 4, 10, 8, 5, 10, 20, 6, 9};
            int actual = Task406.findSecondMax(a);
            Assertions.assertEquals(10, actual);
        }

        @Test
        public void shouldFindSecondMaxWhenTwoSame() {
            int[] a = new int[]{10, 10};
            int actual = Task406.findSecondMax(a);
            Assertions.assertEquals(10, actual);
        }
    }
}
