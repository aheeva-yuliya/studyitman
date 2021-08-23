package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task432Tests {

    @Test
    public void calcprimeNumbersNormalCase() {
        long x = 120;
        long[] expected = new long[] {2, 3, 5,};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcprimeNumbersPrimeCase() {
        long x = 121;
        long[] expected = new long[] {11};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcprimeNumbers1() {
        long x = 1;
        long[] expected = new long[0];
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcprimeNumbers2() {
        long x = 2;
        long[] expected = new long[] {2};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcprimeNumbersprimelessthanhundred() {
        long x = 67;
        long[] expected = new long[] {67};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcprimeNumberprime() {
        long x = 967;
        long[] expected = new long[] {967};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcprimeNumbermorethanhundred() {
        long x = 968;
        long[] expected = new long[] {2, 11};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcprimeNumberlong() {
        long x = 1000000000000000L;
        long[] expected = new long[] {2, 5};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcprimeNumberLongnotPrime() {
        long x = 987654321000009L;
        long[] expected = new long[] {3, 13, 1506287, 1868057};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcprimeNumberLongnotPrime2() {
        long x = 99999999999999L;
        long[] expected = new long[] {3, 11, 239, 4649, 909091};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcprimeNumberLongnotPrime3() {
        long x = 68532987640817L;
        long[] expected = new long[] {7, 29, 92623, 520699};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcPrimeNumberlong_999999797() {
        long x = 999999797L;
        long[] expected = new long[] {999999797};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcPrimeNumberlong_39601() {
        long x = 39601;
        long[] expected = new long[] {199};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcPrimeNumberlong_304250263527210() {
        long x = 304250263527210L;
        long[] expected = new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcPrimeNumberlong_70368760954879x2() {
        long x = 70368760954879L * 2;
        long[] expected = new long[] {2, 70368760954879L};
        long[] actual = Task432.calcPrimeNumbers(x);
        Assertions.assertArrayEquals(expected, actual);
    }
}