package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ExampleTests {
    @Nested
    public class Sum {
        @Test
        public void shouldReturnPositiveWhenSumPositive() {
            Assertions.assertEquals(15, Example.sum(5, 10));
        }

        @Test
        public void shouldReturnNegativeWhenSumNegative() {
            Assertions.assertEquals(-10, Example.sum(-7, -3));
        }
    }
}
