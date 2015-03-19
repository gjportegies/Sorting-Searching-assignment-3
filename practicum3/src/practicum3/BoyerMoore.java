package practicum3;

/**
 *
 * @authors guus_portegies && koen_karsten
 */
public class BoyerMoore {
    final private String haystack;
    final private int[] right;
    private String needle;
    
    private int matches = 0;
    private int comparisons = 0;
    

    
    BoyerMoore(String haystack) {
        // Set haystack for future usage
        this.haystack = haystack;
        // Compute the amount of chars to skip after any mismatch
        right = new int[haystack.length()];
    }

    private int search(int position) {  // Search for pattern in txt.
        int N = this.haystack.length(); // Used for detecting haystack end (failure)
        int M = needle.length(); // Used for detecting end of needle (succes)
        int skip;
        for (int i = position; i <= N - M; i += skip) {  // Does the pattern match the text at position i ?
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (needle.charAt(j) != this.haystack.charAt(i + j)) {
                    skip = j - right[this.haystack.charAt(i + j)];
                    if (skip < 1) {
                        skip = 1;
                    }
                    break;
                }
            }
            if (skip == 0) {
                matches++;
                return i; // found (hit end of pattern)
            }
            comparisons++;
        }
        return N; // not found
    }

    public int searchForWord(String word) {
        // Step 1: Initialize some default values for future use
        this.matches = 0;
        this.comparisons = 0;
        this.needle = word; // The word were looking for
        int M = needle.length(); // Used for detecting end of needle (succes)
        int R = haystack.length(); // Used for detecting haystack end (failure)
        
        // Step 2: Initialize and alter the right Array for use in search()  
        for (int c = 0; c < R; c++) { right[c] = -1; }
        for (int j = 0; j < M; j++) { right[needle.charAt(j)] = j; }
        
        // Step 3: Start looking for the substring by looping the haystack
        int position = 0;
        for (int i = 0; i < haystack.length(); i++) {
            position = search(position + 1);
            if (position >= haystack.length()) {
                return this.getMatches();
            }
        }
        
        return this.getMatches();
    }
    
    public int getMatches() {
        return matches;
    }

    public int getComparisons() {
        return comparisons;
    }

}
