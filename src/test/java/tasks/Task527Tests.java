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
    public void findComponentAllConnected() {
        ArrayList[] adjacencyList = new ArrayList[]{
                ArrayList.of(1, 2, 3, 4, 5),
                ArrayList.of(0, 2, 3, 4, 5),
                ArrayList.of(0, 1, 3, 4, 5),
                ArrayList.of(0, 2, 1, 4, 5),
                ArrayList.of(0, 1, 2, 3, 5),
                ArrayList.of(0, 1, 2, 3, 4),
        };
        boolean[] expected = new boolean[] {true, true, true, true, true, true};
        Assertions.assertArrayEquals(expected,Task527.findComponent(adjacencyList));
    }

    @Test
    public void findComponentReachableCase() {
        ArrayList[] adjacencyList = new ArrayList[]{
                ArrayList.of(1),
                ArrayList.of(0, 4),
                ArrayList.of(3),
                ArrayList.of(2, 5),
                ArrayList.of(1, 5),
                ArrayList.of(3, 4)
        };
        boolean[] expected = new boolean[] {true, true, true, true, true, true};
        Assertions.assertArrayEquals(expected,Task527.findComponent(adjacencyList));
    }


    @Test
    public void findComponentAllNotReachable() {
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

    @Test
    public void findComponentSomeNotReachable() {
        ArrayList[] adjacencyList = new ArrayList[]{
                ArrayList.of(1, 3),
                ArrayList.of(0, 4),
                ArrayList.of(5),
                ArrayList.of(0),
                ArrayList.of(1, 6, 7, 8),
                ArrayList.of(2),
                ArrayList.of(4),
                ArrayList.of(4),
                ArrayList.of(4, 9),
                ArrayList.of(8),
                ArrayList.of()
        };
        boolean[] expected = new boolean[] {true, true, false, true, true, false, true, true, true, true, false};
        Assertions.assertArrayEquals(expected,Task527.findComponent(adjacencyList));
    }
}