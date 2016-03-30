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
	

	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	public Pawn(Color color)
	{
		super(color);
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


}
