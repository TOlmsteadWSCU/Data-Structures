/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class RandomData 
{
    public CC<Integer> cc;
    public int[] a;
    public String description;
    public RandomData(int [] a, String description) {
        this.a = a;
        this.description = description; 
      }
   public CC<Integer> getData() {
        return new CC<Integer>(new GtrInt(), new IntegerArray(a));
        // Copy the data into a CC object 
      }
   public String getDescription() {
       return description;
      // Return the description
      }

}
