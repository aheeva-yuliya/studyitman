package tasks;

import collections.ArrayList;
import entities.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task532Tests {
    @Nested
    public class ChainByDfs {
        @Test
        public void shouldReturnTrueWhenExistsChain() {
            Pair[] acquaintances = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(3, 4),
                    new Pair(3, 5)
            };
            Assertions.assertTrue(Task532.existsChain(5, acquaintances, 1, 5));
            Assertions.assertTrue(Task532.existsChain(5, acquaintances, 3, 5));
        }

        @Test
        public void shouldReturnTrueWhenExistsAndFalseWhenDoesNot() {
            Pair[] acquaintances = new Pair[]{
                    new Pair(0, 3),
                    new Pair(0, 1),
                    new Pair(1, 4),
                    new Pair(4, 5),
                    new Pair(4, 6),
                    new Pair(4, 7),
                    new Pair(2, 8),
                    new Pair(7, 11),
                    new Pair(11, 12),
                    new Pair(12, 9),
            };
            Assertions.assertTrue(Task532.existsChain(13, acquaintances, 4, 12));
            Assertions.assertFalse(Task532.existsChain(13, acquaintances, 11, 10));
        }

        @Test
        public void shouldReturnFalseWhenNoChain() {
            Pair[] acquaintances = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(3, 4),
                    new Pair(3, 5)
            };
            Assertions.assertFalse(Task532.existsChain(5, acquaintances, 3, 2));
            Assertions.assertFalse(Task532.existsChain(5, acquaintances, 5, 1));
        }
    }

    @Nested
    public class ChainByBfs {
        @Test
        public void shouldReturnTrueWhenTryFindFromOneToSeven() {
            Pair[] acquaintances = new Pair[]{
                    new Pair(1, 3),
                    new Pair(1, 2),
                    new Pair(3, 4),
                    new Pair(3, 5),
                    new Pair(5, 6),
                    new Pair(5, 7),
                    new Pair(1, 8),
                    new Pair(8, 9)
            };
            Assertions.assertTrue(Task532.existsChainByBfs(9, acquaintances, 1, 7));
        }

        @Test
        public void shouldReturnFalseWhenNoChain() {
            Pair[] acquaintances = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(3, 4),
                    new Pair(3, 5)
            };
            Assertions.assertFalse(Task532.existsChainByBfs(5, acquaintances, 3, 2));
        }
    }

    @Nested
    public class FindMinChainLengthByVisits {
        @Test
        public void shouldReturnTwoWhenFromIsOneAndToIsFive() {
            Pair[] acquaintances = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(3, 4),
                    new Pair(3, 5),
            };
            Assertions.assertEquals(2, Task532.findMinChainLengthByVisits(5, acquaintances, 1, 5));
        }

        @Test
        public void shouldFindMinLengthWhenSomePeopleKnowTo() {
            Pair[] acquaintances = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(1, 6),
                    new Pair(3, 4),
                    new Pair(3, 5),
                    new Pair(3, 6),
                    new Pair (5, 6)
            };
            Assertions.assertEquals(1, Task532.findMinChainLengthByVisits(6, acquaintances, 1, 6));
        }

        @Test
        public void shouldReturnMinusOneWhenFromIsFiveAndToIsOne() {
            Pair[] acquaintances = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(3, 4),
                    new Pair(3, 5),
            };
            Assertions.assertEquals(-1, Task532.findMinChainLengthByVisits(5, acquaintances, 5, 1));
        }
    }

    @Nested
    public class FindMinChainLengthByQueue {
        @Test
        public void shouldReturnArrayWhenChainExists() {
            Pair[] acquaintances = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(3, 4),
                    new Pair(3, 5),
            };
            ArrayList expected = ArrayList.of(1, 3, 4);
            ArrayList actual = Task532.findMinChainLengthByQueue(5, acquaintances, 1, 4);
            Assertions.assertTrue(expected.equals(actual));
        }

        @Test
        public void shouldFindMinChainWhenSomePeopleKnowTo() {
            Pair[] acquaintances = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(1, 6),
                    new Pair(3, 4),
                    new Pair(3, 5),
                    new Pair(3, 6),
                    new Pair (5, 6)
            };
            ArrayList expected = ArrayList.of(1, 6);
            ArrayList actual = Task532.findMinChainLengthByQueue(6, acquaintances, 1, 6);
            Assertions.assertTrue(expected.equals(actual));
        }

        @Test
        public void shouldReturnNullWhenFromNotKnowTo() {
            Pair[] acquaintances = new Pair[]{
                    new Pair(1, 2),
                    new Pair(1, 3),
                    new Pair(3, 4),
                    new Pair(3, 5),
            };
            Assertions.assertNull(Task532.findMinChainLengthByQueue(5, acquaintances, 5, 1));
        }

        @Test
        public void shouldReturnMinDistanceChainWhenCycleGraph() {
            Pair[] acquaintances = new Pair[]{
                    new Pair(1, 2),
                    new Pair(2, 1),
                    new Pair(2, 3),
                    new Pair(3, 2),
                    new Pair(3, 4),
                    new Pair(4, 3),
                    new Pair(4, 5),
                    new Pair(5, 4),
                    new Pair(5, 6),
                    new Pair(6, 5),
                    new Pair(6, 7),
                    new Pair(7, 6),
                    new Pair(1, 7),
                    new Pair(7, 1)
            };
            ArrayList expected = ArrayList.of(1, 7, 6, 5);
            ArrayList actual = Task532.findMinChainLengthByQueue(7, acquaintances, 1, 5);
            Assertions.assertTrue(expected.equals(actual));
        }
    }
}