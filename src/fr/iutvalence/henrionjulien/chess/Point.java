package fr.iutvalence.henrionjulien.chess;

/**
 * create a Point represented by two attribute, x and y.
 * @author henrionj
 *
 */
public class Point 
{
	/**
	 * attribut of position X for abscisse
	 * 						Y for ordered
	 */
	private final int x,
					  y;
	/**
	 * 
	 * @param x attribut of position X for abscisse
	 * @param y Y for ordered
	 */
	public Point(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	/**
	 * 
	 * @return x the attribut of postion X for abscisse
	 */
	public int getX() {
		return x;
	}
	/**
	 * 
	 * @return y the attribut of postion Y for Ordered
	 */
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Point [ "+ x + " , " + y + "]";
	}
	
	
	
}
