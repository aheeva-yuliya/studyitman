package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task579Tests {
    @Nested
    public class DrawWay {
        @Test
        public void shouldDrawMinimumDistanceWayWhenSomeWays() {
            final char[][] map = new char[][]{
                    {'.', '.', '.', '.', '.', '.', '.', 'f', 'x'},
                    {'.', 'x', 'x', '.', 'x', 'x', 'x', 'x', 'x'},
                    {'.', 'x', '.', '.', 'x', '.', 'x', 's', '.'},
                    {'.', '.', '.', 'x', 'x', '.', 'x', 'x', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
            };
            Task579.drawWay(map);
            final char[][] expected = new char[][] {
                    {'.', '.', '.', '*', '*', '*', '*', '*', 'x'},
                    {'.', 'x', 'x', '*', 'x', 'x', 'x', 'x', 'x'},
                    {'.', 'x', '*', '*', 'x', '.', 'x', '*', '*'},
                    {'.', '.', '*', 'x', 'x', '.', 'x', 'x', '*'},
                    {'.', '.', '*', '*', '*', '*', '*', '*', '*'}
            };
            final int row = expected.length;
            final int col = expected[0].length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    Assertions.assertEquals(expected[i][j], map[i][j]);
                }
            }
        }

        @Test
        public void shouldDrawMinimumDistanceWayWhenEntranceNextToExist() {
            final char[][] map = new char[][]{
                    {'.', '.', '.', '.', '.', '.', '.', '.', 'x'},
                    {'.', 'x', 'x', '.', 'x', 'x', 'x', '.', 'x'},
                    {'.', 'x', '.', '.', 'x', '.', 'x', 's', 'f'},
                    {'.', '.', '.', 'x', 'x', '.', 'x', 'x', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
            };
            Task579.drawWay(map);
            final char[][] expected = new char[][] {
                    {'.', '.', '.', '.', '.', '.', '.', '.', 'x'},
                    {'.', 'x', 'x', '.', 'x', 'x', 'x', '.', 'x'},
                    {'.', 'x', '.', '.', 'x', '.', 'x', '*', '*'},
                    {'.', '.', '.', 'x', 'x', '.', 'x', 'x', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
            };
            final int row = expected.length;
            final int col = expected[0].length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    Assertions.assertEquals(expected[i][j], map[i][j]);
                }
            }
        }
    }
}