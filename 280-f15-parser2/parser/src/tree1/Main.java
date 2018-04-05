/*
 * Main.java
 *
 * Created on November 11, 2007, 8:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tree1;

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
//    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* String testString = "--2 * 5";
            StringReader sr = new StringReader(testString);
            TokenStream toks = Lexer.lex(new BufferedReader(sr));
            Program p = Parser.parse(toks);
            System.out.println(testString);
            System.out.println(p);
            System.out.println(p.simplify());

               */
       String testString = "(x+0)/1";
            StringReader sr = new StringReader(testString);
            TokenStream toks = Lexer.lex(new BufferedReader(sr));
            Program p = Parser.parse(toks);
            System.out.println("input1: " + testString);
            System.out.println("parse1: " + p.printProgram(0));
            System.out.println("simplify1: " + p.simplify().printProgram(0));
            
            String testString2 = "(x*0)/x";
            StringReader sr2 = new StringReader(testString2);
            TokenStream toks2 = Lexer.lex(new BufferedReader(sr2));
            Program p2 = Parser.parse(toks2);
            System.out.println("input2: " + testString2);
            System.out.println("parse2: " + p2.printProgram(0));
            System.out.println("simplify2: " + p2.simplify().printProgram(0));
            
            String testString3 = "x^2-0";
            StringReader sr3 = new StringReader(testString3);
            TokenStream toks3 = Lexer.lex(new BufferedReader(sr3));
            Program p3 = Parser.parse(toks3);
            System.out.println("input3: " + testString3);
            System.out.println("parse3: " + p3.printProgram(0));
            System.out.println("simplify3: " + p3.simplify().printProgram(0));
            
            String testString4 = "--2";
            StringReader sr4 = new StringReader(testString4);
            TokenStream toks4 = Lexer.lex(new BufferedReader(sr4));
            Program p4 = Parser.parse(toks4);
            System.out.println("input4: " + testString4);
            System.out.println("parse4: " + p4.printProgram(0));
            System.out.println("simplify4: " + p4.simplify().printProgram(0));
            
           /* String testString5 = "(x^1)";
            StringReader sr5 = new StringReader(testString5);
            TokenStream toks5 = Lexer.lex(new BufferedReader(sr5));
            Program p5 = Parser.parse(toks5);
            System.out.println("input5: " + testString5);
            System.out.println("parse5: " + p5.printProgram(0));
            System.out.println("simplify5: " + p5.simplify().printProgram(0));

*/
    }
    
}
