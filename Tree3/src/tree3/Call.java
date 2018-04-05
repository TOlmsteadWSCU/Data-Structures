package tree3;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
//part of the tree with an operator with operands below it
//
public class Call extends Program {
    public String function;
    public ArrayList<Program> p;
    public Call(String function)
    {
        this.function = function;
        this.p = new ArrayList<Program>();
    }
    @Override
    public String printProgram() {
        if(p.size() == 1)
        {
            return function + "(" + p.get(0).printProgram() + ")";
        }
        else if(p.size() == 2)
        {
            return "(" + p.get(0).printProgram() + ", " + function + p.get(1).printProgram() + ")";
      }
      return "????";

    }
    public void addArg(Program a)
    {
        //make tree one bigger
        p.add(a);
    }
    
}
