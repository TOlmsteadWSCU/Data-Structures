/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree1;

/**
 *
 * @author Owner
 */
public class Parser {

    public static TokenStream toks;

    public static Program parse(TokenStream t) {
        toks = t;
        Program p = parseExp();
        if (toks.peek() == Token.EOF) {
            return p;
        }
        System.out.println("I dont understand" + toks.peek());
        System.exit(0);
        return null;

    }

    // Create a function call with two arguments, like +
    public static Program call2(String fn, Program a1, Program a2) {
        Call res = new Call(fn); // has no subtrees on initialization
        res.addArg(a1);  // addArg is a method in Call
        res.addArg(a2);
        return res;
    }
    // Create a function call with 1 argument, like -x

    public static Program call1(String fn, Program a1) {
        Call res = new Call(fn);
        res.addArg(a1);
        return res;
    }
    // Use this when the next token has to be a certain
    // piece of punctuation

    public static void requirePunct(String s) {
        Token t = toks.next();
        if (t.isPunct(s)) {
            return;
        }
        System.out.println("Error: expecting " + s);
    }

    public static Program parseExp()
    {
        Program res = parseMulexp();
       String op = "";
       while ((op = parseAddop()) != null) {  // Followed by * or /?
           Program a = parseMulexp();   // Get second argument
           res = call2(op, res, a);           // Place the call in the result
       };
       return res;
    }
    // Parse a multiplying expression
      // Parse a multiplying expression
   public static Program parseMulexp() {
       Program res = parseNegexp();
       String op = "";
       while ((op = parseMulop()) != null) {  // Followed by * or /?
           Program a = parseNegexp();   // Get second argument
           res = call2(op, res, a);           // Place the call in the result
       };
       return res;
   }
    public static Program parseNegexp()
    {
        Token t = toks.peek();
        if(t.isPunct("-"))
        {
            toks.next();
            Program p = parseNegexp();
            return call1("-", p);
        }
        return parseExp();
        
    }
    public static Program parseAexp()
    {
        Token t = toks.peek();
        if(t.isPunct("("))
        {
            Program p = parseExp();
            requirePunct(")");
            return p;
        }
        if(t.isNumber())
        {
            return new Number(Double.parseDouble(t.body));
        }
        if(t.isName())
        {
            return new Variable(t.body);
        }
        System.out.println("Error: " + t);
        System.exit(0);
        return null;
    }
    public static String parseAddop()
    {
        Token t = toks.peek();
        if(t.isPunct("+") || t.isPunct("-"))
        {
            toks.next();
            return t.body;
        }
        else return null;
    }
    public static String parseMulop()
    {
        Token t = toks.peek();
        if(t.isPunct("*") || t.isPunct("/"))
        {
            toks.next();
            return t.body;
        }
        else return null;
    }
    
    
    
}
