package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Board;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Rook extends Piece
{

	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	public Rook()
	{
		super();

	}

	@Override
	protected int[][] createMove()
	{
		
		/**
		 * [0,8],[0,-8],[8,0],[-8,0] maximal move possible for the rook.
		 */
		return new int[][]{{0,0,8,-8},{8,-8,0,0}};
	}
	
}