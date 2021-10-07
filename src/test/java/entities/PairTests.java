package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PairTests {

    @Test
    public void getLeft() {
        Pair pair = new Pair(4, 6);
        Assertions.assertEquals(4, pair.getLeft());
    }

    @Test
    public void getRight() {
        Pair pair = new Pair(4, 6);
        Assertions.assertEquals(6, pair.getRight());
    }

    @Test
    public void testToString() {
        Pair pair = new Pair(4, 6);
        String expected = "Pair{left=4, right=6}";
        Assertions.assertEquals(expected, pair.toString());
    }

    @Test
    public void testEqualsIfTrue() {
        Pair pair = new Pair(4, 6);
        Pair that = new Pair(4, 6);
        Assertions.assertTrue(pair.equals(that));
    }

    @Test
    public void testEqualsIfFalse() {
        Pair pair = new Pair(4, 6);
        Pair that = new Pair(6, 4);
        Assertions.assertFalse(pair.equals(that));
    }
}