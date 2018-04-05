
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Snapshot 
{   
    public int special1, special2;
    public Color specialColor;
    public String action;
    public int[] a;
    public int swapCount, compareCount;
    public Snapshot(int[] a, int swapCount, int compareCount)
    {
        this.a=a;
        this.swapCount = swapCount;
        this.compareCount = compareCount;
    }//Constructor
    public void paint(Graphics g)
    {
        for(int i = 0; i<a.length; i++)
        {
            g.setColor(Color.red);
            g.fillRect(i*10, 0, 10, a[i] * 10);
        }
    }
    //swapCount and compareCount
}//Snapshot
