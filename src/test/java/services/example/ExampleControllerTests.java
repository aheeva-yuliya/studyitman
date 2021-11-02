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
            String actual = controller.second();
            Assertions.assertEquals(expected,actual);
        }
    }

    @Nested
    public class Annotations {
        @Test
        public void shouldReturnStringWhenMappingSecondPost() {
            ExampleController controller = new ExampleController();
            String expected = "I'm post mapping";
            String actual = controller.secondPost();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnStringWhenMappingSecondPut() {
            ExampleController controller = new ExampleController();
            String expected = "I'm put mapping";
            String actual = controller.secondPut();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnStringWhenMappingSecondPatch() {
            ExampleController controller = new ExampleController();
            String expected = "I'm patch mapping";
            String actual = controller.secondPatch();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnStringWhenSecondDelete() {
            ExampleController controller = new ExampleController();
            String expected = "I'm delete mapping";
            String actual = controller.secondDelete();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Extract {
        @Test
        public void shouldExtractWhenTry() {
            ExampleController controller = new ExampleController();
        }
    }
}