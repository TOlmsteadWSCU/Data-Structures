package tree1;


import tree1.Call;
import tree1.Printer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Printers implements Printer{

    public String print(Call c, int prec) {
        return c.printProgram(prec);
    }
    public static Printer printUnary = new Printer()
    {
        public String print(Call c, int prec)
        {
            String r = c.function.name;
            r = c.function.name + c.p.get(0).printProgram(c.function.leftPrec);
            return r;
        }
    };
    public static Printer printInfix = new Printer()
    {
        public String print(Call c, int prec)
        {
            String r = c.p.get(0).printProgram(c.function.leftPrec);
            r += c.function.name;
            r += c.p.get(1).printProgram(c.function.rightPrec);
            if(prec > c.function.myPrec)
            {
                r = "(" + r + ")";
            }
            return r;
        }
    };
    
}
