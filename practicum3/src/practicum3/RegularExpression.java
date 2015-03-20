/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicum3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author guus_portegies & koen_karsten
 */
public class RegularExpression {
    
    
    public boolean checkNummer(String telNr) {
        
        // Remove all spaces from the telephone number
        String str = telNr.replaceAll("\\s","");
        
        // Alle nummers beginnen met 031 of +31 of 0031 of 0.
        // ^((\\+31)|(0031)|(0))
        
        // Als mobiel nummer
        // EXTRA abonneenummer begint nooit met een 0
        // ((6)[-]?[1-9]{1}(\\d{7}))
        
        // Als nummer met gebiedscode van 3 cijfers zoals 020 / 033
        // EXTRA 2e letter nooit een 0, dus geen: 002
        // EXTRA kan ook met streepje: 020-
        // ([1-9]{1}\\d{1}[- ]?[0-9](\\d{6}))
        
        // Als nummer met gebiedscode van 4 cijfers zoals 0228 / 0521
        // EXTRA kan ook met streepje: 0228-
        // ([1-9]{2}\\d{1}[- ]?[0-9](\\d{6}))
        
        // Uitzonderingen korte servicenummers zoals 112 / 0900 / 0800
        // EXTRA ook 0906 en 0909 netnummers toegevoegd: http://nl.wikipedia.org/wiki/Lijst_van_Nederlandse_netnummers
        // ((0)((800)|(90)[0,6,9])[-]?(\\d{4}))|(112)
        
        String regex = ""
            + "^(((\\+31)|(0031)|(0))"                          // Alle nummers beginnen met 031 of +31 of 0031 of 0.
            + "(((6)[-]?[1-9](\\d{7}))$"                        // Als mobiel nummer dus begint met 06
            + "|([1-9]{2}[-]?[1-9](\\d{6}))$"                   // Als nummer met gebiedscode van 3 cijfers zoals 020 / 033
            + "|([1-9]{2}\\d{1}[-]?[1-9](\\d{5}))$)"            // Als nummer met gebiedscode van 4 cijfers zoals 0228 / 0521
            + "|((0)((800)|(90)[0,6,9])[-]?(\\d{4}))|(112))";   // Uitzonderingen korte servicenummers zoals 112 / 0900 / 0800
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        
        return matcher.matches();
    }
}
