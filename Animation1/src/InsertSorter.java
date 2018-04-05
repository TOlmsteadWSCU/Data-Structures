/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class InsertSorter implements Sorter
{
    @Override
    public void sort(Sortable s)
    {
        for(int i=1; i<s.size(); i++)
        {
            for(int j=i; j>0; j--)
            {
                if(s.gtr(j-1,j))
                {
                    s.swap(j,j-1 );
                }
                else
                {
                    break;
                }
            }
        }
    }

    @Override
    public String description() {
        return "Insertion Sorter";
    }
}
