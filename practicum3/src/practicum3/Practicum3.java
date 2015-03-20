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
        String gedicht = fileToString("/Users/guus_portegies/Documents/School/HvA/2014-2015/Searching & Sorting/Opdracht 3/practicum3/src/practicum3/gedicht.txt");
        // String gedicht = fileToString("/Users/koen_karsten/Documents/Hva/S&S/Sorting-Searching-assignment-3/practicum3/src/practicum3/gedicht.txt");
        
        // Step 2: load both the algorithms, and pass the testFile into it
        BoyerMoore boyerMoore = new BoyerMoore(gedicht);
        KMP kmp = new KMP(gedicht);
        RegularExpression regExp = new RegularExpression();
        
        // Step 3: Search for 10 different words with both the 2 algorithms
        System.out.println("===========BM algorithm===========");
        System.out.println("de:  FOUND:" + boyerMoore.searchForWord("de") +" COMPARISONS: " + boyerMoore.getComparisons());
        System.out.println("het:  FOUND:" + boyerMoore.searchForWord("het") + " COMPARISONS: " + boyerMoore.getComparisons());
        System.out.println("voor:  FOUND:" + boyerMoore.searchForWord("voor") + " COMPARISONS: " + boyerMoore.getComparisons());
        System.out.println("welke:  FOUND:" + boyerMoore.searchForWord("welke") + " COMPARISONS: " + boyerMoore.getComparisons());
        System.out.println("mei:  FOUND:" + boyerMoore.searchForWord("mei") + " COMPARISONS: " + boyerMoore.getComparisons());
        System.out.println("droefenis:  FOUND:" + boyerMoore.searchForWord("droefenis") + " COMPARISONS: " + boyerMoore.getComparisons());
        System.out.println("ziternietin:  FOUND:" + boyerMoore.searchForWord("ziternietin") + " COMPARISONS: " + boyerMoore.getComparisons());
        System.out.println("haar:  FOUND:" + boyerMoore.searchForWord("haar") + " COMPARISONS: " + boyerMoore.getComparisons());
        System.out.println("zitten:  FOUND:" + boyerMoore.searchForWord("zitten") + " COMPARISONS: " + boyerMoore.getComparisons());
        System.out.println("golven:  FOUND:" + boyerMoore.searchForWord("golven") + " COMPARISONS: " + boyerMoore.getComparisons());
        System.out.println("===========KMP algorithm==========");
        System.out.println("de:  FOUND:" + kmp.searchForWord("de") + " COMPARISONS: " + kmp.getComparisons());
        System.out.println("het:  FOUND:" + kmp.searchForWord("het") + " COMPARISONS: " + kmp.getComparisons());
        System.out.println("voor:  FOUND:" + kmp.searchForWord("voor") + " COMPARISONS: " + kmp.getComparisons());
        System.out.println("welke:  FOUND:" + kmp.searchForWord("welke") + " COMPARISONS: " + kmp.getComparisons());
        System.out.println("mei:  FOUND:" + kmp.searchForWord("mei") + " COMPARISONS: " + kmp.getComparisons());
        System.out.println("droefenis:  FOUND:" + kmp.searchForWord("droefenis") + " COMPARISONS: " + kmp.getComparisons());
        System.out.println("ziternietin:  FOUND:" + kmp.searchForWord("ziternietin") + " COMPARISONS: " + kmp.getComparisons());
        System.out.println("haar:  FOUND:" + kmp.searchForWord("haar") + " COMPARISONS: " + kmp.getComparisons());
        System.out.println("zitten:  FOUND:" + kmp.searchForWord("zitten") + " COMPARISONS: " + kmp.getComparisons());
        System.out.println("golven:  FOUND:" + kmp.searchForWord("golven") + " COMPARISONS: " + kmp.getComparisons());
        
        RegularExpression regex = new RegularExpression();
        
        String phoneNumbers[] = new String[20];
        phoneNumbers[0] = "0634149271";
        phoneNumbers[1] = "06-34149271";
        phoneNumbers[2] = "0604149271";
        
        phoneNumbers[3] = "0361234567";
        phoneNumbers[4] = "036-1234567";
        phoneNumbers[5] = "006-1234567";
        
        phoneNumbers[6] = "0228512203";
        phoneNumbers[7] = "0228-512203";
        phoneNumbers[8] = "0304-123456";
        
        phoneNumbers[9] = "0900-1234";
        phoneNumbers[10] = "0906-1234";
        
        phoneNumbers[11] = "112";
        phoneNumbers[12] = "0 6 3 4 1 49 2 7 1";
        
        for (int i = 0; i < 13; i++) {
            if(regex.checkNummer(phoneNumbers[i])) {
                System.out.println("Nummer: " + phoneNumbers[i] + " is TRUE.");
            } else {
                System.out.println("Nummer: " + phoneNumbers[i] + " is FALSE.");
            }
        }

    }
    
    // Helper function to convert the .txt to a String
    // Based upon http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file#answer-326440
    static String fileToString(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }
    
}
