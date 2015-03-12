/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicum3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author koen_karsten
 */
public class Practicum3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        String gedicht = fileToString("/Users/guus_portegies/Documents/School/HvA/2014-2015/Searching & Sorting/Opdracht 3/practicum3/src/practicum3/gedicht.txt");
        String gedicht = fileToString("/Users/koen_karsten/Documents/Hva/S&S/Sorting-Searching-assignment-3/practicum3/src/practicum3/gedicht.txt");
        BoyerMoore boyerMoore = new BoyerMoore(gedicht);
        
        System.out.println("de: " + boyerMoore.searchForWord("de"));
        System.out.println("het: " + boyerMoore.searchForWord("het"));
        System.out.println("voor: " + boyerMoore.searchForWord("voor"));
    }
    
    static String fileToString(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }
    
}
