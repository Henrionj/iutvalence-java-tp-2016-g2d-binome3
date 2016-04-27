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
	/** 
	 * 
	 * defaultMove give the higher movement who can do the piece
	 * color is the color of the piece
	 * 
	 * 
	 *  */
	private int defaultMove[][];
	private final Color color;

	/**
	 * The constructor for the Piece
	 * @param color the color of the piece
     */
	protected Piece(Color color)
	{
		
		this.defaultMove = createMove();
		this.color = color;
	}
	
	public int[][] allowedMovement() {
		return defaultMove;
	}

	/**
	 * 
	 *create the different moves for the pieces
	 * @return an array of maximum moves possible from the pieces
	 */
	protected abstract int[][] createMove();
	
	public Color getColor()
	{
		return this.color;
	}
	
	public String toString() {
		return color.toString();
	}
	
	public abstract boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]);

}
