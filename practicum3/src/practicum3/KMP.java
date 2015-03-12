package practicum3;

/**
 *
 * @authors guus_portegies && koen_karsten
 */
public class KMP {

    private int[][] dfa;
    private int matches;
    private int comparisons;
    final private String haystack;
    private String needle;

    public KMP(String haystack) {
        this.haystack = haystack;
    }

    public int search(int position) {
        int i, j, N = haystack.length(), M = needle.length();
        for (i = position, j = 0; i < N && j < M; i++) {
            comparisons++;
            j = dfa[haystack.charAt(i)][j];
        }
        if (j == M) {
            return i - M; // found (hit end of pattern)
        } else {
            return N; // not found (hit end of text)
        }
    }

    public int searchForWord(String word) {
        this.matches = 0;
        this.comparisons = 0;
        this.needle = word;

        int M = needle.length();
        int R = haystack.length();

        dfa = new int[R][M];
        dfa[needle.charAt(0)][0] = 1;

        for (int X = 0, j = 1; j < M; j++) {  // Compute dfa[][j].
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[needle.charAt(j)][j] = j + 1;
            X = dfa[needle.charAt(j)][X];

        }

        int position = 0;
        for (int i = 0; i < haystack.length(); i++) {
            position = search(position + 1);
            if (position >= haystack.length()) {
                return this.matches;
            } else {
                matches++;
            }
        }

        return this.matches;
    }

    public int getMatches() {
        return this.matches;
    }

    public int getComparisons() {
        return this.comparisons;
    }
}
