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
public class KMP {

    private String pat;
    private int[][] dfa;
    private int vergelijkingen = 0;
    private int aantal = 0;

    public KMP(String pat) { // Build DFA from pattern.
        this.pat = pat;
        int M = pat.length();
        int R = 256;

        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) { // Compute dfa[][j].
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X]; // Copy mismatch cases.
            }
            dfa[pat.charAt(j)][j] = j + 1; // Set match case.
            X = dfa[pat.charAt(j)][X]; // Update restart state.
        }
    }

    public String search(String txt) { // Simulate operation of DFA on txt.

        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {

            j = dfa[txt.charAt(i)][j];
            vergelijkingen++;

        }
        if (j == M) {
            aantal++;

            search(txt.substring(i));

        }  return aantal + "\t" + vergelijkingen;

    }
}
