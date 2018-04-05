/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class IntegerArray implements Indexable<Integer>
{
    public int[] a;
    public IntegerArray(int[] x)
    {
        this.a = x.clone();
    }
    @Override
    public int size() {
         return a.length;
    }

    @Override
    public Integer get(int i) {
        return a[i];
    }

    @Override
    public void put(int i, Integer obj) {
        a[i] = obj;   
    }
    public String toString()
    {
        String c = ", ";
        String s = "";
        for(int i = 0; i < a.length-1; i++)
        {
            s = s + a[i] + c;
        }
        s = s + a[a.length-1];
        return s;
    }
    
}
