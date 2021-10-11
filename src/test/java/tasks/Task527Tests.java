package tasks;

import collections.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task527Tests {

    @Test
    public void findComponentNormalCase() {
        ArrayList[] adjacencyList = new ArrayList[]{
                ArrayList.of(1, 3),
                ArrayList.of(0, 4),
                ArrayList.of(5),
                ArrayList.of(0),
                ArrayList.of(1),
                ArrayList.of(2)
        };
        boolean[] expected = new boolean[] {true, true, false, true, true, false};
        Assertions.assertArrayEquals(expected,Task527.findComponent(adjacencyList));
    }

    @Test
    public void findComponentReachableCase() {
        ArrayList[] adjacencyList = new ArrayList[]{
                ArrayList.of(1, 5),
                ArrayList.of(0),
                ArrayList.of(3),
                ArrayList.of(2, 4),
                ArrayList.of(3, 5),
                ArrayList.of(0, 4)
        };
        boolean[] expected = new boolean[] {true, true, true, true, true, true};
        Assertions.assertArrayEquals(expected,Task527.findComponent(adjacencyList));
    }

    @Test
    public void findComponentNotReachable() {
        ArrayList[] adjacencyList = new ArrayList[]{
                ArrayList.of(),
                ArrayList.of(3, 4, 5),
                ArrayList.of(5),
                ArrayList.of(1),
                ArrayList.of(1),
                ArrayList.of(2)
        };
        boolean[] expected = new boolean[] {true, false, false, false, false, false};
        Assertions.assertArrayEquals(expected,Task527.findComponent(adjacencyList));
    }
}