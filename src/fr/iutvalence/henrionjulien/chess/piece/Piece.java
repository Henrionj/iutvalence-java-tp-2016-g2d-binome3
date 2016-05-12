package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 *  A piece on the chessboard.Can't be created except his children.
 *
 * @author henrion & murer
 * @version 1
 */
public abstract class Piece
{
	/**
	 *  the color of the piece.
	 * 
	 */
	private final Color color;

	/**
	 * The constructor for the Piece
	 * @param color the color of the piece
     */
	protected Piece(Color color)
	{
		
		this.color = color;
	}
	
	/**
	 * 
	 * 
	 * @return the color of the piece.
	 */
	public Color getColor()
	{
		return this.color;
	}
	
	public String toString() {
		return color.toString();
	}
	
	/**
	 * 
	 * @param currentPiece
	 * @param nextPiece
	 * @param p an array of pieces.
	 * @return <tt>true</tt> if the move is possible, <tt>false</tt> if not.
	 * @throws NoMoveException
	 */
	public abstract boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) throws  NoMoveException;
	
	public boolean isKing()
	{
		return false;
	}

	public boolean isPawn()
	{
		return false;
	}
	
	public boolean isRook()
	{
		return false;
	}
}
