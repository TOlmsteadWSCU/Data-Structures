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
public class Op {
  public String name;
  public int leftPrec = 0, rightPrec = 0, myPrec = 0;
  public Printer printer;
  public Simplifier simplifier;
  public Derive deriver;
  public Op (String name, int leftPrec,  int rightPrec, int myPrec, Printer printer, Simplifier simplifier, Derive deriver){
      this.name = name;
      this.leftPrec = leftPrec;
      this.rightPrec = rightPrec;
      this.printer = printer;
      this.simplifier = simplifier;
      this.deriver = deriver;
  }

//    Op(String string, int i, int i0, int i1, Printer printBinary, Simplifier simplifier) {
//        this.name = name;
//        this.leftPrec = leftPrec;
//        this.rightPrec = rightPrec;
//        this.printer = printer;
//        this.simplifier = simplifier;
//        this.deriver = deriver;
//    }
}
