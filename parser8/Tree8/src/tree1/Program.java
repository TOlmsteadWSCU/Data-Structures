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

public abstract class Program {
   public abstract String printProgram(int prec);
   public Program simplify() {
       return this;
   }
   public double cval() {  // The value of a constant
       return 0;
   }
   public boolean isConst() {
       return false;
   }
   public boolean isConst(double c) {
       return false;
   }
   public boolean isVar(String x)
   {
       return false;
   }
   public boolean isCall(Op fn) {
       return false;
   }
   public String toString()
   {
      return printProgram(0);
   }
   public abstract Program derive();
   public abstract boolean same(Program p);
   public int size()
   {
       return 1;
   }
   
}    
