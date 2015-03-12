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
    

    BoyerMoore(String gedicht) {  // Compute skip table.
        this.haystack = gedicht;
        right = new int[gedicht.length()];
    }

    private int search(int position) {  // Search for pattern in txt.
        int N = this.haystack.length();
        int M = needle.length();
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
                return i; // found
            }
            comparisons++;
        }
        return N; // not found
    }

    public int searchForWord(String word) {
        this.matches = 0;
        this.comparisons = 0;
        this.needle = word;
        
        int M = needle.length();
        int R = haystack.length();
        
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < M; j++) {
            right[needle.charAt(j)] = j;
        }
        
        int position = 0;
        for (int i = 0; i < haystack.length(); i++) {
            position = search(position + 1);
            if (position >= haystack.length()) {
                return this.matches;
            }
        }
        
        return this.matches;
    }
    
    public int getMatches() {
        return matches;
    }

    public int getComparisons() {
        return comparisons;
    }

}
