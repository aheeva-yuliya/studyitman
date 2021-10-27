package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task432Tests {
    @Nested
    public class CalcPrimeNumbers {
        @Test
        public void shouldCalcPrimeNumbersWhenNumberHasSome() {
            long x = 120;
            long[] expected = new long[]{2, 3, 5,};
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCalcPrimeNumbersWhenHasOnePrime() {
            long x = 121;
            long[] expected = new long[]{11};
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCalcPrimeNumbersWhenItsOne() {
            long x = 1;
            long[] expected = new long[0];
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCalcPrimeNumbersWhenItsTwo() {
            long x = 2;
            long[] expected = new long[]{2};
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCalcPrimeNumbersWhenPrimeLessThanHundred() {
            long x = 67;
            long[] expected = new long[]{67};
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCalcPrimeNumbersWhenItsPrime() {
            long x = 967;
            long[] expected = new long[]{967};
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCalcPrimeNumbersWhenItsMoreThanHundred() {
            long x = 968;
            long[] expected = new long[]{2, 11};
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCalcPrimeNumbersWhenItsLong() {
            long x = 1000000000000000L;
            long[] expected = new long[]{2, 5};
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCalcPrimeNumbersWhenItsLongNotPrime() {
            long x = 987654321000009L;
            long[] expected = new long[]{3, 13, 1506287, 1868057};
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCalcPrimeNumberWhenItsLongAndPrime() {
            long x = 999999797L;
            long[] expected = new long[]{999999797};
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCalcPrimeNumberWhenItsSquareOfNumber() {
            long x = 39601;
            long[] expected = new long[]{199};
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCalcPrimeNumberWhenLongWithMaximumDivs() {
            long x = 304250263527210L;
            long[] expected = new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldCalcPrimeNumberWhenLongWithTwoDivs() {
            long x = 70368760954879L * 2;
            long[] expected = new long[]{2, 70368760954879L};
            long[] actual = Task432.calcPrimeNumbers(x);
            Assertions.assertArrayEquals(expected, actual);
        }
    }
}