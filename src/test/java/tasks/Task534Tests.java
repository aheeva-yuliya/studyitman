package tasks;

import entities.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task534Tests {
    @Nested
    public class CountChildren {
        @Nested
        public class UsingStack {
            @Test
            public void shouldCountChildrenWhenSubtreeHasSomeChildren() {
                Pair[] edges = new Pair[]{
                        new Pair(1, 2),
                        new Pair(2, 4),
                        new Pair(2, 5),
                        new Pair(5, 7),
                        new Pair(5, 6),
                        new Pair(5, 9),
                        new Pair(7, 8),
                        new Pair(7, 10),
                        new Pair(10, 11),
                        new Pair(10, 12),
                        new Pair(11, 13),
                        new Pair(11, 14),
                        new Pair(14, 15)
                };
                Assertions.assertEquals(6, Task534.countChildrenInSubtree(15, edges, 10));
            }

            @Test
            public void shouldCountChildrenWhenSubtreeHasJustARoot() {
                Pair[] edges = new Pair[]{
                        new Pair(1, 2),
                        new Pair(1, 3),
                        new Pair(3, 4),
                        new Pair(3, 5)
                };
                Assertions.assertEquals(1, Task534.countChildrenInSubtree(5, edges, 5));
            }
        }

        @Nested
        public class ByRecursion {
            @Test
            public void shouldCountChildrenInSubtreeByRecursionWhenSome() {
                Pair[] pairs = new Pair[]{
                        new Pair(1, 2),
                        new Pair(1, 3),
                        new Pair(1, 13),
                        new Pair(2, 4),
                        new Pair(4, 12),
                        new Pair(4, 5),
                        new Pair(5, 6),
                        new Pair(5, 7),
                        new Pair(7, 8),
                        new Pair(8, 9),
                        new Pair(9, 10),
                };
                Assertions.assertEquals(6, Task534.countChildrenInSubtreeByRecursion(13, pairs, 5));
                Assertions.assertEquals(3, Task534.countChildrenInSubtreeByRecursion(13, pairs, 8));
                Assertions.assertEquals(8, Task534.countChildrenInSubtreeByRecursion(13, pairs, 4));
            }

            @Test
            public void shouldCountChildrenInSubtreeByRecursionWhenJustARoot() {
                Pair[] edges = new Pair[]{
                        new Pair(1, 2),
                        new Pair(1, 3),
                        new Pair(3, 4),
                        new Pair(3, 5)
                };
                Assertions.assertEquals(1, Task534.countChildrenInSubtreeByRecursion(5, edges, 5));
            }

            @Test
            public void shouldCountChildrenInSubtreeByRecursionWhenAllAreChildren() {
                Pair[] pairs = new Pair[]{
                        new Pair(1, 2),
                        new Pair(1, 3),
                        new Pair(1, 13),
                        new Pair(2, 4),
                        new Pair(4, 12),
                        new Pair(4, 5),
                        new Pair(5, 6),
                        new Pair(5, 7),
                        new Pair(7, 8),
                        new Pair(8, 9),
                        new Pair(9, 10),
                };
                Assertions.assertEquals(12, Task534.countChildrenInSubtreeByRecursion(13, pairs, 1));
            }
        }
    }
}