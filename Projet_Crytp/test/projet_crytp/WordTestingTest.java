/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet_crytp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author edouard
 */
public class WordTestingTest {
    
    public WordTestingTest() {
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
     * Test of NormalizeString method, of class WordTesting.
     */
    @Test
    public void testNormalizeString() {
        System.out.println("NormalizeString");
        String p_wordToTest = "";
        WordTesting instance = new WordTesting();
        String expResult = "";
        String result = instance.NormalizeString(p_wordToTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FindLanguage method, of class WordTesting.
     */
    @Test
    public void testFindLanguage() {
        System.out.println("FindLanguage");
        String p_wordToTest = "";
        WordTesting instance = new WordTesting();
        String expResult = "";
        String result = instance.FindLanguage(p_wordToTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
