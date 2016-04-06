package fr.iutvalence.henrionjulien.chess;

/**
 * create a Point represented by two attribute, x and y.
 * @author henrionj
 *
 */
public class Point 
{
	private final int x,
					  y;
	
	public Point(int x,int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Point [ "+ x + " , " + y + "]";
	}
	
	
	
}
