/*
 * Main.java
 *
 * Created on November 11, 2007, 8:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tree3;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 *
 * @author fac_peterson
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String testString = "There's more than 1 (one) way to test.";
        StringReader sr = new StringReader(testString);
        TokenStream toks = Lexer.lex(new BufferedReader(sr));
        Token t;
        while ((t = toks.next()) != Token.EOF) {
            System.out.println(" " + t + "   (" + t.type + ")");
        }
               
    }
    
}
