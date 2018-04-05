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
public class RandomData {

    int[] a;
    String description;

    public RandomData(int[] a, String description) {

        this.a = a;
        this.description = description;

    }

    public CC<Integer> getData() {
        // Copy the data into a CC object 
        return new CC<Integer>(new GtrInt(), new IntegerArray(a));
    }

    public String getDescription() {
        // Return the description
        return description;
    }

   

}
