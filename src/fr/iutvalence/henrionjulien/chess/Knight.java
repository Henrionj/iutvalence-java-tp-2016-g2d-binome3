package fr.iutvalence.henrionjulien.chess;

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
	public Knight(Board board)
	{
		super(board);
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
