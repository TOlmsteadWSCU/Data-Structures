/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quicksort;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author stu461516
 */
public class Snapshot {
    public int swaps;
    public int compares;
    public int [] ss;
    public int special1 = -1;
    public int special2 = -1;
    public String action = "";
    public Color specialColor = Color.red;
    
    
    public Snapshot (int [] ss, int swaps, int compares) {
        this.swaps = swaps;
        this.compares = compares;
        this.ss = ss;
        
    }
    
    
    
    public void paintComponent(Graphics g) {
          
           for (int i = 0; i < ss.length; i++) {
               if(i==special1 || i == special2){
                   g.setColor(specialColor);
               }
               else
                   g.setColor(Color.black);
               
               g.fillRect(i*10, 0, 10, ss[i]*10);
           }
       }
    
    
}
