package benchmarks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderBenchmarkTests {

    @Test
    public void concatenateUsingOperator() {
        String actual = StringBuilderBenchmark.concatenateUsingOperator(500000);
        Assertions.assertEquals(1000000, actual.length());
    }

    @Test
    public void concatenateUsingStringBuilder() {
        String actual = StringBuilderBenchmark.concatenateUsingStringBuilder(500000);
        Assertions.assertEquals(1000000, actual.length());
    }
}