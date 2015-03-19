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
        this.haystack = haystack; // Set the haystak for future reference
    }

    public int search(int position) {
        int i, j, N = haystack.length(), M = needle.length();
        for (i = position, j = 0; i < N && j < M; i++) {
            comparisons++; // Increment the amount of comparisons
            j = dfa[haystack.charAt(i)][j];
        }
        if (j == M) {
            return i - M; // found (hit end of pattern)
        } else {
            return N; // not found (hit end of text)
        }
    }

    public int searchForWord(String word) {
        // Step 1: Initialize some default values for future use
        this.matches = 0;
        this.comparisons = 0;
        this.needle = word; // The word were looking for
        int M = needle.length(); // Used for detecting end of needle (succes)
        int R = haystack.length(); // Used for detecting haystack end (failure)

        // Step 2: Initialize and alter dfa Array for use in Search() method  
        dfa = new int[R][M];
        dfa[needle.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {  // Compute dfa[][j].
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[needle.charAt(j)][j] = j + 1;
            X = dfa[needle.charAt(j)][X];

        }

        // Step 3: Start looking for the substring by looping the haystack
        int position = 0;
        for (int i = 0; i < haystack.length(); i++) {
            position = search(position + 1);
            if (position >= haystack.length()) {
                return this.getMatches();
            } else {
                matches++;
            }
        }

        // Return the amount of matches
        return this.getMatches();
    }

    // Return the amount of matches
    public int getMatches() {
        return this.matches;
    }

    // REturn the amount of comparisons
    public int getComparisons() {
        return this.comparisons;
    }
}
