/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicum3;

/**
 *
 * @author guus_portegies
 */
public class BoyerMoore {

    private int[] right;
    private String pat;
    
    private int matches;
    private int comparisons;
    final private String gedicht;

    BoyerMoore(String gedicht) {  // Compute skip table.
        matches = 0;
        comparisons = 0;
        
        this.gedicht = gedicht;
        this.right = new int[gedicht.length()];
    }

    public int search(int pos) {  // Search for pattern in txt.
        int N = this.gedicht.length();
        int M = pat.length();
        int skip;
        for (int i = pos; i <= N - M; i += skip) {  // Does the pattern match the text at position i ?
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (pat.charAt(j) != this.gedicht.charAt(i + j)) {
                    skip = j - right[this.gedicht.charAt(i + j)];
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

    public int getMatches() {
        return matches;
    }

    public int getComparisons() {
        return comparisons;
    }
    
    public int searchForWord(String word) {
        this.matches = 0;
        this.comparisons = 0;
        this.pat = word;
        
        int M = word.length();
        int R = gedicht.length();
        
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < M; j++) {
            right[pat.charAt(j)] = j;
        }
        
        int currentPos = 0;
        for (int i = 0; i < gedicht.length(); i++) {
            currentPos = search(currentPos + 1);
            if (currentPos >= gedicht.length()) {
                return this.matches; // Stop
            }
        }
        
        return this.matches;
    }

}
