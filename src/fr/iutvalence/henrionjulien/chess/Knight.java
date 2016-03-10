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
		// TODO Why don't you use the abstract class? _*/
		defaultMove  = createMove();
	}

	@Override
	protected int[][] createMove()
	{
		// TODO Transform the next comment into javadoc.
		//[2,-1],[1,-2],[-1,-2],[-2,-1],[-2,1],[-1,2],[1,2],[2,1] maximal move possible for the knight.
		return new int[][]{{2,1,-1,-2,-2,-1,1,2},{-1,-2,-2,-1,1,2,2,1}};
	}
	
}
