package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public abstract class Piece
{

	private final Color color;

	/**
	 * The constructor for the Piece
	 * @param color the color of the piece
     */
	protected Piece(Color color)
	{
		
		this.color = color;
	}
	
	
	public Color getColor()
	{
		return this.color;
	}
	
	public String toString() {
		return color.toString();
	}
	
	public abstract boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]);

}
