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
public class Printers implements Printer {

    public static Printer printBinary = new Printer() {

        public String print(Call c, int prec) {
            String r = c.args.get(0).printProgram(c.function.leftPrec);
            r += c.function.name;
            r += c.args.get(1).printProgram(c.function.rightPrec);
            if (prec > c.function.myPrec) {
                r = "(" + r + ")";

            }

            return r;
        }
    };

    public static Printer printUnary = new Printer() {

        public String print(Call c, int prec) {
            String r = c.function.name + c.args.get(0).printProgram(c.function.leftPrec);
            return r;
        }
    };

    public String print(Call c, int prec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
