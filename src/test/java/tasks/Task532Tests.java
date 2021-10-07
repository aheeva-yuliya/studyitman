package tasks;

import entities.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task532Tests {

    @Test
    public void existsChainIfYes() {
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
    public void existsChainIfNo() {
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