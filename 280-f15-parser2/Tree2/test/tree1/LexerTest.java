/*
 * LexerTest.java
 * JUnit based test
 *
 * Created on November 14, 2007, 7:56 PM
 */

package tree1;
import java.io.*;

import junit.framework.*;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author fac_peterson
 */
public class LexerTest extends TestCase {
    
    public LexerTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }
    public void testLexer() {
        String input = "abc = 2;\ndef = 1 + (abc - 2)*2/445;";
        StringReader i1 = new StringReader(input);
        BufferedReader i2 = new BufferedReader(i1);
        TokenStream toks = new TokenStream();
        int errs = Lexer.lex(i2, toks);
        Token t;
        int i = 0;
        String [] expected = {
            "abc", "=", "2", ";", "def", "=", "1", "+", "(",
            "abc", "-", "2", ")", "*", "2", "/", "445", ";"};
            
        while (!(t = toks.next()).isEOF()) {
            System.out.println(t);
            System.out.println("Type: " + t.type + " Line: " + t.lineNum +
                               " Col: " + t.colNum + " Context: " + t.line);
            assertEquals("Token " + t + " should be " + expected[i],
                         t.body, expected[i]);
            if (i == 6) { // the "1"

                assertEquals("Line should be 2", t.lineNum, 2);
                assertEquals("Column should be 7", t.colNum, 7);
                assertEquals("Context should be def = 1 + (abc - 2)*2/445;",
                             t.line, "def = 1 + (abc - 2)*2/445;");
                assertEquals("Type should be numberToken", t.type, TokenType.numberToken);
            }
            i++;
        }
        

    }    
}
