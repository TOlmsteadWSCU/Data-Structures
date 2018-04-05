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
public class CC<T> implements Sortable {
  int countCom = 0;
  int countSwap = 0;
  public Indexable<T> container;
  public Comparable<T> compare;

    
     public CC(Comparable<T> compare, Indexable<T> container)
{
    this.compare = compare;
    this.container = container;
}

    @Override
    public int size() {
       
        return container.size();
    }

    @Override
    public boolean gtr(int i, int j) {
       countCom++;
       T x = container.get(i);
       T y = container.get(j);
       
       return compare.gtr(x, y);
    }

    @Override
    public void swap(int i, int j) {
       
            countSwap++;
            T x = container.get(i);
            T y = container.get(j);
            
            container.put(i, y);
            container.put(j, x);
            
            
            
        
    }

    @Override
    public int getCompares() {
        return countCom;
    }

    @Override
    public int getSwaps() {
       return countSwap;
       
    }
    
  @Override
    public String toString(){
        return container.toString();
    }
    
  @Override
   public Snapshot snap(){
       Snapshot s = container.snap();
       s.compares=countCom;
       s.swaps = countSwap;
       return s;
}
}
