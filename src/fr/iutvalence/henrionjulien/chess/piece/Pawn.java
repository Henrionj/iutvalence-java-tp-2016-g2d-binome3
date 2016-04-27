package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 * the Pawn of a traditional chess game.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Pawn extends Piece
{
	
	private boolean firstMove;
	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	public Pawn(Color color)
	{
		super(color);
		this.firstMove = true;
	}
	
	@Override
	protected int[][] createMove()
	{
		return new int[][]{{0},{1}};
	}
	@Override
	public String toString() {
		return String.format("[%s Pawn]\t",super.toString());
	}
	
	/**
	 * 
	 * @return true if this is the first move for the piece, false if not.
	 */
	public boolean isFirstMove()
	{
		return firstMove;
	}

	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) 
	{
		if(currentPiece.getY() == nextPiece.getY()+2 && isFirstMove())
			return true;
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX())
			return true;
		return false;
	}
	
	public boolean eat(Point currentPiece, Point nextPiece,boolean isEatable) 
	{
		if(currentPiece.getY() == nextPiece.getY()+1 && currentPiece.getX() == nextPiece.getX()+1 && isEatable)
			return true;
		if(currentPiece.getY() == nextPiece.getY()-1 && currentPiece.getX() == nextPiece.getX()+1 && isEatable)
			return true;
			
		return false;
	}
	


}
