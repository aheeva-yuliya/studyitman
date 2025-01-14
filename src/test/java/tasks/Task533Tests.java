package tasks;

import entities.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task533Tests {
    @Nested
    public class CountComponents {
        @Test
        public void shouldCountComponentsWhenOneBranchWithOneSeparateVertex() {
            Pair[] pairs = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(3, 4),
                    new Pair(3, 6)
            };
            Assertions.assertEquals(2, Task533.countComponents(6, pairs));
            Assertions.assertEquals(2, Task533.countComponentsByRecursion(6, pairs));
        }

        @Test
        public void shouldCountComponentsWhenOneSmallBranch() {
            Pair[] pairs = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(3, 4),
                    new Pair(3, 6),
                    new Pair(4, 5)
            };
            Assertions.assertEquals(1, Task533.countComponents(6, pairs));
            Assertions.assertEquals(1, Task533.countComponentsByRecursion(6, pairs));

        }

        @Test
        public void shouldCountComponentsWhenOneLongBranch() {
            Pair[] pairs = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(3, 4),
                    new Pair(3, 6),
                    new Pair(4, 7),
                    new Pair(4, 9),
                    new Pair(7, 8),

            };
            Assertions.assertEquals(2, Task533.countComponents(9, pairs));
            Assertions.assertEquals(2, Task533.countComponentsByRecursion(9, pairs));

        }

        @Test
        public void shouldCountComponentsWhenOneLongOneSmallAndSeparateVertices() {
            Pair[] pairs = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(3, 7),
                    new Pair(2, 4),
                    new Pair(2, 5),
                    new Pair(4, 6),
                    new Pair(8, 9),
            };
            Assertions.assertEquals(5, Task533.countComponents(12, pairs));
            Assertions.assertEquals(5, Task533.countComponentsByRecursion(12, pairs));
        }
    }
}