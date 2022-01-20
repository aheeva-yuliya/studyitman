package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BoardGameTests {
    @Nested
    public class GetTimeMinTest {
        @Test
        public void shouldReturnValueOfTimeMinWhenCalled() {
            final BoardGame boardGame = new BoardGame(1, "title", 10, 4, 30, 10, 60);
            Assertions.assertEquals(10, boardGame.getTimeMin());
        }
    }

    @Nested
    public class GetTimeMaxTest {
        @Test
        public void shouldReturnValueOfTimeMaxWhenCalled() {
            final BoardGame boardGame = new BoardGame(1, "title", 10, 4, 30, 10, 60);
            Assertions.assertEquals(60, boardGame.getTimeMax());
        }
    }

    @Nested
    public class ToStringTest {
        @Test
        public void shouldReturnStringWhenFieldsHasNotDefaultValues() {
            final BoardGame boardGame = new BoardGame(1, "t", 5, 4, 9, 1, 6);
            final String expected =
                    "BoardGame{Game{Item{id=1, title='t', price=5}, playersMin=4, playersMax=9}, timeMin=1, timeMax=6}";
            final String actual = boardGame.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class EqualsTests {
        @Test
        public void shouldReturnTrueWhenAllFieldsTheSame() {
            final BoardGame game1 = new BoardGame(1, "title", 10, 3, 30, 10, 90);
            final BoardGame game2 = new BoardGame(1, "title", 10, 3, 30, 10, 90);
            Assertions.assertEquals(game1, game2);
        }

        @Test
        public void shouldReturnFalseWhenFieldsDifferent() {
            final BoardGame game1 = new BoardGame(1, "title", 10, 3, 30, 10, 70);
            final BoardGame game2 = new BoardGame(1, "title", 10, 3, 30, 10, 90);
            Assertions.assertNotEquals(game1, game2);
        }

        @Test
        public void shouldReturnFalseWhenThatIsNull() {
            final BoardGame game1 = new BoardGame(1, "title", 10, 3, 30, 10, 90);
            Assertions.assertNotEquals(null, game1);
        }
    }
}
