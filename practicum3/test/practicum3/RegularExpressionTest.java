/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicum3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guus_portegies
 */
public class RegularExpressionTest {
    
    public RegularExpressionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkNummer method, of class RegularExpression.
     * TEST MOBILE NUMBERS
     */
    @Test
    public void testCheckNummer1() {
        String telNr = "0634149271";
        RegularExpression instance = new RegularExpression();
        boolean expResult = true;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNummer2() {
        String telNr = "06-34149271";
        RegularExpression instance = new RegularExpression();
        boolean expResult = true;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNummer3() {
        String telNr = "0604149271";
        RegularExpression instance = new RegularExpression();
        boolean expResult = false;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNummer4() {
        String telNr = "06-04149271";
        RegularExpression instance = new RegularExpression();
        boolean expResult = false;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkNummer method, of class RegularExpression.
     * TEST 3 DIGIT AREA NUMBERS
     */
    @Test
    public void testCheckNummer5() {
        String telNr = "0201234567";
        RegularExpression instance = new RegularExpression();
        boolean expResult = true;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNummer6() {
        String telNr = "023-1234567";
        RegularExpression instance = new RegularExpression();
        boolean expResult = true;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNummer7() {
        String telNr = "1234567890";
        RegularExpression instance = new RegularExpression();
        boolean expResult = false;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNummer8() {
        String telNr = "0061234567";
        RegularExpression instance = new RegularExpression();
        boolean expResult = false;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkNummer method, of class RegularExpression.
     * TEST 4 DIGIT AREA NUMBERS
     */
    @Test
    public void testCheckNummer9() {
        String telNr = "0228512203";
        RegularExpression instance = new RegularExpression();
        boolean expResult = true;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNummer10() {
        String telNr = "0228-512203";
        RegularExpression instance = new RegularExpression();
        boolean expResult = true;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNummer11() {
        String telNr = "0304-123456";
        RegularExpression instance = new RegularExpression();
        boolean expResult = false;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
 
    /**
     * Test of checkNummer method, of class RegularExpression.
     * TEST SPECIAL NUMBERS
     */
    @Test
    public void testCheckNummer12() {
        String telNr = "0900-1234";
        RegularExpression instance = new RegularExpression();
        boolean expResult = true;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNummer13() {
        String telNr = "0906-1234";
        RegularExpression instance = new RegularExpression();
        boolean expResult = true;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNummer14() {
        String telNr = "112";
        RegularExpression instance = new RegularExpression();
        boolean expResult = true;
        boolean result = instance.checkNummer(telNr);
        System.out.println("Test checkNummer(), Phonenumber: " + telNr +"\t Expected result: " + expResult + "\t\t Result: " + result);
        assertEquals(expResult, result);
    }
}
