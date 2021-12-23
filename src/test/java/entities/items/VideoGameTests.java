package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class VideoGameTests {
    @Nested
    public class GetPlatformTest {
        @Test
        public void shouldReturnValueOfPlatformWhenCalled() {
            final VideoGame videoGame = new VideoGame(1, "title", 10, 4, 30, "platform");
            Assertions.assertEquals("platform", videoGame.getPlatform());
        }
    }

    @Nested
    public class ToStringTest {
        @Test
        public void shouldReturnStringWhenFieldsHasNotDefaultValues() {
            final VideoGame videoGame = new VideoGame(1, "title", 10, 4, 30, "pl");
            final String expected =
                    "VideoGame{Game{Item{id=1, title='title', price=10}, playersMin=4, playersMax=30}, platform='pl'}";
            final String actual = videoGame.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class EqualsTests {
        @Test
        public void shouldReturnTrueWhenAllFieldsTheSame() {
            final VideoGame game1 = new VideoGame(1, "title", 10, 3, 30, "a");
            final VideoGame game2 = new VideoGame(1, "title", 10, 3, 30, "a");
            Assertions.assertTrue(game1.equals(game2));
        }

        @Test
        public void shouldReturnFalseWhenFieldsDifferent() {
            final VideoGame game1 = new VideoGame(1, "title", 10, 3, 30, "a");
            final VideoGame game2 = new VideoGame(1, "t", 10, 3, 30, "a");
            Assertions.assertFalse(game1.equals(game2));
        }

        @Test
        public void shouldReturnFalseWhenThatIsNull() {
            final VideoGame game1 = new VideoGame(1, "title", 10, 3, 30, "a");
            Assertions.assertFalse(game1.equals(null));
        }
    }
}