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
public class Variable extends Program   {
// A Variable contains a string called "name"
    public String name;
public Variable(String name){
    this.name = name;
}    
    


    @Override
    public String printProgram(int prec) {
        return name;
    }

    @Override
    public Program derive() {
        if(name.equals("x") )
        {
           return Ops.mkNum(1);
        }
        else return Ops.mkNum(0);
    }
    @Override
    public boolean isVar(String x)
    {
        return name.equals(x);
    }
    @Override
    public boolean same(Program p) {
        return p.isVar(this.name);
    }
    
}
