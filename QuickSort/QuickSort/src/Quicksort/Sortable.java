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
public interface Sortable {
  public int size();                // return the size of the collection
  public boolean gtr(int i, int j); // Is a[i] > a[j]?
  public void swap(int i, int j);   // Swap the elements at i and j in the array
  public int getCompares();         // Return the number of times that gtr has been called
  public int getSwaps();            // Return the number of times that swap has been 
 public Snapshot snap();
}
