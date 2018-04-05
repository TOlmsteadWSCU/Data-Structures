/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class BubbleSorter implements Sorter
{

    @Override
    public void sort(Sortable s) {
        boolean sort = false;
        int counter = 1;
        while(!sort)
        {
            sort = true;
            for(int i=0; i<s.size() - counter; i++)
            {
                if(s.gtr(i, i+1))
                {
                    s.swap(i, i+1);
                    sort = false;
                }
            }
            counter++;
        }
    }

    @Override
    public String description() {
        return "Bubble Sorter";
    }
    
}//BubbleSorter
