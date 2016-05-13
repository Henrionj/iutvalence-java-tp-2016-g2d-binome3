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
	private boolean isMoved;
	public King(Color color)
	{
		super(color);
		this.isMoved = false;

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
		{
			this.isMoved = true;
			return true;
		}
		if(currentPiece.getY() == nextPiece.getY()-1 && currentPiece.getX() == nextPiece.getX())
		{
			this.isMoved = true;
			return true;
		}
		if(currentPiece.getY() == nextPiece.getY() && currentPiece.getX() == nextPiece.getX()+1)
		{
			this.isMoved = true;
			return true;
		}
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX()-1)
		{
			this.isMoved = true;
			return true;
		}
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX()+1)
		{
			this.isMoved = true;
			return true;
		}
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX()-1)
		{
			this.isMoved = true;
			return true;
		}
		if(currentPiece.getY() == nextPiece.getY()-1 && currentPiece.getX() == nextPiece.getX()+1)
		{
			this.isMoved = true;
			return true;
		}
		if(currentPiece.getY() == nextPiece.getY()-1 && currentPiece.getX() == nextPiece.getX()-1)
		{
			this.isMoved = true;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isKing()
	{
		return true;
	}


	public boolean isMoved() {
		return isMoved;
	}


	public void Moved() {
		isMoved = true;
	}
	
	

	
	
}
