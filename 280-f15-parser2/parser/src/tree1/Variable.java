package tree1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Variable extends Program {
    public String name;
    public Variable(String name)
    {
        this.name = name;
    }
    
    @Override
    public String printProgram(int prec) {
return "" + name;    }
    
}
