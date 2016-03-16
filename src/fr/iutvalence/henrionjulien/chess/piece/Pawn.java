package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Board;

/**
 * TODO.
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
	public Pawn()
	{
		super();
	}
	
	protected int[][] createMove()
	{
		return new int[][]{{0},{1}};
	}

}
