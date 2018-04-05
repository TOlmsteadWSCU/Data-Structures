
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
public class Spy implements Sortable
{
    public ArrayList<Snapshot> snapshot = new ArrayList<>();
    public CC<Integer> cc;
    public Spy(CC<Integer> cc)
    {
        this.cc = cc;
        snapshot.add(cc.snap());
    }

    @Override
    public int size() {
        return cc.size();
    }

    @Override
    public boolean gtr(int i, int j) {
        return cc.gtr(i, j);
    }

    @Override
    public void swap(int i, int j) {
        cc.swap(i, j);
        snapshot.add(cc.snap());
        
    }

    @Override
    public int getCompares() {
        return cc.compCount;
    }

    @Override
    public int getSwaps() {
        return cc.swapCount;
    }
    public Snapshot snap()
    {
        return cc.snap();
    }
}//Spy
