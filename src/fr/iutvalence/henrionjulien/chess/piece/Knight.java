package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 * the Knight of a traditional chess game.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Knight extends Piece
{

	/**
	 * TODO.
	 *
     */
	public Knight(Color color)
	{
		super(color);
	}

	
	@Override
	public String toString() {
		return String.format("[%s Knight]\t",super.toString());
	}

	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][])  throws NoMoveException 
	{
		if(currentPiece.getY() == nextPiece.getY() && currentPiece.getX() == nextPiece.getX())
			throw new NoMoveException();	
		if(currentPiece.getY() == nextPiece.getY()+2 && currentPiece.getX() == nextPiece.getX()+1)
			return true;
		if(currentPiece.getY() == nextPiece.getY()+2 && currentPiece.getX() == nextPiece.getX()-1)
			return true;
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX()+2)
			return true;
		if(currentPiece.getY() == nextPiece.getY()-1 && currentPiece.getX() == nextPiece.getX()+2)
			return true;
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX()-2)
			return true;
		if(currentPiece.getY() == nextPiece.getY()-1 && currentPiece.getX() == nextPiece.getX()-2)
			return true;
		if(currentPiece.getY() == nextPiece.getY()-2 && currentPiece.getX() == nextPiece.getX()+1)
			return true;
		if(currentPiece.getY() == nextPiece.getY()-2 && currentPiece.getX() == nextPiece.getX()-1)
			return true;
		
		return false;
	}

}
