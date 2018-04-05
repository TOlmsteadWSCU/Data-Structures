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
    public static Program call2(Op fn, Program a1, Program a2) {
        Call res = new Call(fn); // has no subtrees on initialization
        res.addArg(a1);  // addArg is a method in Call
        res.addArg(a2);
        return res;
    }
    // Create a function call with 1 argument, like -x

    public static Program call1(Op fn, Program a1) {
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
       
       Op op1;
       while((op1 = parseAddop()) != null)
       {
            Program a = parseMulexp();
            res = call2(op1, res, a);
       };
       /*while ((op = parseAddop()) != null) {  // Followed by * or /?
           Program a = parseMulexp();   // Get second argument
           res = call2(op, res, a);           // Place the call in the result
       };*/
       return res;
    }
    // Parse a multiplying expression
      // Parse a multiplying expression
   public static Program parseMulexp() {
       Program res = parsePowexp();
       Op op2;
       while((op2 = parseMulop()) != null)
       {
           Program a = parsePowexp();
           res = call2(op2, res, a);
       };
       return res;
   }
   public static Program parsePowexp()
   {
       Program res = parseNegexp();
       
       Op op1;
       while((op1 = parseMulop()) != null){
            Program a = parseMulexp();
            res = call2(op1, res, a);
       };
       return res;
   }
    public static Program parseNegexp()
    {
        Op op = Ops.negate;
        Token t = toks.peek();
        if(t.isPunct("-"))
        {
            toks.next();
            Program p = parseNegexp();
            return call1(op, p);
        }
        return parseAexp();
        
    }
    public static Program parseAexp()
    {
        Token t = toks.next();
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
    public static Op parseAddop()
    {
        Token t = toks.peek();
        if(t.isPunct("+"))
        {
            toks.next();
            return Ops.add;
        }
        if(t.isPunct("-"))
        {
            toks.next();
            return Ops.sub;
        }
        return null;
    }
    public static Op parseMulop()
    {
        Token t = toks.peek();
        if(t.isPunct("*"))
        {
            toks.next();
            return Ops.mul;
        }
        if(t.isPunct("/"))
        {
            toks.next();
            return Ops.div;
        }
        return null;
    }
    public static Op parseExpop()
    {
        Token t = toks.peek();
        if(t.isPunct("^"))
        {
            toks.next();
            return Ops.pow;
        }
        return null;
    }
    
    
    
}
