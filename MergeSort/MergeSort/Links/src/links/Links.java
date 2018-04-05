/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package links;

/**
 *
 * @author fac_peterson
 */
public class Links {

    /**
     * @param args the command line arguments
     */
    public static int compares = 0;
    public static void main(String[] args) {
        Link<Integer> x = new Link<>(1, null);
        //System.out.println("x = " + Link.print(x));
        Link<Integer> y = new Link<>(2, x);
        //System.out.println("y = " + Link.print(y));
        x.data = 3;
        y = null;
        //System.out.println("y = " + Link.print(y));
        //System.out.println("y = " + y);
        
        Link<Integer> lst = null;
       for (int i = 1; i <= 20; i++)
           lst = new Link<Integer>(i, lst);
       
       
       
       System.out.println("Input:  " + Link.print(lst));
       lst = Link.mergesort(lst);
          System.out.println("Output: " + Link.print(lst));      
       System.out.println("Compares: " + compares); 
    }
    public static <T> int len(Link<T> lst) {
        if (lst == null) {
            return 0;
        }
        return 1+len(lst.next);
    }
    
}
