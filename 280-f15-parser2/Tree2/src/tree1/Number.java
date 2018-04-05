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
public class Number extends Program {
    public double value;
    public Number(double value)
    {
        this.value = value;
    }
    @Override
    public String printProgram() {
        return "" + value;
    }
    
}
