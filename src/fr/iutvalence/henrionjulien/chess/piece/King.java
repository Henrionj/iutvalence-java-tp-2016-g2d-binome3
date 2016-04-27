package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 * the King of a traditional chess game.
 *
 * @author henrion & murer
 * @version TODO
 */
public class King extends Piece
{

	/**
	 * TODO.
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
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) {
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
