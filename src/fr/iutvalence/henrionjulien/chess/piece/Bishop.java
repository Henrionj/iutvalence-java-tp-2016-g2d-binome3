package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 * the Bishop of a traditional chess game.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Bishop extends Piece
{

	/**
	 * TODO.
	 *
	 *
     */
	public Bishop(Color color)
	{
		super(color);
	}

	
	@Override
	public String toString() {
		return String.format("[%s Bishop]\t",super.toString());
	}

	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) throws NoMoveException 
	{
		int x = 1
		   ,y = 1;
		if(currentPiece.getY() == nextPiece.getY() && currentPiece.getX() == nextPiece.getX())
			throw new NoMoveException();
		if(-(nextPiece.getY()-currentPiece.getY()) == nextPiece.getX() - currentPiece.getX())
		{
			while(currentPiece.getX()+x != nextPiece.getX())
			{
				if(p[currentPiece.getY()-y][currentPiece.getX()+x].getColor() != Color.BLANK)
					return false;
				x++;
				y++;
			}
			return true;	
		}
		if(nextPiece.getY()-currentPiece.getY() == -(nextPiece.getX() - currentPiece.getX()))
		{
			while(currentPiece.getY()+y != nextPiece.getY())
			{
				if(p[currentPiece.getY()+y][currentPiece.getX()-x].getColor() != Color.BLANK)
					return false;
				x++;
				y++;
			}
			return true;	
		}
		
		if(nextPiece.getY()-currentPiece.getY() == nextPiece.getX() - currentPiece.getX() && nextPiece.getY()-currentPiece.getY()>0)
		{
			while(currentPiece.getY()+y != nextPiece.getY())
			{
				if(p[currentPiece.getY()+y][currentPiece.getX()+x].getColor() != Color.BLANK)
					return false;
				x++;
				y++;
			}
			return true;	
		}
		if(nextPiece.getY()-currentPiece.getY() == nextPiece.getX() - currentPiece.getX() && nextPiece.getY()-currentPiece.getY()<0)
		{
			while(currentPiece.getY()-y != nextPiece.getY())
			{
				if(p[currentPiece.getY()-y][currentPiece.getX()-x].getColor() != Color.BLANK)
					return false;
				x++;
				y++;
			}
			return true;	
		}
		
		return false;
	}


}
