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

    /**
     * Creates a new instance of Main
     */
    public Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      /*
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
            
            String testString3 = "(x^0)-0";
            StringReader sr3 = new StringReader(testString3);
            TokenStream toks3 = Lexer.lex(new BufferedReader(sr3));
            Program p3 = Parser.parse(toks3);
            System.out.println("input3: " + testString3);
            System.out.println("parse3: " + p3.printProgram(0));
            System.out.println("simplify3: " + p3.simplify().printProgram(0));
            
            String testString4 = "(-x/1)-0";
            StringReader sr4 = new StringReader(testString4);
            TokenStream toks4 = Lexer.lex(new BufferedReader(sr4));
            Program p4 = Parser.parse(toks4);
            System.out.println("input4: " + testString4);
            System.out.println("parse4: " + p4.printProgram(0));
            System.out.println("simplify4: " + p4.simplify().printProgram(0));
            
            String testString5 = "(x^1)";
            StringReader sr5 = new StringReader(testString5);
            TokenStream toks5 = Lexer.lex(new BufferedReader(sr5));
            Program p5 = Parser.parse(toks5);
            System.out.println("input5: " + testString5);
            System.out.println("parse5: " + p5.printProgram(0));
            System.out.println("simplify5: " + p5.simplify().printProgram(0));
            */
           
      String testString = "(x+2)/x";
      StringReader sr = new StringReader(testString);
      TokenStream toks = Lexer.lex(new BufferedReader(sr));
      Program p = Parser.parse(toks);
      Program ab = p.derive();
        System.out.println(testString);
        System.out.println(ab.printProgram(0));
        System.out.println(ab.simplify().printProgram(0));
        Program ab1 = ab.simplify();
        System.out.println("");
        System.out.println(ab.size());
        System.out.println(ab1.size());
        System.out.println("");
     
        
      String testS = "(x+2)^3";
      StringReader st = new StringReader(testS);
      TokenStream tok = Lexer.lex(new BufferedReader(st));
      Program p1 = Parser.parse(tok);
      Program abc = p1.derive();
        System.out.println(testS);
        System.out.println(abc.printProgram(0));
        System.out.println(abc.simplify().printProgram(0));
      
        System.out.println("");
        
        String t3 = "(x+2)-(x+3)";
      StringReader st1 = new StringReader(t3);
      TokenStream t1 = Lexer.lex(new BufferedReader(st1));
      Program p3 = Parser.parse(t1);
      Program a1 = p3.derive();
        System.out.println(t3);
        System.out.println(a1.printProgram(0));
        System.out.println(a1.simplify().printProgram(0));
        System.out.println("");
        
        
        
        String t4 = "(x+2)*(x+3)";
      StringReader s2 = new StringReader(t4);
      TokenStream tok3 = Lexer.lex(new BufferedReader(s2));
      Program p4 = Parser.parse(tok3);
      Program a2 = p4.derive();
        System.out.println(t4);
        System.out.println(a2.printProgram(0));
        System.out.println(a2.simplify().printProgram(0));
        System.out.println("");
        
        String t5 = "(x+2)+(x+3)";
      StringReader st5 = new StringReader(t5);
      TokenStream tok5 = Lexer.lex(new BufferedReader(st5));
      Program p5 = Parser.parse(tok5);
      Program a5 = p5.derive();
        System.out.println(t3);
        System.out.println(a5.printProgram(0));
        System.out.println(a5.simplify().printProgram(0));
        System.out.println("");
        
        
        
        String test = "-x";
      StringReader s = new StringReader(test);
      TokenStream to = Lexer.lex(new BufferedReader(s));
      Program p2 = Parser.parse(to);
      Program abcd = p2.derive();
      
        System.out.println(test);
        System.out.println(abcd.printProgram(0));
        System.out.println(abcd.simplify().printProgram(0));
        System.out.println("");
        
        
        Program k = Ops.mkNum(2);
            Program m = Ops.mkNum(5);
            Program w = new Variable("y");
            Program b = new Variable("a");
            Program t = Ops.add(k, m);
            Program q = Ops.add(m, k);
            Program u = Ops.add(k, q);
            System.out.println(m.same(k));
            System.out.println(k.same(k));
            System.out.println(w.same(b));
            System.out.println(b.same(b));
            System.out.println(t.same(q));
            System.out.println(u.same(u));

        }

    
    }


