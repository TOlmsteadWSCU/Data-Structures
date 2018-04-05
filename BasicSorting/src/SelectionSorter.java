/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class SelectionSorter implements Sorter
{
    @Override
    public void sort(Sortable s) {
        for(int i=0; i<s.size()-1; i++)
        {
            int best = i;
            for(int j=i+1; j<s.size(); j++)
            {
                if(s.gtr(best, j))
                {
                    s.swap(best, j);
                }
            }
            
        }
    }

    @Override
    public String description() {
        return "SelectionSorter";
    }
    
}//SelectionSorter
