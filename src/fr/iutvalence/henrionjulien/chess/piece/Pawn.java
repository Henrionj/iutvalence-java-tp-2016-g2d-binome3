package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Board;

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
	


}
