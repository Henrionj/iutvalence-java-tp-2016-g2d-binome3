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

	/**
	 * [8,8],[-8,-8],[-8,8],[8,-8] maximal move possible for the bishop.
	 */
	@Override
	protected int[][] createMove()
	{
		return new int[][]{{8,-8,-8,8},{8,-8,8,-8}};
	}

}
