/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree1;

import java.text.DecimalFormat;

/**
 *
 * @author gunny
 */
public class Number extends Program {
// A Number contains a double called "value"
    public double value;
    public DecimalFormat f = new DecimalFormat("0.#");
    
public Number(double value){
    this.value = value;
}    


    @Override
    public String printProgram(int prec) {
        if(value - Math.floor(value)==0)
        {
            return f.format(value);
        }
        return ("" + value);
    }
    
    @Override
   public double cval() {  // The value of a constant
       return value;
   }
    @Override
   public boolean isConst() {
       return true;
   }
    @Override
   public boolean isConst(double c) {
       return value == c;
   }

    @Override
    public Program derive() {
        return Ops.mkNum(0);
    }
    public boolean same(Program p)
    {
        return p.isConst(this.cval());
    }
    
}
