/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class CC<T> implements Sortable
{
    public int swapCount = 0;
    public int compCount = 0;
    public Comparable<T> compare;
    public Indexable<T> container;
    public CC(Comparable<T> compare, Indexable<T> container)
    {
        this.compare = compare;
        this.container = container;
    }

    @Override
    public int size() {
        return container.size();
    }

    @Override
    public boolean gtr(int i, int j)
    {
        T x = container.get(i);
        T y = container.get(j);
        compCount++;
        return compare.gtr(x, y);
        
    }

    @Override
    public void swap(int i, int j)
    {
        T x = container.get(i);
        T y = container.get(j);
        container.put(i, y);
        container.put(j, x);
        swapCount++;
    }

    @Override
    public int getCompares()
    {
        return compCount;
    }
    
    @Override
    public int getSwaps()
    {
        return swapCount;
    }
    public String toString()
    {
        return container.toString();
    }
    public Snapshot snap()
    {
        Snapshot s = container.snap();
        s.compareCount = compCount;
        s.swapCount = swapCount;
        return s;
    }
}
