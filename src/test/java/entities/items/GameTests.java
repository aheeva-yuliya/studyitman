package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GameTests {
    @Nested
    public class GetPlayersMinTest {
        @Test
        public void shouldReturnValueOfPlayersMinWhenCalled() {
            final Game game = new Game(1, "title", 10, 4, 30);
            Assertions.assertEquals(4, game.getPlayersMin());
        }
    }

    @Nested
    public class GetPlayersMaxTest {
        @Test
        public void shouldReturnValueOfPlayersMaxWhenCalled() {
            final Game game = new Game(1, "title", 10, 4, 30);
            Assertions.assertEquals(30, game.getPlayersMax());
        }
    }

    @Nested
    public class ToStringTest {
        @Test
        public void shouldReturnStringWhenFieldsHasNotDefaultValues() {
            final Game game = new Game(1, "title", 10, 4, 30);
            final String expected = "Game{Item{id=1, title='title', price=10}, playersMin=4, playersMax=30}";
            final String actual = game.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class EqualsTests {
        @Test
        public void shouldReturnTrueWhenAllFieldsTheSame() {
            final Game game1 = new Game(1, "title", 10, 3, 30);
            final Game game2 = new Game(1, "title", 10, 3, 30);
            Assertions.assertTrue(game1.equals(game2));
        }

        @Test
        public void shouldReturnFalseWhenFieldsDifferent() {
            final Game game1 = new Game(1, "title", 10, 3, 30);
            final Game game2 = new Game(1, "title", 10, 4, 30);
            Assertions.assertFalse(game1.equals(game2));
        }

        @Test
        public void shouldReturnFalseWhenThatIsNull() {
            final Game game1 = new Game(1, "title", 10, 3, 30);
            Assertions.assertFalse(game1.equals(null));
        }
    }
}