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

import static tree1.Parser.*;
public class Ops {


    
   public static Program mkNum(double n) {
       return new Number(n);  
   }
   public static Program add(Program x, Program y) {
       return Parser.call2(Ops.add, x, y);
   }
   public static Program sub(Program x, Program y) {
       return Parser.call2(Ops.sub, x, y);
   }
   public static Program mul(Program x, Program y) {
       return Parser.call2(Ops.mul, x, y);
   }
   public static Program div(Program x, Program y) {
       return Parser.call2(Ops.div, x, y);
   }
   public static Program negate(Program x) {
       return Parser.call1(Ops.negate, x);
   }
   public static Program power(Program x, Program y) {
       return Parser.call2(Ops.power, x, y);
   }
   
   public static Simplifier addSimp = new Simplifier()
   {
       public Program simplify(Call c)
       {
           Program l = c.args.get(0).simplify();
           Program r = c.args.get(1).simplify();
           if(l.isConst() && r.isConst())
           {
               return mkNum(l.cval()+ r.cval());
           }
           if(l.isConst(0))
           {
               return r;
           }
           if(r.isConst(0))
           {
               return l;
           }
           return add(l, r);
                   
       }
   };
   
   public static Simplifier subSimp = new Simplifier()
   {
       public Program simplify(Call c)
       {
           Program l = c.args.get(0).simplify();
           Program r = c.args.get(1).simplify();
           if(l.isConst() && r.isConst())
           {
               return mkNum(l.cval()- r.cval());
           }
           if(l.isConst(0))
           {
               return negate(r);
           }
           if(r.isConst(0))
           {
               return l;
           }
           return sub(l, r);
       }
   };
   
   public static Simplifier mulSimp = new Simplifier()
   {
       public Program simplify(Call c)
       {
           Program l = c.args.get(0).simplify();
           Program r = c.args.get(1).simplify();
           if(l.isConst() && r.isConst())
           {
               return mkNum(l.cval()* r.cval());
           }
           if(r.isConst(0) || l.isConst(0))
           {
               return mkNum(0);
           }
           if(l.isConst(1))
           {
              return r; 
           }
           if(r.isConst(1))
           {
              return l; 
           }
           return mul(l, r);
       }
   };
   
   public static Simplifier divSimp = new Simplifier()
   {
       public Program simplify(Call c)
       {
           Program l = c.args.get(0).simplify();
           Program r = c.args.get(1).simplify();
           if(l.isConst() && r.isConst())
           {
               return mkNum(l.cval()/ r.cval());
           }
           if(l.isConst(0))
           {
               return mkNum(0);
           }
           if(r.isConst(1))
           {
               return l;
           }
           return div(l, r);
           
       }
   };
   
   public static Simplifier powSimp = new Simplifier()
   {
       public Program simplify(Call c)
       {
           Program l = c.args.get(0).simplify();
           Program r = c.args.get(1).simplify();
           if(l.isConst() && r.isConst())
           {
               return mkNum(Math.pow(l.cval(),r.cval())); 
           }
           if(l.isConst(0))
           {
               return mkNum(0);
           }
           if(r.isConst(0))
           {
               return mkNum(1);
           }
           if(r.isConst(1))
           {
               return l;
           }
           return power(l, r);
       };
   
   
   
   
           
           
   };
   public static Simplifier mulPowSimp = new Simplifier()
   {
       public Program simplify(Call c) {
           Program l = c.args.get(0).simplify();
           //Program p = c.args.get(2).simplify();
           double p;
           Program r = c.args.get(1).simplify();
           if(l.isConst() && r.isConst())
               return mkNum(Math.pow(p, (mul(l.cval(),r.cval()))));
           return mul(l,r);
       }
       
   };
   public static Simplifier negSimp = new Simplifier()
   {
       public Program simplify(Call c)
       { 
            Program l = c.args.get(0).simplify();
            if(l.isConst())
            {
                return mkNum(-l.cval());
            }
            return negate(l);
       }
   };
   public static Derive addDeriv = new Derive()
   {
       public Program derive(Call c) {
           Program l = c.args.get(0);
           Program r = c.args.get(1);
           Program lprime = l.derive();
           Program rprime = r.derive();
           return add(lprime, rprime);
           
       }
       
   };
   
   public static Derive multDeriv = new Derive()
   {
       public Program derive(Call c)
       {
           Program l = c.args.get(0);
           Program r = c.args.get(1);
           Program lprime = l.derive();
           Program rprime = r.derive();
           return add(mul(lprime, r), mul(rprime,l));
       }
   };
   public static Derive divDeriv = new Derive()
   {
       public Program derive(Call c)
       {
           Program l = c.args.get(0);
           Program r = c.args.get(1);
           Program lprime = l.derive();
           Program rprime = r.derive();
           return div(sub(mul(lprime, r), mul(rprime,l)), mul(r,r));
       }
   };
   public static Derive subDeriv = new Derive()
   {
       public Program derive(Call c)
       {
           Program l = c.args.get(0);
           Program r = c.args.get(1);
           Program lprime = l.derive();
           Program rprime = r.derive();
           return sub(l,r);
       }
   };
   
   
   public static Derive powDeriv = new Derive()
   {
       public Program derive(Call c) {
           Program l = c.args.get(0);
           int x = (int)c.args.get(1).cval();
           if(mkNum(x).equals(0))
               return mkNum(0);
           Program lprime = l.derive();
           return mul(mul(power(l,mkNum(x-1)), lprime), mkNum(x));
           
           
       }
       
   };
   
   public static Derive negDeriv = new Derive()
   {
       public Program derive(Call c)
       {
           Program l = c.args.get(0);
           return negate(l.derive());
       }
   };
    public static Simplifier noSimp;
    public static Op add = new Op("+", 0, 1, 1, Printers.printBinary, addSimp, addDeriv);
    public static Op sub = new Op("-", 0, 1, 1, Printers.printBinary, subSimp, subDeriv);
    public static Op mul = new Op("*", 1, 2, 2, Printers.printBinary, mulSimp, multDeriv);
    public static Op div = new Op("/", 1, 2, 0, Printers.printBinary, divSimp, divDeriv);
    public static Op negate = new Op("-", 3, 3, 3, Printers.printUnary, negSimp, negDeriv);
    public static Op power = new Op("^", 4, 3, 4, Printers.printBinary, powSimp, powDeriv);
    
}
