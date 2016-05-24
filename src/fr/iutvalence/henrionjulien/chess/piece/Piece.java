package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 *  A piece on the chessboard.Can't be created except his heirs.
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
	 * @param color The color of the piece.
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
	
	/**
	 * Check if the current piece is the king  
	 * @return <tt>true</tt> if the piece is a king, <tt>false</tt> if not.
	 */
	public boolean isKing()
	{
		return false;
	}
	/**
	 * Check if the current piece is the pawn.  
	 * @return <tt>true</tt> if the piece is a pawn, <tt>false</tt> if not.
	 */

	public boolean isPawn()
	{
		return false;
	}
	
	/**
	 * Check if the current piece is the rook  
	 * @return <tt>true</tt> if the piece is a rook, <tt>false</tt> if not.
	 */
	public boolean isRook()
	{
		return false;
	}
	
	/**
	 * Check if the piece is a king or a rook and has already move.
	 */
	public void Moved() {}
	
	/**
	 * Check if piece have already move. 
	 * @return <tt>true</tt> if the piece has already move and if it's a Rook or a King, <tt>false</tt> if not.
	 */
	public boolean isMoved(){
		
		return false;
	}
}
