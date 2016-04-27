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
	protected int[][] createMove()
	{
		
		/**
		 * [2,-1],[1,-2],[-1,-2],[-2,-1],[-2,1],[-1,2],[1,2],[2,1] maximal move possible for the knight.
		 */
		return new int[][]{{2,1,-1,-2,-2,-1,1,2},{-1,-2,-2,-1,1,2,2,1}};
	}
	
	@Override
	public String toString() {
		return String.format("[%s Knight]\t",super.toString());
	}

	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) {
		
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
