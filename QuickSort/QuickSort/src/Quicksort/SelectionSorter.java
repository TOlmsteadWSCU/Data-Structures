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
public class SelectionSorter implements Sorter {

    @Override
    public void sort(Sortable s) {
       for(int i = 0; i < s.size()- 1; i++){
        int index = i;
        for(int j = 0; j < s.size()-1; j++){
            if(s.gtr(j, index)){
                index = j;
                
            }
            s.swap(i, index);
        }
    }
    
}
    @Override
    public String description() {
        
        return "Selection ";
    }
    
    
}
