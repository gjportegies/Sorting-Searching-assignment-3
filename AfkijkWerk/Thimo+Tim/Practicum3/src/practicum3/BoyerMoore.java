/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicum3;

/**
 *
 * @author Tim
 */
public class BoyerMoore {

    private int[] right;
    private String pat;
    private int vergelijkingen = 0;
    private int aantal = 0;

    BoyerMoore(String pat) { // Compute skip table.
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1; // -1 for chars not in pattern
        }
        for (int j = 0; j < M; j++) // rightmost position for
        {
            right[pat.charAt(j)] = j; // chars in pattern
        }
    }
    
    public String search(String txt) { // Search for pattern in txt.

        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) { // Does the pattern match the text at position i ?
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                vergelijkingen++;
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    if (skip < 1) {
                        skip = 1;
                    }
                    break;
                }
            }
            if (skip == 0) {
                aantal++; // found.
                skip = M;
            }
        }
        return aantal + "\t" + vergelijkingen;
    }

}
