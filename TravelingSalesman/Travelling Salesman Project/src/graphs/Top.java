/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

public class Top {
    // You may add other variables and methods
    public static int[] cities;
    public static int bestfinal = 0;
    public static ArrayList<Integer> bestpath;
    
    public static int[] group;
    public static int[] centers;
//    public static IRoute bestRoute = null;
//    public static boolean competing = false;
    public static JFrame gui = null;
    public static String[] testCities = {"Grand Junction", "Denver", "Durango", "Craig", "Alamosa", "Boulder", "Pueblo", "Naturita"};
    public static void planRoute(String[] cities) { 
        System.out.println("Build route not implemented yet");
    }
    
    public static Journey paths[][];
    public static void getShortest() {
        paths = new Journey[City.cities.size()][City.cities.size()];
        for (City c : City.cities) {
            for (Road r : c.roads) {
                if (r.start == c) {
                    paths[r.start.n][r.end.n] = new Journey(r, r.start, r.end);
                } else {
                    paths[r.end.n][r.start.n] = new Journey(r, r.end, r.start);
                }
            }
        }
        boolean changed = true;
        while (changed) {
            changed = false;
            for (City from : City.cities) {
                for (Road r : from.roads) {
                    City via;
                    if (r.start == from) {
                        via = r.end;
                    } else {
                        via = r.start;
                    }
                    for (City to : City.cities) {
                        Journey ft = paths[from.n][to.n];
                        Journey vt = paths[via.n][to.n];
                        if (from != to && via != to && vt != null) {
                            if ( ft == null || ft.length > r.length + vt.length ) {
                                paths[from.n][to.n] = new Journey(r, from, to, vt);
                                changed = true;
                            }
                        }
                    }
                }
            }
        }
    }
    
    
    
    
    public static void main(String[] args) {
        String err = MapReader.readMapFile(new File("coloradomap.csv"));
        if (err != null) {
            System.out.println("Error: " + err);
            System.exit(0);
        }
        getShortest();
        cities = new int[testCities.length];
        for(int i=0; i < testCities.length; i++)
        {
            cities[i] = City.find(testCities[i]).n;
            System.out.println(cities[i]);
        }
        comparePath(new ArrayList<Integer>());
        for(int i : bestpath)
        {
            System.out.print(City.cities.get(i) + ", ");
        }
        System.out.println("");
        System.out.println("Best length " + bestfinal);
//        Journey p = paths[City.find("Gunnison").n][City.find("Denver").n];
//        System.out.println("Distance from Gunnison to Denver: " + p.length);
//        while (p != null) {
//            System.out.println("Drive from " + p.from + " on " + p.road.name + " (" + p.road.length + ")");
//            p = p.next;
//        }
        
    }
    public static int findLength(ArrayList<Integer> a)
    {
            int finalDistance = 0;
            for(int i=0; i<a.size()-1; i++)
            {
                finalDistance += paths[a.get(i)][a.get(i+1)].length;
            }
            return finalDistance;
    }
    public static void comparePath(ArrayList<Integer> a)
    {
        //arraylist bestpath
        if(a.size() == testCities.length)
        {
            int x = findLength(a);
            if(bestfinal == 0 || x < bestfinal)
            {
                bestfinal = x;
                bestpath = a;
            }
        }
            else
            {
                for(int i : cities)
                {
                    if(!a.contains(i))
                    {
                        ArrayList<Integer> a1 = (ArrayList<Integer>)a.clone();
                        a1.add(i);
                        comparePath(a1);
                    }
                    
                }
            }
        
    }
    public static void randomPoints()
    {
        int n = 10;
        //Randomly assign cities a number bw 0 and n-1
        Random r = new Random();
        int x = r.nextInt(n-1);
        group = new int[x];
        
    }
    
}
