package tasks;

import entities.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task544Tests {

    @Test
    public void findHeightTwoBranches() {
        Pair[] pairs = new Pair[] {
                new Pair(1,2),
                new Pair(1, 3),
                new Pair(3, 4),
                new Pair(4, 5),
                new Pair(5, 6),
                new Pair(5, 7),
                new Pair(7, 8),
                new Pair(8, 9),
                new Pair(9, 10),
        };
        Assertions.assertEquals(8, Task544.findHeight(10, pairs));
    }

    @Test
    public void findHeightOneLongAndTwoShortBranches() {
        Pair[] pairs = new Pair[] {
                new Pair(1,2),
                new Pair(1, 3),
                new Pair(1, 13),
                new Pair(2, 4),
                new Pair(4, 12),
                new Pair(3, 11),
                new Pair(4, 5),
                new Pair(5, 6),
                new Pair(5, 7),
                new Pair(7, 8),
                new Pair(8, 9),
                new Pair(9, 10),
        };
        Assertions.assertEquals(8, Task544.findHeight(13, pairs));
    }

    @Test
    public void findHeightManyBranches() {
        Pair[] pairs = new Pair[] {
                new Pair(1,2),
                new Pair(2, 3),
                new Pair(1, 13),
                new Pair(2, 4),
                new Pair(4, 12),
                new Pair(3, 11),
                new Pair(4, 5),
                new Pair(5, 6),
                new Pair(5, 7),
                new Pair(7, 8),
                new Pair(8, 9),
                new Pair(9, 10),
        };
        Assertions.assertEquals(8, Task544.findHeight(17, pairs));
    }
}