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
            final VideoGame videoGame = new VideoGame(1, "title", 10, 4, 30, "plat");
            final String expected =
                    "VideoGame{Game{Item{id=1, title='title', price=10}, playersMin=4, playersMax=30}, platform=plat}";
            final String actual = videoGame.toString();
            Assertions.assertEquals(expected, actual);
        }
    }
}