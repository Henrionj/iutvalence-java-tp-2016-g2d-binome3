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
	 * @param board TODO.
     */
	public King(Color color)
	{
		super(color);

	}

	@Override
	protected int[][] createMove()
	{
		
		/**
		 * [1,1],[-1,-1],[-1,1],[1,-1],[0,1],[0,-1],[1,0],[-1,0] maximal move possible for the king.
		 */
		return new int[][]{{1,-1,-1,1,0,0,1,-1},{1,-1,1,-1,1,-1,0,0}};
	}
	
	@Override
	public String toString() {
		return String.format("[%s King]\t",super.toString());
	}

	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece) {
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX())
			return true;
		
		return false;
	}

	
}
