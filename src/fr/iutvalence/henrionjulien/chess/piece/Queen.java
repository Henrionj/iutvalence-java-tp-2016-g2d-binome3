package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 * the Queen of a traditional chess game.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Queen extends Piece
{

	/**
	 * TODO.
	 *
	 * 
     */
	public Queen(Color color)
	{
		super(color);

	}

	@Override
	public String toString() {
		return String.format("[%s Queen]\t",super.toString());
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
						return true;
						
					}
				}
				
		return false;
	}

	
}
