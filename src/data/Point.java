package data;

public class Point {

	public double x;
	public double y;
	
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override 
	public boolean equals(Object o)
	{
		if(o instanceof Point)
			if( ((Point)o).getX() == x && ((Point)o).getY() == y)
				return true;

		return false;
	}
	
	@Override 
	public String toString()
	{
		return "("+x+","+y+")";
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
}
