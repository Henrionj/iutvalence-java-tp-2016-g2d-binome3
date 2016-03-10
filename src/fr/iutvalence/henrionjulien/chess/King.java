package fr.iutvalence.henrionjulien.chess;

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
		// TODO Why don't you use the abstract class? _*/
		defaultMove  = createMove();
	}

	@Override
	protected int[][] createMove()
	{
		// TODO Transform the next comment into javadoc.
		//[1,1],[-1,-1],[-1,1],[1,-1],[0,1],[0,-1],[1,0],[-1,0] maximal move possible for the king.
		return new int[][]{{1,-1,-1,1,0,0,1,-1},{1,-1,1,-1,1,-1,0,0}};
	}
	
}
