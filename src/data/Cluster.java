package data;

import java.util.ArrayList;

public class Cluster {

	private ArrayList<Point> points;
	private Point centroid;
	
	public Cluster(Point initial)
	{
		centroid = initial;
		points = new ArrayList<>();
		points.add(initial);
	}
	
	public Point getCentroid()
	{
		return centroid; 
	}
	
	public void setCentroid(Point c)
	{
		centroid = c;
	}
	
	public void addPoint(Point p)
	{
		points.add(p);
	}
	
	public void empty()
	{
		points.clear();
	}
	
	public double distance(Point p)
	{
		double dis = Math.pow((p.getX() - centroid.getX()),2);
		dis += Math.pow((p.getY() - centroid.getY()),2);
		return dis;
	}
	
	public Point findCentroid()
	{
		double x = 0;
		double y = 0;
		for(Point p: points){
			
			x += p.getX();
			y+= p.getY();
		}
		
		x /= points.size();
		y /= points.size();
		
		return new Point(x,y);
	}
	
	@Override
	public String toString()
	{
		String s = "Centroid: "+ centroid;
		s+= "\nPoints:\n";
		for(Point p: points)
		{
			s+= p+"\n";
		}
		return s;
	}
}
