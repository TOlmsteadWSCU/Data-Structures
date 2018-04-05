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

import static tree1.Parser.*;


public class Ops {
  


   public static Program mkNum(double n) {
       return new Number(n);  
   }


    public static Program add(Program x, Program y) {
        return call2(Ops.add, x, y);
    }

    public static Program sub(Program x, Program y) {
        return call2(Ops.sub, x, y);
    }

    public static Program mul(Program x, Program y) {
        return call2(Ops.mul, x, y);
    }

    public static Program div(Program x, Program y) {
        return call2(Ops.div, x, y);
    }

    public static Program negate(Program x) {
        return call1(Ops.negate, x);
    }
    public static Program pow(Program x, Program y)
    {
        return call2(Ops.pow, x, y);
    }
    public static Simplifier addSimp = new Simplifier()
    {
        public Program simplify(Call c)
        {
            Program l = c.p.get(0).simplify();
            Program r = c.p.get(1).simplify();
            if(l.isConst() && r.isConst())
            {
                return mkNum(l.cval() + r.cval());
            }
            if(l.isConst(0)){
                return r;
            }
            
            if(r.isConst(0)){
                return l;
            }
                
            return add(l,r);
        }
    };
    public static Simplifier subSimp = new Simplifier()
    {
        public Program simplify(Call c)
        {
            Program l = c.p.get(0).simplify();
            Program r = c.p.get(1).simplify();
            if(l.isConst() && r.isConst())
            {
                return mkNum(l.cval() - r.cval());
            }
            if(l.isConst(0))
            {
                return negate(r);
            }
            if(r.isConst(0))
                return l;
            
            return sub(l,r);
        }
    };
    public static Simplifier multSimp = new Simplifier()
    {
        public Program simplify(Call c) {
            Program l = c.p.get(0).simplify();
            Program r = c.p.get(1).simplify();
            if(l.isConst() && r.isConst())
            {
                return mkNum(l.cval() * r.cval());
            }
            if(l.isConst(0) || r.isConst(0))
                return mkNum(0);
            if(l.isConst(1))
                return r;
            if(r.isConst(1))
                return l;
            
            return mul(l,r);
        }
        
    };
    public static Simplifier divSimp = new Simplifier()
    {
        public Program simplify(Call c) {
            Program l = c.p.get(0).simplify();
            Program r = c.p.get(1).simplify();
            if(l.isConst() && r.isConst())
            {
                return mkNum(l.cval()/r.cval());
            }
            if(l.isConst(0))
                return mkNum(0);
            if(r.isConst(1))
                return l;
            
            return div(l,r);
        }
        
    };
    public static Simplifier powSimp = new Simplifier()
    {
        public Program simplify(Call c)
        {
            Program l = c.p.get(0).simplify();
            Program r = c.p.get(1).simplify();
            if(l.isConst() && r.isConst())
            {
                return mkNum(Math.pow(l.cval(), r.cval()));
            }
            if(l.isConst(0))
                return mkNum(0);
            if(r.isConst(0))
                return mkNum(1);
            if(r.isConst(1))
                return l;
            return pow(l,r);
        }
    };
    public static Simplifier negateSimp = new Simplifier()
    {
   
        public Program simplify(Call c) {
            Program l = c.p.get(0).simplify();
            if (l.isConst()) {
                return mkNum(-l.cval());
            }

            return negate(l);        }
        
    };
        public static Op add = new Op("+",0,1,1, Printers.printInfix, addSimp);
    public static Op sub = new Op("-", 0,1,1,Printers.printInfix, subSimp);
    public static Op mul = new Op("*", 1,2,2,Printers.printInfix, multSimp);
    public static Op div = new Op("/", 1,2,0, Printers.printInfix, divSimp);
    public static Op negate = new Op("-", 3,3,3, Printers.printUnary, negateSimp);
    public static Op pow = new Op("^", 4,3,4, Printers.printInfix, powSimp);
 
}
