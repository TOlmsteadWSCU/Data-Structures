/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quicksort;

/**
 *
 * @author stu461516
 * @param <T>
 */
public interface Indexable<T> {
    public int size();
   public T get(int i);
   public void put(int i, T obj);
   public Snapshot snap();
   

}
