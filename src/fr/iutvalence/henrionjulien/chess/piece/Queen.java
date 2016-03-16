package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Board;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Queen extends Piece
{

	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	public Queen()
	{
		super();

	}

	@Override
	protected int[][] createMove()
	{
		/**
		 * [8,8],[-8,-8],[-8,8],[8,-8],[0,8],[0,-8],[8,0],[-8,0] maximal move possible for the queen.
		 */
		return new int[][]{{8,-8,-8,8,0,0,8,-8},{8,-8,8,-8,8,-8,0,0}};
	}
	
}
