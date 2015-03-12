package practicum3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @authors guus_portegies && koen_karsten
 */
public class Practicum3 {
    
    public static void main(String[] args) throws IOException {
        // Step 1: Convert the text file to search in to a String
        // String gedicht = fileToString("/Users/guus_portegies/Documents/School/HvA/2014-2015/Searching & Sorting/Opdracht 3/practicum3/src/practicum3/gedicht.txt");
        String gedicht = fileToString("/Users/koen_karsten/Documents/Hva/S&S/Sorting-Searching-assignment-3/practicum3/src/practicum3/gedicht.txt");
        
        // Step 2: load both the algorithms, and pass the testFile into it
        BoyerMoore boyerMoore = new BoyerMoore(gedicht);
        KMP kmp = new KMP(gedicht);
        
        System.out.println("===========BM algorithm===========");
        System.out.println("de: " + boyerMoore.searchForWord("de"));
        System.out.println("het: " + boyerMoore.searchForWord("het"));
        System.out.println("voor: " + boyerMoore.searchForWord("voor"));
        System.out.println("===========KMP algorithm==========");
        System.out.println("de: " + kmp.searchForWord("de"));
        System.out.println("het: " + kmp.searchForWord("het"));
        System.out.println("voor: " + kmp.searchForWord("voor"));
    }
    
    
    // Helper function to convert the .txt to a String
    // Based upon http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file#answer-326440
    static String fileToString(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }
    
}
