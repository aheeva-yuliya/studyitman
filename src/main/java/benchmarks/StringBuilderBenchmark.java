package benchmarks;

/**
 * StringBuilderBenchmark.
 */
public class StringBuilderBenchmark {
    /**
     * Concatenates strings using operator "+".
     *
     * @cpu O(n^2)
     * @ram O(n)
     *
     * @param n int argument
     * @return a concatenated String.
     */
    public static String concatenateUsingOperator(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += " " + i % 10;
        }
        return result;
    }

    /**
     * Concatenates strings using StringBuilder.
     *
     * @cpu O(n)
     * @ram O(n)
     *
     * @param n int argument
     * @return a concatenated String.
     */
    public static String concatenateUsingStringBuilder(int n) {
        StringBuilder stringBuilder = new StringBuilder(1);
        for (int i = 0; i < n; i++) {
            stringBuilder.append(" " + i % 10);
        }
        return stringBuilder.toString();
    }

    /**
     * Main.
     *
     * @param args String[] arguments
     *
     * concatenateUsingOperator 411,95 s
     * concatenateUsingStringBuilder 0,13 s
     */
    public static void main(String[] args) {
        long x1 = System.currentTimeMillis();
        concatenateUsingOperator(500000);
        long x2 = System.currentTimeMillis();
        System.out.println((x2 - x1) / 1000.0);
        long y1 = System.currentTimeMillis();
        concatenateUsingStringBuilder(500000);
        long y2 = System.currentTimeMillis();
        System.out.println((y2 - y1) / 1000.0);
    }
}
