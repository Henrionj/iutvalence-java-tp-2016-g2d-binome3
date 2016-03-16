package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Board;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Knight extends Piece
{

	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	public Knight()
	{
		super();
	}

	@Override
	protected int[][] createMove()
	{
		
		/**
		 * [2,-1],[1,-2],[-1,-2],[-2,-1],[-2,1],[-1,2],[1,2],[2,1] maximal move possible for the knight.
		 */
		return new int[][]{{2,1,-1,-2,-2,-1,1,2},{-1,-2,-2,-1,1,2,2,1}};
	}
	
}
