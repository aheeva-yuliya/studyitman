package benchmarks;

/**
 * StringBuilderBenchmark
 */
public class StringBuilderBenchmark {
    /**
     * Concatenates strings using operator "+".
     *
     * @cpu O()
     * @ram O()
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
     * @cpu O()
     * @ram O()
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
     * concatenateUsingOperator 411,95 s
     * concatenateUsingStringBuilder 0,13 s
     */
    public static void main(String[] args) {
        concatenateUsingOperator(500000);
        concatenateUsingStringBuilder(500000);
    }
}
