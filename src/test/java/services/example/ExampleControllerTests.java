package services.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ExampleControllerTests {
    @Nested
    public class GetMapping {
        @Test
        public void shouldReturnStringWhenMapping() {
            ExampleController controller = new ExampleController();
            String expected = "I'm your first web-service";
            String actual = controller.index();
            Assertions.assertEquals(expected,actual);
        }

        @Test
        public void shouldReturnStringWhenMappingSecond() {
            ExampleController controller = new ExampleController();
            String expected = "I'm the second binding";
            String actual = controller.secondIndex();
            Assertions.assertEquals(expected,actual);
        }
    }
}