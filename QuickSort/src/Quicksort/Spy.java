/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quicksort;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author stu461516
 * @param <T>
 */
public class Spy<T> implements Sortable {

    public CC<Integer> copy;
    public ArrayList<Snapshot> list = new ArrayList<>();

    public Spy(CC<Integer> a) {
        this.copy = a;
        Snapshot s = copy.snap();
        list.add(s);
    }

    @Override
    public int size() {
        return copy.size();
    }

    @Override
    public boolean gtr(int i, int j) {

        Snapshot s = copy.snap();
        s.special1 = i;
        s.special2 = j;
        s.specialColor = Color.CYAN;
        s.action = "Compare #" + copy.countCom;
        list.add(s);
        return copy.gtr(i, j);
    }

    @Override
    public void swap(int i, int j) {

        copy.swap(i, j);
        Snapshot s = copy.snap();
        s.special1 = i;
        s.special2 = j;
        s.specialColor = Color.YELLOW;
        s.action = "Swap #" + copy.countSwap;
        list.add(s);

    }

    @Override
    public int getCompares() {
        return copy.getCompares();
    }

    @Override
    public int getSwaps() {
        return copy.getSwaps();

    }

    @Override
    public Snapshot snap() {

        return copy.snap();

    }

}
