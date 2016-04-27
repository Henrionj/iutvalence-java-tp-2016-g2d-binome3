package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 * the King of a traditional chess game.
 *
 * @author henrion & murer
 * @version 1
 */
public class King extends Piece
{

	/**
	 * The constructor for the King.
	 * @param color the color of the King.
	 *
	 * 
     */
	public King(Color color)
	{
		super(color);

	}

	
	@Override
	public String toString() {
		return String.format("[%s King]\t",super.toString());
	}

	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) throws NoMoveException 
	{
		if(currentPiece.getY() == nextPiece.getY() && currentPiece.getX() == nextPiece.getX())
			throw new NoMoveException();
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX())
			return true;
		if(currentPiece.getY() == nextPiece.getY()-1 && currentPiece.getX() == nextPiece.getX())
			return true;
		if(currentPiece.getY() == nextPiece.getY() && currentPiece.getX() == nextPiece.getX()+1)
			return true;
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX()-1)
			return true;
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX()+1)
			return true;
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX()-1)
			return true;
		if(currentPiece.getY() == nextPiece.getY()-1 && currentPiece.getX() == nextPiece.getX()+1)
			return true;
		if(currentPiece.getY() == nextPiece.getY()-1 && currentPiece.getX() == nextPiece.getX()-1)
			return true;
		return false;
	}

	
}
