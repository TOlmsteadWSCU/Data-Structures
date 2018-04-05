
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Linear implements HashTable {
    public int size;
    public int numKeys = 0;
    public Hasher hasher;
    Pair[] a;  
    public int compares = 0;
    public Linear(Hasher hasher, int size)
    {
        this.hasher = hasher;
        this.size = size;
        this.a = new Pair[size];
        
    }
    @Override
    public int get(String s) {
        HashedString str = new HashedString(s, hasher);
        //tell us where to look
        int i = Math.abs(str.hash) % size;
        
        while(a[i] != null)//cycle through each location
        {
            compares++;
            //see if the hashcode is same as the one that were at
            
            if(a[i].h.same(str)) return a[i].value;
            if(a[i] == null) return 0;
            i = (i+1) % size;
        }
        return 0;
    }

    @Override
    public int size() {
        return numKeys;
              
    }

    @Override
    public void set(String s, int v) {
        HashedString str = new HashedString(s, hasher);
        int i = Math.abs(str.hash) % size;
        while(a[i] != null)
        {
            compares++;
            if(numKeys == size - 1)
            {
                System.out.println("Error:  The table is full!");
                return;
            }
            if(a[i].h.same(str)){
                a[i].value = v;
                return;
            }
            i = (i + 1) % size;
            
        }
        numKeys++;
        a[i] = new Pair(str, v);
    }

    @Override
    public int getCompares() {
        return compares;
    }

    @Override
    public ArrayList<String> getKeys() {
        ArrayList<String> a1 = new ArrayList<String>();
        for(int i=0; i<size; i++)
        {
            if(a[i] != null)
                a1.add(a[i].h.s);
        }
        return a1;
    }
    
}
