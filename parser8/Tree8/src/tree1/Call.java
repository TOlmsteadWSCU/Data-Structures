/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree1;

import java.util.ArrayList;

/**
 *
 * @author gunny
 */
public class Call extends Program {
// A Call contains a string called "function" and an ArrayList of Program objects

   
public Op function;
    public ArrayList<Program> args = new ArrayList<Program>();
    public Call(Op function)
    {
        this.function = function;
        this.args = new ArrayList<Program>();
    }
 
    
@Override
    public boolean isCall(Op fn)
    {
        return function == fn;
    }
    public void addArg(Program a)
    {
        //make tree one bigger
        args.add(a);
    }
 
    public String printProgram(int prec) {
        return function.printer.print(this, prec);
    }
    @Override
    public Program simplify()
    {
        return function.simplifier.simplify(this);
    }

    @Override
    public Program derive() {
        return function.deriver.derive(this);
        
    }
    @Override
    public int size()
    {
        int count = 1;
        for(Program p: args)
        {
            count += p.size();
            
        }
        return count;
    }

    @Override
    public boolean same(Program p) {
        if(p.isCall(function))
        {
            Call c = (Call)p;
            for(int i=0; i<args.size(); i++)
            {
                if(!args.get(i).same(c.args.get(i)))
                    return false;
            }
            return true;
        }
        return false;
    }
}