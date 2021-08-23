package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task433Tests {

    @Test
    public void gcd_36_64() {
        long a = 36;
        long b = 64;
        long expected = 4;
        long actual = Task433.gcd(a, b);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void gcd_975_10875() {
        long a = 975;
        long b = 10875;
        long expected = 75;
        long actual = Task433.gcd(a, b);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void gcd_975986433786_10875() {
        long a = 975986433786L;
        long b = 108758765342L;
        long expected = 2;
        long actual = Task433.gcd(a, b);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void gcd_999999797_108758765342() {
        long a = 999999797L;
        long b = 108758765342L;
        long expected = 1;
        long actual = Task433.gcd(a, b);
        Assertions.assertEquals(expected, actual);

    }
}