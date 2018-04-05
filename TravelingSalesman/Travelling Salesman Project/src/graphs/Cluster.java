/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class Cluster {
    public ArrayList<Point> cities;
	public Point centroid;
	public int id;
	
	//Creates a new Cluster
	public Cluster(int id) {
		this.id = id;
		this.cities = new ArrayList();
		this.centroid = null;
	}

	public ArrayList getPoints() {
		return cities;
	}
	
	public void addPoint(Point point) {
		cities.add(point);
	}

	public void setPoints(ArrayList points) {
		this.cities = points;
	}

	public Point getCentroid() {
		return centroid;
	}

	public void setCentroid(Point centroid) {
		this.centroid = centroid;
	}

	public int getId() {
		return id;
	}
	
	public void clear() {
		cities.clear();
	}
	
	public void plotCluster() {
		System.out.println("[Cluster: " + id+"]");
		System.out.println("[Centroid: " + centroid + "]");
		System.out.println("[Points: \n");
		for(Point p : cities) {
			System.out.println(p);
		}
		System.out.println("]");
	}


        
}
