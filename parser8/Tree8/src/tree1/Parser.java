/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree1;

/**
 *
 * @author gunny
 */
public class Parser {

    private static TokenStream toks;

    public static Program parse(TokenStream tok) {
        toks = tok;
        Program p = parseExp();
        if (toks.peek() == Token.EOF) {
            return p;
        }
        System.out.println("I dont understand" + toks.peek());
        System.exit(0);
        return null;
    }
//    Grammer:     
//exp = mulexp (addop mulexp)*
//mulexp = negexp (mulop negexp)*
//powexp = mulexp | '^' | mulexp   
//negexp = '-' negexp | aexp | powexp
//aexp = '(' exp ')' | num | name
//addop = '+' | '-'
//mulop = '*' | '/'

    public static Program parseExp() {
        Program res = parseMulexp();
        
        Op xx = null;
        while ((xx = parseAddop()) != null) {
            Program a = parseMulexp();
            res = call2(xx, res, a);
        };
        return res;
    }
//mulexp = negexp (mulop negexp)*
    public static Program parseMulexp() {
        Program res = parsePowexp();
        
        Op xx = null;
        while ((xx = parseMulop()) != null) {  // Followed by * or /?
            Program a = parsePowexp();   // Get second argument
            res = call2(xx, res, a);           // Place the call in the result
        };
        return res;
    }
    
      public static Program parsePowexp(){
        Op op1 = null;
         Program res = parseNegexp();
        
        while ((op1 = parsePowop()) != null) {  // Followed by * or /?
            Program a = parseNegexp();   // Get second argument
            res = call2(op1, res, a);           // Place the call in the result
        };
        return res;
    }

    //negexp = '-' negexp | aexp
    public static Program parseNegexp() {
        Op op = Ops.negate;
        Token t = toks.peek();
        if(t.isPunct("-")){
            toks.next();
            Program negExp = parseNegexp();
            return call1(op, negExp);
        }
        return parseAexp();
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

//aexp = '(' exp ')' | num | name
    public static Program parseAexp() {
        Token t = toks.next();
        if (t.isPunct("(")) {
            Program p = parseExp();
            requirePunct(")");
            return p;
        }
        if (t.isNumber()) {
            return new Number(Double.parseDouble(t.body));
        }

        if (t.isName()) {
            return new Variable(t.body);
            }
        
        System.out.println("You messed up");
        return null;
    }

//addop = '+' | '-'
    public static Op parseAddop() {
        Token t = toks.peek();
        if (t.isPunct("+")) {
            toks.next();
            return Ops.add;
        }
        if (t.isPunct("-")) {
            toks.next();
            return Ops.sub;
        }
        return null;
    }

    public static Op parseMulop() {
        Token t = toks.peek();
        if (t.isPunct("*")) {
            toks.next();
            return Ops.mul;
        }
        if (t.isPunct("/")) {
            toks.next();
            return Ops.div;
        }
        return null;

    }
    
    public static Op parsePowop(){
         Token t = toks.peek();
        if (t.isPunct("^")) {
            toks.next();
              return Ops.power;
        }
        return null;
    }
    
  

}
