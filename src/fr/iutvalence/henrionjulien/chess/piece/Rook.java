package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 * the Rook of a traditional chess game.
 * 
 * @author henrion & murer
 * @version 1
 */
public class Rook extends Piece
{

	/**
	 * The constructor for the Rook.
	 * @param color the color of the Rook.
	 * 
	 * 
     */
	private boolean isMoved;
	/**
	 * Check if the Rook have been moved
	 * this method is usefull to know if the player can whether or not do a castling.
	 * @param color The color of the piece.
	 */
	
	public Rook(Color color)
	{
		super(color);
		this.isMoved = false;

	}
								
	
	@Override
	public String toString() {
		return String.format("[%s Rook]\t",super.toString());
	}

	
	
	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) throws NoMoveException 
	{
		if(currentPiece.getY() == nextPiece.getY() && currentPiece.getX() == nextPiece.getX())
			throw new NoMoveException();
		int i = 1;
		if(currentPiece.getY() == nextPiece.getY())
		{
			if(currentPiece.getX() < nextPiece.getX())
			{
				while(currentPiece.getX()+i != nextPiece.getX())
				{
					if(p[currentPiece.getY()][currentPiece.getX()+i].getColor() != Color.BLANK)
						return false;
					i++;
				}
				this.isMoved = true;
				return true;
			}
			else
			{
				i = 1;
				while(currentPiece.getX()-i != nextPiece.getX())
				{
					
					if(p[currentPiece.getY()][currentPiece.getX()-i].getColor() != Color.BLANK)
						return false;
					i++;
				}
				this.isMoved = true;
				return true;
				
			}
		}
		if( currentPiece.getX() == nextPiece.getX())
		{
			if(currentPiece.getY() < nextPiece.getY())				
			{
				i = 1;
				while(currentPiece.getY()+i != nextPiece.getY())
				{
					if(p[currentPiece.getY()+i][currentPiece.getX()].getColor() != Color.BLANK)
						return false;
					i++;
				}
				this.isMoved = true;
				return true;
			}
			else
			{
				i = 1;
				while(currentPiece.getY()-i != nextPiece.getY())
				{				
					if(p[currentPiece.getY()-i][currentPiece.getX()].getColor() != Color.BLANK)
						return false;
					i++;
				}
				this.isMoved = true;
				return true;
				
			}
		}
		
			return false;
	}

	/**
	 * Check if the rook have been move during the game.
	 */
	public boolean isMoved() {
		return isMoved;
	}
	/**
	 * Check if the piece is a rook.
	 */
	public boolean isRook()
	{
		return true;
	}
	
	
	
}
