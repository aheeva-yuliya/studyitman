package benchmarks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderBenchmarkTests {

    @Test
    public void concatenateUsingOperator() {
        String actual = StringBuilderBenchmark.concatenateUsingOperator(50);
        Assertions.assertEquals(100, actual.length());
    }

    @Test
    public void concatenateUsingOperatorStringCheck() {
        String actual = StringBuilderBenchmark.concatenateUsingOperator(6);
        Assertions.assertEquals(" 0 1 2 3 4 5", actual.toString());
    }

    @Test
    public void concatenateUsingStringBuilder() {
        String actual = StringBuilderBenchmark.concatenateUsingStringBuilder(500000);
        Assertions.assertEquals(1000000, actual.length());
    }

    @Test
    public void concatenateUsingStringBuilderStringCheck() {
        String actual = StringBuilderBenchmark.concatenateUsingStringBuilder(6);
        Assertions.assertEquals(" 0 1 2 3 4 5", actual.toString());
    }
}