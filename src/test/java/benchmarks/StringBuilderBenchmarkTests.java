package benchmarks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;



public class StringBuilderBenchmarkTests {
    @Nested
    public class Concatenate {
        @Test
        public void shouldConcatenateWhenTryConcatenateUsingOperator() {
            String actual = StringBuilderBenchmark.concatenateUsingOperator(50);
            Assertions.assertEquals(100, actual.length());
        }

        @Test
        public void shouldConcatenateAndCheckStringWhenTryConcatenateUsingOperator() {
            String actual = StringBuilderBenchmark.concatenateUsingOperator(6);
            Assertions.assertEquals(" 0 1 2 3 4 5", actual);
        }

        @Test
        public void shouldConcatenateWhenTryConcatenateUsingStringBuilder() {
            String actual = StringBuilderBenchmark.concatenateUsingStringBuilder(50);
            Assertions.assertEquals(100, actual.length());
        }

        @Test
        public void shouldConcatenateAndCheckStringWhenTryConcatenateUsingStringBuilder() {
            String actual = StringBuilderBenchmark.concatenateUsingStringBuilder(6);
            Assertions.assertEquals(" 0 1 2 3 4 5", actual);
        }
    }
}