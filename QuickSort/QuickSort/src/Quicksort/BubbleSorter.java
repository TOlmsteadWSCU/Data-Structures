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
public class BubbleSorter implements Sorter {

    @Override
    public void sort(Sortable s) {
        boolean sorted = false;
        
        while(!sorted){
            for(int i = 0; i < s.size(); i++){
                for(int j = 0; j < s.size() - 1; j++){
                    if(s.gtr(j, i)){
                        s.swap(i, j);
                        
                    }
                    else
                        sorted = true;
                }
            }
        }
    }

    @Override
    public String description() {
        
        return "Selection ";
        
    }
    
}