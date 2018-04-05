
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
public class Buckets implements HashTable{
    public int size;
    public int numKeys = 0;
    public Hasher hasher;
    Link[] a;  
    
    public int compares = 0;
    public Buckets(Hasher hasher, int size)
    {
        this.hasher = hasher;
        this.size = size;
        this.a = new Link[size];
    }

    @Override
    public int get(String s) {
        HashedString k = new HashedString(s, hasher);
        int i = Math.abs(k.hash) % size;
        Link l = a[i];
        while(l != null){
            compares++;
            if(l.h.same(k))
                return l.value;
            //i = (i+1) % size;
            l = l.link;
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
        //tell us where to look
        int i = Math.abs(str.hash) % size;
        Link l = a[i];
        while(l != null)//cycle through each location
        {
            compares++;
            //see if the hashcode is same as the one that were at
            
            if(l.h.same(str))  {
                l.value = v;
                return;
            }
//            if(a[i] == null) a[i] = 0;
            //i = (i+1) % size;
            l = l.link;
        }
        a[i] = new Link(str, v, a[i]);
        //size++;
        numKeys++;
        
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
            Link l = a[i];
            while(l != null){
                a1.add(l.h.s);
                l = l.link;
            }
            
        }
        return a1;
    }
    
}
