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
public class KMP {
    
    private String pat;
    private int[][] dfa;
    private int matches;
    
    public KMP(String pat) {
        // Build DFA from pattern.
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        
        for (int X = 0, j = 1; j < M; j++) {  // Compute dfa[][j].
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X];
            dfa[pat.charAt(j)][j] = j+1;
            X = dfa[pat.charAt(j)][X];
           
        }
    }
    
    public int search(String txt) {
        
        int i, j, N = txt.length(), M = pat.length();
        
        for (i = 0, j = 0; i < N && j < M; i++) {
           j = dfa[txt.charAt(i)][j];
        }
        
        if (j == M) {
            // found (hit end of pattern)
            this.matches++;
            return i - M;
        } else {
            // not found (hit end of text)
            return N;
        }      
    }
    
    public int getMatches() {
        return this.matches;
    }
}
