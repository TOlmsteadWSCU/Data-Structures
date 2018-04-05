
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
public interface HashTable {
    public int get(String s);
   public int size();
   public void set(String s, int v); // Print an error message if the table is full
   public int getCompares();
   public ArrayList<String> getKeys();  // Get all of the keys - note that you have to filter out the nulls


}
