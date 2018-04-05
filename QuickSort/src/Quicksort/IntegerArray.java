/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quicksort;

/**
 *
 * @author stu461516
 */
public class IntegerArray implements Indexable<Integer>{
    int[] a;
    public Snapshot s;
    
    public IntegerArray(int[] a){
    
    this.a = a.clone();
    s=new Snapshot(this.a,0,0);
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
    
    @Override
    public String toString(){
        String s = "";
        for(int i : a){
            s = s + " " + i;
        }
        return s;
    }
    
    @Override
    public Snapshot snap(){
        return new Snapshot(a.clone(), 0,0);
        
    }
    
    
}
