/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author jackthibodeau
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
  public static int compares = 0;
  public static void main(String[] args) {
       Link<Integer> lst = null;
       for (int i = 1; i <= 20; i++)
           lst = new Link<Integer>(i, lst);
       
       
       
       System.out.println("Input:  " + Link.print(lst));
       lst = Link.mergesort(lst);
          System.out.println("Output: " + Link.print(lst));      
       System.out.println("Compares: " + compares); 
       //System.out.println("Head:  " + Link.split(lst));
       //System.out.println("Tail:  " + Link.print(lst));    
    }
    
}

