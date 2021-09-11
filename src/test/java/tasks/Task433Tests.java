package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task433Tests {

    @Test
    public void gcdHaveMaxDiv() {
        long a = 36;
        long b = 64;
        long expected = 4;
        long actual = Task433.gcd(a, b);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void gcdHaveMaxDivAnother() {
        long a = 975;
        long b = 10875;
        long expected = 75;
        long actual = Task433.gcd(a, b);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void gcdHaveOnlyOneDiv() {
        long a = 975986433786L;
        long b = 108758765342L;
        long expected = 2;
        long actual = Task433.gcd(a, b);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void gcdHaveOneAsADiv() {
        long a = 999999797L;
        long b = 108758765342L;
        long expected = 1;
        long actual = Task433.gcd(a, b);
        Assertions.assertEquals(expected, actual);

    }
}