package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Board;

/**
 * TODO.
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
	public King(Board board)
	{
		super(board);

	}

	@Override
	protected int[][] createMove()
	{
		
		/**
		 * [1,1],[-1,-1],[-1,1],[1,-1],[0,1],[0,-1],[1,0],[-1,0] maximal move possible for the king.
		 */
		return new int[][]{{1,-1,-1,1,0,0,1,-1},{1,-1,1,-1,1,-1,0,0}};
	}
	
}
