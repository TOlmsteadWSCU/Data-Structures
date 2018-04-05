/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Sorters 
{
    
    public Sorter insertion = new Sorter()
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
    }//Description
    };//InsertSorter
    public Sorter bubble = new Sorter()
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
    }//Description
    };//BubbleSorter
    public Sorter selection = new Sorter()
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
    }//Description
    };//SelectionSorter
    public static Sorter heapSort = new Sorter()
    {
        public void heapify(int i, Sortable s, int n) {  // n is the limit of s
        int l = 2*i+1;
        int r = 2*i+2;
        if (r < n) {
           if (s.gtr(l, i) || s.gtr(r, i)) {
              if (s.gtr(l,r)) {
                  s.swap(i,l);
                  heapify(l,s,n);
              } else {
                  s.swap(i,r);
                  heapify(r,s,n); }}} 
          else if (l < n) {
             if (s.gtr(l, i)) s.swap(i,l);  }

        }//heapify

        @Override
        public void sort(Sortable s) {
            
            for(int i=s.size()/2; i>=0; i--)
            {
                heapify(i, s, s.size());
                
                //call heapify after swap
                //calling sortable from halfway in heapify
                //n-1 to the beginning
            }
            for(int j=s.size(); j>=0; j--)
                {
                    s.swap(0, j);
                    heapify(0, s, j);
                }
        }

        @Override
        public String description() {
            return "HeapSorter";
        }
    };//HeapSort
    public Sorter[] allSorters = {insertion, bubble, selection, heapSort};
}//Sorters
