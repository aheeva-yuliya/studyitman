package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PairTests {
    @Nested
    public class Get {
        @Test
        public void shouldGetWhenTryGetLeft() {
            Pair pair = new Pair(4, 6);
            Assertions.assertEquals(4, pair.getLeft());
        }

        @Test
        public void shouldGetWhenTryGetRight() {
            Pair pair = new Pair(4, 6);
            Assertions.assertEquals(6, pair.getRight());
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenHasPair() {
            Pair pair = new Pair(4, 6);
            String expected = "Pair{left=4, right=6}";
            Assertions.assertEquals(expected, pair.toString());
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenPairsEqual() {
            Pair pair = new Pair(4, 6);
            Pair that = new Pair(4, 6);
            Assertions.assertTrue(pair.equals(that));
        }

        @Test
        public void shouldReturnFalseWhenPairsNotEqual() {
            Pair pair = new Pair(4, 6);
            Pair that = new Pair(6, 4);
            Assertions.assertFalse(pair.equals(that));
        }
    }
}