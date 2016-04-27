package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 * the Pawn of a traditional chess game.
 *
 * @author henrion & murer
 * @version 1
 */
public class Pawn extends Piece
{
	/**
	 * a boolean used to know if the first move have already been done.
	 */
	private boolean firstMove;
	/**
	 * The constructor for the Pawn.
	 * @param color the color of the Pawn.
     */
	public Pawn(Color color)
	{
		super(color);
		this.firstMove = true;
	}
	
	@Override
	public String toString() {
		return String.format("[%s Pawn]\t",super.toString());
	}
	
	/**
	 * 
	 * @return <tt>true</tt> if this is the first move for the piece, <tt>false</tt> if not.
	 */
	public boolean isFirstMove()
	{
		return firstMove;
	}

	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) throws NoMoveException 
	{
		if(currentPiece.getY() == nextPiece.getY() && currentPiece.getX() == nextPiece.getX())
			throw new NoMoveException();
		if(currentPiece.getY() == nextPiece.getY()+2 && isFirstMove() 
				&& p[nextPiece.getY()][nextPiece.getX()].getColor() == Color.BLANK)
			return true;
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX() 
				&& p[nextPiece.getY()][nextPiece.getX()].getColor() == Color.BLANK)
			return true;
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX()+1 
				&& p[nextPiece.getY()][nextPiece.getX()].getColor() != Color.BLANK)
			return true;
		if(currentPiece.getY() == nextPiece.getY()-1 && currentPiece.getX() == nextPiece.getX()+1 
				&& p[nextPiece.getY()][nextPiece.getX()].getColor() != Color.BLANK)
			return true;
		return false;
	}
	
	


}
