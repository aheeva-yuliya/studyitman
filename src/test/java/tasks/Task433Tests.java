package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task433Tests {
    @Nested
    public class GreatestCommonDivisor {
        @Test
        public void shouldFindGcdWhenHaveMaxDiv() {
            long a = 36;
            long b = 64;
            long expected = 4;
            long actual = Task433.gcd(a, b);
            Assertions.assertEquals(expected, actual);

        }

        @Test
        public void shouldFindGcdWhenHaveOnlyOneDiv() {
            long a = 975986433786L;
            long b = 108758765342L;
            long expected = 2;
            long actual = Task433.gcd(a, b);
            Assertions.assertEquals(expected, actual);

        }

        @Test
        public void shouldFingGcdWhenHaveOneAsADiv() {
            long a = 999999797L;
            long b = 108758765342L;
            long expected = 1;
            long actual = Task433.gcd(a, b);
            Assertions.assertEquals(expected, actual);

        }
    }
}