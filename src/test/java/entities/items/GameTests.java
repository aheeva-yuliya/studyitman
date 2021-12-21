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
}