
package graphs;

import java.util.ArrayList;
import java.util.Random;


public class Point {
    public int x;
    public int y;
    public int clusterNumber = 0;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    public int sx() {
        return x*2;
    }
    public int sy() {
        return (int) (y*1.3)-30;
    }
    public static Point ToPoint(int x, int y) {
        return new Point(x/2, (int) ((y-30)/1.3));
    }
    public boolean near(double x, double y) {
        double sx = sx();
        double sy = sy();
        return ((x-sx)*(x-sx) + (y-sy)*(y-sy) < 25);
    }
    public double getX(double x)
    {
        return this.x;
    }
    public double getY(double y)
    {
        return this.y;
    }
    public void setCluster(int n)
    {
        this.clusterNumber = n;
    }
    public double getCluster()
    {
        return this.clusterNumber;
    }
    /*public static Point createRandomPoint(double min, double max)
    {
        Random r = new Random();
        double x = min + (max - min) * r.nextDouble();
        double y = min + (max - min) * r.nextDouble();
        return new Point(x, y);
    }
    public static ArrayList createRandomPoints(int min, int max, int number)
    {
        ArrayList points = new ArrayList(number);
        for(int i=0; i<number; i++)
        {
            points.add(createRandomPoint(min, max));
        }
        return points;
    }*/
}

