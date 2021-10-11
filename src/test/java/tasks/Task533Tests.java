package tasks;

import entities.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task533Tests {

    @Test
    public void countComponentsOneBranchWithOneSeparateVertex() {
        Pair[] pairs = new Pair[] {
                new Pair(1,2),
                new Pair(1, 3),
                new Pair(3, 4),
                new Pair(3, 6)
        };
        Assertions.assertEquals(2,Task533.countComponents(6, pairs));
    }

    @Test
    public void countComponentsOneBranch() {
        Pair[] pairs = new Pair[] {
                new Pair(1,2),
                new Pair(1, 3),
                new Pair(3, 4),
                new Pair(3, 6),
                new Pair(4, 5)
        };
        Assertions.assertEquals(3,Task533.countComponents(6, pairs));
    }

    @Test
    public void countComponentsOneLongAndOneSmall() {
        Pair[] pairs = new Pair[] {
                new Pair(1,2),
                new Pair(1,3),
                new Pair(3,7),
                new Pair(2, 4),
                new Pair(2, 5),
                new Pair(4, 6),
                new Pair(8, 9),
        };
        Assertions.assertEquals(3,Task533.countComponents(9, pairs));
    }
}