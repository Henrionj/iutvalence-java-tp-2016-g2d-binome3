package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Board;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Bishop extends Piece
{

	/**
	 * TODO.
	 *
	 * @param board TODO.
     */
	public Bishop()
	{
		super();
	}

	protected int[][] createMove()
	{
		/**
		 * [8,8],[-8,-8],[-8,8],[8,-8] maximal move possible for the bishop.
		 */
		return new int[][]{{8,-8,-8,8},{8,-8,8,-8}};
	}

}
